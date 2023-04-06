package genetic.algorithm;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

import genetic.tests.Parser;

/**
 * Genetic algorithm for minimum sum coloring problem
 * 
 * 
 * @author Tudosa Eduard-Bogdan
 * @version classic genetic algorithm
 * @since 2023-04-02 Java 19.0.2
 * 
 * 
 */
public class App 
{
    private static int minimumSum = Integer.MAX_VALUE;
    private static int maximumSum = 0;
    private static int averageSum = 0;

    private static long startTime;
    private static long endTime;
    private static long duration;
    private static double durationSeconds;

    private static File file = new File("E:/Dizertatie/Algoritmi/GA/ga/src/main/java/genetic/tests/results/queen11_11_results.txt");

    public static void main( String[] args ) throws FileNotFoundException
    {

        Parameters parameters = new Parameters(200, 0.2, 0.8, 3000, 30);

        Parser parser = new Parser("queen11_11.txt");
        parser.parseFile();

        Graph graph = new Graph();
        graph.setN(parser.getN());
        graph.setM(parser.getM());
        graph.setGraph(parser.getG());
        graph.createAdjacencyList();
        int cromaticNumber = graph.greedyColoring();

        startTime = System.currentTimeMillis();

        for(int i = 0 ; i < parameters.getEpoch(); i++) {
            GeneticAlgorithm geneticAlgorithm = new GeneticAlgorithm(parameters, graph, cromaticNumber * 4);
            geneticAlgorithm.evolvePopulation();

            System.out.print("Best sum ever: " + geneticAlgorithm.getBestSumEver() + " " + "Best cromozom ever: ");
            /*for(int j = 0; j < geneticAlgorithm.getBestCromozomEver().getCromozomSize(); j++)
                System.out.print(geneticAlgorithm.getBestCromozomEver().getGene(j) + " ");
            System.out.println();*/

            if(geneticAlgorithm.getBestSumEver() < minimumSum)
                minimumSum = geneticAlgorithm.getBestSumEver();
            if(geneticAlgorithm.getBestSumEver() > maximumSum)
                maximumSum = geneticAlgorithm.getBestSumEver();
            averageSum += geneticAlgorithm.getBestSumEver();
        }

        averageSum /= parameters.getEpoch();
        endTime = System.currentTimeMillis();
        duration = (endTime - startTime);
        durationSeconds = (double)(duration / 1000);

        PrintWriter writer = new PrintWriter(file);
        writer.println("Minimum sum: " + minimumSum);
        writer.println("Maximum sum: " + maximumSum);
        writer.println("Average sum: " + averageSum);
        writer.println("Duration: " + durationSeconds + " s");
        writer.close();

        //print results in queen5_5_results.txt

    }
}
