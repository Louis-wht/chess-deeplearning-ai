package fr.louiswht.chess;


import fr.louiswht.chess.loader.NNLoader;
import org.deeplearning4j.nn.multilayer.MultiLayerNetwork;
import org.jetbrains.annotations.NotNull;

public class DefaultChessAI implements ChessAI {


    private final MultiLayerNetwork mlc;
    private final NNLoader nnLoader;

    public DefaultChessAI(@NotNull final NNLoader nnLoader) {

        this.nnLoader = nnLoader;
        mlc = nnLoader.readNetwork();

    }



}
