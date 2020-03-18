package dungeon;

public class MonsterFactory {

	private final HashChainAttack attacks;
	private final HashChainSpecial specials;
	
	public MonsterFactory(HashChainAttack Attacks, HashChainSpecial Specials) {
		attacks = Attacks;
		specials = Specials;
	}
	
    public Monster getMonster(int value) {

        switch (value) {

            case 1:
                return new Ogre(attacks.get(new ClubSwing()), specials.get(new Sings()));

            case 2:
                return new Gremlin(attacks.get(new KrisJab()), specials.get(new RoundhouseKick()));

            case 3:
                return new Skeleton(attacks.get(new RustyBlade()), specials.get(new ArmSwing()));
            case 4:
            	return new Vampire(attacks.get(new DefaultAttack()), specials.get(new BloodSteal()));
            case 5:
            	return new DeadlyVirus(attacks.get(new DefaultAttack()), specials.get(new Infect()));
            default:
                System.out.println("invalid choice, returning Skeleton");
                return new Skeleton(attacks.get(new RustyBlade()), specials.get(new ArmSwing()));
        }
    }
}
