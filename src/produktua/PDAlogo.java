package produktua;

public class PDAlogo {
	
	public static void logoa() {
		marrazkia1();
		marrazkia2();
		marrazkia3();
		lerroa();
		zutabea();
		lerroa();
		marrazkia3();
	}


	public static void marrazkia1() {
		for (int i = 7; i >= 1; i -= 2) {
			int zuria = (7 - i) / 2;
			for (int j = 0; j < zuria; j++) {
				System.out.print(" ");
			}
			for (int j = 0; j < i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}

	public static void marrazkia2() {
		for (int i = 1; i <= 7; i += 2) {
			int zuria = (7 - i) / 2;
			for (int j = 0; j < zuria; j++) {
				System.out.print(" ");
			}
			for (int j = 0; j < i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}

	public static void marrazkia3() {
		for (int i = 1; i <= 4; i++) {
			for (int j = 4; j > i; j--) {
				System.out.print(" ");
			}
			System.out.print("*");
			if (i > 1) {
				for (int j = 1; j < (i - 1) * 2; j++) {
					System.out.print(" ");
				}
				System.out.print("*");
			}
			System.out.println();
		}
	}

	public static void lerroa() {
		for (int i = 1; i <= 7; i++) {
			System.out.print("*");
		}
		System.out.println();
	}

	public static void zutabea() {
		for (int i = 1; i <= 3; i++) {
			for (int j = 0; j < 3; j++) {
				System.out.print(" ");
			}
			System.out.println("*");
		}
	}

}
