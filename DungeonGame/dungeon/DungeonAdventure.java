package dungeon;
import java.util.*;
public class DungeonAdventure {
	private static Scanner kb = new Scanner(System.in);
	private static Dungeon d;
	private static Hero theHero;
	private static Inventory inventory;
	
	public static void main(String[] args) {
		System.out.println("\nWelcome to the Dungeon Maze.\n");
		System.out.println("To quit at anytime just type 'quit'");
		System.out.println("To get instructions/information about the game type 'info'");
		startGame();
		
	}//end main
	
	private static void startGame() {
		
		HashChainAttack attackIndex = new HashChainAttack(3);
		HashChainSpecial specialIndex = new HashChainSpecial(3);
		
        HeroFactory heroFactory = new HeroFactory(attackIndex, specialIndex);
       
        
		d = new Dungeon();
		System.out.println("--------------------------------------------------------------------");
		theHero = heroFactory.getHero(chooseHero());
		System.out.println("--------------------------------------------------------------------");
		
		inventory = new Inventory(theHero);
		
		System.out.println("\nWelcome "+theHero.getName()+". You have entered the first room.");
		
		do{
			d.printCurrentRoom();
			System.out.println(inventory.toString());
			String choice = getChoice();
			System.out.println("\n\n--------------------------------------------------------------------\n");
			performChoice(choice);
			System.out.println("\n--------------------------------------------------------------------\n");
	
		}while(countinueGame());
		endGame();
			
	}
	
	private static boolean countinueGame() {
		if(!theHero.isAlive()) {
			System.out.println("Uh oh, your Hero "+theHero.getName()+" has died. Better luck next time.");
			return false;
		}
		return true;
	}

	private static void performChoice(String choice) {
		if(choice.equals("quit")) {
			handleQuitAttempt();
		}
		else if(d.foundExit() && choice.equalsIgnoreCase("exit")) {
			handleExit();
		}
		else if(choice.equals("n")||choice.equals("s")||choice.equals("w")||choice.equals("e")) {
			handleNewRoom(choice);
		}
		else if(choice.equals("h") && inventory.getHealingPotions()>0) {
			inventory.useHealingPotion();
		}
		else if(choice.equals("h")&& inventory.getHealingPotions() == 0){
			System.out.println(theHero.getName() + " has no healing potions in their inventory.");
		}
		else if(choice.equals("v") && inventory.getVisionPotions()>0) {
			d.useVisionPotion();
			inventory.removeVisionPotion();
		}
		else if(choice.equals("v") && inventory.getVisionPotions()==0){
			System.out.println(theHero.getName() + " has no vision potions in their inventory.");
		}
		else if(choice.equals("printmaze".toLowerCase())) {//hidden option for testing
			System.out.println(d.printMaze());
		}
		else if(choice.equals("info".toLowerCase())) {
			info();
		}
		else {
			System.out.println("Invalid input. Please re-enter choice.");
		}
		
		
	}


	private static void handleNewRoom(String choice) {
		d.move(choice,theHero.getName());
		Room cr = d.currentRoom();//current Room
		if(cr.hasPillar()) {
			System.out.println(theHero.getName()+" has found a PILLAR OF OO in the room! "+theHero.getName()+" adds the pillar of "+cr.pillarName()+" to their inventory.");
			cr.removePillar(cr.pillarName().toLowerCase());
			inventory.addPillar();
		}
		else if(cr.isExit()) {System.out.println("You found the exit! (type 'exit' to leave the dungeon)");}
		else if(cr.hasHealthPotion()) {
			System.out.println(theHero.getName() + " has found a HEALING POTION in the room! "+theHero.getName()+" adds the healing potion to their inventory.");
			inventory.addHealingPotion();
			cr.removeHealingPotion();
		}
		else if(cr.hasPit()) {
			theHero.fallsInPit();
		}
		else if(cr.hasVisionPotion()) {
			System.out.println(theHero.getName() + " has found a VISION POTION in the room! "+theHero.getName()+" adds the vision potion to their inventory.");
			inventory.addVisionPotion();
			cr.removeVisionPotion();
		}
		
		if(cr.isEntrance() || cr.isExit()) {
			System.out.println("This is a safe room from monsters");
		} else if (monsterChance() <= 3) {
			System.out.println(theHero.getName() + " encounters a monster!");
			cr.monsterRoom(theHero);
			cr.removeMonster();
<<<<<<< HEAD
			if(theHero.isAlive())
				chanceDrop();
		}
		
	}
	
	private static void chanceDrop() {
		Random r = new Random();
		float chance = r.nextFloat();
		if(chance >= .50) {
			System.out.println("\nThe Monster drops a HEALING POTION.");
			System.out.println(theHero.getName()+" picks up the healing potion.");
			inventory.addHealingPotion();
		}
		else {
			System.out.println("The Monster drops a VISION POTION.");
			System.out.println(theHero.getName()+" picks up the vision potion.");
			inventory.addVisionPotion();
=======
>>>>>>> 33ab4714e3f8ef0581ec832f608d4b380fc42170
		}
		
	}

	private static void handleExit() {
		System.out.println("Are you ready to leave?");
		System.out.println("(Remember that leaving without all 4 pillars means you lose the game)");
		System.out.println("(Type 'yes' to leave, Type anything else to stay)");
		System.out.print("-->");
		String c = kb.nextLine().toLowerCase();
		if(c.equals("yes")||c.equals("y")) {
			if(inventory.hasAllPillars()) {
				System.out.println("\n--------------------------------------------------------------------\n");
				System.out.println("YOU WIN! Congratulations "+theHero.getName()+", you have conquered the maze!");
				System.out.println("\n--------------------------------------------------------------------\n");
				endGame();
			}
			else {
				System.out.println("You Lose. Better luck next time.");
				endGame();
			}
		}
			
	}
	
	private static void endGame(){
		System.out.println(d.printMaze());
		System.exit(0);;
	}

	private static String getChoice() {
		System.out.println("Which door will you take? (type choice)");
		System.out.println("('n' for north)  ('e' for east)  ('w' for west)  ('s' for south)");
		System.out.print("--> ");
		String choice = kb.nextLine();
		choice = choice.toLowerCase();
		return choice;
		
	}
	

	public static void handleQuitAttempt() {
		boolean attemptQuit = true;
		while(attemptQuit) {
			System.out.println("\nQuitting already? (yes/no)");
			System.out.print("-->");
			String answer = kb.nextLine();
			if(answer.equalsIgnoreCase("yes")||answer.equalsIgnoreCase("y")) {
				System.out.println("You have failed. Bring courage next time coward.");
				endGame();
			}
			else if(answer.equalsIgnoreCase("no")||answer.equalsIgnoreCase("n")) {
				System.out.println("Alright, we will continue on then!");
				attemptQuit = false;
			}
			else{
				System.out.println("I did not understand that answer. Let's try again.");
			}
		}
	}

	private static void info() {
		System.out.println("*******************************************************************\n" + 
				"	 Information about the game:\n" + 
				"*******************************************************************\n" + 
				"|	Room letter representations:\n" + 
				"|	P- Pit\n" + 
				"|	I - Entrance(IN)\n" + 
				"|	O - Exit(Out)\n" + 
				"|	V - Vision Potion\n" + 
				"|	H - Healing Potion\n" + 
				"|	C - A pillar of OO\n" + 
				"|	E - Empty room\n" + 
				"|	\n" + 
				"|	-If an item is picked up by the hero, \n" + 
				"|	you will not see it in the room \n" + 
				"|	after it is picked up. The room will go back \n" + 
				"|	to being empty 'E'.\n" + 
				"|	\n" + 
				"|	-You can see these room representations when \n" + 
				"|	you use the vision potion.\n" + 
				"--------------------------------------------------------------------\n" + 
				"|	HOW TO WIN THE GAME:\n" + 
				"|	-Collect all 4 pillars of OO. \n" + 
				"|	\n" + 
				"|	Pillars: \n" + 
				"|	(Abstraction, Encapsulation, Inheritance, Polymorphism)\n" + 
				"|	\n" + 
				"|	-Once all 4 pillars are collected, find \n" + 
				"|	the Exit room and leave the maze.\n" + 
				"--------------------------------------------------------------------\n" + 
				"|	ADDITIONAL HINTS/INFO:\n" + 
				"|	\n" + 
				"|	-Monsters spawn randomely in rooms \n" + 
				"|	that are not the Entrance or Exit of dungeon.\n" + 
				"|\n" + 
				"|	-You can type option 'quit' to quit \n" + 
				"|	at anytime when traversing the maze.\n" + 
				"|\n" + 
				"|	-(cheat) You can type option 'printmaze' \n" + 
				"|	to print out the whole maze at anytime.\n" + 
				"|\n" + 
				"|	\n" + 
				"*******************************************************************");
	}
	
	public static int chooseHero() {
        int choice;
        String c;
        Scanner input = new Scanner(System.in);
        do {
        	System.out.println("\nChoose a hero:\n" +
                    "1. Warrior\n" +
                    "2. Sorceress\n" +
                    "3. Thief\n" +
                    "4. SpongeBob\n"+
                    "5. Old Man\n");
        	System.out.println("(Type choice number)");
            System.out.print("Your choice: ");
            c = input.nextLine();
            //choice = input.nextInt();
            
            System.out.println();
            if(c.equals("quit")) {handleQuitAttempt();}
            else if(!c.equals("1") && !c.equals("2") && !c.equals("3") && !c.equals("4") && !c.equals("5")) {
            	System.out.println("\nInvalid input. Please re-enter a valid option.\n");
            }

        }while(!c.equals("1") && !c.equals("2") && !c.equals("3") && !c.equals("4")&& !c.equals("5"));
        choice = Integer.parseInt(c);
        return choice;
    }

    private static int monsterChance() {
    	int roll = (int) (Math.random() * 10 ) + 1;
    	return roll;
    }

}
