package dungeon;

import java.util.Scanner;

/**
 * Title: Dungeon.java
 * <p>
 * Description: Driver file for Heroes and Monsters project
 * <p>
 * Copyright:    Copyright (c) 2001
 * Company: Code Dogs Inc.
 * I.M. Knurdy
 * <p>
 * History:
 * 11/4/2001: Wrote program
 * --created DungeonCharacters.DungeonCharacter class
 * --created DungeonCharacters.Hero class
 * --created DungeonCharacters.Monster class
 * --had DungeonCharacters.Hero battle DungeonCharacters.Monster
 * --fixed attack quirks (dead monster can no longer attack)
 * --made DungeonCharacters.Hero and DungeonCharacters.Monster abstract
 * --created DungeonCharacters.Warrior
 * --created DungeonCharacters.Ogre
 * --made DungeonCharacters.Warrior and DungeonCharacters.Ogre battle
 * --added battleChoices to DungeonCharacters.Hero
 * --added special skill to DungeonCharacters.Warrior
 * --made DungeonCharacters.Warrior and DungeonCharacters.Ogre battle
 * --created DungeonCharacters.Sorceress
 * --created DungeonCharacters.Thief
 * --created DungeonCharacters.Skeleton
 * --created DungeonCharacters.Gremlin
 * --added game play features to Dungeon.java (this file)
 * 11/27/2001: Finished documenting program
 * version 1.0
 */



/*
  This class is the driver file for the Heroes and Monsters project.  It will
  do the following:

  1.  Allow the user to choose a hero
  2.  Randomly select a monster
  3.  Allow the hero to battle the monster

  Once a battle concludes, the user has the option of repeating the above

*/

public class DungeonOld {
    public static void main(String[] args) {
    	
    	HashChainAttack attackIndex = new HashChainAttack(3);
		HashChainSpecial specialIndex = new HashChainSpecial(3);
		
        HeroFactory theHero = new HeroFactory(attackIndex, specialIndex);
        MonsterFactory theMonster = new MonsterFactory(attackIndex, specialIndex);
        Battle arena = new Battle();
        do {
            arena.getBattle(theHero.getHero(chooseHero()), theMonster.getMonster(generateMonster()));

        } while (playAgain());

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

    public static boolean playAgain() {
        char again;
        Scanner input = new Scanner(System.in);

        System.out.println("Play again (y/n)?");
        again = input.next().charAt(0);

        return (again == 'Y' || again == 'y');
    }

}