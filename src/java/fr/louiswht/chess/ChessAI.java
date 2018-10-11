package fr.louiswht.chess;

import org.deeplearning4j.nn.api.OptimizationAlgorithm;
import org.deeplearning4j.nn.conf.MultiLayerConfiguration;
import org.deeplearning4j.nn.conf.NeuralNetConfiguration;
import org.deeplearning4j.nn.conf.layers.DenseLayer;
import org.deeplearning4j.nn.conf.layers.OutputLayer;
import org.deeplearning4j.nn.weights.WeightInit;
import org.nd4j.linalg.activations.Activation;
import org.nd4j.linalg.learning.config.Adam;
import org.nd4j.linalg.lossfunctions.LossFunctions;

public class ChessAI {


    private final MultiLayerConfiguration nnConf;

    public ChessAI() {
        // Basically, the neurone net we'll use here
        nnConf = new NeuralNetConfiguration.Builder()
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
