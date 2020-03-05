package DungeonCharacters;

import java.util.Scanner;

public class Battle {

    public void getBattle(Hero theHero, Monster theMonster) {
        char pause = 'p';
        Scanner input = new Scanner(System.in);
        System.out.println(theHero.getName() + " battles " +
                theMonster.getName());
        System.out.println("---------------------------------------------");


        while (theHero.isAlive() && theMonster.isAlive() && pause != 'q') {
            //hero goes first
            theHero.battleChoices(theMonster);

            //monster's turn (provided it's still alive!)
            if (theMonster.isAlive())
                theMonster.attack(theHero);

            //let the player bail out if desired
            System.out.print("\n-->q to quit, anything else to continue: ");
            pause = input.next().charAt(0);

        }//end battle loop

        if (!theMonster.isAlive())
            System.out.println(theHero.getName() + " was victorious!");
        else if (!theHero.isAlive())
            System.out.println(theHero.getName() + " was defeated :-(");
        else//both are alive so user quit the game
            System.out.println("Quitters never win ;-)");

    }
}
