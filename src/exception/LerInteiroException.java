package exception;

public class LerInteiroException extends RuntimeException {
    public LerInteiroException() {
        super("Digite um número válido.");
    }
}
