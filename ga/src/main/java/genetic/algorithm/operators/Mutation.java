package genetic.algorithm.operators;

import genetic.algorithm.population.Population;

public class Mutation {
    
    private double mutationRate;
    
    public Mutation(double mutationRate) {
        this.mutationRate = mutationRate;
    }
    
    public Population mutation(Population population) {
        for(int i = 0; i < population.getPopulationSize(); i++) {
            for(int j = 0; j < population.getCromozom(0).getCromozomSize(); j++) {
                if(Math.random() < mutationRate) {
                    int gene = (int) (Math.random() * population.getCromozom(0).getCromozomSize());
                    population.getCromozom(i).setGene(j, gene);
                }
            }
        }
        return population;
    }
}
