package dungeon;

public class BloodSteal implements SpecialBehavior{
	@Override
	public void specialMove(DungeonCharacter user, DungeonCharacter opponent) {
		//steals half of opponent's life and gives it to user
		System.out.println(user.getName()+" sucks "+opponent.getName()+"'s blood.");
		int damage;
		if(opponent.hitPoints > 2)
			damage = opponent.hitPoints/2;
		else {
			damage = 1;
		}
		int healthBefore = opponent.hitPoints;
		opponent.subtractHitPoints(damage);
		int healthAfter = opponent.hitPoints;
		if(!(healthBefore == healthAfter)) {//if attack was not blocked
			user.addHitPoints(damage);
			System.out.println("\n"+user.getName()+" uses "+opponent.getName()+"'s blood. \n"+user.getName()+" increases his health by <"+damage+"> hit points.");
			System.out.println(user.getName() + " now has "+user.getHitPoints()+" hit points remaining.");
			
		}
		
	}
	
	@Override
	public String specialOption() {
		return "Perform BloodSteal";
	}
}
