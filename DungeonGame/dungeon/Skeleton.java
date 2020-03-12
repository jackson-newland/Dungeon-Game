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

class Skeleton extends Monster {

    public Skeleton() {
        super("Sargath the Skeleton", 100, 3, .8, .3, 30, 50, 30, 50);

    }


    protected void specialMove(DungeonCharacter opponent) {
        System.out.println("Takes his arm off and swings it.");
        opponent.subtractHitPoints(55);
    }


    public String attackDialogue() {
        return " slices his rusty blade at ";
    }


}