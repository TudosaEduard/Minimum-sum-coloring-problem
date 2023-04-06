package genetic.algorithm.operators;

import genetic.algorithm.population.Population;

public class Crossover {
    private double crossoverRate;

    public Crossover(double crossoverRate) {
        this.crossoverRate = crossoverRate;
    }

    public Population crossover(Population population) {
        for(int i = 0; i < population.getPopulationSize(); i+=2) {
            if(Math.random() < crossoverRate) {
                int crossoverPoint = (int) (Math.random() * population.getCromozom(0).getCromozomSize());
                for(int j = 0; j < crossoverPoint; j++) {
                    int aux = population.getCromozom(i).getGene(j);
                    population.getCromozom(i).setGene(j, population.getCromozom(i+1).getGene(j));
                    population.getCromozom(i+1).setGene(j, aux);
                }
            }
        }
        return population;
    }
}
