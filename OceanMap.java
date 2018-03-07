//package joeyVersion;
import java.awt.Point;
import java.util.Random;
// import java.util.ArrayList;

public class OceanMap {
	final static int pirates = 2;
	boolean[][] grid;
	int dimensions;
	int islandCount;
	Random rand = new Random();
	Point shipLocation;
	Point[] islands = new Point[20];
	Point[] pirate = new Point[pirates]; 
	// ArrayList<Movement> moveables = new ArrayList<Movement>();
	// Constructor
	// Not adding validation code so make sure islandCount is much less than dimension^2
	public OceanMap(int dimensions, int islandCount){
		this.dimensions = dimensions;
		this.islandCount = islandCount;
		createGrid();
		placeIslands();
		shipLocation = placeShip();
		placePirate();
		
	}
	
	// Create an empty map
	private void createGrid() {
		 grid = new boolean[dimensions][dimensions];
		 for(int x = 0; x < dimensions; x++)
			 for(int y = 0; y < dimensions; y++)
				 grid[x][y] = false;
	}
	
	// Place islands onto map
	private void placeIslands() {
		int islandsToPlace = islandCount;
		int count = 0;
		while(islandsToPlace > 0){
			int x = rand.nextInt(dimensions);
			int y = rand.nextInt(dimensions);
			if(!grid[x][y]) {
				grid[x][y] = true;
				islandsToPlace--;
				islands[count] = new Point(x,y);
				count++;
			}
		}
	}
	
	private Point placeShip() {
		boolean placedShip = false;
		int x=0,y=0;
		while(!placedShip){
			x = rand.nextInt(dimensions);
			y = rand.nextInt(dimensions);
			if(!grid[x][y]){
				placedShip = true;
				//grid[x][y] =true;
			}
		}
		return new Point(x,y);
	}

	private void placePirate() {
		int x = 0, y = 0;
		int count = 0;
		while(count < pirates){
			x = rand.nextInt(dimensions);
			y = rand.nextInt(dimensions);
			if(!grid[x][y]){
				pirate[count] = new Point(x,y);
				count++;
			}
		}
	}
	public Point getShipLocation() {
		return shipLocation;
	}
	public Point[] getPirates() {
		return pirate;
	}
	public Point[] getIslands() {
		return islands;
	}
	// Return generated map
	public boolean[][] getMap() {
		return grid;
	}
	
	public int getDimensions() {
		return dimensions;
	}
	
	public boolean isOcean(int x, int y) {
		if (x >= 0 && x < dimensions && y >= 0 && y < dimensions) {
			if (!grid[x][y]) return true;
			return false;
		}
		return false;
	}
	
}
