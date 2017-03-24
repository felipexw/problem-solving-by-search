import core.busca.Estado;
import org.junit.Test;
import problems.eightpuzzle.Estado8Puzzle;
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

    @Test
    public void deveria_gerar_os_sucessores_para_a_coluna_esquerda_linha_inferior() {
        byte[][] eI = {{1, 2, 3}, {4, 5, 6}, {0, 7, 8}};
        byte[][] e1 = {{1, 2, 3}, {0, 5, 6}, {4, 7, 8}};
        byte[][] e2 = {{1, 2, 3}, {4, 5, 6}, {7, 0, 8}};

        Estado8Puzzle inicial = new Estado8Puzzle(eI);

        java.util.List<Estado> sucessores = inicial.geraSucessores(eI);

        assertThat(sucessores.size()).isEqualTo(2);
        byte[][] encontrado1 = ((Estado8Puzzle) sucessores.get(0)).getEstado();
        byte[][] encontrado2 = ((Estado8Puzzle) sucessores.get(1)).getEstado();

        assertThat(encontrado1).isEqualTo(e1);
        assertThat((encontrado2)).isEqualTo(e2);
    }

    @Test
    public void deveria_gerar_os_sucessores_para_a_coluna_esquerda_linha_superior() {
        byte[][] eI = {{0, 1, 5}, {7, 8, 4}, {3, 2, 1}};
        byte[][] e1 = {{7, 1, 5}, {0, 8, 4}, {3, 2, 1}};
        byte[][] e2 = {{1, 0, 5}, {7, 8, 4}, {3, 2, 1}};

        Estado8Puzzle inicial = new Estado8Puzzle(eI);

        java.util.List<Estado> sucessores = inicial.geraSucessores(eI);

        assertThat(sucessores.size()).isEqualTo(2);
        byte[][] encontrado1 = ((Estado8Puzzle) sucessores.get(0)).getEstado();
        byte[][] encontrado2 = ((Estado8Puzzle) sucessores.get(1)).getEstado();

        assertThat(encontrado1).isEqualTo(e1);
        assertThat((encontrado2)).isEqualTo(e2);
    }

    @Test
    public void deveria_gerar_os_sucessores_para_a_coluna_esquerda_linha_central() {
        byte[][] eI = {{1, 2, 3}, {0, 5, 6}, {7, 8, 4}};
        byte[][] e1 = {{0, 2, 3}, {1, 5, 6}, {7, 8, 4}};
        byte[][] e2 = {{1, 2, 3}, {7, 5, 6}, {0, 8, 4}};
        byte[][] e3 = {{1, 2, 3}, {5, 0, 6}, {7, 8, 4}};

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
    public void deveria_gerar_os_sucessores_para_a_coluna_direita_linha_inferior() {
        byte[][] eI = {{1, 2, 3}, {4, 5, 6}, {7, 8, 0}};
        byte[][] e1 = {{1, 2, 3}, {4, 5, 0}, {7, 8, 6}};
        byte[][] e2 = {{1, 2, 3}, {4, 5, 6}, {7, 0, 8}};

        Estado8Puzzle inicial = new Estado8Puzzle(eI);

        java.util.List<Estado> sucessores = inicial.geraSucessores(eI);

        assertThat(sucessores.size()).isEqualTo(2);
        byte[][] encontrado1 = ((Estado8Puzzle) sucessores.get(0)).getEstado();
        byte[][] encontrado2 = ((Estado8Puzzle) sucessores.get(1)).getEstado();

        assertThat(encontrado1).isEqualTo(e1);
        assertThat((encontrado2)).isEqualTo(e2);
    }

    @Test
    public void deveria_gerar_os_sucessores_para_a_coluna_direita_linha_superior() {
        byte[][] eI = {{1, 2, 0}, {4, 5, 3}, {6, 7, 8}};
        byte[][] e1 = {{1, 2, 3}, {4, 5, 0}, {6, 7, 8}};
        byte[][] e2 = {{1, 0, 2}, {4, 5, 3}, {6, 7, 8}};

        Estado8Puzzle inicial = new Estado8Puzzle(eI);

        java.util.List<Estado> sucessores = inicial.geraSucessores(eI);

        assertThat(sucessores.size()).isEqualTo(2);
        byte[][] encontrado1 = ((Estado8Puzzle) sucessores.get(0)).getEstado();
        byte[][] encontrado2 = ((Estado8Puzzle) sucessores.get(1)).getEstado();

        assertThat(encontrado1).isEqualTo(e1);
        assertThat((encontrado2)).isEqualTo(e2);
    }


    @Test
    public void deveria_gerar_os_sucessores_para_a_coluna_direita_linha_central() {
        byte[][] eI = {{1, 2, 3}, {4, 5, 0}, {6, 7, 8}};
        byte[][] e1 = {{1, 2, 0}, {4, 5, 3}, {6, 7, 8}};
        byte[][] e2 = {{1, 2, 3}, {4, 5, 8}, {6, 7, 0}};
        byte[][] e3 = {{1, 2, 3}, {4, 0, 5}, {6, 7, 8}};

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
    public void deveria_gerar_os_sucessores_para_a_coluna_central_linha_superior() {
        byte[][] eI = {{1, 0, 2}, {3, 4, 5}, {6, 7, 8}};
        byte[][] e1 = {{1, 4, 2}, {3, 0, 5}, {6, 7, 8}};
        byte[][] e2 = {{0, 1, 2}, {3, 4, 5}, {6, 7, 8}};
        byte[][] e3 = {{1, 2, 0}, {3, 4, 5}, {6, 7, 8}};

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
    public void deveria_gerar_os_sucessores_para_a_coluna_central_linha_central() {
        byte[][] eI = {{1, 2, 3}, {4, 0, 5}, {6, 7, 8}};

        byte[][] e1 = {{1, 0, 3}, {4, 2, 5}, {6, 7, 8}};
        byte[][] e2 = {{1, 2, 3}, {4, 7, 5}, {6, 0, 8}};
        byte[][] e3 = {{1, 2, 3}, {0, 4, 5}, {6, 7, 8}};
        byte[][] e4 = {{1, 2, 3}, {4, 5, 0}, {6, 7, 8}};

        Estado8Puzzle inicial = new Estado8Puzzle(eI);

        java.util.List<Estado> sucessores = inicial.geraSucessores(eI);

        assertThat(sucessores.size()).isEqualTo(4);
        byte[][] encontrado1 = ((Estado8Puzzle) sucessores.get(0)).getEstado();
        byte[][] encontrado2 = ((Estado8Puzzle) sucessores.get(1)).getEstado();
        byte[][] encontrado3 = ((Estado8Puzzle) sucessores.get(2)).getEstado();
        byte[][] encontrado4 = ((Estado8Puzzle) sucessores.get(3)).getEstado();

        assertThat(encontrado1).isEqualTo(e1);
        assertThat((encontrado2)).isEqualTo(e2);
        assertThat((encontrado3)).isEqualTo(e3);
        assertThat((encontrado4)).isEqualTo(e4);
    }

    @Test
    public void deveria_gerar_os_sucessores_para_a_coluna_central_linha_inferior()    {
        byte[][] eI = {{1, 2, 3}, {4, 5, 6}, {7, 0, 8}};
        byte[][] e1 = {{1, 2, 3}, {4, 0, 6}, {7, 5, 8}};
        byte[][] e2 = {{1, 2, 3}, {4, 5, 6}, {0, 7, 8}};
        byte[][] e3 = {{1, 2, 3}, {4, 5, 6}, {7, 8, 0}};

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
    public void deveria_calcular_a_distancia_de_manhattan_entre_o_meta_e_atual() {
        byte[][] eI = {{7,6,0}, {4,3,1}, {2,5,8}};
        byte[][] meta = {{1,2,3}, {8,0,4}, {7,6,5}};
        Estado8Puzzle inicial = new Estado8Puzzle(eI);
        inicial.setEstadoMeta(meta);

        int distanciaEsperada = 18;
        int distanciaObtida= inicial.h3() ;

        assertThat(distanciaObtida).isEqualTo(distanciaEsperada);
    }


    @Test(expected = IllegalArgumentException.class)
    public void deveria_lancar_uma_excecao_ao_procurar_valores_invalidos(){
        byte[][] eI = {{1, 2, 3}, {4, 5, 6}, {7, 0, 8}};
        Estado8Puzzle inicial = new Estado8Puzzle(eI);

        byte[] indices = inicial.find((byte) 20);
    }

    @Test
    public void deveria_retornar_os_indices_de_um_valor(){
        byte[][] eI = {{1, 2, 3}, {4, 5, 6}, {7, 0, 8}};
        Estado8Puzzle inicial = new Estado8Puzzle(eI);
        inicial.setEstadoMeta(eI);

        byte[] indices = inicial.find((byte) 7);

        assertThat(indices.length).isEqualTo(2);
        assertThat(indices[0]).isEqualTo((byte) 2);
        assertThat(indices[1]).isEqualTo((byte) 0);
    }



}
