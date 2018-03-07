import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class OceanExplorer extends Application {

	boolean[][] islandMap;
	Pane root;
	final int dimensions = 20;
	final int islandCount = 20;
	final int scale = 50;
	Image shipImage;
	Image pirateImage;
	Image islandImage;
	Image pirateLand;
	ImageView shipImageView;
	ImageView[] pirateImageView;
	ImageView[] islandImageView;
	//ImageView[] pirateLandView;
	OceanMap oceanMap;
	Scene scene;
	Ship ship;
	PirateShip pirateship;

	@Override
	public void start(Stage mapStage) throws Exception {

		oceanMap = new OceanMap(dimensions, islandCount);
		islandMap = oceanMap.getMap(); // Note: We will revisit this in a future class and use an iterator instead of
										// exposing the underlying representation!!!
		islandImageView = new ImageView[oceanMap.getIslands().length];
		pirateImageView = new ImageView[oceanMap.getPirates().length];
		//pirateLandView = new ImageView[oceanMap.getPirates().length];
		root = new AnchorPane();
		drawMap();

		ship = new Ship(oceanMap);
		pirateship = new PirateShip(oceanMap);
		loadShipImage();
		ship.addObserver(pirateship);

		scene = new Scene(root, 1000, 1000);
		mapStage.setTitle("Christopher Columbus Sails the Ocean Blue");
		mapStage.setScene(scene);
		mapStage.show();
		startSailing();
	}

	private void loadShipImage() {
		// Load the ship image for player
		Image shipImage = new Image("ship.png", 50, 50, true, true);
		shipImageView = new ImageView(shipImage);
		shipImageView.setX(oceanMap.getShipLocation().x * scale);
		shipImageView.setY(oceanMap.getShipLocation().y * scale);
		root.getChildren().add(shipImageView);

		// Load the pirate's islands
/*		Image pirateLand = new Image("pirateIsland.png", 50, 50, true, true);
		for (int i = 0; i < oceanMap.getPirates().length; i++) {
			pirateLandView[i] = new ImageView(pirateLand);
			pirateLandView[i].setX(oceanMap.getPirates()[i].x * scale);
			pirateLandView[i].setY(oceanMap.getPirates()[i].y * scale);
			root.getChildren().add(pirateLandView[i]);
		}*/

		// Load the pirate ships
		Image pirateImage = new Image("pirateShip.png", 50, 50, true, true);
		for (int i = 0; i < oceanMap.getPirates().length; i++) {
			pirateImageView[i] = new ImageView(pirateImage);
			pirateImageView[i].setX(oceanMap.getPirates()[i].x * scale);
			pirateImageView[i].setY(oceanMap.getPirates()[i].y * scale);
			root.getChildren().add(pirateImageView[i]);
		}
		// Load the island images
		Image islandImage = new Image("island.jpg", 50, 50, true, true);
		for (int i = 0; i < 20; i++) {
			islandImageView[i] = new ImageView(islandImage);
			islandImageView[i].setX(oceanMap.getIslands()[i].x * scale);
			islandImageView[i].setY(oceanMap.getIslands()[i].y * scale);
			root.getChildren().add(islandImageView[i]);
		}
	}

	private void startSailing() {
		scene.setOnKeyPressed(new EventHandler<KeyEvent>() {

			@Override
			public void handle(KeyEvent ke) {
				switch (ke.getCode()) {
				case RIGHT:
					ship.goEast();
					break;
				case LEFT:
					ship.goWest();
					break;
				case UP:
					ship.goNorth();
					break;
				case DOWN:
					ship.goSouth();
					break;
				default:
					break;
				}
				shipImageView.setX(ship.getShipLocation().x * scale);
				shipImageView.setY(ship.getShipLocation().y * scale);
				for (int i = 0; i < oceanMap.getPirates().length; i++) {
					pirateImageView[i].setX(pirateship.getShipLocation()[i].x * scale);
					pirateImageView[i].setY(pirateship.getShipLocation()[i].y * scale);
				}
			}
		});
	}

	// Draw ocean and islands
	public void drawMap() {
		for (int x = 0; x < dimensions; x++) {
			for (int y = 0; y < dimensions; y++) {
				Rectangle rect = new Rectangle(x * scale, y * scale, scale, scale);
				rect.setStroke(Color.BLACK);
				if (islandMap[x][y])
					rect.setFill(Color.GREEN);
				else
					rect.setFill(Color.PALETURQUOISE);
				root.getChildren().add(rect);
			}
		}
	}

	public static void main(String[] args) {
		launch(args);
	}

}