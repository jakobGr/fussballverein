package fbvereininserts;
/**
 * 
 * @author Jakob 
 *
 */
public class Spieler extends Person{

	public String position;
	public float gehalt;
	public String von;
	public String bis;
	
	
	public Spieler(int persnr, String vname, String nname, char geschlecht,
			String gebdat, String position, float gehalt, String von, String bis) {
		super(persnr, vname, nname, geschlecht, gebdat);
		this.position = position;
		this.gehalt = gehalt;
		this.von = von;
		this.bis = bis;
	}
	
	public Spieler(Person person, String position, float gehalt, String von, String bis) {
		super(person.persnr, person.vname, person.nname, person.geschlecht, person.gebdat);
		this.position = position;
		this.gehalt = gehalt;
		this.von = von;
		this.bis = bis;
	}
	
	
	public String toSqlString(){
		return "INSERT INTO Spieler VALUES (" + this.persnr
				+ ",'"+this.position+"'," + this.gehalt
				+ ",'" + this.von + "','" + this.bis + "');"
				+ System.getProperty("line.separator");
	}
	
}
