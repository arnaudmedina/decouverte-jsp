package co.simplon.poleEmploi.decouverte.jsp;

public class Utilisateur {

	private String nom;
	private String prenom;
	private Utilisateur copain;

	public Utilisateur (String nom, String prenom)
	{
		setNom(nom);
		setPrenom(prenom);
	}
	
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public Utilisateur getCopain() {
		return copain;
	}

	public void setCopain(Utilisateur copain) {
		this.copain = copain;
	}

	@Override
	public String toString() {
		return "Utilisateur [" + nom + ", prenom=" + prenom + "]";
	}
}
