import org.assertj.core.api.Assert;
import org.assertj.core.api.Assertions;
import org.assertj.core.util.VisibleForTesting;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;


/**
 * Created by Appio on 20/03/2017.
 */
public class Estado8PuzzleTest {
    private CalculaSucessores8Puzzle calculaSucessores = new CalculaSucessores8Puzzle();
    private byte[][] estadoMeta;


    @Test
    public void deveria_encontrar_o_valor_em_branco_ao_centro() {
        byte[][] matrix = {{7, 2, 4}, {5, 0, 6}, {8, 3, 1}};
        byte indexes[] = calculaSucessores.getIndiceColunaEmBranc(matrix);
        byte expected[] = {1, 1};

        assertThat(expected).isEqualTo(indexes);
    }

    @Test(expected = IllegalArgumentException.class)
    public void deveria_lancar_uma_excessao() {
        byte[][] matrix = {{7, 2, 4}, {5, 21, 6}, {8, 3, 1}};
        byte indexes[] = calculaSucessores.getIndiceColunaEmBranc(matrix);
    }

    @Test
    public void deveria_encontrar_todos_os_valores_na_quina_esquerda() {
        assertThat(calculaSucessores.isQuinaEsquerda(new byte[]{1,0})).isEqualTo(true);
        assertThat(calculaSucessores.isQuinaEsquerda(new byte[]{2,0})).isEqualTo(true);
        assertThat(calculaSucessores.isQuinaEsquerda(new byte[]{3,0})).isEqualTo(true);
    }

    @Test(expected = AssertionError.class)
    public void deveria_lancar_uma_excao_ao_procurar_valores_na_quina_esquerda() {
        assertThat(calculaSucessores.isQuinaEsquerda(new byte[]{1,1})).isEqualTo(true);
        assertThat(calculaSucessores.isQuinaEsquerda(new byte[]{2,2})).isEqualTo(true);
        assertThat(calculaSucessores.isQuinaEsquerda(new byte[]{3,0})).isEqualTo(true);
    }

    @Test
    public void deveria_encontrar_todos_os_valores_na_quina_direita() {
        assertThat(calculaSucessores.isQuinaDireita(new byte[]{1,2})).isEqualTo(true);
        assertThat(calculaSucessores.isQuinaDireita(new byte[]{2,2})).isEqualTo(true);
        assertThat(calculaSucessores.isQuinaDireita(new byte[]{3,2})).isEqualTo(true);
    }

    @Test(expected = AssertionError.class)
    public void deveria_lancar_uma_excao_ao_procurar_valores_na_quina_direita() {
        assertThat(calculaSucessores.isQuinaDireita(new byte[]{1,2})).isEqualTo(true);
        assertThat(calculaSucessores.isQuinaDireita(new byte[]{2,0})).isEqualTo(true);
        assertThat(calculaSucessores.isQuinaDireita(new byte[]{3,1})).isEqualTo(true);
    }

}
