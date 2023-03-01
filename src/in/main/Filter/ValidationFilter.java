package in.main.Filter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class ValidationFilter implements Filter {

	public void destroy() {
		System.out.println("Object De-Instantiate");
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		String id_error = "", ename_error = "", eage_error = "", emobile_error = "", eemail_error = "";
		boolean isValid = true;

		response.setContentType("text/html");
		PrintWriter writer = response.getWriter();

		String empid = request.getParameter("empid");
		String ename = request.getParameter("ename");
		String eage = request.getParameter("eage");
		String emobile = request.getParameter("emobile");
		String eemail = request.getParameter("eemail");

		if (empid == null || empid.equals("") || !(empid.startsWith("iNeuron"))) {
			id_error = "ID should not be null or blank and should starts with iNeuron";
			isValid = false;
		}
		if (ename == null || ename.equals("")) {
			ename_error = "Name should not be null or blank";
			isValid = false;
		}
		if (eage == null || eage.equals("") || !(Integer.parseInt(eage) >= 20 && Integer.parseInt(eage) <= 30)) {
			eage_error = "Age should not be null, blank or greater than 30";
			isValid = false;
		}
		if (emobile == null || emobile.equals("")) {
			emobile_error = "Mobile should not be null or blank";
			isValid = false;
		}
		if (eemail == null || eemail.equals("") || !(eemail.endsWith("@iNeuron.ai"))) {
			eemail_error = "Email should not be null, blank or should ends with @iNeuron.ai";
			isValid = false;
		}

		if (isValid == true) {
			chain.doFilter(request, response);
		} else {
			writer.println("<html><head><title>writerput</title></head>");
			writer.println("<body bgcolor='lightgreen'>");
			writer.println("<center>");
			writer.println("<h1 style='color:red; text-align:center;'>Employee Registration Details</h1>");
			writer.println("<form method='post' action='./reg'>");
			writer.println("<table>");
			writer.println("<tr><th>EID</th><td><input type='text' name ='empid' value='" + empid
					+ "'/></td><td> <font color='red' size ='5'>" + id_error + "</font></td></tr>");
			writer.println("<tr><th>ENAME</th><td><input type='text' name ='ename' value='" + ename
					+ "'/></td><td><font color='red' size ='5'>" + ename_error + "</font></td></tr>");
			writer.println("<tr><th>EAGE</th><td><input type='text' name ='eage' value='" + eage
					+ "'/></td><td><font color='red' size ='5'>" + eage_error + "</font></td></tr>");
			writer.println("<tr><th>MOBILE</th><td><input type='text' name ='emobile' value='" + emobile
					+ "'/></td><td><font color='red' size ='5'>" + emobile_error + "</font></td></tr>");
			writer.println("<tr><th>EMAIL</th><td><input type='text' name ='eemail' value='" + eemail
					+ "'/></td><td><font color='red' size ='5'>" + eemail_error + "</font></td></tr>");
			writer.println("<tr><td></td><td><input type='submit' value='reg'/></td></tr>");
			writer.println("</table>");
			writer.println("</form>");
			writer.println("</center>");
			writer.println("</body>");
			writer.println("</html>");
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
