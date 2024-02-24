package heros;

public class HeroException extends RuntimeException {
    public HeroException() {
        super();
    }

    public HeroException(String message, Throwable cause) {
        super(message, cause);
    }

    public HeroException(String message) {
        super(message);
    }

    public HeroException(Throwable cause) {
        super(cause);
    }
}