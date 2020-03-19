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


class Warrior extends Hero {

    public Warrior(AttackBehavior ab, SpecialBehavior sb) {
    	super("Warrior", 125, 4, .8, 35, 60, .2);
    	super.setAttacks(ab, sb);
    }

}