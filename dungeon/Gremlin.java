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

    public Gremlin(AttackBehavior ab, SpecialBehavior sb) {
        super("Gnarltooth the Gremlin", 70, 5, .8, .4, 15, 30, 20, 40);
        super.setAttacks(ab, sb);
    }

}