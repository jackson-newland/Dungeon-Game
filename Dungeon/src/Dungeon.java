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

import DungeonCharacters.*;

import java.util.*;

public class Dungeon {
    public static void main(String[] args) {
        HeroFactory theHero = new HeroFactory();
        MonsterFactory theMonster = new MonsterFactory();
        Battle arena = new Battle();
        do {
            arena.getBattle(theHero.getHero(chooseHero()), theMonster.getMonster(generateMonster()));

        } while (playAgain());

    }//end main method

    public static int chooseHero() {
        int choice;
        Scanner input = new Scanner(System.in);

        System.out.println("Choose a hero:\n" +
                "1. Warrior\n" +
                "2. Sorceress\n" +
                "3. Thief");
        choice = input.nextInt();
        //  input.close();
        return choice;
    }//end chooseHero method

    public static int generateMonster() {
        int choice;

        choice = (int) (Math.random() * 3) + 1;

        return choice;
    }//end generateMonster method

    public static boolean playAgain() {
        char again;
        Scanner input = new Scanner(System.in);

        System.out.println("Play again (y/n)?");
        again = input.next().charAt(0);

        return (again == 'Y' || again == 'y');
    }//end playAgain method

}