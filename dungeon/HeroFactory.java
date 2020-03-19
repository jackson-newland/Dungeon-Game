package dungeon;

public class HeroFactory {
	
	private final HashChainAttack attacks;
	private final HashChainSpecial specials;
	
	public HeroFactory(HashChainAttack Attacks, HashChainSpecial Specials) {
		attacks = Attacks;
		specials = Specials;
	}

    public Hero getHero(int value) {

        switch (value) {

            case 1:
                return new Warrior(attacks.get(new SwordSwing()), specials.get(new CrushingBlow()));

            case 2:
                return new Sorceress(attacks.get(new FireBall()), specials.get(new HealSpell()));

            case 3:
                return new Thief(attacks.get(new DefaultAttack()), specials.get(new SurpriseAttack()));

            case 4:
                return new Spongebob(attacks.get(new BubbleBlow()), specials.get(new FishingNet()));
            case 5:
            	return new OldMan(attacks.get(new CaneWack()), specials.get(new StealToiletPaper()));

            default:
                System.out.println("invalid choice, returning Thief");
                return new Thief(attacks.get(new DefaultAttack()), specials.get(new SurpriseAttack()));
        }
    }
}
