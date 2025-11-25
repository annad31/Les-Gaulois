package villagegaulois;
import personnages.Gaulois;
import objets.Equipement;
import villagegaulois.Trophee;

public class Musee {
	private Trophee[] trophees=new Trophee[200];
	private int nbTrophee;
	
	public void donnerTrophee(Gaulois gaulois, Equipement equipement) {
		Trophee trophee = new Trophee(gaulois,equipement);
		trophees[nbTrophee]=trophee;
		nbTrophee++;
	}
	
}
