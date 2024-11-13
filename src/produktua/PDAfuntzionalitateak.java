package produktua;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Scanner;

public class PDAfuntzionalitateak {
	
	private static final String RUTA_LANGILE = "src/produktua/fitxategiak/LANGILE.txt";
    private static final String RUTA_BEZERO = "src/produktua/fitxategiak/BEZERO.txt";
    private static final String RUTA_BEZERO_TLF = "src/produktua/fitxategiak/BEZERO_TELEFONO.txt";
    private static final String RUTA_ESKARI = "src/produktua/fitxategiak/ESKARI.txt";
    private static final String RUTA_ESKARI_LERRO = "src/produktua/fitxategiak/ESKARI_LERRO.txt";

	private static Scanner sc = new Scanner(System.in);

	public static void kontsultaLangile() {
		// Sartzen dugun koodearen arabera, langile horren informazia kontsultatu egiten
		// du funtzioak.
		System.out.print("Sartu langilearen kodea: ");
		String kodeaBilatu = sc.nextLine();
		boolean aurkituta = false;

		// FileReader berria sortu dugu nahi dugun fitxategia irakurtzeko eta bertatik
		// langileen informazioa ateratzeko. FileReader eta haren BufferedReader egin
		// ditugu. Lerro zatiaren arabera, informazioa mota bat ala bestea aurkituko
		// dugu (izena, abizena, etab.) eta bakoitza variable bati esleitu dugu, gero
		// pantailatik atera ahal izateko.
		try {
			FileReader fr = new FileReader(RUTA_LANGILE);
			BufferedReader br = new BufferedReader(fr);
			String lerroa;
			lerroa = br.readLine();
			while (lerroa != null) {
				String[] lerroZatiak = lerroa.split("	");
				String kodea = lerroZatiak[0];
				if (kodea.equals(kodeaBilatu)) {
					String izena = lerroZatiak[1];
					String abizena = lerroZatiak[2];
					String telefonoa = lerroZatiak[4];
					String kontratazio_data = lerroZatiak[5];

					System.out.println("Izena: " + izena);
					System.out.println("Abizena: " + abizena);
					System.out.println("Telefonoa: " + telefonoa);
					System.out.println("Kontratazio data: " + kontratazio_data);
					// Aurkituta booleanoarekin lortzen dugu identifikatzea ea langilea aurkitu den
					// hala ez, kodearen arabera.
					aurkituta = true;
					break;
				}

				lerroa = br.readLine();
			}

			// Ez badu aurkituta booleanoa egia bihurtzen, agertuko da hurengo mezua ez duen
			// aurkitu bezala.
			if (!aurkituta) {
				System.out.println("Ez da aurkitu langilerik hurrengo kodearekin: " + kodeaBilatu);
			}

			br.close();
			fr.close();

		} catch (FileNotFoundException e) {
			System.out.println("Errorea: fitxategia ezin da aurkitu.");
		} catch (IOException e) {
			System.out.println("Errorea: fitxategia irakurtzean arazoa.");
		}
		// Behin langilearen identifikazio-prozesua bukatuta, langileen menura
		// bueltatuko da.
		System.out.println("Langileen menura itzultzen...");
		PDAmenu.menuLangileak();
	}

	public static void erlazioakLangileNagusi() {
		// Sartzen dugun nagusi kodearen arabera, nagusi horren menpe dauden langileak kontsultatuko ditu.
		System.out.println("Sartu nagusiaren kodea:");
		String kodeaBilatu = sc.nextLine();
		boolean aurkituta = false;
		boolean nagusizerrenda = false;
		// Bilatuko du langilea eta haren kodea aterako du. Ondoren, kargura dituen langile zerrenda aterako du.
		try {
			FileReader fr = new FileReader(RUTA_LANGILE);
			BufferedReader br = new BufferedReader(fr);
			String lerroa;
			lerroa = br.readLine();
			while (lerroa != null) {
				String[] lerroZatiak = lerroa.split("	");
				String kodea = lerroZatiak[6];
				if (kodea.equals(kodeaBilatu)) {
					if (!nagusizerrenda) {
						System.out.println("Nagusi kodea: " + kodea);
						System.out.println("Langile zerrenda:");
						nagusizerrenda = true;
					}

					String izena = lerroZatiak[1];
					String abizena = lerroZatiak[2];
					String emaila = lerroZatiak[3];

					System.out.println("- " + izena + " " + abizena + " | " + emaila);
					aurkituta = true;
				}

				lerroa = br.readLine();
			}

			if (!aurkituta) {
				System.out.println("Ez da aurkitu nagusirik hurrengo kodearekin: " + kodeaBilatu);
			}

			br.close();
			fr.close();

		} catch (FileNotFoundException e) {
			System.out.println("Errorea: fitxategia ezin da aurkitu.");
		} catch (IOException e) {
			System.out.println("Errorea: fitxategia irakurtzean arazoa.");
		}
		System.out.println("Langileen menura itzultzen...");
		PDAmenu.menuLangileak();
	}

	public static void kontsultaBezero() {
		// Sartzen dugun koodearen arabera, langile horren informazia kontsultatu egiten
		// du funtzioak.
		System.out.print("Sartu bezeroaren kodea: ");
		String kodeaBilatu = sc.nextLine();
		boolean aurkituta = false;

		// FileReader-ak sortu ditugu bi fitxategietatik bezeroen informazioa
		// ateratzeko. Lehen fitxategitik izena, abizena eta emaila ateratzen dugu, eta
		// bigarrenetik telefonoa. Bakoitza variable bati esleitu dugu pantailatik atera
		// ahal izateko.
		try {
			FileReader fr1 = new FileReader(RUTA_BEZERO);
			BufferedReader br1 = new BufferedReader(fr1);
			FileReader fr2 = new FileReader(RUTA_BEZERO_TLF);
			BufferedReader br2 = new BufferedReader(fr2);
			String lerroa1, lerroa2;
			lerroa1 = br1.readLine();
			lerroa2 = br2.readLine();
			while (lerroa1 != null) {
				String[] lerroZatiak = lerroa1.split("	");
				String kodea = lerroZatiak[0];
				if (kodea.equals(kodeaBilatu)) {
					String izena = lerroZatiak[1];
					String abizena = lerroZatiak[2];
					String emaila = lerroZatiak[4];

					System.out.println("Izena: " + izena);
					System.out.println("Abizena: " + abizena);
					System.out.println("Emaila: " + emaila);
					// Aurkituta booleanoarekin lortzen dugu ateratzea ea bezeroa aurkitu den hala
					// ez sartu dugun kodearen arabera.
					aurkituta = true;
					break;
				}

				lerroa1 = br1.readLine();
			}

			while (lerroa2 != null) {
				String[] lerroZatiak = lerroa2.split("	");
				String kodea = lerroZatiak[1];
				if (kodea.equals(kodeaBilatu)) {
					String telefonoa = lerroZatiak[2];

					System.out.println("Telefonoa: " + telefonoa);
					break;
				}

				lerroa2 = br2.readLine();
			}

			// Ez badu aurkituta booleanoa egia bihurtzen, agertuko da hurengo mezua ez duen
			// aurkitu bezala.
			if (!aurkituta) {
				System.out.println("Ez da aurkitu bezerorik hurrengo kodearekin: " + kodeaBilatu);
			}

			br1.close();
			fr1.close();

			br2.close();
			fr2.close();

		} catch (FileNotFoundException e) {
			System.out.println("Errorea: fitxategia ezin da aurkitu.");
		} catch (IOException e) {
			System.out.println("Errorea: fitxategia irakurtzean arazoa.");
		}
		// Behin bezeroaren identifikazioa bukatuta, bezeroen menura bueltatuko da.
		System.out.println("Bezeroen menura itzultzen...");
		PDAmenu.menuBezeroak();
	}

	public static void fakturaSortu() {
		// Bi kode eskatu beharko ditugu: eskari kodea eta eskari lerroa.
		System.out.print("Sartu eskariaren kodea: ");
		String kodeaBilatu = sc.nextLine();
		String lerroaBilatu = "0";
		do {
			System.out.print("Sartu eskariaren lerroa 1-9: ");
			lerroaBilatu = sc.nextLine();
		} while (!lerroaBilatu.equals("1") && !lerroaBilatu.equals("2") && !lerroaBilatu.equals("3")
				&& !lerroaBilatu.equals("4") && !lerroaBilatu.equals("5") && !lerroaBilatu.equals("6")
				&& !lerroaBilatu.equals("7") && !lerroaBilatu.equals("8") && !lerroaBilatu.equals("9"));
		boolean aurkituta = false;
		boolean aurkituta2 = false;
		// Definituko ditugu string guztiak gero FileWriter-ak erabili ahal izateko.
		String kodea = "";
		String lerroa = "";
		String bezeroa = "";
		String bezeroId = "";
		String izena = "";
		String abizena = "";
		String eskaera_data = "";
		String produktuId = "";
		String kopurua = "";
		String salmenta = "";
		String salmentaBorobildu = "";

		// Sartzen ditugun kode-konbinazioaren arabera hurrengo fitxategietan bilatuko
		// du eskari bakoitzaren ezaugarriak. Eskarien datuak bi fitxategietatik
		// ateratzen da, eta hirugarren bezeroen fitxategia erabiltzen da eskari
		// bakoitza bezero batekin erlazionatzeko.
		try {
			FileReader fr1 = new FileReader(RUTA_ESKARI);
			BufferedReader br1 = new BufferedReader(fr1);
			FileReader fr2 = new FileReader(RUTA_ESKARI_LERRO);
			BufferedReader br2 = new BufferedReader(fr2);
			FileReader fr3 = new FileReader(RUTA_BEZERO);
			BufferedReader br3 = new BufferedReader(fr3);
			String lerroa1, lerroa2, lerroa3;
			lerroa1 = br1.readLine();
			lerroa2 = br2.readLine();
			lerroa3 = br3.readLine();
			while (lerroa1 != null) {
				String[] lerroZatiak = lerroa1.split("	");
				kodea = lerroZatiak[0];
				if (kodea.equals(kodeaBilatu)) {
					bezeroId = lerroZatiak[1];
					eskaera_data = lerroZatiak[3];
					aurkituta = true;
					break;
				}

				lerroa1 = br1.readLine();
			}

			while (lerroa3 != null) {
				String[] lerroZatiak = lerroa3.split("	");
				bezeroa = lerroZatiak[0];
				if (bezeroa.equals(bezeroId)) {
					izena = lerroZatiak[1];
					abizena = lerroZatiak[2];
					break;
				}

				lerroa3 = br3.readLine();
			}

			while (lerroa2 != null) {
				String[] lerroZatiak = lerroa2.split("	");
				lerroa = lerroZatiak[1];
				if (lerroa.equals(lerroaBilatu)) {
					produktuId = lerroZatiak[2];
					kopurua = lerroZatiak[3];
					salmenta = lerroZatiak[4];
					salmenta = salmenta.replace(",", ".");
					double salmentaZbk = Double.parseDouble(salmenta);
					DecimalFormat df = new DecimalFormat("#.00");
					salmentaBorobildu = df.format(salmentaZbk).replace(",", ".");
					aurkituta2 = true;
					break;
				}

				lerroa2 = br2.readLine();
			}

			if (!aurkituta | !aurkituta2) {
				System.out.println("Ez da aurkitu eskaririk hurrengo kodearekin: " + kodeaBilatu);
			}

			br1.close();
			fr1.close();

			br2.close();
			fr2.close();

			br3.close();
			fr3.close();

			// Eskariaren datuak hartu ahal baditu, orduan fakturaren fitxategia sortzen du FileWriter batekin.
			if (aurkituta && aurkituta2) {
				FileWriter fw = new FileWriter("src/produktua/fakturak/faktura_" + kodea + "_" + lerroa + ".txt");
				BufferedWriter bw = new BufferedWriter(fw);
				bw.write("#" + kodea + "_" + lerroa + " eskariaren faktura");
				bw.write("\n= = = = = = = = = = = = =");
				bw.write("\nEskaera zenbakia: " + kodea + "_" + lerroa);
				bw.write("\nEskaera data: " + eskaera_data);
				bw.write("\nBezeroa: " + izena + " " + abizena);
				bw.write("\n- - - - - - - - - - - - -");
				bw.write("\nZehaztasunak:\n Produktua: " + produktuId + "\n Kopurua: " + kopurua + "\n Totala: "
						+ salmentaBorobildu + "€");
				bw.close();
				fw.close();
				System.out.println("OK | Faktura gordeta fitxategietan.");
			}
		} catch (FileNotFoundException e) {
			System.out.println("Errorea: fitxategia ezin da aurkitu.");
		} catch (IOException e) {
			System.out.println("Errorea: fitxategia irakurtzean arazoa.");
		}
		System.out.println("Bezeroen menura itzultzen...");
		PDAmenu.menuBezeroak();
	}

	public static void atzeraJoan() {
		// Funtzio honek soilik menura bideratzen du erabiltzailea.
		PDAmenu.menua();
	}

	public static void saioaItxi() {
		// Funtzioak galdetzen du ea saioa itxi nahi duen ala ez, erantzuna letra
		// txikira bihurtzen du eta soilik erantzuna "bai" denean saioa itxiko du.
		// Horrela ez bada, menu nagusira joango da berriz.
		System.out.println("=== SAIOA ITXI ===\nSaioa itxi nahi duzu? (Bai/Ez)");
		String erantzuna = sc.nextLine().toLowerCase();
		if (erantzuna.equals("bai")) {
			System.out.println("Saioa itxita.");
		} else {
			System.out.println("Hasierako menura itzultzen...");
			PDAmenu.menua();
		}
	}

}
