package dungeon;

public class SurpriseAttack implements SpecialBehavior {

	@Override
	public void specialMove(DungeonCharacter user, DungeonCharacter opponent) {
		double surprise = Math.random();
        if (surprise <= .4) {
            System.out.println("Surprise attack was successful!\n" +
                    user.getName() + " gets an additional turn.");
            ((Hero) user).incrementNumTurns();
            user.attack(opponent);
        } else if (surprise >= .9) {
            System.out.println("Uh oh! " + opponent.getName() + " saw you and" +
                    " blocked your attack!");
        } else
            user.attack(opponent);
	}

	@Override
	public String specialOption() {
		return "Surprise Attack";
	}

}
