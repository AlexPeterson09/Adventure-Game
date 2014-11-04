import java.util.ArrayList;
/**
 *	Orc object
 */
public class Orc {

	String[] orcNames = {"Azog", "Balcmeg", "Boldog", "Bolg", "Golfimbul", "Gorbag", "Gorgol", "Grishnákh", "Lagduf", "Lug", "Lugdush", "Mauhúr", "Muzgash", "Orcobal", "Othrod", "Radbug", "Shagrat", "Snaga", "Ufthak", "Uglúk"};
	public String name = "";
	public int health = 80;
	public int currentX;
	public int currentY;
	public int attack = 15;
	public Player currentPlayer;
	/**
	 *	Assigns the Orc's name, currentX, and currentY
	 *  
	 *	@param x Orc's currentX
	 *	@param y Orc's currentY
	 */
	public Orc (int x, int y) {
	
		int rand = (int)(Math.random() * (orcNames.length - 0) + 0);
		name = orcNames[rand];
		currentX = x;
		currentY = y;
	
	}
	/**
	 *	Deals damage to Orc's currentPlayer
	 */
	public void attack () {
	
		currentPlayer.health = currentPlayer.health-attack;
	
	}
	/**
	 *	returns the Orc's name
	 *  
	 *	@return name
	 */
	public String toString() {
	
		return name;
	
	}
	
}