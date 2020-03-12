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


class Sorceress extends Hero {
    private final int MIN_ADD = 25;
    private final int MAX_ADD = 50;

    //-----------------------------------------------------------------
    public Sorceress() {
        super("Sorceress", 75, 5, .7, 25, 50, .3);


    }


    protected String attackDialogue() {
        return " casts a spell of fireball at ";

    }

    protected void specialMove(DungeonCharacter opponent) {
        int hPoints;

        hPoints = (int) (Math.random() * (MAX_ADD - MIN_ADD + 1)) + MIN_ADD;
        addHitPoints(hPoints);
        System.out.println(name + " added [" + hPoints + "] points.\n"
                + "Total hit points remaining are: "
                + hitPoints);
        System.out.println();
    }

    protected String specialOption() {
        return " Increase Hit Points\n";
    }

}