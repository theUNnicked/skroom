package pl.pg.eti.kio.skroom.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.SystemEnvironmentPropertySource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import pl.pg.eti.kio.skroom.exception.signup.UserAccountCreationErrorException;
import pl.pg.eti.kio.skroom.exception.signup.UserAlreadyExistsException;
import pl.pg.eti.kio.skroom.model.Project;
import pl.pg.eti.kio.skroom.model.User;
import pl.pg.eti.kio.skroom.model.UserSecurity;
import pl.pg.eti.kio.skroom.model.UserSettings;
import pl.pg.eti.kio.skroom.model.dao.UserDao;
import pl.pg.eti.kio.skroom.model.enumeration.UserRole;
import pl.pg.eti.kio.skroom.settings.DatabaseSettings;

import java.sql.Connection;

import static pl.pg.eti.kio.skroom.controller.Views.LOGIN_JSP_LOCATION;
import static pl.pg.eti.kio.skroom.controller.Views.SIGNUP_JSP_LOCATION;

/**
 * @author Wojciech Stanisławski
 * @since 22.08.16
 */
@Controller
@SessionAttributes({"loggedUser", "userSettings", "selectedProject"})
public class AccountManagementController {
	private static final Logger LOGGER = LoggerFactory.getLogger(AccountManagementController.class);

	// Messages
	private static final String YOUR_ACCOUNT_MUST_BE_ACCEPTED = "Your account hasn't been accepted yet. Please contact your system administrator.";
	private static final String WRONG_USERNAME_OR_PASSWORD_MESSAGE = "You entered wrong username or password. Please try again.";
	private static final String SUCCESSFULLY_CREATED_ACCOUNT = "Thank you, your account has been created successfully.";

	// Redirects
	private static final String REDIRECT_AFTER_SUCCESSFULL_LOGIN = "redirect:/dashboard";
	private static final String PASSWORDS_NOT_MATCH = "Passwords not match";
	private static final String WRONG_EMAIL_FORMAT = "Wrong email format.";

	@Autowired private UserDao userDao;

	@ModelAttribute("loggedUser")
	public User defaultNullUser() {
		return new User();
	}

	@ModelAttribute("selectedProject")
	public Project defaultNullProject() {
		return new Project();
	}

	@ModelAttribute("userSettings")
	public UserSettings defaultNullUserSettings() {
		return new UserSettings();
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView tryLoggingIn(@ModelAttribute("loggedUser") User user, @RequestParam String name, @RequestParam String password) {
		if (!isUserNull(user)) {
			return new ModelAndView(REDIRECT_AFTER_SUCCESSFULL_LOGIN);
		}

		Connection dbConnection = DatabaseSettings.getDatabaseConnection();
		user = userDao.fetchByName(dbConnection, name);
		if(user == null) {
			return getLoginModel(WRONG_USERNAME_OR_PASSWORD_MESSAGE);
		}
		UserSecurity userSecurity = userDao.fetchUserSecurityData(dbConnection, user);
		if(!userSecurity.isAccepted()) {
			return getLoginModel(YOUR_ACCOUNT_MUST_BE_ACCEPTED);
		}
		if(userSecurity.getPassword().equals(password)) {
			UserSettings settings = userDao.fetchUserSettingsData(dbConnection, user);

			ModelAndView model = new ModelAndView(REDIRECT_AFTER_SUCCESSFULL_LOGIN);
			model.addObject("loggedUser", user);
			if(settings != null) {
				model.addObject("userSettings", settings);
			}
			return model;
		}
		else {
			return getLoginModel(WRONG_USERNAME_OR_PASSWORD_MESSAGE);
		}

	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public ModelAndView logout() {
		ModelAndView model = getLoginModel();
		model.addObject("loggedUser", new User());
		return model;
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView loginScreen(@ModelAttribute("loggedUser") User user) {
		if (!isUserNull(user)) {
			return new ModelAndView(REDIRECT_AFTER_SUCCESSFULL_LOGIN);
		}
		return getLoginModel();
	}

	@RequestMapping(value = "/signup", method = RequestMethod.GET)
	public ModelAndView signUpScreen() {
		return new ModelAndView(SIGNUP_JSP_LOCATION);
	}

	@RequestMapping(value = "/signup", method = RequestMethod.POST)
	public ModelAndView createAccount(@RequestParam("name") String name, @RequestParam("password") String password,
									  @RequestParam("confirm_password") String confirmPassword, @RequestParam("email") String email,
									  @RequestParam("question") String question, @RequestParam("answer") String answer) {
		if(!confirmPassword.equals(password)) {
			LOGGER.debug("Passwords not match for user {}.", name);
			return getSignupModelWithErrorMessage(PASSWORDS_NOT_MATCH);
		}

		if(!email.matches("(.*@.*[.].*)")) {
			LOGGER.debug("Wrong email format {}.", email);
			return getSignupModelWithErrorMessage(WRONG_EMAIL_FORMAT);
		}

		Connection dbConnection = DatabaseSettings.getDatabaseConnection();
		User user = new User();

		user.setName(name);
		user.setEmail(email);
		user.setRole(UserRole.PEASANT);

		UserSecurity userSecurity = new UserSecurity();

		userSecurity.setPassword(password);
		userSecurity.setSalt("SALT");
		userSecurity.setSecureQuestion(question);
		userSecurity.setSecureAnswer(answer);

		try {
			userDao.registerUser(dbConnection, user, userSecurity);
		} catch (UserAlreadyExistsException e) {
			return getSignupModelWithErrorMessage(e.getMessage());
		} catch (UserAccountCreationErrorException e) {
			return getSignupModelWithErrorMessage(e.getMessage());
		}

		return getLoginModel(SUCCESSFULLY_CREATED_ACCOUNT);
	}

	private ModelAndView getSignupModelWithErrorMessage(String message) {
		ModelAndView defaultModel = new ModelAndView(SIGNUP_JSP_LOCATION);
		defaultModel.addObject("signupError", message);
		return defaultModel;
	}

	private ModelAndView getLoginModel() {
		return getLoginModel(null);
	}

	private ModelAndView getLoginModel(String error) {
		ModelAndView model = new ModelAndView(LOGIN_JSP_LOCATION);
		model.addObject("loginError", error);
		return model;
	}

	private boolean isUserNull(User user) {
		return user.getId() < 0;
	}
}
