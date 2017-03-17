package problems;

import core.busca.Estado;
import core.busca.Heuristica;

import java.util.List;

/**
 * Created by Appio on 16/03/2017.
 */
public class Estado8Puzzle implements Estado, Heuristica {
    private final int[] ESTADO_INCIAL = {7, 2, 4, 5, 0, 6, 8, 3, 1};
    private final int[] ESTADO_META = {0, 1, 2, 3, 4, 5, 6, 7, 8};
    private int[][] estadoAtual = new int[3][3];

    public int h() {
        return 0;
    }

    public String getDescricao() {
        return null;
    }

    public boolean ehMeta() {
        return false;
    }

    public int custo() {
        return 0;
    }

    public List<Estado> sucessores() {
        return null;
    }

    public static void main(String[] args) {
        Estado inicial = new Estado8Puzzle();
        System.out.println("Estado inicial:" + inicial + "\n");

        core.busca.Nodo n = null;
        // os tr�s m�todos seguintes n�o conseguem
        // resolver o problema das ra�nhas
        //n = Busca.buscaLargura(inicial, null);
        //n = Busca.buscaProfRec(inicial, null, 10);
        //n = Busca.buscaProfIterativo(inicial, null);
                /*
                if (n == null) {
                System.out.println("sem solu��o!");
                } else {
                System.out.println("solu��o:\n" + n.montaCaminho() + "\n\n");
                }
                 */

        // a subida da montanha consegue resolver
        n = new core.busca.AEstrela(new core.busca.MostraStatusConsole()).busca(inicial);
        System.out.println("solu��o:\n" + n.getEstado() + "\n\n");
    }
}


