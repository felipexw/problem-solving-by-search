package problems.eightpuzzle;

import core.busca.Estado;

import java.util.List;

/**
 * Created by Appio on 16/03/2017.
 */
public class Estado8Puzzle implements Estado {

    private byte BRANCO = 0;
    private byte[][] estado = {{7, 2, 4}, {5, BRANCO, 6}, {8, 3, 1}};
    private byte[][] estadoMeta = {{BRANCO, 1, 2}, {3, 4, 5}, {6, 7, 8}};

    public Estado8Puzzle() {
    }

    public Estado8Puzzle(byte[][] estadoInicial, byte[][] estadoMeta) {
        this.estado = estadoInicial;
        this.estadoMeta = estadoMeta;
    }

    public String getDescricao() {
        return "8 quebra cabeças";
    }

    public boolean ehMeta() {
        for (byte i = 0; i < estado.length; i++) {
            for (byte j = 0; j < estadoMeta.length; j++) {
                if (estado[i][j] != estadoMeta[i][j])
                    return false;
            }
        }
        return true;
    }

    public int custo() {
        return 0;
    }



    public List<Estado> sucessores() {
        byte[] indexes = getIndiceColunaEmBranc();

        if (indexes[0] == indexes[1]) {
            if (indexes[0] == 0) {
                //gera sucessores a para baixo e para direita
            } else if (indexes[0] == 1) {
                //gera sucessores a para baixo e para cima, para esquerda e para a direita
            } else if (indexes[0] == 2) {
                //gera sucessores a para cima e para esquerda
            }
        } else {

            if (indexes[1] == 1) {
                // anda para esquerda, direita e para baixo
            } else if (indexes[1] == 2) {
                // anda para esquerda, e para baixo
            }
        }

        return null;
    }

//    public static void main(String[] args) {
//        Estado inicial = new Estado8Puzzle();
//        System.out.println("Estado inicial:" + inicial + "\n");
//
//        core.busca.Nodo n =  new core.busca.AEstrela(new core.busca.MostraStatusConsole()).busca(inicial);
//        System.out.println("Solucaoo:\n" + n.getEstado() + "\n\n");
//    }
}


