
public class Game {
	static int _zeilen =  3;
	static int _spalten = 3;
	public static void main(String[] args) {
		String[][] feld = mineField(_zeilen,_spalten);
		spielfeldAnzeigen(feld, _zeilen, _spalten);
		
	}
	public static String[][] mineField(int Zeilen, int Spalten){
		String[][] mineFeld  = new String[Zeilen][Spalten];
		for(int i = 0; i<mineFeld.length;i++) {
			for(int q = 0; q<mineFeld.length;q++) {
				mineFeld[i][q] = "[ ]";
			}
		}
		return mineFeld;
	}
	public static void spielfeldAnzeigen(String[][] feld, int zeilen, int spalten) {
		for(int i = 0; i<zeilen;i++) {
			for(int q = 0;q<spalten;q++) {
				System.out.print(feld[i][q]);
			}
		System.out.println();
		}
	}
}
