package exception;

public class CadeiraNaoEncontradaException extends RuntimeException {
    public CadeiraNaoEncontradaException() {
        super("Cadeira não encontrada.");
    }
}
