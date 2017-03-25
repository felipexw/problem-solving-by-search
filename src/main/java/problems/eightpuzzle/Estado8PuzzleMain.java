package problems.eightpuzzle;

import core.busca.Estado;

import java.util.Scanner;

/**
 * Created by Appio on 24/03/2017.
 */
public class Estado8PuzzleMain {
    private static final byte NIVEL_FACIL = 1;
    private static final byte NIVEL_MEDIO = 2;
    private static final byte NIVEL_DIFICIL = 3;

    private static final byte BUSCA_EM_LARGURA = 1;
    private static final byte BUSCA_EM_PROFUNDIDADE_ITERATIVA = 2;    
    private static final byte BUSCA_A_ESTRELA = 3;

    public static void main(String[] args) throws Exception {
        run();
    }

    private static void run() {
        Scanner in = new Scanner(System.in);
        byte opcaoComplexidade = 0;
        byte opcaoMetodo = 0;
        byte opcaoHeuristica = 0;
        byte continua = 1;

        do {
            System.out.println("Selecione o nivel de complexidade do problema:  + " +
                    "\n 1 - facil" +
                    "\n 2 - medio" +
                    "\n 3 - dificil" +
                    "\n 0 - Finalizar");

            opcaoComplexidade = in.nextByte();

            System.out.println("Selecione um metodo de busca para resolver o problema escolhido:  + " +
                    "\n 1 - largura (cega) " +
                    "\n 2 - profundidade iterativa (cega)" +
                    "\n 3 ou qualquer valor - A* (heuristica)"+                    
                    "\n 0 - Finalizar");
            opcaoMetodo = in.nextByte();

            if (opcaoMetodo == BUSCA_A_ESTRELA) {
                System.out.print("Selecione a heuristica a ser utilizada:" +
                        "\n - 1 contar a quantidade de casas fora do lugar em relacao ao meta" +
                        "\n - 2 - distancia de manhattan (quantidade de movimentos necessários para chegar ate o meta) | Domina h1, ou seja, h2 > h1" +
                        "\n - 3 - distancia de mahanttan considerando a quantidade de transicoes das pecas adjancentes | Domina h2, ou seja, h3 > h2" +
                        "\n 0 - Finalizar");
                opcaoHeuristica = in.nextByte();
            }

            executarBuscaOpcaoSelecionada(opcaoComplexidade, opcaoMetodo, opcaoHeuristica);
            System.out.print("Deseja continuar? " +
                    "\n 1 - Sim" +
                    "\n 0 - Não");
            continua = in.nextByte();

        } while (continua != 0);
    }


    private static void executarBuscaOpcaoSelecionada(byte complexidadeProblema, byte metodo, byte heuristica) {
        core.busca.Nodo n = null;
        Estado inicial = new Estado8Puzzle(getEstadoBaseadoNaComplexidade(complexidadeProblema));

        switch (metodo) {
            case BUSCA_EM_LARGURA:
                n = new core.busca.BuscaLargura(new core.busca.MostraStatusConsole()).busca(new Estado8Puzzle(getEstadoBaseadoNaComplexidade(complexidadeProblema)));
                break;

            case BUSCA_EM_PROFUNDIDADE_ITERATIVA:
                n = new core.busca.BuscaIterativo(new core.busca.MostraStatusConsole()).busca(new Estado8Puzzle(getEstadoBaseadoNaComplexidade(complexidadeProblema)));
                break;

            default:
                n = new core.busca.AEstrela(new core.busca.MostraStatusConsole()).busca(new Estado8Puzzle(getEstadoBaseadoNaComplexidade(complexidadeProblema), heuristica));
                break;
        }

        System.out.println("Caminho: " + n.montaCaminho());
    }


    private static byte[][] getEstadoBaseadoNaComplexidade(byte opcao) {
        switch (opcao) {
            case NIVEL_FACIL:
                return new byte[][]{{1, 2, 0}, {3, 4, 5}, {6, 7, 8}};

            case NIVEL_MEDIO:{
            	return new byte[][]{{8, 7, 6}, {5, 4, 0}, {3, 2, 1}};
//              return new byte[][]{{7, 2, 4}, {5, 0, 6}, {8, 3, 1}};
//            	return new byte[][]{{0, 2, 1}, {3, 4, 5}, {6, 7, 8}}; 
            	
            }


            case NIVEL_DIFICIL:{
//            	return new byte[][]{{8, 3, 2}, {1, 5, 4}, {6, 7, 0}};
            	
            	return new byte[][]{{8, 5, 7}, {6, 2, 3}, {0, 4, 1}};
            }
                

            default:
                return new byte[][]{{1, 2, 0}, {3, 4, 5}, {6, 7, 8}};
        }


    }
}
