package genetic.algorithm.selection;

import genetic.algorithm.Graph;
import genetic.algorithm.population.Population;

public class Tournament {

    private Population population;
    private Population tournamentPopulation;
    private int populationSize;
    private int cromaticNumber;

    public Tournament(Population population, int cromaticNumber) {
        this.population = population;
        this.populationSize = population.getPopulationSize();
        this.cromaticNumber = cromaticNumber;
    }

    public Population tournamentSelection(Graph graph) {
        tournamentPopulation = new Population(populationSize, population.getCromozom(0).getCromozomSize(), cromaticNumber);
        int index = 0;

        population.shufflePopulation();
        for(int i = 0; i < populationSize; i+=2)
            if(population.getCromozom(i).getFitness() < population.getCromozom(i+1).getFitness())
                tournamentPopulation.addCromozom(index++, population.getCromozom(i), graph);
            else
                tournamentPopulation.addCromozom(index++, population.getCromozom(i+1), graph);
        population.shufflePopulation();
        for(int i = 0; i < populationSize; i+=2)
            if(population.getCromozom(i).getFitness() < population.getCromozom(i+1).getFitness())
                tournamentPopulation.addCromozom(index++, population.getCromozom(i), graph);
            else
                tournamentPopulation.addCromozom(index++, population.getCromozom(i+1), graph);

        tournamentPopulation.sortPopulation();
        return tournamentPopulation;
    }
}
