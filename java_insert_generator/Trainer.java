package fbvereininserts;
/**
 * 
 * @author Jakob 
 *
 */
public class Trainer extends Person{
	
	public float gehalt;
	public String von;
	public String bis;
	
	
	public Trainer(int persnr, String vname, String nname, char geschlecht,
			String gebdat, float gehalt, String von, String bis) {
		super(persnr, vname, nname, geschlecht, gebdat);
		this.gehalt = gehalt;
		this.von = von;
		this.bis = bis;
	}
	
	public Trainer(Person person, float gehalt, String von, String bis) {
		super(person.persnr, person.vname, person.nname, person.geschlecht, person.gebdat);
		this.gehalt = gehalt;
		this.von = von;
		this.bis = bis;
	}
	
	
	public String toSqlString(){
		return "INSERT INTO Trainer VALUES (" + this.persnr
				+ "," + this.gehalt
				+ ",'" + this.von + "','" + this.bis + "');"
				+ System.getProperty("line.separator");
	}
	
}
