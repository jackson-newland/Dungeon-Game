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

class Gremlin extends Monster {

    public Gremlin() {
        super("Gnarltooth the Gremlin", 70, 5, .8, .4, 15, 30, 20, 40);

    }

    protected void specialMove(DungeonCharacter opponent) {
        System.out.println(this.getName() + " screams and roundhouse kicks " + opponent.getName());
        opponent.subtractHitPoints(35);
    }


    public String attackDialogue() {
        return " jabs his kris at ";
    }

}