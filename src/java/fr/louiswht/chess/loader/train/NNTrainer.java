package fr.louiswht.chess.loader.train;

import org.deeplearning4j.nn.multilayer.MultiLayerNetwork;
import org.jetbrains.annotations.NotNull;

public interface NNTrainer {

    void train(@NotNull final MultiLayerNetwork mlc);
}
