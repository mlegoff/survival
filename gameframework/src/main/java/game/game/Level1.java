package game.game;

import java.awt.Point;
import java.net.MalformedURLException;

import gameframework.motion.MoveStrategyKeyboard;
import gameframework.motion.GameMovableDriverDefaultImpl;
import gameframework.drawing.GameCanvas;
import gameframework.game.GameData;
import gameframework.game.GameLevelDefaultImpl;

public class Level1 extends GameLevelDefaultImpl{
	public static final int RENDERING_SIZE = 16;
	private final int[][] board = {{5,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,5},
								    {4,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,2},
						            {4,0,0,0,0,9,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,9,0,0,0,0,0,0,2},
						            {4,0,0,0,9,9,9,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,9,0,0,0,0,0,2},
						            {4,0,0,0,0,9,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,9,0,0,0,0,2},
						            {4,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,2},
						            {4,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,2},
						            {4,0,0,0,0,0,0,0,0,9,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,2},
						            {4,0,0,0,0,0,0,0,0,9,9,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,2},
						            {4,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,9,9,0,0,0,0,0,0,0,0,0,0,0,2},
						            {4,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,9,9,0,0,0,0,0,0,0,0,0,0,2},
						            {4,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,2},
						            {4,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,2},
						            {4,0,0,0,0,0,9,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,9,0,0,2},
						            {4,0,0,0,0,9,9,9,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,9,9,0,0,2},
						            {4,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,9,9,9,0,0,2},
						            {4,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,2},
						            {5,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,5}};
	private GameCanvas canvas;
	public Level1(GameData data) {
		super(data);
		
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void init() {
		this.universe = this.data.getUniverse();
		this.canvas = data.getCanvas();
		this.gameBoard = new SurvivalGameBoard(this.data);
		this.loadEntities();
	}
	
	private void createPikachu(){
		Pikachu pika = new Pikachu(this.canvas);
		pika.setPosition(new Point(200,200));
		GameMovableDriverDefaultImpl pikaDriver = new GameMovableDriverDefaultImpl();
		MoveStrategyKeyboard keyStrategy = new MoveStrategyKeyboard();
		pika.setDriver(pikaDriver);
		this.data.getCanvas().addKeyListener(keyStrategy);
		this.universe.addGameEntity(pika);
		
	}
	private void loadEntities() {
		/**
		for(int i = 0; i < board.length; i++) {
			for(int j = 0; j < board[0].length; j++) {
				if(board[i][j] == 4){
					Mur mur = new Mur(j*RENDERING_SIZE,i*RENDERING_SIZE,canvas,"/images/murGauche.png");
					this.universe.addGameEntity(mur);
					this.data.getMoveBlockerChecker().addMoveBlocker(mur);
									}
				if(board[i][j] == 2) {
					Mur mur = new Mur(j*RENDERING_SIZE,i*RENDERING_SIZE,canvas,"/images/murDroit.png");
					this.universe.addGameEntity(mur);
					this.data.getMoveBlockerChecker().addMoveBlocker(mur);
									}
				if(board[i][j] == 3){
					Mur mur = new Mur(j*RENDERING_SIZE,i*RENDERING_SIZE,canvas,"/images/murBas.png");
					this.universe.addGameEntity(mur);
					this.data.getMoveBlockerChecker().addMoveBlocker(mur);
									}
				if(board[i][j] == 1) {
					Mur mur = new Mur(j*RENDERING_SIZE,i*RENDERING_SIZE,canvas,"/images/murHaut.png");
					this.universe.addGameEntity(mur);
					this.data.getMoveBlockerChecker().addMoveBlocker(mur);
									}
				if(board[i][j] == 5) {
					Mur mur = new Mur(j*RENDERING_SIZE,i*RENDERING_SIZE,canvas,"/images/murCote.png");
					this.universe.addGameEntity(mur);
					this.data.getMoveBlockerChecker().addMoveBlocker(mur);
									}
			}
			}**/
		createPikachu();
	
	}

}
