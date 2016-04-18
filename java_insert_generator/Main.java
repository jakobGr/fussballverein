package fbvereininserts;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.GregorianCalendar;
import java.util.Vector;
/**
 * 
 * @author Jakob 
 *
 */

public class Main {

	public static Vector<Person> personen;
	public static Vector<Spieler> spielers;
	public static Vector<Standort> standorte;
	public static Vector<Trainer> trainers;
	public static Vector<Angestellter> angestellte;
	public static Vector<Mitglied> mitglieder;
	public static Vector<Mannschaft> mannschaften;
	public static Vector<Spiel> spiele;
	public static Vector<SpielerSpiel> spielerSpiele;
	public static Vector<SpielerMannschaft> spielerMannschaften;
	public static Vector<FanClub> fanclubs;
	public static Vector<AngestellterFanClub> angestellterfanclubs;
	
	public static String[] positionen;
	public static String[] klassen;
	public static String[] ergebnis;
	public static char[] geschlecht;


	
	public static final int ENTRIES = 100000;
	public static final int PERSON_START_ID = 10000;
	public static final int STANDORT_START_ID = 1;
	public static final int ID_INCR = 2;
	public static final int PLAYERS_PER_GAME = 12;
	
	public static void main(String[] args) {
	
			positionen = new String[]{
					"Tormann",
					"Verteidiger",
					"Mittelfeld",
					"Stuermer",
					"Ersatz"
			};
			
			klassen = new String[]{
					"AMannschaft",
					"BMannschaft",
					"Junioren",
					"Amateure",
					"Senioren"
			};
			ergebnis = new String[]{
					"Sieg",
					"Niederlage",
					"Unentschieden"
			};
			geschlecht = new char[]{
					'M',
					'W',
					'N'
			};
			
			personen = new Vector<Person>();
			spielers = new Vector<Spieler>();
			trainers = new Vector<Trainer>();
			angestellte = new Vector<Angestellter>();
			mitglieder = new Vector<Mitglied>();
			mannschaften = new Vector<Mannschaft>();
			spiele = new Vector<Spiel>();
			spielerSpiele = new Vector<SpielerSpiel>();
			spielerMannschaften = new Vector<SpielerMannschaft>();
			standorte = new Vector<Standort>();
			fanclubs = new Vector<FanClub>();
			angestellterfanclubs = new Vector<AngestellterFanClub>();
			
			Main.generateSpieler();
			Main.generateTrainer();
			Main.generateAngestellter();
			Main.generateMitglied();
			Main.generateMannschaft();
			Main.generateSpiel();
			Main.generateSpielerSpiel();
			Main.generateSpielerMannschaft();
			Main.generateStandort();
			Main.generateFanClub();
			Main.generateAngestellterFanClub();			
			Main.generateSql();
	}
	
	private static void generateSql() {
		try {
		File file = new File(
				"/Schule/4AHITM/INSY/Fbverein/Insert/insert.txt");

		if (!file.exists()) {
			file.createNewFile();

		}

		FileWriter fw = new FileWriter(file.getAbsoluteFile());
		BufferedWriter bw = new BufferedWriter(fw);
		
		for(int i = 0; i < personen.size(); i++){
			bw.write(personen.elementAt(i).toSqlString());
		}
		
		for(int i = 0; i < spielers.size(); i++){
			bw.write(spielers.elementAt(i).toSqlString());
		}
		
		for(int i = 0; i < angestellte.size(); i++){
			bw.write(angestellte.elementAt(i).toSqlString());
		}
		
		for(int i = 0; i < trainers.size(); i++){
			bw.write(trainers.elementAt(i).toSqlString());
		}
		
		for(int i = 0; i < mitglieder.size(); i++){
			bw.write(mitglieder.elementAt(i).toSqlString());
		}
		
		for(int i = 0; i < mannschaften.size(); i++){
			bw.write(mannschaften.elementAt(i).toSqlString());
		}
		
		for(int i = 0; i < spiele.size(); i++){
			bw.write(spiele.elementAt(i).toSqlString());
		}
		
		for(int i = 0; i < spielerSpiele.size(); i++){
			bw.write(spielerSpiele.elementAt(i).toSqlString());
		}
		
		for(int i = 0; i < spielerMannschaften.size(); i++){
			bw.write(spielerMannschaften.elementAt(i).toSqlString());
		}
		
		for(int i = 0; i < standorte.size(); i++){
			bw.write(standorte.elementAt(i).toSqlString());
		}
		
		for(int i = 0; i < fanclubs.size(); i++){
			bw.write(fanclubs.elementAt(i).toSqlString());
		}
		
		for(int i = 0; i < angestellterfanclubs.size(); i++){
			bw.write(angestellterfanclubs.elementAt(i).toSqlString());
		}
		
		
	
		bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static void generateAngestellter() {
		for(int i = 0; i < ENTRIES; i++){
			Person person = generatePerson();
			Angestellter angestellter = new Angestellter(
					person,
					(float) (Math.random() * 2000), 
					(int) (Math.random() * 10),
					person.vname + "." + person.nname + "@fbverein.com");
			angestellte.addElement(angestellter);
		}
	}

	private static void generateTrainer() {
		for(int i = 0; i < ENTRIES; i++){
			Person person = generatePerson();
			Trainer trainer = new Trainer(
					person,
					(float) (Math.random() * 2000), 
					randBetween(2005,2020,0),
					randBetween(2005,2020,10));
			trainers.addElement(trainer);
		}		
	}
	private static void generateSpieler() {
		for(int i = 0; i < ENTRIES; i++){
			Person person = generatePerson();
			Spieler spieler = new Spieler(
					person,
					positionen[i%5],
					(float) (Math.random() * 2000), 
					randBetween(2005,2020,0),
					randBetween(2005,2020,10));
			spielers.addElement(spieler);
		}			
	}
	private static void generateMitglied() {
		for(int i = 0; i < ENTRIES; i++){
			Person person = generatePerson();
			Mitglied mitglied = new Mitglied(
					person,
					(float) (Math.random() * 200));
			mitglieder.addElement(mitglied);
		}
	}
	

	private static void generateMannschaft() {
		for(int i = 0; i < ENTRIES; i++){
			Mannschaft mannschaft = new Mannschaft(
					"Mannschaft"+i,
					klassen[i%5],
					randBetween(2016, 2018, 0),
					trainers.elementAt(i),
					trainers.elementAt((i+1)%ENTRIES),
					spielers.elementAt(i));
			mannschaften.addElement(mannschaft);
		}		
	}
	
	private static void generateSpiel() {
		for(int i = 0; i < ENTRIES; i++){
			Spiel spiel = new Spiel(
					randBetween(2014, 2017, 0),
					mannschaften.elementAt(i),
					ergebnis[i%3],
					mannschaften.elementAt((i+1)%ENTRIES));
			spiele.addElement(spiel);
		}			
	}

	private static void generateSpielerSpiel() {
		for(int i = 0; i < ENTRIES; i++){
			for(int j = 0; j < PLAYERS_PER_GAME; j++) {
				SpielerSpiel spielerSpiel = new SpielerSpiel(
						spielers.elementAt((int) (Math.random() *ENTRIES)),
						spiele.elementAt(i) , 
						((i+j)*j)%90);
				spielerSpiele.addElement(spielerSpiel);
			}
		}
	}

	private static void generateSpielerMannschaft() {
		for(int i = 0; i < ENTRIES; i++){
			for(int j = 0; j < PLAYERS_PER_GAME; j++) {
					SpielerMannschaft spielerMannschaft = new SpielerMannschaft(
							spielers.elementAt((int) (Math.random() * ENTRIES)),
							mannschaften.elementAt(i) ,
							(int) (Math.random() * 90));
					spielerMannschaften.addElement(spielerMannschaft);
				}
			}
	}	

	private static void generateStandort() {
		for(int i = 0; i < ENTRIES; i++){
			Standort standort = new Standort(
					generateStandortId(),
					"land"+i,
					(int) (Math.random() * 90),
					"ort"+i);
			standorte.addElement(standort);
		}
	}
	private static void generateFanClub() {
		for(int i = 0; i < ENTRIES; i++){
			FanClub fanClub = new FanClub(
					"name"+i,
					standorte.elementAt(i),
					randBetween(2005,2016,0),
					mitglieder.elementAt(i));
			fanclubs.addElement(fanClub);
		}
	}
	
	private static void generateAngestellterFanClub() {
		for(int i = 0; i < ENTRIES; i++){
			AngestellterFanClub angestellterFanClub = new AngestellterFanClub(
					angestellte.elementAt(i),
					fanclubs.elementAt(i),
					fanclubs.elementAt(i),
					randBetween(2005,2016,0),
					randBetween(2005,2016,10));
			angestellterfanclubs.addElement(angestellterFanClub);
		}
	}


	private static Person generatePerson(){
		int i = personen.size();
		Person person = new Person(
				generatePersonId(),
				"vname"+i,
				"nname"+i,
				geschlecht[i%3],
				randBetween(1900,2010,0));
		personen.addElement(person);
		return person;
	}

	private static int generatePersonId(){
		int i = PERSON_START_ID;
		i += personen.size()*ID_INCR;
		return i;
	}
	
	private static int generateStandortId(){
		int i = STANDORT_START_ID;
		i += standorte.size();
		return i;
	}

	public static String randBetween(int start, int end, int seperator) {
		GregorianCalendar gc = new GregorianCalendar();
		String date;

		int year = start + (int) Math.round(Math.random() * (end - start));

		gc.set(gc.YEAR, year);

		int dayOfYear = gc.getActualMaximum(gc.DAY_OF_YEAR)
				+ (int) Math.round(Math.random()
						* (1 - gc.getActualMaximum(gc.DAY_OF_YEAR)));

		gc.set(gc.DAY_OF_YEAR, dayOfYear);

		return date = +(gc.get(gc.YEAR) + seperator) + "-"
				+ (gc.get(gc.MONTH) + 1) + "-" + gc.get(gc.DAY_OF_MONTH);
	}
}
