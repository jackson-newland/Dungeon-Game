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


class Spongebob extends Hero {

    public Spongebob() {

        super("Spongebob", 50, 9, .9, 1, 10, .1);


    }


    public String attackDialogue() {
        return " blows a bubble at ";

    }


    protected void specialMove(DungeonCharacter opponent) {
        if (Math.random() <= .4) {
            int blowPoints = (int) (Math.random() * 100) + 100;
            System.out.println(name + " tries to catch " + opponent.getName() + " in a net for " + blowPoints + " damage!");
            opponent.subtractHitPoints(blowPoints);
        } else {
            System.out.println(name + " failed to catch " + opponent.getName());
            System.out.println();
        }

    }

    protected String specialOption() {
        return " Use Net On Opponent\n";
    }

}