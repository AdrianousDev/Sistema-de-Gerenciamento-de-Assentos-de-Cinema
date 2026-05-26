package exception;

public class CadeiraOcupadaException extends RuntimeException {
    public CadeiraOcupadaException() {
        super("A cadeira já está ocupada.");
    }
}
