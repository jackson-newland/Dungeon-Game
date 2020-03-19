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


class Spongebob extends Hero {

    public Spongebob(AttackBehavior ab, SpecialBehavior sb) {
        super("Spongebob", 50, 9, .9, 1, 10, .1);
        super.setAttacks(ab, sb);
    }

}