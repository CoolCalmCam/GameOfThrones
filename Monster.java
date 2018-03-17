/*
import java.awt.Point;
import java.util.Random;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

// Not currently implemented as of right now

public class Monster implements MonsterInterface, Movement {
	int x; 
	int y;
	
	OceanMap oceanMap; 
	int[][] grid;
	Movement[][] map; 
	Random rand = new Random();
	
	Circle circle; 
	int scalingFactor = 15; 
	int radius = 10; 
	int size; 
	int c; 
	
	public Monster(int scalingFactorScale) {
		oceanMap = OceanMap.getOceanMapInstance(); 
		map = OceanMap.getOceanMap(); 
		circle = new Circle(); 
		circle.setFill(Color.DARKGREEN);
		scalingFactor = scalingFactorScale; 
		x = rand.nextInt(map.length -1);
		y = rand.nextInt(map[0].length - 1); 
		while(!(map[y][x] instanceof OceanMap)) {
			if(map[y][x] instanceof Monster) {
				Monster m = (Monster)map[y][x];
				m.destroy();
				map[y][x] = new BiggerMonster(x,y, circle);
				System.out.println("HAHA");
			}
			x = rand.nextInt(map.length - 1);
			y = rand.nextInt(map.length - 1);
		}
		setPositionOfX(x); 
		setPositionOfY(y);
		map[y][x] = this; 
		size = 1; 
		circle.setRadius(radius);
	}
	
	public void move(int PosX, int PosY) {
		//TODO Auto-generated method stub
	}
	
	public String getVal() {
		//TODO Auto-generated method stub
		return "monster"; 
	}
	
	public Movement getObject() {
		//TODO Auto-generated method stub
		return this; 
	}
	
	public Point getMonsterLocation() {
		return new Point(x, y); 
	}
	
	public MonsterInterface getComponent() {
		//TODO Auto-generated method stub
		return (MonsterInterface) circle; 
	}
	
	public Circle getCircle() {
		//TODO Auto-generated method stub
		return circle; 
	}

	
	public void setPositionOfY(int y) {
		circle.setCenterY(y*scalingFactor + (scalingFactor/2));
	}
	
	public void setSize(int newSize) {
		//Auto-generated method stub
		size = 1; 
	}
	
	public int getSize() {
		return 0; 
	}
	
	public int getX() {
		return x; 
	}
	
	public int getY() {
		return y; 
	}

	private void destroy() {
		map[y][x] = new OceanPart(x, y);
		circle.setFill(Color.TRANSPARENT); //so that it can disappear
		circle.setStroke(Color.TRANSPARENT);
		
	}
	
	public void increaseSize() {
		System.out.println("Size of monster can't be increased");
	}
	
	public int getIndex() {
		return 0; 
	}
	
	public int c() {
		return 1; 
	}

	@Override
	public void goNorth() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void goEast() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void goWest() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void goSouth() {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public int getC() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void changeC() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void destory() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void setPositionOfX(int x) {
		circle.setCenterX(x*scalingFactor + (scalingFactor/2));
		
	}

	@Override
	public void setX(int posX) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setY(int posY) {
		// TODO Auto-generated method stub
		
	}
	
	/*
	private void setX(int PosX) {
		// TODO Auto-generated method stub
		x = PosX; 
		setPositionOfX(x); 
	}
	
	private void setY(int PosY) {
		//TODO Auto-generated method stub
		y = PosY; 
		setPositionOfY(y); 
	}
	 */

/*	
}
*/