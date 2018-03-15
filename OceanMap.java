import java.awt.Point;
import java.util.Random;
// import java.util.ArrayList;

// Implements the Singleton design pattern.

public class OceanMap {
	final static int pirates = 2;
	private static OceanMap oceanMap_instance = null;
	
	int[][] grid;
	int dimensions;
	int islandCount;
	Random rand = new Random();
	Point shipLocation;
	Point sharkLocation;
	Point DoubleLocation;
	Point treasureLocation;
	Point[] islands = new Point[20];
	Point[] pirate = new Point[pirates];

	// ArrayList<Movement> moveables = new ArrayList<Movement>();
	// Constructor
	// Not adding validation code so make sure islandCount is much less than
	// dimension^2
	private OceanMap(int dimensions, int islandCount) {
		this.dimensions = dimensions;
		this.islandCount = islandCount;
		createGrid();
		placeIslands();
		placeShip();
		placePirate();
		placeShark();
		placeDoubleS();
		placeTreasure();
	}
	
	// Instantiates OceanMap in accordance with Singleton pattern
	public static OceanMap createOceanMapInstance(int dimensions, int islandCount) {
		oceanMap_instance = new OceanMap(dimensions, islandCount);
		return oceanMap_instance;
	}
	
	// May be unneeded, but returns the OceanMap if needs to be accessed again.
	public static OceanMap getOceanMapInstance() {
		return oceanMap_instance;
	} // Will return NULL if createOceanMapInstance isn't called first!!

	// Create an empty map
	private void createGrid() {
		grid = new int[dimensions][dimensions];
		/* for (int x = 0; x < dimensions; x++)
			for (int y = 0; y < dimensions; y++)
				grid[x][y] = false; */
	}
	public void retry() {
		placeIslands();
		placePirate();
		placeShark();
		placeDoubleS();
		placeTreasure();
		placeShip();
	}

	// Place islands onto map; islands are represented by 1
	private void placeIslands() {
		int islandsToPlace = islandCount;
		int count = 0;
		while (islandsToPlace > 0) {
			int x = rand.nextInt(dimensions);
			int y = rand.nextInt(dimensions);
			if (grid[x][y] < 1) {
				grid[x][y] = 1;
				islandsToPlace--;
				islands[count] = new Point(x,y);
				count++;
			}
		}
	}
	
	// Places the player's Ship onto map; player's ship represented by 2
	private void placeShip() {
		boolean placedShip = false;
		int x = 0, y = 0;
		while (!placedShip) {
			x = rand.nextInt(dimensions);
			y = rand.nextInt(dimensions);
			if (grid[x][y] < 1) {
				placedShip = true;
				shipLocation = new Point(x,y);
				grid[x][y] = 2;
			}
		}
	}
	
	// Places a LittleShark onto map; LittleShark represented by 3
	private void placeShark() {
		boolean placedShark = false;
		int x = 0;
		int y = 0;
		while (!placedShark) {
			x = rand.nextInt(dimensions);
			y = rand.nextInt(dimensions);
			if (grid[x][y] < 1) {
				grid[x][y] = 3;
				sharkLocation = new Point(x, y);
				placedShark = true;
			}
		}
	}
	
	// Places the Treasure on the map; Treasure represented by 4
	private void placeTreasure() {
		boolean placedTreasure = false;
		int x = 0;
		int y = 0;
		while (!placedTreasure) {
			x = rand.nextInt(dimensions);
			y = rand.nextInt(dimensions);
			if (grid[x][y] < 1) {
				grid[x][y] = 4;
				treasureLocation = new Point(x, y);
				placedTreasure = true;
			}
		}
	}
	
	// Places the DoubleSpeed ship on the map; DoubleSpeed represented by 5
	private void placeDoubleS() {
		boolean placedDouble = false;
		int x = 0;
		int y = 0;
		while (!placedDouble) {
			x = rand.nextInt(dimensions);
			y = rand.nextInt(dimensions);
			if (grid[x][y] < 1) {
				grid[x][y] = 5;
				DoubleLocation = new Point(x, y);
				placedDouble = true;
			}
		}
	}
	
	// Places the PirateShips on the map; PirateShips represented by 6
	private void placePirate() {
		int x = 0, y = 0;
		int count = 0;
		while (count < pirates) {
			x = rand.nextInt(dimensions);
			y = rand.nextInt(dimensions);
			if (grid[x][y] < 1) {
				grid[x][y] = 6;
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

	public Point getSharkLocation() {
		return sharkLocation;
	}

	public Point getDoubleSpeed() {
		return DoubleLocation;
	}

	public Point[] getIslands() {
		return islands;
	}

	public Point getTreasureLocation() {
		return treasureLocation;
	}

	// Return generated map
	public int[][] getMap() {
		return grid;
	}

	public int getDimensions() {
		return dimensions;
	}

	/* public boolean isOcean(int x, int y) {
		if (x >= 0 && x < dimensions && y >= 0 && y < dimensions) {
			if (!grid[x][y])
				return true;
			return false;
		}
		return false;
	} */
	
	public boolean isIsland(int x, int y) {
		if (x >= 0 && x < dimensions && y >= 0 && y < dimensions)
			if (grid[x][y] == 1)
				return true;
		return false;
	}
	
	public boolean isOccupied(int x, int y) {
		if (x >= 0 && x < dimensions && y >= 0 && y < dimensions)
			if (grid[x][y] > 2 || grid[x][y] == 1)
				return true;
		return false;
	}

	public boolean checkL() {
		if (getSharkLocation().equals(getShipLocation())) {
			return false;
		}
		if (getDoubleSpeed().equals(getShipLocation())) {
			return false;
		}
		for (int i = 0; i < 2; i++) {
			if (getPirates()[i].equals(getShipLocation())) {
				return false;
			}
		}
		return true;
	}

	public boolean checkW() {
		if (getShipLocation().equals(getTreasureLocation()))
			return true;
		else
			return false;
	}
}
