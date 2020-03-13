package dungeon;

import java.util.Scanner;

public class Battle {

    public void getBattle(Hero theHero, Monster theMonster) {
        char pause = 'p';
        Scanner input = new Scanner(System.in);
        System.out.println(theHero.getName() + " battles " +
                theMonster.getName());
        System.out.println("---------------------------------------------");


        while (theHero.isAlive() && theMonster.isAlive() && pause != 'q') {

            theHero.battleChoices(theMonster);


            if (theMonster.isAlive())
                theMonster.attack(theHero);


            System.out.print("\n-->q to quit, anything else to continue: ");
            pause = input.next().charAt(0);
            System.out.println();
        }

        if (!theMonster.isAlive())
            System.out.println(theHero.getName() + " was victorious!");
        else if (!theHero.isAlive())
            System.out.println(theHero.getName() + " was defeated :-(");
        else
            System.out.println("Quitters never win ;-)");

    }
}
