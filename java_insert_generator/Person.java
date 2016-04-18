package fbvereininserts;
/**
 * 
 * @author Jakob 
 *
 */
public class Person {

	public int persnr;
	public String vname;
	public String nname;
	public char geschlecht;
	public String gebdat;
	
	
	public Person(int persnr, String vname, String nname, char geschlecht,
			String gebdat) {
		super();
		this.persnr = persnr;
		this.vname = vname;
		this.nname = nname;
		this.geschlecht = geschlecht;
		this.gebdat = gebdat;
	}
	
	public String toSqlString(){
		return "INSERT INTO Person VALUES (nextval('seq_incr_two'),'" 
			+ this.vname 
			+ "','"
			+this.nname
			+"','"
			+this.geschlecht
			+"','"
			+ this.gebdat
			+ "');"
				+ System.getProperty("line.separator");
	}
	
}
