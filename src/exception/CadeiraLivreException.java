package exception;

public class CadeiraLivreException extends RuntimeException{
    public CadeiraLivreException() {
        super("A cadeira já está livre.");
    }
}
