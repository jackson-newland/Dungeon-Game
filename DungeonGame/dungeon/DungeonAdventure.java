package dungeon;
import java.util.*;
public class DungeonAdventure {
	private static Scanner kb = new Scanner(System.in);
	private static Dungeon d;
	private static Hero theHero;
	private static Inventory inventory;
	
	public static void main(String[] args) {
		startGame();
		
	}//end main
	
	private static void startGame() {
		info();
		
		HashChainAttack attackIndex = new HashChainAttack(3);
		HashChainSpecial specialIndex = new HashChainSpecial(3);
		
        HeroFactory heroFactory = new HeroFactory(attackIndex, specialIndex);
        MonsterFactory theMonster = new MonsterFactory(attackIndex, specialIndex);
        
		d = new Dungeon();
		theHero = heroFactory.getHero(chooseHero());
		
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
		else if(choice.equals("printmaze")) {//hidden option for testing
			System.out.println(d.printMaze());
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
				System.exit(0);
			}
			else {
				System.out.println("You Lose. Better luck next time.");
				System.exit(0);
			}
		}
			
	}

	private static String getChoice() {
		System.out.println("Which door will you take? (type choice)");
		System.out.println("('n' for north)  ('e' for east)  ('w' for west)  ('s' for south)");
		System.out.print("--> ");
		String choice = kb.nextLine();
		choice = choice.toLowerCase();
		return choice;
		
	}
	
	private static String createName() {
		String name = null;
		boolean c = true;
		while(c) {
			System.out.print("\nChoose a name for your hero: ");
			name = kb.nextLine();
			if(name.equalsIgnoreCase("quit")) {
				handleQuitAttempt();
			}
			else {
				c = false;
			}
		}//end while
		return name;
	}



	private static void handleQuitAttempt() {
		boolean attemptQuit = true;
		while(attemptQuit) {
			System.out.println("\nQuitting already? (yes/no)");
			System.out.print("-->");
			String answer = kb.nextLine();
			if(answer.equalsIgnoreCase("yes")||answer.equalsIgnoreCase("y")) {
				System.out.println("You have failed. Bring courage next time coward.");
				System.exit(0);
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
		System.out.println("Welcome to the Dungeon Maze.");
		System.out.println("To quit at anytime just type 'quit'");
	}
	
	public static int chooseHero() {
        int choice;
        Scanner input = new Scanner(System.in);

        System.out.println("Choose a hero:\n" +
                "1. Warrior\n" +
                "2. Sorceress\n" +
                "3. Thief\n" +
                "4. SpongeBob\n");
        System.out.print("Your choice: ");
        choice = input.nextInt();
        System.out.println();

        return choice;
    }

    public static int generateMonster() {
        int choice;

        choice = (int) (Math.random() * 3) + 1;

        return choice;
    }

}
