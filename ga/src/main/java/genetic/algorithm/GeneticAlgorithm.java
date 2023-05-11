package genetic.algorithm;

import genetic.algorithm.operators.Crossover;
import genetic.algorithm.operators.Mutation;
import genetic.algorithm.population.Cromozom;
import genetic.algorithm.population.Population;
import genetic.algorithm.selection.Tournament;

public class GeneticAlgorithm {
    
    private Parameters parameters;
    private Graph graph;
    private Population population;
    private Tournament tournament;
    private int generation;
    private int bestSumEver = Integer.MAX_VALUE;
    private Cromozom bestCromozomEver;
    private int cromaticNumber;

    public GeneticAlgorithm(Parameters parameters, Graph graph, int cromaticNumber) {
        this.parameters = parameters;
        this.graph = graph;
        this.cromaticNumber = cromaticNumber;
        this.population = new Population(parameters.getPopulationSize(), graph.getN(), graph, cromaticNumber);
        this.tournament = new Tournament(population, cromaticNumber);
        this.generation = 0;
    }

    public void evolvePopulation() {
        while(generation < parameters.getMaxGeneration()) {
            generation++;
            population = tournament.tournamentSelection(graph);
            population = new Crossover(parameters.getCrossoverRate()).crossover(population);
            population = new Mutation(parameters.getMutationRate(), graph.getAdjacencyList()).mutation(population);
            for(int i = 0 ; i < population.getPopulationSize(); i++)
                population.getCromozom(i).setFitness(population.getCromozom(i).calculateFitness(graph.getGraph()));
            bestSumAllGenerations(population);
            //System.out.println("Generation: " + generation + " Best sum: " + bestSumEver);
        }
    }

    public Population getPopulation() {
        return population;
    }

    public int getGeneration() {
        return generation;
    }

    public void bestSumAllGenerations(Population population) {
        for(int i = 0; i < population.getPopulationSize(); i++) {
            if(population.getCromozom(i).getSumColor() < bestSumEver && population.getCromozom(i).isValidSolution(graph.getGraph())) {
                bestSumEver = population.getCromozom(i).getSumColor();
                bestCromozomEver = population.getCromozom(i);
            }
        }
    }

    public int getBestSumEver() {
        return bestSumEver;
    }

    public Cromozom getBestCromozomEver() {
        return bestCromozomEver;
    }
}
