import core.busca.Estado;
import org.junit.Test;
import problems.eightpuzzle.Estado8Puzzle;
import problems.eightpuzzle.Estado8PuzzleInformado;
import problems.eightpuzzle.Puzzle8Utils;

import static org.assertj.core.api.Assertions.assertThat;


/**
 * Created by Appio on 20/03/2017.
 */
public class Estado8PuzzleTest {
    private byte[][] estadoMeta;


    @Test
    public void deveria_encontrar_o_valor_em_branco_ao_centro() {
        byte[][] matrix = {{7, 2, 4}, {5, 0, 6}, {8, 3, 1}};
        byte indexes[] = Puzzle8Utils.getIndiceColunaEmBranc(matrix);
        byte expected[] = {1, 1};

        assertThat(expected).isEqualTo(indexes);
    }

    @Test(expected = IllegalArgumentException.class)
    public void deveria_lancar_uma_excessao() {
        byte[][] matrix = {{7, 2, 4}, {5, 21, 6}, {8, 3, 1}};
        byte indexes[] = Puzzle8Utils.getIndiceColunaEmBranc(matrix);
    }

    @Test
    public void deveria_encontrar_todos_os_valores_na_quina_esquerda() {
        assertThat(Puzzle8Utils.isLadoEsquerdo(new byte[]{1, 0})).isEqualTo(true);
        assertThat(Puzzle8Utils.isLadoEsquerdo(new byte[]{2, 0})).isEqualTo(true);
        assertThat(Puzzle8Utils.isLadoEsquerdo(new byte[]{3, 0})).isEqualTo(true);
    }

    @Test(expected = AssertionError.class)
    public void deveria_lancar_uma_excao_ao_procurar_valores_na_quina_esquerda() {
        assertThat(Puzzle8Utils.isLadoEsquerdo(new byte[]{1, 1})).isEqualTo(true);
        assertThat(Puzzle8Utils.isLadoEsquerdo(new byte[]{2, 2})).isEqualTo(true);
        assertThat(Puzzle8Utils.isLadoEsquerdo(new byte[]{3, 0})).isEqualTo(true);
    }

    @Test
    public void deveria_encontrar_todos_os_valores_na_quina_direita() {
        assertThat(Puzzle8Utils.isLadoDireito(new byte[]{1, 2})).isEqualTo(true);
        assertThat(Puzzle8Utils.isLadoDireito(new byte[]{2, 2})).isEqualTo(true);
        assertThat(Puzzle8Utils.isLadoDireito(new byte[]{3, 2})).isEqualTo(true);
    }

    @Test(expected = AssertionError.class)
    public void deveria_lancar_uma_excao_ao_procurar_valores_na_quina_direita() {
        assertThat(Puzzle8Utils.isLadoDireito(new byte[]{1, 2})).isEqualTo(true);
        assertThat(Puzzle8Utils.isLadoDireito(new byte[]{2, 0})).isEqualTo(true);
        assertThat(Puzzle8Utils.isLadoDireito(new byte[]{3, 1})).isEqualTo(true);
    }

    @Test
    public void deveria_encontrar_todos_os_valores_no_centro() {
        assertThat(Puzzle8Utils.isLinhaCentro(new byte[]{1, 1})).isEqualTo(true);
        assertThat(Puzzle8Utils.isLinhaCentro(new byte[]{1, 2})).isEqualTo(true);
        assertThat(Puzzle8Utils.isLinhaCentro(new byte[]{1, 3})).isEqualTo(true);
    }

    @Test(expected = AssertionError.class)
    public void deveria_lancar_uma_excao_ao_procurar_valores_no_centro() {
        assertThat(Puzzle8Utils.isLinhaCentro(new byte[]{1, 1})).isEqualTo(true);
        assertThat(Puzzle8Utils.isLinhaCentro(new byte[]{2, 0})).isEqualTo(true);
        assertThat(Puzzle8Utils.isLinhaCentro(new byte[]{3, 3})).isEqualTo(true);
    }


    //topo, bottom e centro

    @Test
    public void deveria_encontrar_todos_os_valores_que_estao_no_fundo_da_matriz() {
        assertThat(Puzzle8Utils.isLinhaInferior(new byte[]{2, 1})).isEqualTo(true);
        assertThat(Puzzle8Utils.isLinhaInferior(new byte[]{2, 0})).isEqualTo(true);
        assertThat(Puzzle8Utils.isLinhaInferior(new byte[]{2, 3})).isEqualTo(true);
    }

    @Test(expected = AssertionError.class)
    public void deveria_lancar_execao_ao_procurar_os_valores_que_estao_no_fundo_da_matriz() {
        assertThat(Puzzle8Utils.isLinhaInferior(new byte[]{1, 1})).isEqualTo(true);
        assertThat(Puzzle8Utils.isLinhaInferior(new byte[]{2, 0})).isEqualTo(true);
        assertThat(Puzzle8Utils.isLinhaInferior(new byte[]{0, 3})).isEqualTo(true);
    }

    @Test(expected = AssertionError.class)
    public void deveria_lancar_execao_ao_procurar_os_valores_que_estao_no_topo_da_matriz() {
        assertThat(Puzzle8Utils.isLinhaSuperior(new byte[]{1, 1})).isEqualTo(true);
        assertThat(Puzzle8Utils.isLinhaSuperior(new byte[]{2, 0})).isEqualTo(true);
        assertThat(Puzzle8Utils.isLinhaSuperior(new byte[]{3, 3})).isEqualTo(true);
    }

    @Test
    public void deveria_encontrar_todos_os_valores_que_estao_no_topo_da_matriz() {
        assertThat(Puzzle8Utils.isLinhaSuperior(new byte[]{0, 0})).isEqualTo(true);
        assertThat(Puzzle8Utils.isLinhaSuperior(new byte[]{0, 3})).isEqualTo(true);
        assertThat(Puzzle8Utils.isLinhaSuperior(new byte[]{0, 2})).isEqualTo(true);
    }

    @Test
    public void deveria_gerar_os_sucessores_na_quina_inferior_esquerda() {
        byte[][] eI = {{1,2,3}, {4,5,6}, {0, 7, 8}};
        byte[][] e1 = {{1,2,3}, {0,5,6}, {4,7,8}};
        byte[][] e2 = {{1,2,3}, {4,5,6}, {7,0,8}};

        Estado8Puzzle inicial = new Estado8Puzzle(eI);

        java.util.List<Estado> sucessores = inicial.geraSucessores(eI);

        assertThat(sucessores.size()).isEqualTo(2);
        byte[][] encontrado1 = ((Estado8Puzzle) sucessores.get(0)).getEstado();
        byte[][] encontrado2 = ((Estado8Puzzle) sucessores.get(1)).getEstado();

        assertThat(encontrado1).isEqualTo(e1);
        assertThat((encontrado2)).isEqualTo(e2);
    }
    @Test
    public void deveria_gerar_os_sucessores_no_lado_superior_esquerdo() {
        byte[][] eI = {{0,1,5}, {7,8,4}, {3,2,1}};
        byte[][] e1 = {{7,1,5}, {0,8,4}, {3,2,1}};
        byte[][] e2 = {{1,0,5}, {7,8,4}, {3,2,1}};

        Estado8Puzzle inicial = new Estado8Puzzle(eI);

        java.util.List<Estado> sucessores = inicial.geraSucessores(eI);

        assertThat(sucessores.size()).isEqualTo(2);
        byte[][] encontrado1 = ((Estado8Puzzle) sucessores.get(0)).getEstado();
        byte[][] encontrado2 = ((Estado8Puzzle) sucessores.get(1)).getEstado();

        assertThat(encontrado1).isEqualTo(e1);
        assertThat((encontrado2)).isEqualTo(e2);
    }

    @Test
    public void deveria_gerar_os_sucessores_ao_centro_esquerdo() {
        byte[][] eI = {{1,2,3}, {0,5,6}, {7,8,4}};
        byte[][] e1 = {{0,2,3}, {1,5,6}, {7,8,4}};
        byte[][] e2 = {{1,2,3}, {7,5,6}, {0,8,4}};
        byte[][] e3 = {{1,2,3}, {5,0,6}, {7,8,4}};

        Estado8Puzzle inicial = new Estado8Puzzle(eI);

        java.util.List<Estado> sucessores = inicial.geraSucessores(eI);

        assertThat(sucessores.size()).isEqualTo(3);
        byte[][] encontrado1 = ((Estado8Puzzle) sucessores.get(0)).getEstado();
        byte[][] encontrado2 = ((Estado8Puzzle) sucessores.get(1)).getEstado();
        byte[][] encontrado3 = ((Estado8Puzzle) sucessores.get(2)).getEstado();

        assertThat(encontrado1).isEqualTo(e1);
        assertThat((encontrado2)).isEqualTo(e2);
        assertThat((encontrado3)).isEqualTo(e3);
    }

    @Test
    public void deveria_gerar_os_sucessores_no_lado_inferior_direito() {
        byte[][] eI = {{1,2,3}, {4,5,6}, {7,8,0}};
        byte[][] e1 = {{1,2,3}, {4,5,0}, {7,8,6}};
        byte[][] e2 = {{1,2,3}, {4,5,6}, {7,0,8}};

        Estado8Puzzle inicial = new Estado8Puzzle(eI);

        java.util.List<Estado> sucessores = inicial.geraSucessores(eI);

        assertThat(sucessores.size()).isEqualTo(2);
        byte[][] encontrado1 = ((Estado8Puzzle) sucessores.get(0)).getEstado();
        byte[][] encontrado2 = ((Estado8Puzzle) sucessores.get(1)).getEstado();

        assertThat(encontrado1).isEqualTo(e1);
        assertThat((encontrado2)).isEqualTo(e2);
    }

    public void deveria_gerar_os_sucessores_no_lado_superior_direito() {
        byte[][] eI = {{1,2,0}, {4,5,3}, {6,7,8}};
        byte[][] e1 = {{1,2,3}, {4,5,0}, {6,7,8}};
        byte[][] e2 = {{1,0,2}, {4,5,3}, {6,7,8}};

        Estado8Puzzle inicial = new Estado8Puzzle(eI);

        java.util.List<Estado> sucessores = inicial.geraSucessores(eI);

        assertThat(sucessores.size()).isEqualTo(2);
        byte[][] encontrado1 = ((Estado8Puzzle) sucessores.get(0)).getEstado();
        byte[][] encontrado2 = ((Estado8Puzzle) sucessores.get(1)).getEstado();

        assertThat(encontrado1).isEqualTo(e1);
        assertThat((encontrado2)).isEqualTo(e2);
    }

}
