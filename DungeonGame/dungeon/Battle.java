package dungeon;

import java.util.Random;
import java.util.Scanner;

public class Battle {

    public void getBattle(Hero theHero, Monster theMonster) {
        System.out.println(theHero.getName() + " battles " +
                theMonster.getName());
        System.out.println("\n--------------------------------------------------------------------\n");
        System.out.println("<TIME TO BATTLE!>");
        
        if(theMonster.name.equals("Deadly Virus") && theHero.isOldMan()) {
        	System.out.println("\n--------------------------------------------------------------------\n");
            theMonster.specialMove(theHero);
        }

        while (theHero.isAlive() && theMonster.isAlive()) {
        	System.out.println("\n--------------------------------------------------------------------\n");
   
        	theHero.battleChoices(theMonster);

        	if(theMonster.isAlive()) {
            	System.out.println("\n--------------------------------------------------------------------\n");
                theMonster.attack(theHero);
            }

<<<<<<< HEAD
        }

        if (!theMonster.isAlive()) {
            System.out.println(theHero.getName() + " is victorious!");
        } 
        else if (!theHero.isAlive()) {
=======
            if(theHero.isAlive()) {
            System.out.print("\n-->q to quit, anything else to continue: ");
            pause = input.next().charAt(0);
            System.out.println();
            }
        }

        if (!theMonster.isAlive()) {
            System.out.println(theHero.getName() + " was victorious!");
        } else if (!theHero.isAlive()) {
>>>>>>> 33ab4714e3f8ef0581ec832f608d4b380fc42170
            System.out.println(theHero.getName() + " was defeated!");
        }else {
            System.out.println(theHero.getName() + " gives up");
        	theHero.hitPoints = 0;
        }
<<<<<<< HEAD
        
=======
>>>>>>> 33ab4714e3f8ef0581ec832f608d4b380fc42170
    }

	
}
