package pl.pg.eti.kio.skroom.install.frame;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.layout.FormSpecs;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextPane;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.ActionEvent;

public class WelcomeFrame extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WelcomeFrame frame = new WelcomeFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public WelcomeFrame() {
		setResizable(false);
		setTitle("Skroom setup");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 540, 475);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new FormLayout(new ColumnSpec[] {
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("left:max(81dlu;default)"),
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("left:max(57dlu;default):grow"),
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(31dlu;default)"),
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),},
			new RowSpec[] {
				FormSpecs.RELATED_GAP_ROWSPEC,
				RowSpec.decode("max(41dlu;default)"),
				FormSpecs.RELATED_GAP_ROWSPEC,
				RowSpec.decode("max(86dlu;default):grow"),
				FormSpecs.RELATED_GAP_ROWSPEC,
				RowSpec.decode("bottom:max(20dlu;default)"),}));
		
		JLabel iconLabel = new JLabel("");
		contentPane.add(iconLabel, "2, 2, 1, 5");
		
		try {
			Dimension d = new Dimension(iconLabel.getWidth(), iconLabel.getHeight());
			BufferedImage bi = ImageIO.read(this.getClass().getClassLoader().getResourceAsStream("logo.png"));
			Icon icon = new ImageIcon(bi);
			iconLabel.setIcon(icon);
			iconLabel.setMaximumSize(d);
		}
		catch (Exception e) { e.printStackTrace();}
		
		JLabel titleLabel = new JLabel("Welcome to Skroom Setup");
		titleLabel.setFont(new Font("Dialog", Font.BOLD, 18));
		contentPane.add(titleLabel, "4, 2, 5, 1");
		
		JTextPane txtpnThisWizardHelps = new JTextPane();
		txtpnThisWizardHelps.setEditable(false);
		txtpnThisWizardHelps.setText("This wizard helps you install and set up Skroom management application.\n\nTo continue, click Next.");
		contentPane.add(txtpnThisWizardHelps, "4, 4, 5, 1, fill, fill");
		
		JButton btnCancel = new JButton("Cancel");
		
		final JFrame thisFrame = this;
		
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				thisFrame.dispatchEvent(new WindowEvent(thisFrame, WindowEvent.WINDOW_CLOSING));
			}
		});
		contentPane.add(btnCancel, "6, 6");
		
		JButton btnNext = new JButton("Next");
		contentPane.add(btnNext, "8, 6");
		btnNext.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				LicenseFrame fr = new LicenseFrame();
				fr.setLastFrame(thisFrame);
				thisFrame.setVisible(false);
				fr.setVisible(true);
			}
		});
	}
	
	private void getSkroomImage() {
		ImageIcon icon = null;
		try {
			BufferedImage img = ImageIO.read(new File(this.getClass().getResource("logo.png").getPath()));
			icon = new ImageIcon(img);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
