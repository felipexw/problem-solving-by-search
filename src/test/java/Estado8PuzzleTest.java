import org.junit.Test;
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

    @Test(expected = AssertionError.class)
    public void deveria_lancar_uma_execao_ao_procurar_valor_em_branco_ao_centro() {
        byte[][] matrix = {{7, 2, 4}, {5, 12, 6}, {8, 3, 0}};
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
        assertThat(Puzzle8Utils.isColunaEsquerda((byte) 0)).isEqualTo(true);
    }

    @Test(expected = AssertionError.class)
    public void deveria_lancar_uma_excao_ao_procurar_valores_na_quina_esquerda() {
        assertThat(Puzzle8Utils.isColunaEsquerda((byte) 1)).isEqualTo(true);
        assertThat(Puzzle8Utils.isColunaEsquerda((byte) 2)).isEqualTo(true);
        assertThat(Puzzle8Utils.isColunaEsquerda((byte) 0)).isEqualTo(true);
    }

    @Test
    public void deveria_encontrar_todos_os_valores_na_quina_direita() {
        assertThat(Puzzle8Utils.isColunaDireita((byte) 2)).isEqualTo(true);
    }

    @Test(expected = AssertionError.class)
    public void deveria_lancar_uma_excao_ao_procurar_valores_na_quina_direita() {
        assertThat(Puzzle8Utils.isColunaDireita((byte)1)).isEqualTo(true);
    }

    @Test
    public void deveria_encontrar_todos_os_valores_no_centro() {
        assertThat(Puzzle8Utils.isLinhaCentro((byte) 1)).isEqualTo(true);
    }

    @Test(expected = AssertionError.class)
    public void deveria_lancar_uma_excao_ao_procurar_valores_no_centro() {
        assertThat(Puzzle8Utils.isLinhaCentro((byte) 1)).isEqualTo(true);
        assertThat(Puzzle8Utils.isLinhaCentro((byte) 2)).isEqualTo(true);
        assertThat(Puzzle8Utils.isLinhaCentro((byte) 3)).isEqualTo(true);
    }
    @Test
    public void deveria_encontrar_todos_os_valores_que_estao_no_fundo_da_matriz() {
        assertThat(Puzzle8Utils.isLinhaInferior((byte) 2)).isEqualTo(true);
    }

    @Test(expected = AssertionError.class)
    public void deveria_lancar_execao_ao_procurar_os_valores_que_estao_no_fundo_da_matriz() {
        assertThat(Puzzle8Utils.isLinhaInferior((byte) 1)).isEqualTo(true);
        assertThat(Puzzle8Utils.isLinhaInferior((byte) 2)).isEqualTo(true);
        assertThat(Puzzle8Utils.isLinhaInferior((byte) 0)).isEqualTo(true);
    }



}
