package fbvereininserts;
/**
 * 
 * @author Jakob 
 *
 */
public class Mannschaft {
	
	public String bezeichnung;
	public String klasse;
	public String naechstesSpiel;
	public Trainer chefTrainer;
	public Trainer astTrainer;
	public Spieler kapitaen;

	
	public Mannschaft(String bezeichnung, String klasse, String naechstesSpiel,
			Trainer chefTrainer, Trainer astTrainer, Spieler kapitaen) {
		super();
		this.bezeichnung = bezeichnung;
		this.klasse = klasse;
		this.naechstesSpiel = naechstesSpiel;
		this.chefTrainer = chefTrainer;
		this.astTrainer = astTrainer;
		this.kapitaen = kapitaen;
	}
	
	public String toSqlString(){
		return "INSERT INTO Mannschaft VALUES ('" + this.bezeichnung
		+ "','" + this.klasse + "','" + this.naechstesSpiel + "'," + this.chefTrainer.persnr
		+ "," + this.astTrainer.persnr + "," + this.kapitaen.persnr + ");"
		+ System.getProperty("line.separator");
	}
	
	
}
