import java.util.Observable;
import java.util.Observer;
import javafx.scene.image.ImageView;
import java.awt.Point;

// No longer crashes our game :D

public class LittleShark implements Observer, FactoryInterface {
	Point currentLocation;
	OceanMap oceanMap;
	ImageView s;

	public LittleShark(OceanMap oceanMap) {
		this.oceanMap = oceanMap;
		currentLocation = oceanMap.getSharkLocation();
	}

	public Point getLittleShark() {
		return currentLocation;
	}

	public void goEast(Point p) {
		if (p.x < oceanMap.getDimensions() && !oceanMap.isOccupied(p.x + 1, p.y))
			p.x++;
		oceanMap.getMap()[p.x-1][p.y] = 0;
		oceanMap.getMap()[p.x][p.y] = 3;
	}

	public void goWest(Point p) {
		if (p.x > 0 && !oceanMap.isOccupied(p.x - 1, p.y))
			p.x--;
		oceanMap.getMap()[p.x+1][p.y] = 0;
		oceanMap.getMap()[p.x][p.y] = 3;
	}

	public void goNorth(Point p) {
		if (p.y > 0 && !oceanMap.isOccupied(p.x, p.y - 1))
			p.y--;
		oceanMap.getMap()[p.x][p.y+1] = 0;
		oceanMap.getMap()[p.x][p.y] = 3;
	}

	public void goSouth(Point p) {
		if (p.y < oceanMap.getDimensions() && !oceanMap.isOccupied(p.x, p.y + 1))
			p.y++;
		oceanMap.getMap()[p.x][p.y-1] = 0;
		oceanMap.getMap()[p.x][p.y] = 3;
	}

	public void update(Observable o, Object arg) {
		if (o instanceof Ship) {
			Point shipLocation = ((Ship) o).getShipLocation();
			boolean hasMoved = false;
			if (currentLocation.x < shipLocation.x) {
				if (currentLocation.x < oceanMap.getDimensions()
					&& !oceanMap.isOccupied(currentLocation.x + 1, currentLocation.y)) {
					if (!hasMoved) {
						goEast(currentLocation);
						hasMoved = true;
					}
				}
			}
			if (currentLocation.x > shipLocation.x) {
				if (currentLocation.x > 0 && !oceanMap.isOccupied(currentLocation.x - 1, currentLocation.y)) {
					if (!hasMoved) {
						goWest(currentLocation);
						hasMoved = true;
					}
				}
			}
			if (currentLocation.y > shipLocation.y) {
				if (currentLocation.y > 0 && !oceanMap.isOccupied(currentLocation.x, currentLocation.y - 1)) {
					if (!hasMoved) {
						goNorth(currentLocation);
						hasMoved = true;
					}
				}
			}
			if (currentLocation.y < shipLocation.y) {
				if (currentLocation.y < oceanMap.getDimensions()
					&& !oceanMap.isOccupied(currentLocation.x, currentLocation.y + 1)) {
					if (!hasMoved) {
						goSouth(currentLocation);
						hasMoved = true;
					}
				}
			}
		}
	}
	
	public void create(OceanMap oceanMap) {
		this.oceanMap = oceanMap;
    	currentLocation = oceanMap.getShipLocation();
	}
	
}
