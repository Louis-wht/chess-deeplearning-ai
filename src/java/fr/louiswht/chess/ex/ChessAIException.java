package fr.louiswht.chess.ex;

public class ChessAIException extends RuntimeException {

    
    public ChessAIException() {
    }

    public ChessAIException(String message) {
        super(message);
    }

    public ChessAIException(String message, Throwable cause) {
        super(message, cause);
    }

    public ChessAIException(Throwable cause) {
        super(cause);
    }

    public ChessAIException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
