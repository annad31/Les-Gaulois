package personnages;

public class Romain {
	private String nom;
	private int force;
	
	public Romain(String nom, int force) {
		this.nom = nom;
		this.force = force;
		assert isInvariantVerified(force);
	}

	public String getNom() {
		return nom;
	}
	
	public void parler(String texte) {
		System.out.println(prendreParole() + "\"" + texte + "\"");
	}

	private String prendreParole() {
		return "Le romain " + nom + " : ";
	}

	public void recevoirCoup(int forceCoup) {
		assert isInvariantVerified(forceCoup); 				// Pré-condition
		final int forceDebut=force;
		force -= forceCoup;
		if (force < 1) {
			parler("J'abandonne !");
		}
		else {
			parler("A�e !");
		}
		assert forceDebut>force;							// Post-condition
	}
	
	private boolean isInvariantVerified(int force) {
		return force>=0;
	}
	
	public static void main(String[] args) {
		Romain minus = new Romain("Minus", 6);
	}
}
