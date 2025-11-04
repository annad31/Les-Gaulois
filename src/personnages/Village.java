package personnages;

public class Village {
	private String nom;
	private int nbVillageois=0;
	private Gaulois[] villageois;
	private Gaulois chef;
	
	
	public Village(String nom, final int NB_VILLAGEOIS_MAX, Gaulois chef) {
		villageois = new Gaulois[NB_VILLAGEOIS_MAX];
		this.nom = nom;
		this.chef = chef;
		chef.setVillage(this);
	}
	
	public String getNom() {
		return nom;
	}

	public Gaulois getChef() {
		return chef;
	}

	public void ajouterVillageois(Gaulois gaulois) {
			villageois[nbVillageois]=gaulois;
			nbVillageois++;
			gaulois.setVillage(this);
	}
	
	public Gaulois trouverVillageois(int numero) {
		if(numero>0 && numero<=nbVillageois && villageois[numero-1]!=null) {
			return villageois[numero-1];
		}
		else {
			System.out.println("Il n'y a pas autant d'habitants dans le village.");
			return null;
		}
	}
	
	public void afficherVillageois(Village village) {
		System.out.println("Dans le village " + nom + " du chef " + chef.getNom() + " vivent les légendes gauloises :\n");
		for(int i=0;i<nbVillageois;i++) {
			System.out.println("- " + villageois[i] + "\n");
		}
	}
	
	
	public static void main(String[] args) {
		Gaulois abraracourcix = new Gaulois("Abraracourcix", 6);
		Village irreductibles = new Village("Le village des irréductibles", 30, abraracourcix);
		Gaulois asterix = new Gaulois("Astérix", 8);
		irreductibles.ajouterVillageois(asterix);
		Gaulois gaulois = irreductibles.trouverVillageois(1);
		System.out.println(gaulois);
		gaulois = irreductibles.trouverVillageois(2);
		System.out.println(gaulois);
		
		Gaulois obelix = new Gaulois("Obélix", 25);
		irreductibles.ajouterVillageois(obelix);
		irreductibles.afficherVillageois(irreductibles);
		
		Gaulois doublepolemix = new Gaulois("DoublePolémix", 4);
		abraracourcix.sePresenter();
		asterix.sePresenter();
		doublepolemix.sePresenter();
		
	}
	
	
}
