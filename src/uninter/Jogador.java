package uninter;

public class Jogador {

	public boolean jogar(String mapa[][], String linha, String coluna) {

		// verifica se opcao escolhida pelo jogador não esta ocupada
		try {
			int x = Integer.parseInt(linha);
			int y = Integer.parseInt(coluna);
			if (mapa[x - 1][y - 1].equals(" ")) {
				mapa[x - 1][y - 1] = "X";
				return true;
			} else {

				System.out.println("Esta posicao ja esta ocupada!");
				return false;
			}
		} catch (Exception e) {
			System.out.println("Valor invalido!");
			return false;
		}
	}
}
