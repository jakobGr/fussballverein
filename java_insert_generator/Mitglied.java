package fbvereininserts;
/**
 * 
 * @author Jakob 
 *
 */
public class Mitglied extends Person{

		public float beitrag;

		public Mitglied(int persnr, String vname, String nname,
				char geschlecht, String gebdat, float beitrag) {
			super(persnr, vname, nname, geschlecht, gebdat);
			this.beitrag = beitrag;
		}
		
		public Mitglied(Person person, float beitrag) {
			super(person.persnr, person.vname, person.nname, person.geschlecht, person.gebdat);
			this.beitrag = beitrag;
		}
		
		public String toSqlString(){
			return "INSERT INTO Mitglied VALUES (" 
				+ this.persnr 
				+ ","
				+ this.beitrag 
				+ ");"
				+ System.getProperty("line.separator");
		}
}
