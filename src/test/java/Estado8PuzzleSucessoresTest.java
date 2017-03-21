import core.busca.Estado;
import org.junit.Test;
import problems.eightpuzzle.Estado8Puzzle;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by Appio on 21/03/2017.
 */
public class Estado8PuzzleSucessoresTest

{

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
    public void deveria_gerar_os_sucessores_para_a_coluna_central_linha_inferior()

    {
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
}


