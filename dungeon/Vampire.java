package dungeon;

class Vampire extends Monster{
	public Vampire(AttackBehavior ab, SpecialBehavior sb) {
		super("Nosferatu the Vampire", 100, 3, .8, .3, 20, 40, 20, 40);
		super.setAttacks(ab,sb);
	}
}
