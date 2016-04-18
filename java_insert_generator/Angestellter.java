package fbvereininserts;
/**
 * 
 * @author Jakob 
 *
 */
public class Angestellter extends Person {

	public float gehalt;
	public int ueberstunden;
	public String eMail;
	
	
	public Angestellter(int persnr, String vname, String nname,
			char geschlecht, String gebdat, float gehalt, int ueberstunden,
			String eMail) {
		super(persnr, vname, nname, geschlecht, gebdat);
		this.gehalt = gehalt;
		this.ueberstunden = ueberstunden;
		this.eMail = eMail;
	}
	
	public Angestellter(Person person, float gehalt, int ueberstunden,
			String eMail) {
		super(person.persnr, person.vname, person.nname, person.geschlecht, person.gebdat);
		this.gehalt = gehalt;
		this.ueberstunden = ueberstunden;
		this.eMail = eMail;
	}

	public String toSqlString(){
		return "INSERT INTO Angestellter VALUES (" 
			+ this.persnr
			+ ","
			+ this.gehalt 
			+ ","
			+ this.ueberstunden 
			+ ",'"
			+ this.eMail 
			+ "');"
			+ System.getProperty("line.separator");
	}
	
	
}
