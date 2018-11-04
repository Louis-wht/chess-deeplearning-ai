package fr.louiswht.chess;

import fr.louiswht.chess.loader.UnpersistableNNLoader;
import fr.louiswht.chess.loader.train.DefaultNNTrainer;
import fr.louiswht.chess.overrided.AIMenuFrame;

public class GameEngine {

    public static void main(String[] args) {

        ChessAI chessAI =
                new DefaultChessAI(
                    new UnpersistableNNLoader()
                );

        new AIMenuFrame(chessAI);

    }
}
