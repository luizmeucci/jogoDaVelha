package uninter;

import java.util.Random;

public class ComputadorB extends Computador {

	Random num_aleatorio = new Random();

	@Override
	public void jogar(String[][] mapa) {
		// realiza leirura do tabuleiro e insere jogdada num espaço aleario
		int x, y;
		while (true) {
			x = num_aleatorio.nextInt(3);
			y = num_aleatorio.nextInt(3);
			if (mapa[x][y].equals(" ")) {
				mapa[x][y] = "O";
				return;
			}
		}
	}
}
