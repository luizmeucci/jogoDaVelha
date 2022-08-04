package uninter;

import java.util.Random;

public class ComputadorC extends Computador {

	Random num_aleatorio = new Random();

	@Override
	public void jogar(String[][] mapa) {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (mapa[i][j].equals("X")) {
					// realiza leirura do tabuleiro verificando se horizontais ja foram utilizdas
					try {
						if (mapa[i + 1][j].equals(" ")) {
							mapa[i + 1][j] = "O";
							return;
						}
					} catch (Exception e) {
					}
					try {
						if (mapa[i - 1][j].equals(" ")) {
							mapa[i - 1][j] = "O";
							return;
						}
					} catch (Exception e) {
					}

					// realiza leirura do tabuleiro verificando se vericais ja foram utilizdas
					try {
						if (mapa[i][j + 1].equals(" ")) {
							mapa[i][j + 1] = "O";
							return;
						}
					} catch (Exception e) {
					}
					try {
						if (mapa[i][j - 1].equals(" ")) {
							mapa[i][j - 1] = "O";
							return;
						}
					} catch (Exception e) {
					}
				}
			}
		}
		// caso falha, realiza jogada aleatoria
		int x;
		while (true) {
			x = num_aleatorio.nextInt(3);
			for (int j = 0; j < 3; j++) {
				if (mapa[x][j].equals(" ")) {
					mapa[x][j] = "O";
					return;
				}
			}
		}
	}
}
