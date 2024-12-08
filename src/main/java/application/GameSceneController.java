package application;

import java.nio.charset.StandardCharsets;

import edu.princeton.cs.algs4.Graph;
import edu.princeton.cs.algs4.In;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

/**
 * The GameSceneController class is the controller of the GameScene FXML file.
 * 
 * It includes all Java FX elements, such as Buttons and Text. When it is called from
 * 'GameScene.fxml', the constructor method creates a graph based on 10 vertices and 15 edges.
 * It also creates a player and 2 enemies. The 'next' method receives 
 * user input through the attack and select buttons, and controls all changes made 
 * to buttons and text during game-play, such as changing colors. 
 * The 'next' method also calls the 'attack' method, which uses the graph
 * to attack neighbors.
 * 
 * @author Sean Ledesma
 * @author Braden Tolman
 *
 */
public class GameSceneController {
	static Base[] allBases;
	static int enemyOwnedBases; // when no enemy bases are owned the player wins
	static int playerOwnedBases; // when no player bases are owned the player loses
	static Player player;
	static Enemy enemyOne;
	static Enemy enemyTwo;
	static Graph warMap;
	static int attackingBase;
	static int defendingBase = 1;
	FXMLLoader loader = new FXMLLoader(getClass().getResource("/application/GameScene.fxml"));
	static boolean successful;
	static String result;
	public double difficulty = 0.3;

	@FXML
	private Button attacking0;
	@FXML
	private Button attacking1;
	@FXML
	private Button attacking2;
	@FXML
	private Button attacking3;
	@FXML
	private Button attacking4;
	@FXML
	private Button attacking5;
	@FXML
	private Button attacking6;
	@FXML
	private Button attacking7;
	@FXML
	private Button attacking8;
	@FXML
	private Button attacking9;
	@FXML
	private Button defending0;
	@FXML
	private Button defending1;
	@FXML
	private Button defending2;
	@FXML
	private Button defending3;
	@FXML
	private Button defending4;
	@FXML
	private Button defending5;
	@FXML
	private Button defending6;
	@FXML
	private Button defending7;
	@FXML
	private Button defending8;
	@FXML
	private Button defending9;
	@FXML
	private Text playerText;
	@FXML
	private Text numOfBases;
	@FXML
	private Text enemyNumBases;
	@FXML
	private Text enemy2NumBases;
	@FXML
	private Text base0Txt;
	@FXML
	private Text base1Txt;
	@FXML
	private Text base2Txt;
	@FXML
	private Text base3Txt;
	@FXML
	private Text base4Txt;
	@FXML
	private Text base5Txt;
	@FXML
	private Text base6Txt;
	@FXML
	private Text base7Txt;
	@FXML
	private Text base8Txt;
	@FXML
	private Text base9Txt;
	@FXML
	private Text troop0;
	@FXML
	private Text troop1;
	@FXML
	private Text troop2;
	@FXML
	private Text troop3;
	@FXML
	private Text troop4;
	@FXML
	private Text troop5;
	@FXML
	private Text troop6;
	@FXML
	private Text troop7;
	@FXML
	private Text troop8;
	@FXML
	private Text troop9;
	@FXML
	private Text hlth0;
	@FXML
	private Text hlth1;
	@FXML
	private Text hlth2;
	@FXML
	private Text hlth3;
	@FXML
	private Text hlth4;
	@FXML
	private Text hlth5;
	@FXML
	private Text hlth6;
	@FXML
	private Text hlth7;
	@FXML
	private Text hlth8;
	@FXML
	private Text hlth9;
	@FXML
	private Text playerOwned;
	@FXML
	private Text enemy1Owned;
	@FXML
	private Text enemy2Owned;
	@FXML
	private Text summary;
	@FXML
	private RadioButton diffEasy;
	@FXML
	private RadioButton diffMedium;
	@FXML
	private RadioButton diffHard;

	/**
	 * Is called by selecting a difficulty Radio Button in Game Scene, gets User
	 * data by getting the source of the method call and converts it into a double
	 * 
	 * @param event
	 */
	@FXML
	void selectDifficulty(ActionEvent event) {
		Node node = (Node) event.getSource();
		String data = (String) node.getUserData();
		difficulty = Double.parseDouble(data);
		enemyOne.setDifficulty(difficulty);
		enemyTwo.setDifficulty(difficulty);
	}

	/**
	 * method is called when next round button is pressed in Game Scene.
	 * calls attack method, controls all Button and Text changes while game is running.
	 * @param event
	 */
	@FXML
	void next(ActionEvent event) {

		attack(allBases[attackingBase], allBases[defendingBase]);

		numOfBases.setText(String.valueOf(playerOwnedBases));
		enemyNumBases.setText(String.valueOf(enemyOne.basesOwned.size()));
		enemy2NumBases.setText(String.valueOf(enemyTwo.basesOwned.size()));

		String num = "";
		for (Base base : player.basesOwned) {
			num = num.concat(base.getIndex() + " ");
			if (base.getIndex() == 0) {
				attacking0.setStyle("-fx-background-color:  #47B6FF");
				defending0.setStyle("-fx-background-color:  #47B6FF");
				base0Txt.setFill(Color.BLUE);
			} else if (base.getIndex() == 1) {
				attacking1.setStyle("-fx-background-color:  #47B6FF");
				defending1.setStyle("-fx-background-color:  #47B6FF");
				base1Txt.setFill(Color.BLUE);
			} else if (base.getIndex() == 2) {
				attacking2.setStyle("-fx-background-color:  #47B6FF");
				defending2.setStyle("-fx-background-color: #47B6FF");
				base2Txt.setFill(Color.BLUE);
			} else if (base.getIndex() == 3) {
				attacking3.setStyle("-fx-background-color: #47B6FF");
				defending3.setStyle("-fx-background-color: #47B6FF");
				base3Txt.setFill(Color.BLUE);
			} else if (base.getIndex() == 4) {
				attacking4.setStyle("-fx-background-color: #47B6FF");
				defending4.setStyle("-fx-background-color: #47B6FF");
				base4Txt.setFill(Color.BLUE);
			} else if (base.getIndex() == 5) {
				attacking5.setStyle("-fx-background-color: #47B6FF");
				defending5.setStyle("-fx-background-color: #47B6FF");
				base5Txt.setFill(Color.BLUE);
			} else if (base.getIndex() == 6) {
				attacking6.setStyle("-fx-background-color: #47B6FF");
				defending6.setStyle("-fx-background-color: #47B6FF");
				base6Txt.setFill(Color.BLUE);
			} else if (base.getIndex() == 7) {
				attacking7.setStyle("-fx-background-color: #47B6FF");
				defending7.setStyle("-fx-background-color: #47B6FF");
				base7Txt.setFill(Color.BLUE);
			} else if (base.getIndex() == 8) {
				attacking8.setStyle("-fx-background-color: #47B6FF");
				defending8.setStyle("-fx-background-color: #47B6FF");
				base8Txt.setFill(Color.BLUE);
			} else if (base.getIndex() == 9) {
				attacking9.setStyle("-fx-background-color: #47B6FF");
				defending9.setStyle("-fx-background-color: #47B6FF");
				base9Txt.setFill(Color.BLUE);
			}
		}
		playerOwned.setText(num);

		String num2 = "";
		for (Base base : enemyOne.basesOwned) {
			num2 = num2.concat(base.getIndex() + " ");
			if (base.getIndex() == 0) {
				attacking0.setStyle("-fx-background-color:  #40FF7A");
				defending0.setStyle("-fx-background-color: #40FF7A");
				base0Txt.setFill(Color.GREEN);
			} else if (base.getIndex() == 1) {
				attacking1.setStyle("-fx-background-color: #40FF7A");
				defending1.setStyle("-fx-background-color: #40FF7A");
				base1Txt.setFill(Color.GREEN);
			} else if (base.getIndex() == 2) {
				attacking2.setStyle("-fx-background-color: #40FF7A");
				defending2.setStyle("-fx-background-color: #40FF7A");
				base2Txt.setFill(Color.GREEN);
			} else if (base.getIndex() == 3) {
				attacking3.setStyle("-fx-background-color: #40FF7A");
				defending3.setStyle("-fx-background-color: #40FF7A");
				base3Txt.setFill(Color.GREEN);
			} else if (base.getIndex() == 4) {
				attacking4.setStyle("-fx-background-color: #40FF7A");
				defending4.setStyle("-fx-background-color: #40FF7A");
				base4Txt.setFill(Color.GREEN);
			} else if (base.getIndex() == 5) {
				attacking5.setStyle("-fx-background-color: #40FF7A");
				defending5.setStyle("-fx-background-color: #40FF7A");
				base5Txt.setFill(Color.GREEN);
			} else if (base.getIndex() == 6) {
				attacking6.setStyle("-fx-background-color: #40FF7A");
				defending6.setStyle("-fx-background-color: #40FF7A");
				base6Txt.setFill(Color.GREEN);
			} else if (base.getIndex() == 7) {
				attacking7.setStyle("-fx-background-color: #40FF7A");
				defending7.setStyle("-fx-background-color: #40FF7A");
				base7Txt.setFill(Color.GREEN);
			} else if (base.getIndex() == 8) {
				attacking8.setStyle("-fx-background-color: #40FF7A");
				defending8.setStyle("-fx-background-color: #40FF7A");
				base8Txt.setFill(Color.GREEN);
			} else if (base.getIndex() == 9) {
				attacking9.setStyle("-fx-background-color: #40FF7A");
				defending9.setStyle("-fx-background-color: #40FF7A");
				base9Txt.setFill(Color.GREEN);
			}
		}
		enemy1Owned.setText(num2);

		String num3 = "";
		for (Base base : enemyTwo.basesOwned) {
			num3 = num3.concat(base.getIndex() + " ");
			if (base.getIndex() == 0) {
				attacking0.setStyle("-fx-background-color: #E15651");
				defending0.setStyle("-fx-background-color: #E15651");
				base0Txt.setFill(Color.RED);
			} else if (base.getIndex() == 1) {
				attacking1.setStyle("-fx-background-color: #E15651");
				defending1.setStyle("-fx-background-color: #E15651");
				base1Txt.setFill(Color.RED);
			} else if (base.getIndex() == 2) {
				attacking2.setStyle("-fx-background-color: #E15651");
				defending2.setStyle("-fx-background-color: #E15651");
				base2Txt.setFill(Color.RED);
			} else if (base.getIndex() == 3) {
				attacking3.setStyle("-fx-background-color: #E15651");
				defending3.setStyle("-fx-background-color: #E15651");
				base3Txt.setFill(Color.RED);
			} else if (base.getIndex() == 4) {
				attacking4.setStyle("-fx-background-color: #E15651");
				defending4.setStyle("-fx-background-color: #E15651");
				base4Txt.setFill(Color.RED);
			} else if (base.getIndex() == 5) {
				attacking5.setStyle("-fx-background-color: #E15651");
				defending5.setStyle("-fx-background-color: #E15651");
				base5Txt.setFill(Color.RED);
			} else if (base.getIndex() == 6) {
				attacking6.setStyle("-fx-background-color: #E15651");
				defending6.setStyle("-fx-background-color: #E15651");
				base6Txt.setFill(Color.RED);
			} else if (base.getIndex() == 7) {
				attacking7.setStyle("-fx-background-color: #E15651");
				defending7.setStyle("-fx-background-color: #E15651");
				base7Txt.setFill(Color.RED);
			} else if (base.getIndex() == 8) {
				attacking8.setStyle("-fx-background-color: #E15651");
				defending8.setStyle("-fx-background-color: #E15651");
				base8Txt.setFill(Color.RED);
			} else if (base.getIndex() == 9) {
				attacking9.setStyle("-fx-background-color: #E15651");
				defending9.setStyle("-fx-background-color: #E15651");
				base9Txt.setFill(Color.RED);
			}
		}
		enemy2Owned.setText(num3);

		for (Base base : allBases) {
			hlth0.setText(String.valueOf(base.getHealth()));
			troop0.setText(String.valueOf(base.getTroops()));
		}

		Text[] troops = { troop0, troop1, troop2, troop3, troop4, troop5, troop6, troop7, troop8, troop9 };
		Text[] health = { hlth0, hlth1, hlth2, hlth3, hlth4, hlth5, hlth6, hlth7, hlth8, hlth9 };

		for (int i = 0; i < troops.length; i++) {
			troops[i].setText(String.valueOf(allBases[i].getTroops()));
			health[i].setText(String.valueOf(allBases[i].getHealth()));
		}

		summary.setText(result);

		if (playerOwnedBases <= 0) {
			summary.setText("You Lose");
		} else if (enemyOwnedBases <= 0) {
			summary.setText("You Win!");
		}

	}
	/**
	 * method is called when user presses any of the
	 * ten select buttons on map
	 * @param event
	 */
	@FXML
	void attackingBtn(ActionEvent event) {
		Node node = (Node) event.getSource();
		String data = (String) node.getUserData();
		attackingBase = Integer.parseInt(data);
	}
	/**
	 * method is called when user presses any of the 
	 * ten attack buttons on map
	 * @param event
	 */
	@FXML
	void defendingBtn(ActionEvent event) {
		Node node = (Node) event.getSource();
		String data = (String) node.getUserData();
		defendingBase = Integer.parseInt(data);
	}
	
	private static void attack(Base attackingBase, Base defendingBase) {
		boolean isAdj = false;
		for (Integer base : warMap.adj(attackingBase.getIndex())) {
			if (base == defendingBase.getIndex()) {
				isAdj = true;
			}
		}
		if (isAdj || defendingBase.getStatus() == player.getID()) {
			result = chooseAction(attackingBase, defendingBase, player);

			if (enemyOne.basesOwned.size() > 0) {
				Base chosenAttackingBase = enemyOne.chooseAttackingBase();
				chooseAction(chosenAttackingBase, enemyOne.chooseDefendingBase(warMap, allBases, chosenAttackingBase),
						enemyOne);
			}
			if (enemyTwo.basesOwned.size() > 0) {
				Base chosenAttackingBase = enemyTwo.chooseAttackingBase();
				chooseAction(chosenAttackingBase, enemyTwo.chooseDefendingBase(warMap, allBases, chosenAttackingBase),
						enemyTwo);
			}

			enemyOwnedBases = enemyOne.basesOwned.size() + enemyTwo.basesOwned.size();
			playerOwnedBases = player.basesOwned.size();

			for (Base base : allBases) {
				base.nextGrowthCycle();
			}
		} else {
			result = "You cannot attack from base " + attackingBase.getIndex() + " to base " + defendingBase.getIndex() + "!";
		}
	}

	private static String chooseAction(Base attackingBase, Base defendingBase, Player currentPlayer) {
		String result = "";
		if (attackingBase.getStatus() != currentPlayer.getID()) {
			result = ("You do not own " + attackingBase.getIndex());
			return result;
		} else if (defendingBase.getStatus() == currentPlayer.getID()) {
			result = (currentPlayer.getName() + " transferred " + attackingBase.getTroops() + " troops from base "
					+ attackingBase.getIndex() + " to base " + defendingBase.getIndex());
			currentPlayer.transferTroops(attackingBase, defendingBase);
			result = result
					.concat(" Base " + defendingBase.getIndex() + " now has " + defendingBase.getTroops() + " troops.");
			return result;
		} else {
			successful = currentPlayer.attackBase(attackingBase, defendingBase);
			updateAllPlayerBases();
			if (successful) {
				result = ("success! remaining troops at base: " + defendingBase.getTroops() + "\n");
			} else {
				result = ("failure! defending troops remaining: " + defendingBase.getTroops());
			}
		}
		return result;
	}

	private static void updateAllPlayerBases() {
		player.updateBases(allBases);
		enemyOne.updateBases(allBases);
		enemyTwo.updateBases(allBases);
	}
	/**
	 * sets up game when class is called by GameScene.fxml
	 * creates graph, player, and enemies
	 */
	public GameSceneController() {
		// creates the graph and prints info. No real use yet.
		In in = new In(getClass().getResource("/levelOne.txt").getFile());

		warMap = new Graph(in);

		// Builds the array of bases. I want a linked list of some sort but starting
		// with an array for simplicity.
		allBases = new Base[warMap.V()];
		for (int i = 0; i < warMap.V(); i++)
			allBases[i] = new Base(i);

		// Initializes the three players of the game
		player = new Player(allBases, BaseStatus.PLAYER, "Player");
		enemyOne = new Enemy(allBases, BaseStatus.ENEMY1, "Enemy 1", difficulty);
		enemyTwo = new Enemy(allBases, BaseStatus.ENEMY2, "Enemy 2", difficulty);

		// Initializes starting troops and players with a single base each
		allBases[0].setStatus(player.getID());
		allBases[0].setTroops(250);
		allBases[4].setStatus(enemyOne.getID());
		allBases[4].setTroops(250);
		allBases[7].setStatus(enemyTwo.getID());
		allBases[7].setTroops(250);

		updateAllPlayerBases();
	}

}
