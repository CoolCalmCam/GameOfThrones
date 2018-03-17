/*
import java.util.ArrayList;
import java.util.Random;

import org.w3c.dom.Node;

import javafx.collections.ObservableList;
import javafx.scene.shape.Circle;

public class MonstersThread implements Run {
	OceanMap oceanMap; 
	int[][] grid;
	Movement[][] map; 
	Random random; 
	boolean run = true; 
	int scalingFactor; 
	ArrayList<MonsterInterface> monsters = new ArrayList<MonsterInterface>();
	int MoveX; 
	int MoveY;  
	int radius; 
	
	public MonstersThread(int scalingFactorScale) {
		random = new Random(); 
		scalingFactor = scalingFactorScale; 
		for(int i = 0; i < 14; i++) {
			monsters.add(new Monster(scalingFactor)); 
		}
		this.radius = 10; 
		oceanMap = OceanMap.getOceanMapInstance(); 
		grid = oceanMap.getMap(); 
	}
	 
	public ArrayList<MonsterInterface> getMonsters() {
		return monsters; 
	}
	
	public void addMonsters(ObservableList<javafx.scene.Node> observableList) {
		for(MonsterInterface monster: monsters) {
			Circle circle = ((MonsterInterface) monsters).getCircle(); 
			System.out.println("Adding circle: " + circle.getCenterX() + "  " + circle.getCenterY() + " "  + radius);
			((OceanMap) oceanMap).add(circle); 
		}
	}
	
	public void Run() {
		while(true) {
			try {
				Thread.sleep(400);
			} catch(InterruptedException e) {
				e.printStackTrace();
			}
			ArrayList<MonsterInterface> tempList = new ArrayList<MonsterInterface>();
			ArrayList<MonsterInterface> remove = new ArrayList<MonsterInterface>(); 
			for(MonsterInterface monster: monsters) {
				if(monster instanceof Monster) {
					map[monster.getY()][monster.getX()] = new OceanPart(monster.getX(), monster.getY());
					MoveX = monster.getX() + random.nextInt(3) - 1;
					MoveY= monster.getY() + random.nextInt(3) - 1; 
					if(MoveX >= 0 && MoveY >= 0 && MoveX <= map.length-1 && MoveY <= map[0].length -1) {
						if(map[MoveY][MoveX] instanceof OceanPart) {
							map[monster.getY()][monster.getX()] = new OceanPart(monster.getX(), monster.getY());
							map[MoveY][MoveX] = (Monster) monster; 
							monster.setX(MoveX);
							monster.setY(MoveY);
							tempList.add(monster); 
						}
						else if(map[MoveY][MoveX] instanceof Monster) {
							System.out.println("BIGGER MONSTER BEING MADE");
							for(MonsterInterface monsterTemp: monsters) {
								if(monsterTemp.getY() == MoveY && monsterTemp.getX() == MoveX) {
									if(monsterTemp != monster) {
										remove.add(monsterTemp); 									}
								}
							}
							monster = new BiggerMonster(MoveX, MoveY, monster.getCircle());
							tempList.add(monster);
							map[monster.getY()][monster.getX()] = new OceanPart(monster.getX(), monster.getY());
							map[MoveY][MoveX] = (Movement) monster; 
						}
						else {
							tempList.add(monster);
							map[monster.getY()][monster.getX()] = (Monster) monster; 
						}
					}
					else {
						tempList.add(monster);
						map[monster.getY()][monster.getX()] = (Monster) monster; 
					}
				}
				else if(monster instanceof BiggerMonster) {
					map[monster.getY()][monster.getX()] = new OceanPart(monster.getX(), monster.getY());
					for(int i = monster.getX()-1; i < monster.getX() + 2; i++) {
						for(int j = monster.getY()-1; j < monster.getY() + 2; j++) {
							if(map[j][i] instanceof BiggerMonster) {
								map[j][i] = new OceanPart(i, j); 
							}
						}
					}
					MoveX = monster.getX() + random.nextInt(3) - 1; 
					MoveY = monster.getY() + random.nextInt(3) - 1; 
					if(MoveX >= 2 && MoveY >= 2 && MoveX <= map.length-3 && MoveY <= map[0].length-3) {
						if(map[MoveY][MoveX] instanceof OceanPart) {
							for(int i = MoveX-1; i < MoveX + 2; i++) {
								for(int j = MoveY-1; j < MoveY + 2; j++) {
									if(map[j][i] instanceof OceanPart) {
										map[j][i] = (BiggerMonster) monster; 
									}
									else if(map[j][i] == monster) {
										map[j][i] = (BiggerMonster) monster; 
									}
								}
							}
							map[monster.getY()][monster.getX()] = new OceanPart(monster.getX(), monster.getY());
							map[MoveY][MoveX] = (BiggerMonster) monster; 
							monster.setX(MoveX);
							monster.setY(MoveY);
							tempList.add(monster);
						}
						else {
							tempList.add(monster);
							map[monster.getY()][monster.getX()] = (BiggerMonster) monster; 
						}
					}
					else {
						tempList.add(monster);
						map[monster.getY()][monster.getX()] = (BiggerMonster) monster; 
						for(int i = monster.getX()-1; i < monster.getX() + 2; i++) {
							for(int j = monster.getY() -1; j < monster.getY()+2; j++)
							if(map[j][i] instanceof OceanPart) {
								map[j][i] = (BiggerMonster) monster; 
							}
						}
					}
				}
			}
			for(MonsterInterface removeM: remove) {
				removeM.destory();
				if(tempList.contains(removeM)) {
					tempList.remove(removeM); 
				}
			}
			monsters = tempList; 
			oceanMap.Map(); 
			System.out.println("");
		}
		
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}
}
*/
