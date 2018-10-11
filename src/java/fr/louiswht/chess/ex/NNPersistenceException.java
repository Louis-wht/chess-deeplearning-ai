package fr.louiswht.chess.ex;

public class NNPersistenceException extends ChessAIException {


    public NNPersistenceException(Throwable e) {
        super("Neural Network parameters couldn't be persisted because of " + e.getMessage(), e);
    }
}
