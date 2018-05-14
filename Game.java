import javax.swing.JOptionPane;

public class Game {
	static int _zeilen = 3;
	static int _spalten = 3;
	static String[][] minenfeld = spielfeldAnlegen(_zeilen, _spalten, true);
	static String[][] spielfeld = spielfeldAnlegen(_zeilen, _spalten, false);
	static int mines = 0;

	public static void main(String[] args) {
		boolean ende = false;
		while (ende == false) {
			spielfeldAnzeigen();
			int posZeile = eingeben("Bitte Zeile wählen");
			int posSpalte = eingeben("Bitte Spalte wählen");
			ende = spielfeldPruefen(posZeile, posSpalte);
		}
	}

	public static boolean spielfeldPruefen(int zeile, int spalte) {
		if (minenfeld[zeile][spalte] == "[x]") {
			System.out.println("Bummm - du hast leider die Mine erwischt");
			System.out.println("Game over!");
			return true;
		} else {
			spielfeld[zeile][spalte] = "[*]";
		}
		return false;
	}

	public static int eingeben(String hinweis) {
		String eingabe = JOptionPane.showInputDialog(hinweis);
		return Integer.parseInt(eingabe);
	}

	public static String[][] spielfeldAnlegen(int Zeilen, int Spalten, boolean m) {
		String[][] mineFeld = new String[Zeilen][Spalten];
		for (int i = 0; i < mineFeld.length; i++) {
			for (int q = 0; q < mineFeld.length; q++) {
				mineFeld[i][q] = "[ ]";
			}
		}
		if (m == true) {

			mineFeld[2][0] = "[x]";
			mineFeld[1][1] = "[x]";
			mineFeld[0][2] = "[x]";
			mines = 3;

		}
		return mineFeld;
	}

	public static void spielfeldAnzeigen() {

		for (int i = 0; i < _zeilen; i++) {
			for (int q = 0; q < _spalten; q++) {
				System.out.print(spielfeld[i][q]);
			}
			System.out.println();
		}
		System.out.println("-----------------");
	}
}
