package fr.louiswht.chess.loader;

import fr.louiswht.chess.ex.NNPersistenceException;
import fr.louiswht.chess.ex.NNReadingException;
import fr.louiswht.chess.loader.train.DefaultNNTrainer;
import org.deeplearning4j.nn.api.OptimizationAlgorithm;
import org.deeplearning4j.nn.conf.MultiLayerConfiguration;
import org.deeplearning4j.nn.conf.NeuralNetConfiguration;
import org.deeplearning4j.nn.conf.layers.DenseLayer;
import org.deeplearning4j.nn.conf.layers.OutputLayer;
import org.deeplearning4j.nn.multilayer.MultiLayerNetwork;
import org.deeplearning4j.nn.weights.WeightInit;
import org.jetbrains.annotations.NotNull;
import org.nd4j.linalg.activations.Activation;
import org.nd4j.linalg.learning.config.Adam;
import org.nd4j.linalg.lossfunctions.LossFunctions;

public class UnpersistableNNLoader implements NNLoader {

    private final DefaultNNTrainer trainer;

    public UnpersistableNNLoader() {
        this(new DefaultNNTrainer());
    }

    public UnpersistableNNLoader(@NotNull final DefaultNNTrainer trainer) {
        this.trainer = trainer;
    }

    public void saveNetwork(@NotNull final MultiLayerNetwork mlc) throws NNPersistenceException {
        // Does nothing because this NN loader will create a new
        // network each time.
    }

    public MultiLayerNetwork readNetwork() throws NNReadingException {
        MultiLayerNetwork mlc = new MultiLayerNetwork( initNnConf() );

        trainer.train(mlc);

        return mlc;
    }



    private MultiLayerConfiguration initNnConf() {

        // Basically, the neurone net we'll use here
        return new NeuralNetConfiguration.Builder()
                .optimizationAlgo(OptimizationAlgorithm.STOCHASTIC_GRADIENT_DESCENT)
                .updater(new Adam())
                .l2(1e-4)
                .list()
                .layer
                        (
                                new DenseLayer.Builder()
                                        .nIn(8 * 8 * 16)
                                        .nOut(500)
                                        .activation(Activation.SIGMOID)
                                        .weightInit(WeightInit.VAR_SCALING_UNIFORM_FAN_AVG)
                                        .build()
                        )
                .layer
                        (
                                new OutputLayer.Builder(LossFunctions.LossFunction.NEGATIVELOGLIKELIHOOD)
                                        .nIn(500)
                                        .nOut(1)
                                        .activation(Activation.SOFTMAX)
                                        .weightInit(WeightInit.VAR_SCALING_UNIFORM_FAN_AVG)
                                        .build()
                        )
                .pretrain(false)
                .backprop(true)
                .build();
    }

}
