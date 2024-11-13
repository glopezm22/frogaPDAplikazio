package produktua;

public class PDAexekutagarria {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// Lehenik eta behin erabiltzailearen identifikaziora jo behar du programak.
		PDAlogin.identifikazioa();

		// Logoa bistaratzen du.
		PDAlogo.logoa();

		// Menura jo egingo du programak logoa bistaratu ostean. Hemendik aurrera menua
		// arduratzen da beste funtzio guztiak exekutatzeaz.
		PDAmenu.menua();

	}

}
