package co.simplon.poleEmploi.decouverte.jsp;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloWorld extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4799039535301688065L;
	private String messageGet;
	private String messagePut;

	public void init() throws ServletException {
		messageGet = "Hello ";
		messagePut = "Bonjour ";
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String message = messageGet;
		String parametre = request.getParameter("nom");
		if (! "".equals(parametre)) {
			message += parametre;
		} else {
			message += "World";
		}

		RequestDispatcher requestDispatcher;
		requestDispatcher = request.getRequestDispatcher("hello.jsp");
		request.setAttribute("message", message); 
		requestDispatcher.forward(request, response);

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String message = messagePut;
		String parametre = request.getParameter("nom");
		if (! "".equals(parametre)) {
			message += parametre;
		} else {
			message += "World";
		}

		RequestDispatcher requestDispatcher;
		requestDispatcher = request.getRequestDispatcher("WEB-INF/hello.jsp");
		request.setAttribute("message", message); 
		requestDispatcher.forward(request, response);
	}

	public void destroy() {

	}
}
