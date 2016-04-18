package fbvereininserts;
/**
 * 
 * @author Jakob 
 *
 */
public class Standort {

	public int sid;
	public String land;
	public int plz;
	public String ort;
	
	
	public Standort(int sid, String land, int plz, String ort) {
		super();
		this.sid = sid;
		this.land = land;
		this.plz = plz;
		this.ort = ort;
	}
	
	public String toSqlString(){
		return "INSERT INTO Standort VALUES (nextval('seq_auto_incr'),'" 
			+ this.land 
			+ "',"
			+this.plz
			+",'"
			+this.ort
			+ "');"
			+ System.getProperty("line.separator");
	}
	
}
