package uninter;

import java.util.Scanner;

public class Jogo {

	public static void main(String[] args) {

		@SuppressWarnings("resource")
		Scanner entrada = new Scanner(System.in);
		int continuar = 0;

		Jogador jogador = new Jogador();
		ComputadorA computadorA = new ComputadorA();
		ComputadorB computadorB = new ComputadorB();
		ComputadorC computadorC = new ComputadorC();

		while (true) {
			Tabuleiro tab = new Tabuleiro();
			// menu contendo as opcoes do computador
			int dificuldade = menu();
			boolean vitoriaJogador;

			do {
				// verifica se ainda existem casas disponiveis no tbuleiro
				if (tab.numeroJogadas == 9) {
					break;
				}
				// inicia as variaveis que recebem as posicoes do jogador humano
				String x, y;
				x = y = "";
				tab.mostrarTabuleiro();
				// opcao de entrada de jogada do jogador humano
				do {
					System.out.print("Escolha a linha: ");
					x = entrada.next();
					System.out.print("Escolha a coluna: ");
					y = entrada.next();
				} while (!(jogador.jogar(tab.posicoesTabuleiro, x, y)));
				tab.numeroJogadas++;

				// verifica se houve vitoria do jogador, caso contrario, inicia jogada do
				// computador correspondete
				vitoriaJogador = tab.verificarVitoria();
				if (!(vitoriaJogador)) {
					// efetua jogada do computador correspondente, caso não identifique vencedor
					switch (dificuldade) {
					case 1:
						computadorA.jogar(tab.posicoesTabuleiro);
						break;
					case 2:
						computadorB.jogar(tab.posicoesTabuleiro);
						break;
					case 3:
						computadorC.jogar(tab.posicoesTabuleiro);
						break;
					}
					tab.numeroJogadas++;
				}

			} while (!(tab.verificarVitoria()));
			tab.mostrarTabuleiro();
			System.out.println(tab.status());

			// Verifica se deseja jogar de volta
			System.out.println("Jogar novamente? [1] Sim [2] Nao");
			continuar = Integer.parseInt(entrada.next());
			if (continuar != 1) {
				break;
			}
		}
	}

	public static int menu() {
		// menu da escolha dos niveis
		@SuppressWarnings("resource")
		Scanner entrada = new Scanner(System.in);
		int dificuldade = 0;

		// seleciona um dos 3 niveis do jogo
		while (true) {
			try {
				System.out.println("     JOGO DA VELHA     ");
				System.out.println("");
				System.out.print("Escolha a dificuldade: [1] [2] [3]: ");
				dificuldade = Integer.parseInt(entrada.next());
				switch (dificuldade) {
				case 1:
					return 1;
				case 2:
					return 2;
				case 3:
					return 3;
				default:
					System.out.println("Opcao invalida!");
				}
			} catch (Exception e) {
				System.out.println("Dados invalidos!");
			}
		}
	}
}