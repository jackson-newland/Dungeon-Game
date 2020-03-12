public class Hero2 {
	
	private String name;
	private int defaultHitPoints;
	private int hitPoints = 75;
	private int healingPotions=0;
	private int visionPotions=0;
	private int pillars=0;
	
	
	
	public Hero2(String name) {
		this.name = name;
		defaultHitPoints = this.hitPoints;
	}

	
	public String getName() {
		return name;
	}
	public void printStats() {
		System.out.println();
		System.out.println("Hitpoints: "+hitPoints);
		System.out.println("Pillars: "+pillars);
		System.out.println("Healing Potions: "+healingPotions+" (Type 'h' to use)");
		System.out.println("Vision Potions: "+visionPotions+" (Tye'v' to use)");
		System.out.println();
		
	}
	
	public void addPillar() {pillars++;}
	
	public boolean hasAllPillars() {
		if(pillars == 4)return true;
		return false;
	}
	
	public void addHealingPotion() {healingPotions++;}
	public void useHealingPotion() {
		int amount = calculateHealingAmount();
		hitPoints = hitPoints + amount;
		healingPotions--;
		if(hitPoints == defaultHitPoints) {
			System.out.println(name+" uses a healing potion. It restores "+name+" to FULL HEALTH!");
		}
		else {
		System.out.println(name + " uses a healing potion. It restores <"+amount+"> hitpoints! Current health is now "+hitPoints+".");
		}
	}
	private int calculateHealingAmount() {
		//set amount from 20 to 50
		int amount =(int)(Math.random()*((50)-20))+20;
		if((amount+hitPoints)>defaultHitPoints)
			return defaultHitPoints - hitPoints;
		return amount;
	}

	public void fallsInPit() {
		//set amount from 1 to 20
		int amount =(int)(Math.random()*((20)-1))+1;
		hitPoints = hitPoints - amount;
		if(isDead()) {
			System.out.println(name + " has FALLEN INTO A PIT! "+name+" takes <"+amount+"> damage. Current health is now 0.");
		}
		else {
			System.out.println(name + " has FALLEN INTO A PIT! "+name+" takes <"+amount+"> damage. Current health is now "+hitPoints+".");
		}
	}

	public boolean isDead() {
		if(hitPoints <= 0) return true;
		return false;
	}

	public int healingPotions() {return healingPotions;}
	public int visionPotions() {return visionPotions;}
	public void removeVisionPotion() {visionPotions--;}
	public void addVisionPotion() {visionPotions++;}
}
