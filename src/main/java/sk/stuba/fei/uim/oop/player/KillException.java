package sk.stuba.fei.uim.oop.player;

public class KillException extends Exception{
    public KillException() {
    }

    public KillException(String message) {
        super(message);
    }

    public KillException(String message, Throwable cause) {
        super(message, cause);
    }

    public KillException(Throwable cause) {
        super(cause);
    }
}
