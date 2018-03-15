import java.util.Observable;
import java.util.Observer;
import javafx.scene.image.ImageView;
import java.awt.Point;

// Has a bad habit of crashing the shit out of our game

public class LittleShark implements Observer {
	Point currentLocation;
	OceanMap oceanMap;
	// OceanExplorer xs;
	ImageView s;

	public LittleShark(OceanMap oceanMap) {
		this.oceanMap = oceanMap;
		currentLocation = oceanMap.getSharkLocation();
		// xs = new OceanExplorer();
	}

	public Point getLittleShark() {
		return currentLocation;
	}

	public void goEast(Point p) {
		if (p.x < oceanMap.getDimensions() && !oceanMap.isOccupied(p.x + 1, p.y))
			p.x++;
	}

	public void goWest(Point p) {
		if (p.x > 0 && !oceanMap.isOccupied(p.x - 1, p.y))
			p.x--;
	}

	public void goNorth(Point p) {
		if (p.y > 0 && !oceanMap.isOccupied(p.x, p.y - 1))
			p.y--;
	}

	public void goSouth(Point p) {
		if (p.y < oceanMap.getDimensions() && !oceanMap.isOccupied(p.x, p.y + 1))
			p.y++;
	}

	public void update(Observable o, Object arg) {
		if (o instanceof Ship) {
			Point shipLocation = ((Ship) o).getShipLocation();
			// xs.gg();
			boolean hasMoved = false;
			//while (true) {
				if (currentLocation.x < shipLocation.x) {
					if (currentLocation.x < oceanMap.getDimensions()
							&& !oceanMap.isOccupied(currentLocation.x + 1, currentLocation.y)) {
						if (!hasMoved) {
							goEast(currentLocation);
							hasMoved = true;
							// xs.gg();
							
							//break;
						}
					}
				}
				if (currentLocation.x > shipLocation.x) {
					if (currentLocation.x > 0 && !oceanMap.isOccupied(currentLocation.x - 1, currentLocation.y)) {
						if (!hasMoved) {
							goWest(currentLocation);
							hasMoved = true;
						// xs.gg();

						//break;
						}
					}
				}
				if (currentLocation.y > shipLocation.y) {
					if (currentLocation.y > 0 && !oceanMap.isOccupied(currentLocation.x, currentLocation.y - 1)) {
						if (!hasMoved) {
							goNorth(currentLocation);
							hasMoved = true;
							// xs.gg();
							//break;
						}
					}
				}
				if (currentLocation.y < shipLocation.y) {
					if (currentLocation.y < oceanMap.getDimensions()
							&& !oceanMap.isOccupied(currentLocation.x, currentLocation.y + 1)) {
						if (!hasMoved) {
							goSouth(currentLocation);
							hasMoved = true;
							// xs.gg();
							
							//break;
						}
					}
				}

			//}

		}
	}
}
