package fbvereininserts;
/**
 * 
 * @author Jakob 
 *
 */
public class FanClub {

	public String name;
	public Standort standort;
	public String gegruendet;
	public Mitglied obmann;
	
	
	public FanClub( String name, Standort standort, String gegruendet, Mitglied obmann) 
	{
		super();
		this.name = name;
		this.standort = standort;
		this.gegruendet = gegruendet;
		this.obmann = obmann;
		this.standort = standort;
	}	

	public String toSqlString(){
		return "INSERT INTO FanClub VALUES ('"
			+this.name+"'," 
			+this.standort.sid+",'"
			+this.gegruendet + "',"
			+this.obmann.persnr+");"
			+ System.getProperty("line.separator");
	}
	
}
