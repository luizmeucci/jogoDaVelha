package uninter;

public class Tabuleiro {

	public String posicoesTabuleiro[][] = new String[3][3];
	public int numeroJogadas;
	private String marcaDoVencedor;

	public Tabuleiro() {
		this.numeroJogadas = 0;
		iniciarPosicoes();
		this.marcaDoVencedor = "";
	}

	private void iniciarPosicoes() {
		// inicia o tabuleiro vazio
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				this.posicoesTabuleiro[i][j] = " ";
			}
		}
	}

	private void renovarTela() {
		// imprime o cabecalho da tela
		for (int i = 0; i < 30; i++) {
			System.out.println();
		}
		System.out.println("     JOGO DA VELHA     ");
		System.out.println("X [Jogador] | O [Computador]\n");
	}

	public void mostrarTabuleiro() {
		renovarTela();
		// monta o tabuleiros e exibe jogadas ja realizadas
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				System.out.print(" " + this.posicoesTabuleiro[i][j] + " ");
				if (j < 2) {
					System.out.print(" | ");
				}
			}
			if (i < 2) {
				System.out.println("\n----+-----+----");
			}
		}
		System.out.println("\n");
	}

	public boolean verificarVitoria() {
		// verifica se todas as casas do tabuleiro foram preenchidas
		if (numeroJogadas < 5) {
			return false;
		}
		// verifica tabuleiro nas posicoes diagonais
		if (posicoesTabuleiro[0][0].equals(posicoesTabuleiro[1][1])
				&& posicoesTabuleiro[1][1].equals(posicoesTabuleiro[2][2]) && !(posicoesTabuleiro[1][1].equals(" "))) {
			this.marcaDoVencedor = posicoesTabuleiro[0][0];
			return true;
		}
		if (posicoesTabuleiro[2][0].equals(posicoesTabuleiro[1][1])
				&& posicoesTabuleiro[1][1].equals(posicoesTabuleiro[0][2]) && !(posicoesTabuleiro[1][1].equals(" "))) {
			this.marcaDoVencedor = posicoesTabuleiro[2][0];
			return true;

		}
		// verifica tabuleiro nas posicoes horizontais e verticais
		for (int i = 0; i < 3; i++) {
			if (posicoesTabuleiro[i][0].equals(posicoesTabuleiro[i][1])
					&& posicoesTabuleiro[i][1].equals(posicoesTabuleiro[i][2])
					&& !(posicoesTabuleiro[i][1].equals(" "))) {
				this.marcaDoVencedor = posicoesTabuleiro[i][0];
				return true;
			}
			if (posicoesTabuleiro[0][i].equals(posicoesTabuleiro[1][i])
					&& posicoesTabuleiro[1][i].equals(posicoesTabuleiro[2][i])
					&& !(posicoesTabuleiro[1][i].equals(" "))) {
				this.marcaDoVencedor = posicoesTabuleiro[0][i];
				return true;
			}
		}
		return false;
	}

	public String status() {
		// virifica situacao da partida
		boolean statusVitoria = verificarVitoria();
		if (statusVitoria == false && numeroJogadas == 9) {
			return "Empatou!";
		} else if (statusVitoria == false) {
			return "Nao terminou!";
		} else {
			if (this.marcaDoVencedor == "x") {
				return "Jogaador venceu!!!";
			} else {
				return "Computador venceu!!!";
			}
		}
	}
}
