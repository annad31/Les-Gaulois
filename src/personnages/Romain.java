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

//	public void recevoirCoup(int forceCoup) {
//		assert isInvariantVerified(forceCoup); 				// Pré-condition
//		final int forceDebut=force;
//		force -= forceCoup;
//		if (force < 1) {
//			parler("J'abandonne !");
//		}
//		else {
//			parler("A�e !");
//		}
//		assert forceDebut>force;							// Post-condition
//	}
	
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
	
	// TP3
	
	public Equipement[] recevoirCoup(int forceCoup) {
		Equipement[] equipementEjecte = null;
		forceCoup = calculResistanceEquipement(forceCoup);
		force -= forceCoup;
		if (force>0) {
			parler("Aïe");
		}
		else {
			equipementEjecte = ejecterEquipement();
			parler("J'abandonne...");
		}
		return equipementEjecte;
	}
	
	private int calculResistanceEquipement(int forceCoup) {
		String texte = "Ma force est de " + this.force + ", et la force du coup est de " + forceCoup;
		int resistanceEquipement = 0;
		if (nbEquipement>0) {
			texte += "\nMais heureusement, grace à mon équipement sa force est diminué de ";
			for (int i = 0; i < nbEquipement;i++) {
				if (equipements[i] != null && equipements[i].equals(Equipement.BOUCLIER)) {
					resistanceEquipement += 8;
				} else {
					System.out.println("Equipement casque");
					resistanceEquipement += 5;
				}
			}
			texte += resistanceEquipement + "!";
		}
		parler(texte);
		forceCoup -= resistanceEquipement;
		if (forceCoup<0) forceCoup=0;
		return forceCoup;
	}
	
	private Equipement[] ejecterEquipement() {
		Equipement[] equipementEjecte = new Equipement[nbEquipement];
		System.out.println("L'équipement de " + nom + " s'envole sous la force du coup.");
		int nbEquipementEjecte = 0;
		for (int i = 0; i < nbEquipement; i++) {
			if (equipements[i] != null) {
				equipementEjecte[nbEquipementEjecte] = equipements[i];
				nbEquipementEjecte++;
				equipements[i] = null;
			}
		}
		return equipementEjecte;
	}
	
	public int getForce() {
		return force;
	}

	public static void main(String[] args) {
		Romain minus = new Romain("Minus", 6);
		minus.sEquiper(Equipement.CASQUE);
		minus.sEquiper(Equipement.CASQUE);
		minus.sEquiper(Equipement.BOUCLIER);
		minus.sEquiper(Equipement.BOUCLIER);
		
		
	}
	
}
