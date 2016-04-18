package fbvereininserts;
/**
 * 
 * @author Jakob 
 *
 */
public class Spiel {
	
	public String datum;
	public Mannschaft mannschaft;
	public String ergebnis;
	public Mannschaft gegner;
	
	
	public Spiel(String datum, Mannschaft mannschaft, String ergebnis, Mannschaft gegner) {
		super();
		this.datum = datum;
		this.mannschaft = mannschaft;
		this.ergebnis = ergebnis;
		this.gegner = gegner;
	}
	
	public String toSqlString(){
		return "INSERT INTO Spiel VALUES ('" 
		+ this.datum
		+ "','" 
		+ this.mannschaft.bezeichnung 
		+ "','"
		+this.ergebnis
		+"','"
		+ this.gegner.bezeichnung 
		+ "');"
		+ System.getProperty("line.separator");
	}
	

}
