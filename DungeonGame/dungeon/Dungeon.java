package dungeon;
import java.util.ArrayList;
import java.util.Collections;

public class Dungeon {
	private Room[][] maze = new Room[5][5];
	private int entranceRow;
	private int entranceCol;
	private int currentRow;
	private int currentCol;
	
	public Dungeon() {
		ArrayList<Room> rooms = createAllRooms();
		createDungeon(rooms);
		setStartLocation();
	}
	
	//sets heroes start location
	private void setStartLocation() {
		currentRow = entranceRow;
		currentCol = entranceCol;
	}

	//create 5x5 maze
	private void createDungeon(ArrayList<Room> rooms) {
		int i=0;
		for(int row=0;row<maze.length;row++) {
			for(int col=0;col<maze[row].length;col++) {
				
				//set coordinates of the entrance and exit
				if(rooms.get(i).isEntrance()) {
					entranceRow=row;
					entranceCol=col;
				}
				
				//fill maze
				maze[row][col] = rooms.get(i);
				i++;
			}
		}
		buildWalls();
	}
	
	
	private void buildWalls() {
		for(int r=0;r<maze.length;r++) {
			for(int c=0;c<maze[r].length;c++) {
				if(r == 0)
					maze[r][c].setWall('n');
				if(c==0)
					maze[r][c].setWall('w');
				if(r==4)
					maze[r][c].setWall('s');
				if(c==4)
					maze[r][c].setWall('e');
			}
			
		}
		
	}

	//creates a list holding every room for maze
	private ArrayList<Room> createAllRooms() {
		ArrayList<Room> rooms = new ArrayList<Room>();
		rooms.add(new Room("entrance"));
		rooms.add(new Room("exit"));
		rooms.add(new Room("inheritance"));
		rooms.add(new Room("polymorphism"));
		rooms.add(new Room("abstraction"));
		rooms.add(new Room("encapsulation"));
		for(int i =6; i < 25;i++) {
			rooms.add(new Room());
		}
		//randomize room order
		Collections.shuffle(rooms);
		return rooms;
		
	}
	
	//used for testing
	public String printMaze() {
		String result ="";
		for(int r =0; r < maze.length;r++) {
			for(int c =0;c<maze[r].length;c++) {
				result+=maze[r][c];
			}
			
		}
		return result;
	}
	
	public Room currentRoom() {
		return maze[currentRow][currentCol];
	}

	public void printCurrentRoom() {
		System.out.println(currentRoom());
	}

	public void move(String s,String name) {
		Room c = currentRoom();
		if(s.equals("s")) {
			if(c.hasSouthWall()) {
				System.out.println(name+" encounters a wall. There is no south door.");
			}
			else {
				System.out.println(name+" enters the room through the south door.");
				currentRow++;
			}
		}
		else if(s.equals("n")) {
			if(c.hasNorthWall()) {
				System.out.println(name+" encounters a wall. There is no north door.");
			}
			else {
				System.out.println(name+" enters the room through the north door.");
				currentRow--;
			}
		}
		else if(s.equals("e")) {
			if(c.hasEastWall()) {
				System.out.println(name+" encounters a wall. There is no east door.");
			}
			else {
				System.out.println(name+" enters the room through the east door.");
				currentCol++;
			}
		}
		else if(s.equals("w")) {
			if(c.hasWestWall()) {
				System.out.println(name+" encounters a wall. There is no west door.");
			}
			else {
				System.out.println(name+" enters the room through the west door.");
				currentCol--;
			}
		}
	}

	public boolean foundExit() {
		Room c = currentRoom();
		return c.isExit();
	}

	public void useVisionPotion() {
		Room[][] vision = fillVision();
		printSurroundingDiagram(vision);
		printVisionRooms(vision);
	}

	private Room[][] fillVision() {
		Room[][] result = new Room[3][3];//default all rooms are null
		if(validCoordinates(currentRow-1,currentCol-1)) {result[0][0]= maze[currentRow-1][currentCol-1];}
		if(validCoordinates(currentRow-1,currentCol)) {result[0][1]=maze[currentRow-1][currentCol];}
		if(validCoordinates(currentRow-1,currentCol+1)) {result[0][2]=maze[currentRow-1][currentCol+1];}
		if(validCoordinates(currentRow,currentCol-1)) {result[1][0]=maze[currentRow][currentCol-1];}
		result[1][1]=null;//current room
		if(validCoordinates(currentRow,currentCol+1)) {result[1][2]=maze[currentRow][currentCol+1];}
		if(validCoordinates(currentRow+1,currentCol-1)) {result[2][0]=maze[currentRow+1][currentCol-1];}
		if(validCoordinates(currentRow+1,currentCol)) {result[2][1]=maze[currentRow+1][currentCol];}
		if(validCoordinates(currentRow+1,currentCol+1)) {result[2][2]=maze[currentRow+1][currentCol+1];}
		return result;
		
	}

	private boolean validCoordinates(int row, int col) {
		if(row > maze.length-1 || row < 0) return false;
		else if(col > maze[0].length-1 || col < 0)return false;
		return true;
	}

	private void printSurroundingDiagram(Room[][] vision) {
		System.out.println("Using <VISION POTION>:");
		System.out.println("'@' - Your current location");
		System.out.println("'X' - Wall of maze");
		System.out.println("The coordinates represent your surrounding rooms.\n");
		for(int i = 0 ; i < vision.length;i++) {
			for(int j = 0; j < vision[i].length; j++) {
				if(i == 1 && j == 1)System.out.print("( @ )");
				else if(vision[i][j]!= null) {
					System.out.print("("+i+","+j+")");
				}
				else {
					System.out.print("( X )");
				}
			}
			System.out.print("\n");
		}
	}
	
	private void printVisionRooms(Room[][] vision) {
		System.out.println("\nVIEW OF THE ROOMS:\n");
		for(int i = 0;i < vision.length;i++) {
			for(int j = 0; j < vision[i].length;j++) {
				if(vision[i][j]!= null) {
					System.out.println("Room ("+i+","+j+"):");
					System.out.println(vision[i][j]);
				}
			}
		}
		
		
	}






	
	
	
			
			

	
}//end class

	
