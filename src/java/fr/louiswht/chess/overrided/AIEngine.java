package fr.louiswht.chess.overrided;

import chess.board.ArrayMove;
import chess.engine.Engine;
import fr.louiswht.chess.ChessAI;
import org.jetbrains.annotations.NotNull;

public class AIEngine extends Engine {


    private final int difficulty;
    private final ChessAI chessAI;

    public AIEngine(int difficulty, @NotNull ChessAI chessAI) {
        super(0, 0, difficulty);
        this.difficulty = difficulty;
        this.chessAI = chessAI;
    }

    /**
     * Compute and return a move in the current position.SSS
     *
     * @param myTime number of seconds left on the player's clock
     * @param opTime number of seconds left on the opponent's clock
     */
    public ArrayMove computeMove(int myTime, int opTime) {
        return chessAI.computeMove();
    }

    public int getDifficulty() {
        return difficulty;
    }
}
