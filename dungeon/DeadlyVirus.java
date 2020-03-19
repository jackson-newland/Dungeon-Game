package dungeon;

public class DeadlyVirus extends Monster{
	public DeadlyVirus(AttackBehavior ab, SpecialBehavior sb) {
		super("Deadly Virus", 150, 5, .35, .3, 30, 50, 20, 40);//only a 35 percent chance of hitting opponent
		super.setAttacks(ab,sb);
	}
}
