package exception;

public class DimensoesSalaInvalidasException extends RuntimeException {

    public DimensoesSalaInvalidasException(int fileiras, int colunas) {
        super(gerarMensagem(fileiras, colunas));
    }

    private static String gerarMensagem(int fileiras, int colunas) {
        if (fileiras <= 0 || colunas <= 0) {
            return "Fileiras e colunas devem ser maiores que zero.";
        }

        if (fileiras > 26) {
            return "Máximo de 26 fileiras.";
        }

        if (colunas > 20) {
            return "Máximo de 20 colunas.";
        }

        return "Dimensões da sala inválidas.";
    }
}