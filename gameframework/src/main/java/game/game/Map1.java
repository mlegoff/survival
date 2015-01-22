package game.game;

import gameframework.drawing.GameCanvas;

public class Map1 extends Map{

	@Override
	protected void init(int[][] board, int size, GameCanvas canvas) {
		this.map = new Case[board.length][board[0].length];
		for(int i = 0; i < map.length; i++) {
			for(int j = 0; j < map[0].length; j++) {
			 switch(board[i][j]) {
					case 0 : this.map[i][j] = new Sol(j*size,i*size,canvas); break;
					case 1 : this.map[i][j] = new Mur(j*size,i*size,canvas,"/images/murHaut.png"); this.blocker.addMoveBlocker((Mur)this.map[i][j]); break;
					case 2 : this.map[i][j] = new Mur(j*size,i*size,canvas,"/images/murDroit.png"); this.blocker.addMoveBlocker((Mur)this.map[i][j]); break;
					case 3 : this.map[i][j] = new Mur(j*size,i*size,canvas,"/images/murBas.png"); this.blocker.addMoveBlocker((Mur)this.map[i][j]); break;
					case 4 : this.map[i][j] = new Mur(j*size,i*size,canvas,"/images/murGauche.png"); this.blocker.addMoveBlocker((Mur)this.map[i][j]); break;
					case 5 : this.map[i][j] = new Mur(j*size,i*size,canvas,"/images/murCote.png"); this.blocker.addMoveBlocker((Mur)this.map[i][j]); break;
					case 9 : this.map[i][j] = new Decor(j*size,i*size,canvas); break;
				}
			}
		}
	}

}
