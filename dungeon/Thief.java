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

class Thief extends Hero {

    public Thief(AttackBehavior ab, SpecialBehavior sb) {
        super("Thief", 75, 6, .8, 20, 40, .5);
        super.setAttacks(ab, sb);
    }
    
}