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
        throw new IllegalArgumentException("Nao ha¡ colunas em branco");
    }

    public static boolean isColunaEsquerda(byte col) {
        return col == 0;
    }

    public static boolean isColunaDireita(byte col) {
        return col == 2;
    }

    public static boolean isLinhaCentro(byte lin) {
        return lin == 1;
    }

    public static boolean isLinhaInferior(byte lin) {
        return lin == 2;
    }

    public static void copy(byte[][] origin, byte[][] dest){
        for(byte i =0;  i< origin.length; i++){
            for(byte j =0; j < dest.length; j++){
                dest[i][j] =origin[i][j];
            }
        }
    }
}
