package fr.louiswht.chess;


import chess.board.ArrayBoard;
import chess.board.ArrayMove;
import chess.board.ArrayPiece;
import fr.louiswht.chess.loader.NNLoader;
import fr.louiswht.chess.overrided.AIEngine;
import org.deeplearning4j.nn.multilayer.MultiLayerNetwork;
import org.jetbrains.annotations.NotNull;

public class DefaultChessAI implements ChessAI {


    private final MultiLayerNetwork mlc;
    private final NNLoader nnLoader;
    private AIEngine engine;

    public DefaultChessAI(@NotNull final NNLoader nnLoader) {

        this.nnLoader = nnLoader;
        mlc = nnLoader.readNetwork();

    }


    @Override
    public void init(@NotNull AIEngine engine) {
        this.engine = engine;
    }

    @NotNull
    @Override
    public ArrayMove computeMove() {
        return new ArrayMove()
                .init(
                        ArrayPiece.FACTORY.create().init(
                                ArrayPiece.BLACK_PAWN,
                                ArrayBoard.indexOfSquare(6, 1)
                        ),
                        ArrayPiece.FACTORY.create().init(
                                ArrayPiece.EMPTY,
                                ArrayBoard.indexOfSquare(4, 1)
                        ),
                        ArrayPiece.FACTORY.create().init(
                                ArrayPiece.EMPTY,
                                ArrayBoard.indexOfSquare(4, 1)
                        )
                );
    }
}
