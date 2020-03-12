package dungeon;

public class MonsterFactory {

    public Monster getMonster(int value) {

        switch (value) {

            case 1:
                return new Ogre();

            case 2:
                return new Gremlin();

            case 3:
                return new Skeleton();

            default:
                System.out.println("invalid choice, returning DungeonCharacters.Skeleton");
                return new Skeleton();
        }
    }
}
