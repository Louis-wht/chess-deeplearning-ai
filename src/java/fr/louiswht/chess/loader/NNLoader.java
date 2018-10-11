package fr.louiswht.chess.loader;

import fr.louiswht.chess.ex.NNPersistenceException;
import fr.louiswht.chess.ex.NNReadingException;
import org.deeplearning4j.nn.multilayer.MultiLayerNetwork;
import org.jetbrains.annotations.NotNull;

public interface NNLoader {

    void saveNetwork(@NotNull final MultiLayerNetwork mlc) throws NNPersistenceException;

    MultiLayerNetwork readNetwork() throws NNReadingException;

}
