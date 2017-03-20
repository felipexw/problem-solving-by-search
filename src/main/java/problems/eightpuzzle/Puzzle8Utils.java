package problems.eightpuzzle;

/**
 * Created by Appio on 20/03/2017.
 */
public class Puzzle8Utils {
    private static final byte BRANCO = 0;

    public static byte[] getIndiceColunaEmBranc(byte[][] estado) {
        for (byte i = 0; i < estado.length; i++) {
            for (byte j = 0; j < estado.length; j++) {
                if (estado[i][j] == BRANCO)
                    return new byte[]{i, j};
            }
        }
        throw new IllegalArgumentException("Não há células em branco");
    }

    public static boolean isQuinaEsquerda(byte[] indexes) {
        byte col = indexes[1];
        return col == 0;
    }

    public static boolean isQuinaDireita(byte[] indexes) {
        byte col = indexes[1];
        return col == 2;
    }

    public static boolean isCentro(byte[] indexes) {
        byte lin = indexes[0];
        return lin == 1;
    }
}
