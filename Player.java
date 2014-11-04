import java.util.ArrayList;
/**
 *	Player object- what the user controls
 */
public class Player {

	public String name;
	public int pence;
	public int health;
	public Weapon currentWeapon;
	public int attack;
	public World currentWorld;
	public int currentX;
	public int currentY;
	public Orc currentOrc;
	public Location currentLoc;
	public String quest;
	public ArrayList<Item> inventory = new ArrayList<Item>();

	public String[] questList = {"Find The One Ring in Bilbo's Hole", "Drop The One Ring into the fires of Mt. Doom", "Travel to The Undying Lands"};
	/**
	 *	Assigns Player's name, pence, health, currentX, currentY, currentWorld, currentWeapon
	 *  
	 *	@param n Player's name
	 *	@param p Player's pence
	 *	@param h Player's health
	 *	@param x Player's currentX
	 *	@param y Player's currentY
	 *	@param w Player's currentWorld
	 *	@param wp Player's currentWeapon
	 */
	public Player(String n, int p, int h, int x, int y, World w, Weapon wp) {
	
		name = n;
		pence = p;
		health = h;
		quest = questList[0];
		currentX = x;
		currentY = y;
		currentWorld = w;
		currentWeapon = wp;
		attack = currentWeapon.damage;
	
	}
	/**
	 *	Checks to see if Player's currentX and CurrentY both match any living Orc's currentX and currentY
	 *  
	 *	@return TRUE if Player's currentX and currentY match an Orc's, FALSE if it doesn't
	 */
	public boolean inCombat() {
	
			for (int i = 0; i < currentWorld.orcs.size(); i++) {
			
				if (currentX == currentWorld.orcs.get(i).currentX && currentY == currentWorld.orcs.get(i).currentY) {
				
					currentOrc = currentWorld.orcs.get(i);
					currentOrc.currentPlayer = this;
					return true;
				
				} else {
					return false;
				}
				
			}
		
		return false;
	}
	/**
	 *	Given an index, it returns the given quest at that index in the Player's questList
	 *  
	 *	@param q quest number
	 *	@return quest at given index
	 */
	public String getQuest(int q) {
	
		return questList[q];
	
	}
	/**
	 *	Deals damage to Player's currentOrc
	 */
	public void attack() {
	
		currentOrc.health = currentOrc.health-attack;
	
	}
	/**
	 *	Heals the Player by given points
	 *
	 * @param h health points to be added
	 */
	public void heal(int h) {
	
		health += h;
	
	}
	
	/*public void flee() {
	
		int rand = (int)(Math.random() * (4 - 0) + 0);
		Location loc = getAdjLocs().get(rand);
		
		if (loc.status != 0) {
		
			if (loc.worldX == currentX+1) {
			
				moveSouth();
			
			} else if (loc.worldX == currentX-1) {
			
				moveNorth();
			
			} else if (loc.worldY == currentY+1) {
			
				moveEast();
			
			} else if (loc.worldY == currentY-1) {
			
				moveWest();
			
			}
		
		}
	
	}*/
	/**
	 *	Returns the Player's four adjecent Locations
	 *
	 * @return Arraylist of four adjacent Locations
	 */
	public ArrayList<Location> getAdjLocs() {
	
		ArrayList<Location> adjLocs = new ArrayList<Location>();
		adjLocs.add(currentWorld.worldList[currentX+1][currentY]);
		adjLocs.add(currentWorld.worldList[currentX-1][currentY]);
		adjLocs.add(currentWorld.worldList[currentX][currentY+1]);
		adjLocs.add(currentWorld.worldList[currentX][currentY-1]);
		return adjLocs;
	
	}
	/**
	 * Tests to soo if the Location to the NORTH of the Player's currentLocation is valid
	 * If isValid(), then the Player is moved there
	 */
	public void moveNorth() {
	
		if (currentX == 1 && currentY == 1) {
	
			System.out.println("You pause for a moment, realizing you're where you're meant to be...");
	
		} else {
		
			if (currentWorld.isValid(currentX-1,currentY)) {
			
				currentLoc.status = 1;
				currentLoc.player = null;
				currentX = currentX-1;
				currentLoc = currentWorld.worldList[currentX][currentY];
				System.out.println("You have entered " + currentLoc.name);
				
			} else {	
				
				System.out.println("You gaze upon lands vast and unknown...\nYou return from whence you came...");
			
			}
		}
	}
	/**
	 * Tests to soo if the Location to the South of the Player's currentLocation is valid
	 * If isValid(), then the Player is moved there
	 */
	public void moveSouth() {
	
		if (currentX == 1 && currentY == 1) {
	
			System.out.println("You pause for a moment, realizing you're where you're meant to be...");
	
		} else {
	
			if (currentWorld.isValid(currentX+1,currentY)) {
			
				currentLoc.status = 1;
				currentLoc.player = null;
				currentX = currentX+1;
				currentLoc = currentWorld.worldList[currentX][currentY];
				System.out.println("You have entered " + currentLoc.name);
				
			} else {	
				
				System.out.println("You gaze upon lands vast and unknown...\nYou return from whence you came...");
			
			}
			
		}
	
	}
	/**
	 * Tests to soo if the Location to the EAST of the Player's currentLocation is valid
	 * If isValid(), then the Player is moved there
	 */
	public void moveEast() {
	
		if (currentX == 1 && currentY == 1) {
	
			System.out.println("You pause for a moment, realizing you're where you're meant to be...");
	
		} else {
		
			if (currentWorld.isValid(currentX,currentY+1)) {
			
				currentLoc.status = 1;
				currentLoc.player = null;
				currentY = currentY+1;
				currentLoc = currentWorld.worldList[currentX][currentY];
				System.out.println("You have entered " + currentLoc.name);
				
			} else {	
				
				System.out.println("You gaze upon lands vast and unknown...\nYou return from whence you came...");
			
			}
			
		}
	
	}
	/**
	 * Tests to soo if the Location to the WEST of the Player's currentLocation is valid
	 * If isValid(), then the Player is moved there
	 */
	public void moveWest() {
		
		if (currentX == 1 && currentY == 1) {
	
			System.out.println("You pause for a moment, realizing you're where you're meant to be...");
	
		} else {
		
			if (currentWorld.isValid(currentX,currentY-1)) {
			
				currentLoc.status = 1;
				currentLoc.player = null;
				currentY = currentY-1;
				currentLoc = currentWorld.worldList[currentX][currentY];
				System.out.println("You have entered " + currentLoc.name);
				
			} else {	
				
				System.out.println("You gaze upon lands vast and unknown...\nYou return from whence you came...");
			
			}
			
		}
	
	}
	/**
	 * Returns the Player's name, health, and pence
	 * 
	 * @return String containing Player's name, health, and pence
	 */
	public String toString() {
	
		return name + " has " + health + "hp and " + pence + " pence..." ;
		
	}
}