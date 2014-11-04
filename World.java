import java.util.ArrayList;
/**
 *	World object
 */
public class World {

	public Location[][] worldList;
	public ArrayList<Orc> orcs = new ArrayList<Orc>();
	public String name = "";
	/**
	 *	Assigns World's name, width, and length
	 *  
	 *	@param n World's name
	 *	@param w Workd's width
	 *	@param h World's height
	 */
	World(String n, int w, int h) {
	
		name = n;
		worldList = new Location[h][w];
	
	}
	/**
	 *	Checks to see if Location in the worldList at the given x and y isn't null AND its status isn't 0
	 *  
	 *  @param x checked Location's X coordinate
	 *  @param y checked Location's Y coordinate
	 *	@return TRUE if element at worldList[x][y] isn't null and its status isn't 0, FALSE either does not
	 */
	public boolean isValid(int x, int y) {
	
		if (worldList[x][y] != null && worldList[x][y].status != 0) {
		
			return true;
		
		} else {
		
			return false;
		}
	
	}
	/**
	 *	Prints out the toString() of all Locations in worldList
	 */
	public void print() {
	
		for (int i = 0; i < worldList.length; i++) {
		
			for (int j = 0; j < worldList[i].length; j++) {
				
				System.out.print(worldList[i][j]);
				
				if (j < worldList[i].length - 1) {
				
					System.out.print("\t\t\t");
				}
			}
			System.out.println();
		}
	
	}
	/**
	 *	returns the World's name
	 *  
	 *	@return name
	 */
	public String toString() {
	
		return name;
	
	}
	
}