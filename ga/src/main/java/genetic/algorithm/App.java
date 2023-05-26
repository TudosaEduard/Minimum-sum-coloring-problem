package genetic.algorithm;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

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
    private static List<Integer> listBestSum = new ArrayList<Integer>();

    private static File file = new File("E:/Dizertatie/Algoritmi/GA/ga/src/main/java/genetic/tests/results/myciel6_results.txt");

    public static void main( String[] args ) throws FileNotFoundException
    {

        Parameters parameters = new Parameters(100, 0.6, 0.5, 2000, 30);

        Parser parser = new Parser("queen11_11.txt");
        parser.parseFile();

        Graph graph = new Graph();
        graph.setN(parser.getN());
        graph.setM(parser.getM());
        graph.setGraph(parser.getG());
        graph.createAdjacencyList();
        int cromaticNumber = graph.greedyColoring();
        //int cromaticNumber = graph.getN();
        System.out.println("Greedy sum: " + graph.getSumColor() + " " + "Greedy cromatic: " + cromaticNumber);
        startTime = System.currentTimeMillis();

        for(int i = 0 ; i < parameters.getEpoch(); i++) {
            
            GeneticAlgorithm geneticAlgorithm = new GeneticAlgorithm(parameters, graph, graph.getN());
            geneticAlgorithm.evolvePopulation();

            // System.out.print("Best sum ever: " + geneticAlgorithm.getBestSumEver() + " " + "Best cromozom ever: ");
            // for(int j = 0; j < geneticAlgorithm.getBestCromozomEver().getCromozomSize(); j++)
            //     System.out.print(geneticAlgorithm.getBestCromozomEver().getGene(j) + " ");

            listBestSum.add(geneticAlgorithm.getBestSumEver());

            //System.out.println("Duration: " + durationSeconds + " s");

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

        //print listBestSum
        for(int i = 0; i < listBestSum.size(); i++)
            System.out.print(listBestSum.get(i) + " ");
    }
}
