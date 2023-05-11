package genetic.algorithm.operators;

import java.util.Random;

import genetic.algorithm.population.Population;

public class Crossover {
    private double crossoverRate;
    private double chooseCrossoverMethod;

    public Crossover(double crossoverRate) {
        this.crossoverRate = crossoverRate;
        this.chooseCrossoverMethod = 0.8;
    }

    public Population crossover(Population population) {
        if(Math.random() < chooseCrossoverMethod) {
        return crossover1(population);
        }
        else {
            return crossover2(population);
        }
    }

    private Population crossover1(Population population) {
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

    private Population crossover2(Population population) {
        for(int i = 0; i < population.getPopulationSize(); i+=2) {
            if(Math.random() < crossoverRate) {
                //Generate k between 2 and n - 1
                int k = (int) (Math.random() * (Math.min(population.getCromozom(0).getCromozomSize() - 1, 7))) + 2;
                int[] kCrossoverPoints = new int[k];
                //Create k different crossover points between 1 and n - 1
                for(int j = 0; j < k; j++) {
                    int aux = (int) (Math.random() * (population.getCromozom(0).getCromozomSize() - 1)) + 1;
                    while(contains(kCrossoverPoints, aux)) {
                        aux = (int) (Math.random() * (population.getCromozom(0).getCromozomSize() - 1)) + 1;
                    }
                    kCrossoverPoints[j] = aux;
                }
                //Sort the k crossover points
                kCrossoverPoints = sortCrossPoints(kCrossoverPoints);
                //Make the k points crossover
                int aux = 0;
                for(int j = 0; j < kCrossoverPoints.length; j+=2) {
                    for(int l = aux; l < kCrossoverPoints[j]; l++) {
                        int aux2 = population.getCromozom(i).getGene(l);
                        population.getCromozom(i).setGene(l, population.getCromozom(i+1).getGene(l));
                        population.getCromozom(i+1).setGene(l, aux2);
                    }
                    if(j + 1 < kCrossoverPoints.length) {
                        aux = kCrossoverPoints[j+1];
                    }
                    else if(kCrossoverPoints.length % 2 == 0) {
                        aux = population.getCromozom(0).getCromozomSize();
                    }
                }

            }
        }
        return population;
    }

    private boolean contains(int[] kCrossoverPoints, int aux) {
        for(int i = 0; i < kCrossoverPoints.length; i++) {
            if(kCrossoverPoints[i] == aux)
                return true;
        }
        return false;
    }

    private int [] sortCrossPoints(int[] kCrossoverPoints) {
        for(int i = 0; i < kCrossoverPoints.length - 1; i++) {
            for(int j = i + 1; j < kCrossoverPoints.length; j++) {
                if(kCrossoverPoints[i] > kCrossoverPoints[j]) {
                    int aux = kCrossoverPoints[i];
                    kCrossoverPoints[i] = kCrossoverPoints[j];
                    kCrossoverPoints[j] = aux;
                }
            }
        }
        return kCrossoverPoints;
    }
}
