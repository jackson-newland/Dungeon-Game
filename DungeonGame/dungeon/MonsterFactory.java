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

            default:
                System.out.println("invalid choice, returning DungeonCharacters.Skeleton");
                return new Skeleton(attacks.get(new RustyBlade()), specials.get(new ArmSwing()));
        }
    }
}
