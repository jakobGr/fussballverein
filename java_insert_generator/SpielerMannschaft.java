package fbvereininserts;
/**
 * 
 * @author Jakob 
 *
 */
public class SpielerMannschaft {
	
	public Spieler spieler;
	public Mannschaft mannschaft;
	public int nummer;
	
	public SpielerMannschaft(Spieler spieler, Mannschaft mannschaft, int nummer) {
		this.spieler = spieler;
		this.mannschaft = mannschaft;
		this.nummer = nummer;
	}
	
	public String toSqlString(){
		return "INSERT INTO Spieler_Mannschaft VALUES (" + 
				this.spieler.persnr + ",'" 
				+ this.mannschaft.bezeichnung + "',"
				+ this.nummer + ");"
				+ System.getProperty("line.separator");
	}
	

}
