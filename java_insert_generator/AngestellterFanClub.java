package fbvereininserts;
/**
 * 
 * @author Jakob 
 *
 */
public class AngestellterFanClub {
	
	public Angestellter angestellter;
	public FanClub fcName;
	public FanClub fcId;
	public String anfang;
	public String ende;
	
	public AngestellterFanClub(Angestellter angestellter, FanClub fcName, FanClub fcId, String anfang, String ende) {
		this.angestellter = angestellter;
		this.fcName = fcName;
		this.fcId = fcId;
		this.anfang = anfang;
		this.ende = ende;
	}
	
	public String toSqlString(){
		return "INSERT INTO Angestellter_FanClub VALUES ("
			+ this.angestellter.persnr
			+",'"
			+this.fcName.name
			+"',"
			+this.fcId.standort.sid
			+",'"
			+this.anfang
			+"','"
			+this.ende
			+"');"
			+ System.getProperty("line.separator");
	}
	

}
