import java.util.ArrayList;
/**
 *	Location object
 */
public class Location {

	public Player player;
	public ArrayList<Item> itemsHere = new ArrayList<Item>();
	public String name = "";
	public String roomText = "";
	public int status;
	public World world;
	public int worldX;
	public int worldY;
	
	/*status:
	*	0 = locked
	*	1 = available
	*	2 = player
	*/
	/**
	 *	Assigns the Location's name, status, world, worldX, and worldY
	 *  
	 *	@param n Location's name
	 *	@param s Location's status
	 *	@param w Location's world
	 *	@param x Location's worldX
	 *	@param y Lcoation's worldY
	 */
	public Location(String n, int s, World w, int x, int y) {
	
		name = n;
		status = s;
		world = w;
		worldX = x;
		worldY = y;
		world.worldList[x][y] = this;
	
	}
	/**
	 *	returns the Location's name
	 *  
	 *	@return name
	 */
	public String toString() {
	
		return name;
	
	}
	/**
	 *	returns more information about the Location
	 *  
	 *	@return name + roomText
	 */
	public String info() {
		
		String str = "";
		str+=name + "\n";
		str+=roomText + "\n";
		return str;
		
	}
	
}