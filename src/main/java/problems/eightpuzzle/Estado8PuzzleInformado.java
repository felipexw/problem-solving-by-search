package problems.eightpuzzle;

import core.busca.Heuristica;

/**
 * Created by Appio on 20/03/2017.
 */
public class Estado8PuzzleInformado extends Estado8Puzzle implements Heuristica {


    public Estado8PuzzleInformado() {
    }

    public int h() {
        int count = 0;

        for (byte i = 0; i < estado.length; i++) {
            for (byte j = 0; j < estado.length; j++) {
                if (estado[i][j] != estadoMeta[i][j])
                    count++;
            }
        }
        return count;
    }

    @Override
    public boolean ehMeta() {
        return h() == 0;
    }
}
