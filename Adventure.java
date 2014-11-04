import java.util.*;

public class Adventure {

	public static void main(String[] args) {
//Locations
		World mE = new World("Middle Earth",9,7);

		Location loc1 = new Location("Bilbo's Hole", 2, mE, 1, 3);	
		loc1.roomText = "\'Not a nasty, dirty, wet hole, filled with the ends of worms and an oozy smell, \nnor yet a dry, bare, sandy hole with nothing in it to sit down on or to eat: \nit was a Hobbit-hole, and that means comfort.\'";
		
		Location loc2 = new Location("Hobbiton", 1, mE, 2, 3);	
		loc2.roomText ="You gaze upon the green grass and hollow hills of The Shire...";
		
		Location loc3 = new Location("Bree", 1, mE, 2, 4);	
		loc3.roomText ="An ancient settlement; the Westernmost settlement of Men, matter of fact.";
		
		Location loc4 = new Location("Rivendell", 1, mE, 2, 5);	
		loc4.roomText ="\'The Last Homely House East of the Sea.\'";
		
		Location loc5 = new Location("Moria", 1, mE, 3, 5);	
		loc5.roomText ="\'The Doors of Durin, Lord of Moria. \nSpeak, friend, and enter.\'";
		
		Location loc6 = new Location("Lorien", 1, mE, 3, 6);	
			loc6.roomText ="\'That is the fairest of all the dwellings of my people. \nThere are no trees like the trees of that land. For in \nthe autumn their leaves fall not, but turn to gold. Not \ntill the spring and the new green opens do they fall, \nand then the boughs are laden with yellow flowers; \nand the floor of the wood is golden, and golden is the \nroof, and its pillars are of silver, for the bark of the \ntrees is smooth and grey.\'";
		
		Location loc7 = new Location("Amon Hen", 1, mE, 4, 6);	
		loc7.roomText ="\'Hill of the Eye\'";
		
		Location loc8 = new Location("Dead Marshes", 1, mE, 4, 7);	
		loc8.roomText ="\'Dreary and wearisome. Cold, clammy winter still held sway\nin this forsaken country. The only green was the scum of\nlivid weed on the dark greasy surfaces of the sullen waters.\nDead grasses and rotting reeds loomed up in the mists like\nragged shadows of long forgotten summers.\'";
		
		Location loc9 = new Location("Mt. Doom", 1, mE, 5, 7);	
		loc9.roomText ="One does not simply walk into Mordor. Its black gates are\nguarded by more than just Orcs. There is evil there that does not\nsleep. The great Eye is ever watchful. It is a barren wasteland,\nriddled with fire, ash, and dust. The very air you breathe is a\npoisonous fume.\'";
		
		Location loc10 = new Location("Minas Tirith", 0, mE, 5, 6);	
		loc10.roomText ="The White-Gold City";
		
		Location loc11 = new Location("Gulf of Lune", 0, mE, 1, 2);	
		loc11.roomText ="Great place to go gulfing";
		
		Location loc12 = new Location("The Undying Lands", 0, mE, 1, 1);	
		loc12.roomText ="Lands that, like, don't die";
		
		Orc o1 = new Orc(2,3);
		mE.orcs.add(o1);
		
		Weapon w1 = new Weapon();
		w1.damage = 25;
		w1.value = 800;
	
		Player p1 = new Player("Frodo", 8, 100, 1, 3, mE, w1);
		Player currentPlayer = p1;
	
		Item i1 = new Item();
		i1.name = "Book";
		i1.value = 10;
		loc1.itemsHere.add(i1);
		
		Item i2 = new Item();
		i2.name = "Quill";
		i2.value = 5;
		loc1.itemsHere.add(i2);
		
		Item i3 = new Item();
		i3.name = "Ink Bottle";
		i3.value = 15;
		loc1.itemsHere.add(i3);
		
		Item i4 = new Item();
		i4.name = "The One Ring";
		i4.value = 1000000;
		loc1.itemsHere.add(i4);
		
		Item i5 = new Item();
		i5. value = 1776;
		loc10.itemsHere.add(i5);
		
		//Location currentLoc = mE.worldList[p1.currentX][p1.currentY];
		currentPlayer.currentLoc = mE.worldList[p1.currentX][p1.currentY];
		currentPlayer.currentLoc.player = currentPlayer;
		boolean win = false;
		
		System.out.println("Enjoy! \n[type \"help\" or \"?\" for info]\n");

//GAMEPLAY
		System.out.println(mE);
		String input = "";
		Scanner kb = new Scanner(System.in);
		boolean quit = false;
		
		System.out.println("What is our Hero's name?");
		currentPlayer.name = kb.nextLine();
		i5.name = currentPlayer.name + "'s Crown";
		
		while (quit == false) {
			
			while (!(currentPlayer.inCombat())) {
		
				input = kb.nextLine();
				String moveSub = "";
				String pickSub = "";
				String dropSub = "";
				
				if (currentPlayer.inCombat()) {
					System.out.println(currentPlayer.currentOrc + " waits for you...");
					break;
				}
				
		//subs			
				if (input.length() >= 6) {
					//drop
					dropSub = input.substring(0, 5);
				
				}
				
				if (input.length() >= 6) {
					//move
					moveSub = input.substring(0, 5);
				
				}
				
				if (input.length() >= 7) {
					//pick up 
					pickSub = input.substring(0, 7);
				}
		//info		
				if (input.equalsIgnoreCase("location") || input.equalsIgnoreCase("loc")) {
				
					System.out.println(currentPlayer.currentLoc.info());
			
				} else if (input.equalsIgnoreCase("quest")) {
				
					System.out.println(currentPlayer.quest);
			
			
				} else if (input.equalsIgnoreCase("weapon")) {
			
					System.out.println(w1);
			
				} else if (input.equalsIgnoreCase("weapon stats")) {
			
					System.out.println(w1.weaponStat());
			
				} else if (input.equalsIgnoreCase("search") || input.equalsIgnoreCase("search area")) {
					
					if (currentPlayer.currentLoc == loc12) {
					
						System.out.println("Looking around, you find...");
						System.out.println("Inner Peace");
					
					} else {
					
						System.out.println("Looking around, you find...");
						
						if (currentPlayer.currentLoc.itemsHere.size() > 0) {
						
							for (int i = 0; i < currentPlayer.currentLoc.itemsHere.size(); i++) {
							
								System.out.println(currentPlayer.currentLoc.itemsHere.get(i));
								
							}
							
						} else { 
						
							System.out.println("Squat");
							
						}
					}
				
				} else if (input.equalsIgnoreCase("inventory") || input.equalsIgnoreCase("inv")) {
					
					System.out.println("You are carrying: ");
					
					for (int i = 0; i < currentPlayer.inventory.size(); i++) {
					
						System.out.println(currentPlayer.inventory.get(i));
						
					}
					
				} else if (input.equalsIgnoreCase("player")) {
					
					System.out.println(currentPlayer);
						
		//Movement	
				} else if (moveSub.equalsIgnoreCase("move ")) {
					
					if (input.substring(5, input.length()).equalsIgnoreCase("north")) {
					
							currentPlayer.moveNorth();	
					
					} else if (input.substring(5, input.length()).equalsIgnoreCase("south")) {
					
						currentPlayer.moveSouth();
					
					} else if (input.substring(5, input.length()).equalsIgnoreCase("east")) {
					
						currentPlayer.moveEast();
									
					} else if (input.substring(5, input.length()).equalsIgnoreCase("west")) {
				
						currentPlayer.moveWest();
					
					} else {
					
					System.out.println("Where?");
					
					}	
					
					currentPlayer.currentLoc.status = 2;
					
		//Pick up stuff
				} else if (pickSub.equalsIgnoreCase("pick up")) {
						
					String pickItem = input.substring(8, input.length());
						
					for (int i = 0; i < currentPlayer.currentLoc.itemsHere.size(); i++) {
							
						if (currentPlayer.currentLoc.itemsHere.get(i).name.equalsIgnoreCase(pickItem)) {
								
							currentPlayer.inventory.add(currentPlayer.currentLoc.itemsHere.get(i));
							currentPlayer.currentLoc.itemsHere.remove(currentPlayer.currentLoc.itemsHere.get(i));
							break;
						}
					
					}
					
		//Drop Stuff				
				} else if (dropSub.equalsIgnoreCase("drop ")) {
					
					String dropItem = input.substring(5, input.length());
					
					for (int i = 0; i < currentPlayer.inventory.size(); i++) {
						
						if (currentPlayer.inventory.get(i).name.equalsIgnoreCase(dropItem)) {
							
							currentPlayer.currentLoc.itemsHere.add(currentPlayer.inventory.get(i));
							currentPlayer.inventory.remove(currentPlayer.inventory.get(i));
							break;
						}
				
					}
					
		//Map				
				} else if (input.equalsIgnoreCase("map")) {
					System.out.println(currentPlayer.name.substring(0,1) + " = " + currentPlayer.name + "     O = Available Location     0 = Undiscovered Lands");
					for (int i = 0; i < mE.worldList.length; i++) {
			
						for (int j = 0; j < mE.worldList[i].length; j++) {
							
							if (mE.worldList[i][j] != null && mE.worldList[i][j].status == 1) {
							
								System.out.print("O ");
							
							} else if (mE.worldList[i][j] != null && mE.worldList[i][j].status == 2) {
							
								System.out.print(currentPlayer.name.substring(0,1) + " ");
							
							} else {
							
								System.out.print("0 ");
							
							}
							
						}
						System.out.println();
						
					}
			
		//Nothing	
				} else if (input.equalsIgnoreCase("poop")) {
					
					System.out.println("Classic!");
	
		//Help
				} else if (input.equalsIgnoreCase("help") || input.equalsIgnoreCase("?")) {
			
					System.out.println("Commands:");
					System.out.println("\"Quest\"\t\t\tPrints your current QUEST");
					System.out.println("\"Location\"\t\tPrints your LOCATION");
					System.out.println("\"Move + [Direction]\"\tMOVE in specified direction");
					System.out.println("\"Weapon\"\t\tPrints the NAME of your equiped weapon");
					System.out.println("\"Weapon Stats\"\t\tLists your equiped weapon's STATS");
					System.out.println("\"Search\"\t\tLists ITEMS in the area around you");
					System.out.println("\"Pick Up + [Item]\"\tPICK UP specified item");
					System.out.println("\"Drop + [Item]\"\t\tDROP specified item");
					System.out.println("\"Map\"\t\tOpen the world MAP");
					System.out.println("\"Quit\"\t\t\tEXIT the game");
			
				} else if (input.equalsIgnoreCase("q") || input.equalsIgnoreCase("quit")) {
			
					System.out.println("Goodbye");
					quit = true;
					break;
				
				} else {
			
					System.out.println("wat?");
			
				}
				
				if (loc9.itemsHere.contains(i4)) {
				
					loc9.itemsHere.remove(i4);
					System.out.println("You have defeated Sauron by returning The One Ring to the fires of Mt. Doom!");
					//unlock undying lands
					loc10.status = 1;
					loc11.status = 1;
					loc12.status = 1;
					win = true;
					currentPlayer.quest = currentPlayer.questList[2];
				
				}
				
				if (currentPlayer.inventory.contains(i4)) {
				
					currentPlayer.quest = currentPlayer.questList[1];
					//currentQuest = 1;
					
				}
				
			}//1st inside LOOP end
			
			if (currentPlayer.currentOrc != null) {
			
				System.out.println(currentPlayer.currentOrc.name + " waits for you...\n");
			
			}
//Combat Loop			
			while (currentPlayer.inCombat()) {
			
				System.out.println(currentPlayer.name + " -- " + currentPlayer.health + "\t" + currentPlayer.currentOrc.name + " -- " + currentPlayer.currentOrc.health);
				System.out.println("Attack?\t Heal?\tFlee?");
				input = kb.nextLine();
//Attack Heal Flee				
				if (input.equalsIgnoreCase("Attack")) {
				
					System.out.println("You swing at " + currentPlayer.currentOrc.name + "...");
					currentPlayer.attack();
				
				} else if (input.equalsIgnoreCase("Heal")) {
				
					System.out.println("You heal yourself 10hp...");
					currentPlayer.heal(10);
				
				/*} else if (input.equalsIgnoreCase("Flee")) {
				
					//Picks an adjacent Loc and if it is valid, player will travel there
					//Player Health - (1/2)Orc Attack
					currentPlayer.flee();
				*/
				} else {
				
					System.out.println("You hesitate...");
				
				}
//Kill		
				if (currentPlayer.currentOrc.health <= 0) {
				
					currentPlayer.currentOrc.currentX = 0;
					currentPlayer.currentOrc.currentY = 0;
					System.out.println(currentPlayer.currentOrc.name + " has fallen...");
					currentPlayer.currentOrc = null;
					System.out.println("You are left with " + currentPlayer.health + "hp");
					break;
				
				} else if (currentPlayer.health <= 0) {
				
					System.out.println("YOU HAVE FALLEN...");
					quit = true;
					break;
				
				}
				
				System.out.println(currentPlayer.currentOrc.name + " swings at you...");
				currentPlayer.currentOrc.attack();
			
			}//2nd inside LOOP end
			
			
		}//outside LOOP end
		
	}

	

}