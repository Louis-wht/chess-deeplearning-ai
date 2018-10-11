package fr.louiswht.chess;

import fr.louiswht.chess.loader.UnpersistableNNLoader;
import org.deeplearning4j.nn.api.OptimizationAlgorithm;
import org.deeplearning4j.nn.conf.NeuralNetConfiguration;
import org.deeplearning4j.nn.conf.layers.DenseLayer;
import org.deeplearning4j.nn.conf.layers.OutputLayer;
import org.deeplearning4j.nn.weights.WeightInit;
import org.nd4j.linalg.activations.Activation;
import org.nd4j.linalg.learning.config.Adam;
import org.nd4j.linalg.lossfunctions.LossFunctions;

public class GameEngine {

    public static void main(String[] args) {

        DefaultChessAI chessAI = new DefaultChessAI(new UnpersistableNNLoader());

    }
}
