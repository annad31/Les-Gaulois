package personnages;

import objets.Equipement;

public class Romain {
	private String nom;
	private int force;
	private Equipement[] equipements = new Equipement[2];
	private int nbEquipement = 0;
	
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
	
	public void addEquipement(Equipement equipement) {
		equipements[nbEquipement]=equipement;
	}
	
	public void sEquiper(Equipement equipement) {
		String appel = "Le soldat " + nom;
		switch(nbEquipement) {
		
		case 0:
			addEquipement(equipement);
			nbEquipement++;
			System.out.println(appel + " s'équipe avec un " + equipement.toString() + ".");
			break;
			
		case 1:
			if (equipements[0]==equipement) {
				System.out.println(appel + " possède déjà un " + equipement.toString() + " !");
			}
			else {
				addEquipement(equipement);
				System.out.println(appel + " s'équipe avec un " + equipement.toString() + ".");
				nbEquipement++;
			}
			break;
		
		case 2:
			System.out.println(appel + " est déjà bien protégé !");
			break;
		}
	}
	
	public static void main(String[] args) {
		Romain minus = new Romain("Minus", 6);
		minus.sEquiper(Equipement.CASQUE);
		minus.sEquiper(Equipement.CASQUE);
		minus.sEquiper(Equipement.BOUCLIER);
		minus.sEquiper(Equipement.BOUCLIER);
		
		
	}
	
}
