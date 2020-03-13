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

    public Skeleton(AttackBehavior ab, SpecialBehavior sb) {
        super("Sargath the Skeleton", 100, 3, .8, .3, 30, 50, 30, 50);
        super.setAttacks(ab, sb);
    }

}