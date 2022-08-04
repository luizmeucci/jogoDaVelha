package uninter;

public class ComputadorA extends Computador {

	@Override
	public void jogar(String posicoes[][]) {
		// realiza leirura do tabuleiro e insere jogdada no primeiro espaço disponivel

		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (posicoes[i][j].equals(" ")) {
					posicoes[i][j] = "O";
					return;
				}
			}
		}
	}

}
