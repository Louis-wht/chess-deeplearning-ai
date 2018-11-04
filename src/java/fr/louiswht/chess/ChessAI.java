package fr.louiswht.chess;

import chess.board.ArrayMove;
import chess.engine.Engine;
import fr.louiswht.chess.overrided.AIEngine;
import org.jetbrains.annotations.NotNull;

public interface ChessAI {

    // Will contain some common methods later on. Yet, we need
    // to see how we can work out with the future Chess lib we'll
    // be using.


    void init(@NotNull final AIEngine engine);

    @NotNull
    ArrayMove computeMove();
}
