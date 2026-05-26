package exception;

public class SalaNaoEncontradaException extends RuntimeException {
    public SalaNaoEncontradaException() {
        super("Sala não encontrada.");
    }
}
