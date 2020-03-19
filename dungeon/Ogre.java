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

    public Ogre(AttackBehavior ab, SpecialBehavior sb) {
        super("Oscar the Ogre", 200, 2, .6, .1, 30, 50, 30, 50);
        super.setAttacks(ab, sb);
    }
    
}