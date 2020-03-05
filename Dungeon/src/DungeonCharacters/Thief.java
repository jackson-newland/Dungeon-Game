package DungeonCharacters;

/**
 * Title:
 * Description:
 * Copyright:    Copyright (c) 2001
 * Company:
 *
 * @author
 * @version 1.0
 */

class Thief extends Hero {

    public Thief() {
        super("Thief", 75, 6, .8, 20, 40, .5);


    }//end constructor


    protected String attackDialogue() {
        return " attacks ";

    }


    protected void specialMove(DungeonCharacter opponent) {
        double surprise = Math.random();
        if (surprise <= .4) {
            System.out.println("Surprise attack was successful!\n" +
                    name + " gets an additional turn.");
            numTurns++;
            attack(opponent);
        }//end surprise
        else if (surprise >= .9) {
            System.out.println("Uh oh! " + opponent.getName() + " saw you and" +
                    " blocked your attack!");
        } else
            attack(opponent);

    }

    protected String specialOption() {
        return " Surprise Attack\n";
    }
}