package dungeon;

import java.util.Scanner;

/**
 * Title: DungeonCharacters.Hero.java
 * <p>
 * Description: Abstract base class for a hierarchy of heroes.  It is derived
 * from DungeonCharacters.DungeonCharacter.  A DungeonCharacters.Hero has battle choices: regular attack and a
 * special skill which is defined by the classes derived from DungeonCharacters.Hero.
 * <p>
 * class variables (all are directly accessible from derived classes):
 * chanceToBlock -- a hero has a chance to block an opponents attack
 * numTurns -- if a hero is faster than opponent, their is a possibility
 * for more than one attack per round of battle
 * <p>
 * class methods (all are public):
 * public DungeonCharacters.Hero(String name, int hitPoints, int attackSpeed,
 * double chanceToHit, int damageMin, int damageMax,
 * double chanceToBlock)
 * public void readName()
 * public boolean defend()
 * public void subtractHitPoints(int hitPoints)
 * public void battleChoices(DungeonCharacters.DungeonCharacter opponent)
 * <p>
 * Copyright:    Copyright (c) 2001
 * Company:
 *
 * @author
 * @version 1.0
 */


abstract class Hero extends DungeonCharacter {
    protected double chanceToBlock;
    protected int numTurns;

    public Hero(String name, int hitPoints, int attackSpeed,
                double chanceToHit, int damageMin, int damageMax,
                double chanceToBlock) {
        super(name, hitPoints, attackSpeed, chanceToHit, damageMin, damageMax);
        this.chanceToBlock = chanceToBlock;
        readName();
    }

    private void readName() {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter character name: ");
        this.name = in.nextLine();
        System.out.println();
    }

    public void subtractHitPoints(int hitPoints) {
        if (Math.random() <= chanceToBlock) {
            System.out.println(name + " BLOCKED the attack!");
        } else {
            super.subtractHitPoints(hitPoints);
        }

    }

    public void battleChoices(DungeonCharacter opponent) {
        numTurns = calcTurns(this.attackSpeed, opponent.getAttackSpeed());

        if (numTurns == 0)
            numTurns++;
        
        System.out.println("Number of turns this round is: " + numTurns);
        printHealthInfo(opponent);

        int choice;
        String c;

        Scanner inInt = new Scanner(System.in);

        do {
            System.out.println("1. Attack Opponent");
            System.out.println("2. " + special.specialOption());
            System.out.println("3. Quit");
            System.out.print("Choose an option: ");
            
            c = inInt.nextLine();
            while(!c.equals("1") && !c.equals("2") && !c.equals("3")) {
            	System.out.println("\nInvalid Input. Please re-enter a valid choice.\n");
            	System.out.println("1. Attack Opponent");
                System.out.println("2. " + special.specialOption());
                System.out.println("3. Quit");
                System.out.print("Choose an option: ");
                c = inInt.nextLine();
            }
            
            System.out.println();
            choice = Integer.parseInt(c);
            switch (choice) {
                case 1:
                	System.out.println("\n--------------------------------------------------------------------\n");
                    attack(opponent);
                    break;
                case 2:
                	System.out.println("\n--------------------------------------------------------------------\n");
                    special.specialMove(this, opponent);
                    break;
                case 3:
                	System.out.println("\n--------------------------------------------------------------------\n");
                	DungeonAdventure.handleQuitAttempt();
                	break;
                default:
                	System.out.println("\n--------------------------------------------------------------------\n");
                    System.out.println("invalid choice!\n");
            }

            numTurns--;
            if (numTurns > 0 && isAlive() && opponent.isAlive()) {
            	System.out.println("\n--------------------------------------------------------------------\n");
                System.out.println("Number of turns remaining is: " + numTurns);
                printHealthInfo(opponent);
            }
            

        } while (numTurns > 0 && isAlive() && opponent.isAlive());

    }

    private void printHealthInfo(DungeonCharacter opponent) {
    	System.out.println("");
		System.out.println(name +"'s health: "+hitPoints);
		System.out.println(opponent.getName()+"'s health: "+opponent.getHitPoints());
		System.out.println("");
		
	}

	private int calcTurns(final int attackSpeedHero, final int attackSpeedMonster) {
        return attackSpeedHero / attackSpeedMonster;
    }
    
    public void incrementNumTurns() {
    	numTurns++;
    }
    
	public void fallsInPit() {
		//set amount from 1 to 20
		int amount =(int)(Math.random()*((20)-1))+1;
		this.hitPoints -= amount;
		if(isAlive()) {
			System.out.println(name + " has FALLEN INTO A PIT! "+name+" takes <"+amount+"> damage. Current health is now "+hitPoints+".");
		}
		else {
			System.out.println(name + " has FALLEN INTO A PIT! "+name+" takes <"+amount+"> damage. Current health is now 0.");
		}
	}

	

}