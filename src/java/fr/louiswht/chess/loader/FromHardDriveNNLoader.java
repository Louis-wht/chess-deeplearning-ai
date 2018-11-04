package fr.louiswht.chess.loader;

import fr.louiswht.chess.ex.NNPersistenceException;
import fr.louiswht.chess.ex.NNReadingException;
import fr.louiswht.chess.loader.train.NNTrainer;
import org.deeplearning4j.nn.multilayer.MultiLayerNetwork;
import org.jetbrains.annotations.NotNull;

public class FromHardDriveNNLoader implements NNLoader {

    private MultiLayerNetwork mlc;
    private NNTrainer trainer;

    public FromHardDriveNNLoader(NNTrainer trainer) {
        this.trainer = trainer;
    }

    public void saveNetwork(@NotNull MultiLayerNetwork mlc) throws NNPersistenceException {
        // TODO
    }

    @NotNull
    public MultiLayerNetwork readNetwork() throws NNReadingException {

        if(savedNetworkExists())
            mlc = readNetworkFromHD();

        else
            mlc = new UnpersistableNNLoader(trainer).readNetwork();

        return mlc;
    }

    private boolean savedNetworkExists() {
        // TODO
        return false;
    }

    @NotNull
    private MultiLayerNetwork readNetworkFromHD() {
        //TODO
        return null;
    }
}
