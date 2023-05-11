package genetic.algorithm.operators;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import genetic.algorithm.population.Population;

public class Mutation {
    
    private double mutationRate;
    private Map<Integer, List<Integer>> adjacencyList = new HashMap<Integer, List<Integer>>();
    
    public Mutation(double mutationRate, Map<Integer, List<Integer>> adjacencyList) {
        this.mutationRate = mutationRate;
        this.adjacencyList = adjacencyList;
    }
    
    public Population mutation(Population population) {
        /*for(int i = 0; i < population.getPopulationSize(); i++) {
            for(int j = 0; j < population.getCromozom(0).getCromozomSize(); j++) {
                if(Math.random() < mutationRate) {
                    int gene = (int) (Math.random() * population.getCromozom(0).getCromozomSize());
                    population.getCromozom(i).setGene(j, gene);
                }
            }
        }*/
        for(int i = 0; i < population.getPopulationSize(); i++) {
            for(int j = 0; j < population.getCromozom(0).getCromozomSize(); j++) {
                if(Math.random() < mutationRate) {
                    //Verify if his neighbor have the same color and change it randomly
                    List<Integer> neighbors = adjacencyList.get(j);
                    if(neighbors != null)
                        for(int k = 0; k < adjacencyList.get(j).size(); k++) {
                            if(population.getCromozom(i).getGene(j) == population.getCromozom(i).getGene(adjacencyList.get(j).get(k) - 1)) {
                                int gene = (int) (Math.random() * (population.getCromozom(0).getCromozomSize() - 1));
                                population.getCromozom(i).setGene(j, gene);
                            }
                        }
                }
            }
        }

        return population;
    }
}
