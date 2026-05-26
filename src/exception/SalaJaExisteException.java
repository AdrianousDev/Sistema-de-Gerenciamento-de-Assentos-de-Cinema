package exception;

public class SalaJaExisteException extends RuntimeException {
    public SalaJaExisteException() {
        super("Já existe uma sala com esse nome.");
    }
}
