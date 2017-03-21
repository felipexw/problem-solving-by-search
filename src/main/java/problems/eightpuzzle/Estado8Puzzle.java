package problems.eightpuzzle;

import core.busca.Estado;
import core.busca.Nodo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Appio on 16/03/2017.
 */
public class Estado8Puzzle implements Estado {

    protected byte BRANCO = 0;
    protected byte[][] estadoMeta = {{0,1,2}, {3,4,5}, {6,7,8}};
    protected byte[][] estado = {{1,0,2}, {3,4,5}, {6,7,8}};
    protected byte dimensao;

    public Estado8Puzzle() {
    }

    public Estado8Puzzle(byte[][] estadoInicial, byte[][] estadoMeta) {
        this.estado = estadoInicial;
        this.estadoMeta = estadoMeta;
    }

    private void init() {
        estado = new byte[dimensao][dimensao];
        estadoMeta = new byte[dimensao][dimensao];

        java.util.Random random = new java.util.Random();

        byte count = 0;

        for (byte i = 0; i < dimensao; i++) {
            for (byte j = 0; j < dimensao; j++) {
                estado[i][j] = (byte) random.nextInt(dimensao);
                estadoMeta[i][j] = count;
                count++;
            }
        }
    }

    public String getDescricao() {
        return "8 quebra cabeças";
    }

    public boolean ehMeta() {
        for (byte i = 0; i < estado.length; i++) {
            for (byte j = 0; j < estadoMeta.length; j++) {
                System.out.println("(i,j) " + estado[i][j]);
                if (estado[i][j] != estadoMeta[i][j])
                    return false;
            }
        }
        return true;
    }

    public int custo() {
        return 1;
    }

    public byte[][] geraNovaMatriz(byte  linhaAntiga, byte colunaAntiga, byte novaLinha, byte novaColuna) {
        byte[][] novo = new byte[estado.length][estado.length];
        System.arraycopy(estado, 0, novo, 0, estado.length);

        byte atual = novo[linhaAntiga][colunaAntiga];
        novo[novaLinha][novaColuna] = 0;
        novo[novaLinha][novaColuna] = atual;

        return novo;
    }

    private void addSucessores(byte linhaAntiga, byte colunaAntiga, byte novaLinha, byte novaColuna, List<Estado> sucessores) {

        byte[][] novo = geraNovaMatriz(linhaAntiga, colunaAntiga, novaLinha, novaColuna);
        sucessores.add(new Estado8Puzzle(novo, estadoMeta));
    }

    public List<Estado> sucessores() {
        byte indexes[] = Puzzle8Utils.getIndiceColunaEmBranc(estado);
        byte lin = indexes[0];
        byte col = indexes[1];

        List<Estado> sucessores = new ArrayList<Estado>();

        if (Puzzle8Utils.isQuinaEsquerda(indexes)) {
            if (Puzzle8Utils.isCentro(indexes)) {
                //troca o de cima
                addSucessores(lin, col, (byte) ((byte) lin - 1), col, sucessores);

                //e o de baixo
                addSucessores(lin, col, (byte) ((byte) lin + 1), col, sucessores);

                //e o da direita
                addSucessores(lin, col, lin, (byte) (col + 1), sucessores);
            } else if (Puzzle8Utils.isFundo(indexes)) {
                //troca o de cima
                addSucessores(lin, col, (byte) ((byte) lin - 1), col, sucessores);

                //e e o da direita
                addSucessores(lin, col, lin, (byte) ((byte) col + 1), sucessores);
            } else {
                //troca o de baixo
                addSucessores(lin, col, (byte) ((byte) lin + 1), col, sucessores);

                //e da direita
                addSucessores(lin, col, lin, (byte) ((byte) col + 1), sucessores);
            }
        } else if (Puzzle8Utils.isQuinaDireita(indexes)) {
            if (Puzzle8Utils.isCentro(indexes)) {
                //troca o de cima
                addSucessores(lin, col, (byte) ((byte) lin - 1), col, sucessores);

                // e o de baixo
                addSucessores(lin, col, (byte) ((byte) lin + 1), col, sucessores);

                // e o da esquerda
                addSucessores(lin, col, lin, (byte) ((byte) col - 1), sucessores);
            } else if (Puzzle8Utils.isFundo(indexes)) {
                //troca o de cima
                addSucessores(lin, col, (byte) ((byte) lin - 1), col, sucessores);

                // e e o da esquerda
                addSucessores(lin, col, lin, (byte) ((byte) col - 1), sucessores);
            } else {
                //troca o de baixo
                addSucessores(lin, col, (byte) ((byte) lin + 1), col, sucessores);

                // e da esquerda
                addSucessores(lin, col, lin, (byte) ((byte) col - 1), sucessores);
            }
        } else {
            if (Puzzle8Utils.isCentro(indexes)) {
                //troca o de cima,
                addSucessores(lin, col, (byte) ((byte) lin - 1), col, sucessores);

                // de baixo,
                addSucessores(lin, col, (byte) ((byte) lin + 1), col, sucessores);

                // e da esquerda
                addSucessores(lin, col, lin, (byte) ((byte) col - 1), sucessores);

                // e da direita
                addSucessores(lin, col, lin, (byte) ((byte) col + 1), sucessores);
            } else if (Puzzle8Utils.isFundo(indexes)) {
                //troca o de cima,
                addSucessores(lin, col, (byte) ((byte) lin - 1), col, sucessores);

                // da esquerda
                addSucessores(lin, col, lin, (byte) ((byte) col - 1), sucessores);

                // e da direita
                addSucessores(lin, col, lin, (byte) ((byte) col + 1), sucessores);
            } else {
                //troca o de baixo,
                addSucessores(lin, col, (byte) ((byte) lin + 1), col, sucessores);

                // esquerda
                addSucessores(lin, col, lin, (byte) ((byte) col - 1), sucessores);

                // e direita
                addSucessores(lin, col, lin, (byte) ((byte) col + 1), sucessores);
            }
        }

        return sucessores;
    }

    @Override
    public String toString() {
        return super.toString();
    }

    public static void main(String[] args) throws Exception {
        Estado inicial = new Estado8PuzzleInformado();
        System.out.println("Estado inicial:" + inicial + "\n");

        core.busca.Nodo n = new core.busca.BuscaIterativo(new core.busca.MostraStatusConsole()).busca(inicial);
//        core.busca.Nodo n =  new core.busca.AEstrela(new core.busca.MostraStatusConsole()).busca(inicial);

        System.out.println("Solucaoo:\n" + n.getEstado() + "\n\n");

    }


}


