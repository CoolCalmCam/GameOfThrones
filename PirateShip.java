import java.util.Observable;
import java.util.Observer;
import java.awt.Point;

public class PirateShip implements Observer {
	Point[] currentLocation;
	OceanMap oceanMap;
	Point shipLocation;

	public PirateShip(OceanMap oceanMap) {
		this.oceanMap = oceanMap;
		currentLocation = oceanMap.getPirates();
	}

	public Point[] getShipLocation() {
		return currentLocation;
	}

	public void goEast(Point cur) {
		if (cur.x < 9 && oceanMap.isOcean(cur.x + 1, cur.y)) {
			cur.x++;
		}
	}

	public void goWest(Point cur) {
		if (cur.x > 0 && oceanMap.isOcean(cur.x - 1, cur.y)) {
			cur.x--;
		}
	}

	public void goNorth(Point cur) {
		if (cur.y > 0 && oceanMap.isOcean(cur.x, cur.y - 1)) {
			cur.y--;
		}
	}

	public void goSouth(Point cur) {
		if (cur.y < 9 && oceanMap.isOcean(cur.x, cur.y + 1)) {
			cur.y++;
		}
	}

	public void update(Observable o, Object arg) {
		if (o instanceof Ship) {
			shipLocation = ((Ship)o).getShipLocation();
			for (int i = 0; i < 2; i++) {
				if (shipLocation.x  < currentLocation[i].x) {
					goWest(currentLocation[i]);
					
				} if (shipLocation.y > currentLocation[i].y) {
					goSouth(currentLocation[i]);
					
				}  if (shipLocation.y  < currentLocation[i].y) {
					goNorth(currentLocation[i]);
					
				}  if (shipLocation.x  > currentLocation[i].x) {
					goEast(currentLocation[i]);
				
				}
			}
		}
	}
}

