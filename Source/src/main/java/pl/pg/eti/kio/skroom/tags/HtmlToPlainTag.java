package pl.pg.eti.kio.skroom.tags;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.BodyTagSupport;
import java.io.IOException;

import static pl.pg.eti.kio.skroom.PlainTextUtil.HTML_ENDLINE_STRING;
import static pl.pg.eti.kio.skroom.PlainTextUtil.HTML_ENDLINE_STRING2;
import static pl.pg.eti.kio.skroom.PlainTextUtil.PLAIN_TEXT_ENDLINE_STRING;

/**
 * @author Wojciech Stanisławski
 * @since 03.01.17
 */
public class HtmlToPlainTag extends BodyTagSupport {


	@Override
	public int doEndTag() throws JspException {
		JspWriter out = pageContext.getOut();
		String body = bodyContent.getString();

		try {
			out.print(body.replace(HTML_ENDLINE_STRING, PLAIN_TEXT_ENDLINE_STRING).replace(HTML_ENDLINE_STRING2, PLAIN_TEXT_ENDLINE_STRING));
		} catch (IOException e) {
			e.printStackTrace();
		}

		return EVAL_PAGE;
	}
}
