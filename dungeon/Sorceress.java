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


class Sorceress extends Hero {
	
    public Sorceress(AttackBehavior ab, SpecialBehavior sb) {
        super("Sorceress", 75, 5, .7, 25, 50, .3);
        super.setAttacks(ab, sb);
    }

}