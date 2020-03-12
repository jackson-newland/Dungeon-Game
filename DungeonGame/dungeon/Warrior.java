package dungeon;

/**
 * Title:
 * Description:
 * Copyright:    Copyright (c) 2001
 * Company:
 *
 * @author
 * @version 1.0
 */


class Warrior extends Hero {

    public Warrior() {

        super("Warrior", 125, 4, .8, 35, 60, .2);
    }


    public String attackDialogue() {
        return " swings a mighty sword at ";

    }

    protected void specialMove(DungeonCharacter opponent) {
        if (Math.random() <= .4) {
            int blowPoints = (int) (Math.random() * 76) + 100;
            System.out.println(name + " lands a CRUSHING BLOW for " + blowPoints
                    + " damage!");
            opponent.subtractHitPoints(blowPoints);
        } else {
            System.out.println(name + " failed to land a crushing blow");
            System.out.println();
        }

    }

    protected String specialOption() {
        return " Crushing Blow on Opponent\n";
    }

}