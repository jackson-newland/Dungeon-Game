package dungeon;

public class OldMan extends Hero{
	public OldMan(AttackBehavior ab, SpecialBehavior sb) {
    	super("Old Man", 100, 2, 1, 10, 40, .2);//always hits
    	super.setAttacks(ab, sb);
    }
}
