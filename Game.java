import javax.swing.JOptionPane;

public class Game {

	static int _zeilen = 3;
	static int _spalten = 3;
	static String[][] minenfeld = spielfeldAnlegen(_zeilen, _spalten, true);
	static String[][] spielfeld = spielfeldAnlegen(_zeilen, _spalten, false);
	static int mines = 0;
	static int versuche = 0;

	public static void main(String[] args) {
		boolean ende = false;
		while (ende == false) {
			spielfeldAnzeigen();
			int posZeile = eingeben("Bitte Zeile w�hlen", (_zeilen-1));
			int posSpalte = eingeben("Bitte Spalte w�hlen", (_spalten-1));
			ende = spielfeldPruefen(posZeile, posSpalte);
		}
	}

	public static boolean spielfeldPruefen(int zeile, int spalte) {
		if (minenfeld[zeile][spalte] == "[x]") {
			spielfeld[zeile][spalte] = "<X>";
			spielfeldAnzeigen();		
			System.out.println("Bummm\nDu hast leider die Mine erwischt...");
			System.out.println("Game over!");
			return true;
		} else {
			spielfeld[zeile][spalte] = "[*]";
			return false;
		}
	}

	public static int eingeben(String hinweis, int max) {

		String eingabe = JOptionPane.showInputDialog(hinweis);
		int zahl = Integer.parseInt(eingabe);
		
		if (zahl > max || zahl < 0) {
			JOptionPane.showMessageDialog(null, "!!!Number between 0 and " + max + "!!!");
			String eingabe1 = JOptionPane.showInputDialog(hinweis);
			zahl = Integer.parseInt(eingabe1);
		}
		
		return zahl;

	}

	public static void spielfeldAnzeigen() {
		for (int z = 0; z < _zeilen; z++) {
			for (int s = 0; s < _spalten; s++) {
				System.out.print(spielfeld[z][s]);
			}
			System.out.println();
		}
		System.out.println("---------");
	}

	public static String[][] spielfeldAnlegen(int zeilen, int spalten, boolean mienenAnlegen) {
		String[][] mineField = new String[zeilen][spalten];
		for (int z = 0; z < zeilen; z++) {
			for (int s = 0; s < spalten; s++) {
				mineField[z][s] = "[ ]";
			}
		}
		if (mienenAnlegen) {
			mineField[(zeilen - 1)][0] = "[x]";
			mineField[(zeilen - 1)][(spalten - 1)] = "[x]";
			mineField[0][(spalten - 1)] = "[x]";
			mines = 3;
		}
		return mineField;
	}

}