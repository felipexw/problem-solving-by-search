package problems.eightpuzzle;

import core.busca.Estado;
import core.busca.Heuristica;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Appio on 16/03/2017.
 */

public class Estado8Puzzle implements Estado, Heuristica {

    protected byte[][] estadoMeta = {{0, 1, 2}, {3, 4, 5}, {6, 7, 8}};
    protected final byte[][] estado;

    public void setEstadoMeta(byte[][] meta) {
        estadoMeta = meta;
    }

    public Estado8Puzzle(byte[][] estado) {
        this.estado = estado;
    }

    public Estado8Puzzle(byte[][] estadoInicial, byte[][] estadoMeta) {
        this.estado = estadoInicial;
        this.estadoMeta = estadoMeta;
    }

    public byte[][] getEstado() {
        return estado;
    }

    public String getDescricao() {
        return "8 quebra cabeças";
    }

    public boolean ehMeta() {
        return h() == 0;
    }

    public int custo() {
        return 1;
    }

    public byte[][] geraNovaMatriz(byte linhaAntiga, byte colunaAntiga, byte novaLinha, byte novaColuna) {
        byte[][] novo = new byte[estado.length][estado.length];
        Puzzle8Utils.copy(estado, novo);

        byte atual = novo[novaLinha][novaColuna];
        novo[novaLinha][novaColuna] = 0;
        novo[linhaAntiga][colunaAntiga] = atual;

        return novo;
    }


    private void addSucessores(byte linhaAntiga, byte colunaAntiga, byte novaLinha, byte novaColuna, List<Estado> sucessores) {
        byte[][] novo = geraNovaMatriz(linhaAntiga, colunaAntiga, novaLinha, novaColuna);
        sucessores.add(new Estado8Puzzle(novo, estadoMeta));
    }

    private void addSucessoresADireita(byte lin, byte col, List<Estado> sucessores) {
        addSucessores(lin, col, lin, (byte) (col + 1), sucessores);
    }

    private void addSucessoresAEsquerda(byte lin, byte col, List<Estado> sucessores) {
        addSucessores(lin, col, lin, (byte) ((byte) col - 1), sucessores);
    }

    private void addSucessoresACima(byte lin, byte col, List<Estado> sucessores) {
        addSucessores(lin, col, (byte) ((byte) lin - 1), col, sucessores);
    }

    private void addSucessoresAbaixo(byte lin, byte col, List<Estado> sucessores) {
        addSucessores(lin, col, (byte) ((byte) lin + 1), col, sucessores);
    }

    public List<Estado> geraSucessores(byte[][] estado) {
        byte indexes[] = Puzzle8Utils.getIndiceColunaEmBranc(estado);
        byte lin = indexes[0];
        byte col = indexes[1];

        List<Estado> sucessores = new ArrayList<Estado>();

        if (Puzzle8Utils.isColunaEsquerda(col)) {
            if (Puzzle8Utils.isLinhaCentro(lin)) {
                addSucessoresACima(lin, col, sucessores);
                addSucessoresAbaixo(lin, col, sucessores);
                addSucessoresADireita(lin, col, sucessores);
            } else if (Puzzle8Utils.isLinhaInferior(lin)) {
                addSucessoresACima(lin, col, sucessores);
                addSucessoresADireita(lin, col, sucessores);
            } else {
                addSucessoresAbaixo(lin, col, sucessores);
                addSucessoresADireita(lin, col, sucessores);
            }
        } else if (Puzzle8Utils.isColunaDireita(col)) {
            if (Puzzle8Utils.isLinhaCentro(lin)) {
                addSucessoresACima(lin, col, sucessores);
                addSucessoresAbaixo(lin, col, sucessores);
                addSucessoresAEsquerda(lin, col, sucessores);
            } else if (Puzzle8Utils.isLinhaInferior(lin)) {
                addSucessoresACima(lin, col, sucessores);
                addSucessoresAEsquerda(lin, col, sucessores);
            } else {
                addSucessoresAbaixo(lin, col, sucessores);
                addSucessoresAEsquerda(lin, col, sucessores);
            }
        } else {
            if (Puzzle8Utils.isLinhaCentro(lin)) {
                addSucessoresACima(lin, col, sucessores);
                addSucessoresAbaixo(lin, col, sucessores);
                addSucessoresAEsquerda(lin, col, sucessores);
                addSucessoresADireita(lin, col, sucessores);
            } else if (Puzzle8Utils.isLinhaInferior(lin)) {
                addSucessoresACima(lin, col, sucessores);
                addSucessoresAEsquerda(lin, col, sucessores);
                addSucessoresADireita(lin, col, sucessores);
            } else {
                addSucessoresAbaixo(lin, col, sucessores);
                addSucessoresAEsquerda(lin, col, sucessores);
                addSucessoresADireita(lin, col, sucessores);
            }
        }

        return sucessores;
    }

    public List<Estado> sucessores() {
        return geraSucessores(estado);
    }

    @Override
    public String toString() {
        StringBuilder strBuilder = new StringBuilder("\n Jogada: ");
        for(byte i =0; i < estado.length; i++){
            strBuilder.append("\n");
            for(byte j=0; j < estado.length; j++){
                strBuilder.append(estado[i][j] + " ");
            }
        }
        return strBuilder.toString();
    }


    public int h() {
        return distanciaManhattan();
    }

    public int countPecasForaDoLugar() {
        int count = 0;

        for (byte i = 0; i < estado.length; i++) {
            for (byte j = 0; j < estado.length; j++) {
                if (estado[i][j] != estadoMeta[i][j])
                    count++;
            }
        }
        return count;
    }

    public int distanciaManhattan() {
        int distancia = 0;

        for (byte i = 0; i < estado.length; i++) {
            for (byte j = 0; j < estado.length; j++) {
                if (estado[i][j] != 0) {
                    byte[] indices = find(estado[i][j]);
                    int d = (Math.abs((indices[0] - i)) + Math.abs(indices[1] - j));
                    distancia += d;
                }
            }
        }

        return distancia;
    }


    public byte[] find(byte value) {
        for (byte i = 0; i < estadoMeta.length; i++) {
            for (byte j = 0; j < estadoMeta.length; j++) {
                if (estadoMeta[i][j] == value)
                    return new byte[]{i, j};
            }
        }
        throw new IllegalArgumentException("Valor não encontrado");
    }

    public static void main(String[] args) throws Exception {
        Estado inicial = new Estado8Puzzle(new byte[][]{{7, 2, 4}, {5, 0, 6}, {8, 3, 1}});

//        core.busca.Nodo n = new core.busca.BuscaIterativo(new core.busca.MostraStatusConsole()).busca(inicial);
        core.busca.Nodo n = new core.busca.AEstrela(new core.busca.MostraStatusConsole()).busca(inicial);

        System.out.println("Caminho: " +  n.montaCaminho());

    }

}


