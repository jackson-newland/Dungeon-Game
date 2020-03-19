package dungeon;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
import java.io.*;


class DungeonTest {
    private final InputStream systemIn = System.in;
    private final PrintStream systemOut = System.out;

    private ByteArrayInputStream testIn;
    private ByteArrayOutputStream testOut;

    @BeforeEach
    public void setUpOutput() {
        testOut = new ByteArrayOutputStream();
        System.setOut(new PrintStream(testOut));
    }

    private void provideInput(String data) {
        testIn = new ByteArrayInputStream(data.getBytes());
        System.setIn(testIn);
    }

    @AfterEach
    public void restoreSystemInputOutput() {
        System.setIn(systemIn);
        System.setOut(systemOut);
    }

	@Test
	void testValidCoordinates() { //make validCoordinates package visible
		Dungeon d = new Dungeon();
		assertEquals(false, d.validCoordinates(8,9));
		assertEquals(true,d.validCoordinates(0,0));
		assertEquals(true,d.validCoordinates(0,4));
	}

    @Test
    public void testchooseHeroCorrect() {
        provideInput("4");

        assertEquals(4, DungeonAdventure.chooseHero());
    }
    
    @Test
	void addHitPoints() {
    	provideInput("hero");
		Hero hero;
		hero = new Warrior(new DefaultAttack(),new CrushingBlow());
		
		int before = hero.getHitPoints();
		hero.addHitPoints(10);
		int after = hero.getHitPoints();
		assertEquals(after,before+10);
	}
    
    @Test
	void subtractHitPoints() {
    	provideInput("hero");
		DungeonCharacter hero;
		hero = new Warrior(new DefaultAttack(),new CrushingBlow());
		
		int before = hero.getHitPoints();
		hero.subtractHitPoints(10);
		int after = hero.getHitPoints();
		assertTrue(after <= before && after >= before - 10);
	}
    
    @Test
    void TestforOldManVSVirus() {
    	provideInput("hero");
		Hero hero;
		hero = new OldMan(new CaneWack(),new StealToiletPaper());
		
		Monster monster = new DeadlyVirus(new DefaultAttack(),new Infect());
		
		Battle arena = new Battle();
		arena.getBattle(hero, monster);

		assertTrue(hero.isAlive() == false);
    }
    
    @Test 
    void TesthasAllPillars(){
    	provideInput("hero");
		Hero hero;
		hero = new Warrior(new DefaultAttack(),new CrushingBlow());
		Inventory i = new Inventory(hero);
		
		i.addPillar();i.addPillar();i.addPillar();
		assertTrue(i.hasAllPillars() == false);
		
		i.addPillar();
		assertTrue(i.hasAllPillars());
    	
    }
    
    @Test 
    void TestBloodSteal() {
    	provideInput("hero");
		Hero hero;
		hero = new Warrior(new DefaultAttack(),new CrushingBlow());
		
		Monster monster = new Vampire(new DefaultAttack(),new BloodSteal());
		int hbefore = hero.getHitPoints()-hero.hitPoints/2;
		int vbefore = monster.hitPoints + hero.hitPoints/2;
		
		monster.specialMove(hero);
		int hafter = hero.getHitPoints();
		int vafter = monster.getHitPoints();
		
		assertEquals(hbefore,hafter);
		assertEquals(vbefore,vafter);
	
    }
    
    @Test
    void TestaddHealSpell() {
    	provideInput("hero");
    	Hero hero;
    	hero = new Sorceress(new FireBall(), new HealSpell());
    	Monster monster = new Vampire(new DefaultAttack(),new BloodSteal());
    	
    	int before = hero.hitPoints;
    	hero.special.specialMove(hero, monster);
    	int after = hero.hitPoints;
    	int amount = after - before;
    	
    	assertTrue(after > before);
    	assertTrue(amount >= 25 && amount <=50);
    	
    	
    }
    
    
}
