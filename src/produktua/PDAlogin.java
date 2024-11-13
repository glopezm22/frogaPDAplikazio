package produktua;

import java.util.Scanner;
import java.util.HashMap;

public class PDAlogin {

	private static Scanner sc = new Scanner(System.in);
	
	//HashMap bat sortzen da bi String-ekin erabiltzaileak eta pasahitzak gordetzeko.
	private static HashMap<String, String> users = new HashMap<>();

	public static void identifikazioa() {

		// Sisteman gordetako erabiltzaileak.
		users.put("admin", "1234");
		users.put("langile", "1234");
		users.put("bezero", "1234");

		boolean login = false;

		// Kredentzialak eskatzen ditu.
		do {
			System.out.print("Erabiltzailea:");
			String erabiltzailea = sc.nextLine();
			System.out.print("Pasahitza:");
			String pasahitza = sc.nextLine();

			// Kredentzialeen autentikazioa.
			if (authenticate(erabiltzailea, pasahitza)) {
				System.out.println("Saioa hasita, " + erabiltzailea);
				login = true;
			} else {
				System.out.println("Kredentzialak ez dira zuzenak.");
			}

		} while (!login);

	}

	// Autentikazio metodoa: ikusten du ea erabiltzailea sisteman gordeta dagoen eta
	// ea pasahitza bat egiten duen erabiltzailearekin.
	private static boolean authenticate(String erabiltzailea, String pasahitza) {
		if (users.containsKey(erabiltzailea)) {
			return users.get(erabiltzailea).equals(pasahitza);
		}
		return false;
	}
}
