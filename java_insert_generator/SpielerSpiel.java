package fbvereininserts;
/**
 * 
 * @author Jakob 
 *
 */
public class SpielerSpiel {
	
	public Spieler spieler;
	public Spiel spiel;
	public int dauer;
	
	public SpielerSpiel(Spieler spieler, Spiel spiel, int dauer) {
		this.spiel = spiel;
		this.spieler = spieler;
		this.dauer = dauer;
	}
	
	public String toSqlString(){
		return "INSERT INTO Spieler_Spiel VALUES (" 
			+this.spieler.persnr 
			+",'" 
			+ this.spiel.datum 
			+ "','" 
			+ this.spiel.mannschaft.bezeichnung 
			+"',"
			+ this.dauer + ");"
			+ System.getProperty("line.separator");
	}
	

}
