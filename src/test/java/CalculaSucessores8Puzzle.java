/**
 * Created by Appio on 20/03/2017.
 */
public class CalculaSucessores8Puzzle {
    private final byte BRANCO = 0;

    public byte[] getIndiceColunaEmBranc(byte[][] estado) {
        for (byte i = 0; i < estado.length; i++) {
            for (byte j = 0; j < estado.length; j++) {
                if (estado[i][j] == BRANCO)
                    return new byte[]{i, j};
            }
        }
        throw new IllegalArgumentException("Não há células em branco");
    }

    public boolean isQuinaEsquerda(byte[] indexes) {
        byte col = indexes[1];
        return col == 0;
    }

    public boolean isQuinaDireita(byte[] indexes) {
        byte col = indexes[1];
        return col == 2;
    }

    public boolean isCentro(byte[] indexes) {
        byte col = indexes[0];
        return col == 1;
    }
}
