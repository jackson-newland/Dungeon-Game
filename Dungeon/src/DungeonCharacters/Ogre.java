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

class Ogre extends Monster {

    public Ogre() {
        super("Oscar the Ogre", 200, 2, .6, .1, 30, 50, 30, 50);


    }//end constructor

    protected void specialMove(DungeonCharacter opponent) {
        System.out.println("Performing Special Attack.");
    }


    protected String attackDialogue() {
        return " slowly swings a club toward's ";
    }


}//end DungeonCharacters.Monster class