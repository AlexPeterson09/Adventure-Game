import java.util.*;
/**
 *	Weapon object
 */
public class Weapon {

	//public Card(String suit, int value);
	public String name;
	public String make;
	public String type;
	public String adj;
	public int damage;
	public int value;
	
	public String[] nameList = {"Stinger", "Aranruth", "Belthronding", "Dagmor", "Grond", "Herugrim", "Narsil", "Orcrist"};
	public String[] makeList = {"Elvish", "Orcish", "Dwarvish", "Uruk-Hai", "Goblin"};
	public String[] typeList = {"Bow", "Spear", "Pike", "Sword", "Axe", "Mace", "War Hammer", "Crossbow"};
	public String[] adjList = {"Large", "Small", "Enchanted", "Mighty"};
	/**
	 *	Randomly assigns the Weapon's make, adj, type, and name
	 */
	public Weapon() {
	
		int rand = (int)(Math.random() * (5 - 0) + 0);
		make = makeList[rand];
	
		rand = (int)(Math.random() * (4 - 0) + 0);
		adj = adjList[rand];
		
		rand = (int)(Math.random() * (5 - 0) + 0);
		type = typeList[rand];
		
		rand = (int)(Math.random() * (8 - 0) + 0);
		name = nameList[rand];
	
	}
	/**
	 *	Returns a string with the Weapon's adj, make, type and name
	 *  
	 *	@return adj + make + type + name
	 */
	public String toString() {
		String str = "";
		str+="The " + adj + " ";
		str+=make + " ";
		str+=type + ", ";
		str+=name;
		return str;
	}	
	/**
	 *	Returns a string with the Weapon's stats
	 *  
	 *	@return value + damage
	 */
	public String weaponStat() {
		String str = "";
		str+="This item is worth " + value + " pence";
		str+="\nAnd does " + damage + " damage";
		return str;
	}	

}