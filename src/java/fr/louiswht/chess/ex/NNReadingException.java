package fr.louiswht.chess.ex;

public class NNReadingException extends ChessAIException {


    public NNReadingException(Throwable e) {
        super("Neural Network parameters couldn't be loaded because of " + e.getMessage(), e);
    }
}
