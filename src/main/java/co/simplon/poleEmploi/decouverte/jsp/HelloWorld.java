package co.simplon.poleEmploi.decouverte.jsp;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
	
	private void ajouteUtilisateurSession(HttpServletRequest request, Utilisateur utilisateur){
		HttpSession session = request.getSession();
		ArrayList <Utilisateur> listeUtilisateurs;
		
		// Si la liste est vide, on en crée une
		if (session.getAttribute("listeNoms")==null){
			System.out.println("Ma liste n'existe pas, j'en crée une");
			listeUtilisateurs = new ArrayList <Utilisateur>();
			session.setAttribute("listeNoms", listeUtilisateurs);
		}
		else
		{
			listeUtilisateurs = (ArrayList<Utilisateur>) session.getAttribute("listeNoms");
			System.out.println("Ma liste existe, je la charge avec " + listeUtilisateurs.size() + " éléments");
		}
		// On ajoute l'utilisateur à la liste
		listeUtilisateurs.add(utilisateur);
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
		String pNom = request.getParameter("nom");
		String pPrenom = request.getParameter("prenom");
		
		Utilisateur user = new Utilisateur(pNom, pPrenom);
		ajouteUtilisateurSession(request, user);
		
		if (! "".equals(pPrenom + " " + pNom)) {
			message += pPrenom + " " + pNom;
		} else {
			message += "World";
		}

		String objetChaine = "Je suis l'objet chaîne";
		
		RequestDispatcher requestDispatcher;
		requestDispatcher = request.getRequestDispatcher("WEB-INF/hello.jsp");
		request.setAttribute("message", message); 
		
		String monObjet = "message pour la JSP";
		request.setAttribute("chaineMessage", monObjet);
		request.setAttribute("nomObjetChaine", objetChaine);
		HttpSession session = request.getSession();
		request.setAttribute("listeUsers", session.getAttribute("listeNoms"));
		
		request.setAttribute("utilisateur", user);
		
		requestDispatcher.forward(request, response);
	}

	public void destroy() {

	}

	public String getMessageGet() {
		return messageGet;
	}

	public void setMessageGet(String messageGet) {
		this.messageGet = messageGet;
	}

	public String getMessagePut() {
		return messagePut;
	}

	public void setMessagePut(String messagePut) {
		this.messagePut = messagePut;
	}
	
	
}
