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

class Ogre extends Monster {

    public Ogre() {
        super("Oscar the Ogre", 200, 2, .6, .1, 30, 50, 30, 50);


    }

    protected void specialMove(DungeonCharacter opponent) {
        System.out.println(this.getName() + " Sings All Star.");
        opponent.subtractHitPoints(60);
    }


    public String attackDialogue() {
        return " slowly swings a club toward's ";
    }


}