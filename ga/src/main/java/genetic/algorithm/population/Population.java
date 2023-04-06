package genetic.algorithm.population;

import genetic.algorithm.Graph;

public class Population {
    private Cromozom[] population;
    private int populationSize;
    private int cromozomSize;
    private int cromaticNumber;

    public Population(int populationSize, int cromozomSize, int cromaticNumber){
        this.populationSize = populationSize;
        this.cromozomSize = cromozomSize;
        this.population = new Cromozom[populationSize];
        this.cromaticNumber = cromaticNumber;
    }

    public Population(int populationSize, int cromozomSize, Graph graph, int cromaticNumber){
        this.populationSize = populationSize;
        this.cromozomSize = cromozomSize;
        this.population = new Cromozom[populationSize];
        this.cromaticNumber = cromaticNumber;
        for(int i = 0; i < populationSize; i++){
            Cromozom cromozom = new Cromozom(cromozomSize, cromaticNumber);
            cromozom.generateCromozom();
            cromozom.setFitness(cromozom.calculateFitness(graph.getGraph()));
            population[i] = cromozom;
        }
    }

    public Cromozom[] getPopulation() {
        return population;
    }

    public void setPopulation(Cromozom[] population) {
        this.population = population;
    }

    public Cromozom getCromozom(int index){
        return this.population[index];
    }

    public int getPopulationSize() {
        return populationSize;
    }

    public void setCromozom(int index, Cromozom cromozom){
        this.population[index] = cromozom;
    }

    public void addCromozom(int index, Cromozom cromozom, Graph graph){
        Cromozom cz = new Cromozom(cromozomSize, cromaticNumber);
        cz.generateCromozom();
        cz.setFitness(cz.calculateFitness(graph.getGraph()));
        this.population[index] = cz;
    }

    public void shufflePopulation(){
        for(int i = 0; i < populationSize; i++){
            int randomIndex = (int) (Math.random() * populationSize);
            Cromozom temp = population[i];
            population[i] = population[randomIndex];
            population[randomIndex] = temp;
        }
    }

    public void sortPopulation(){
        for(int i = 0; i < populationSize; i++){
            for(int j = i + 1; j < populationSize; j++){
                if(population[i].getFitness() > population[j].getFitness()){
                    Cromozom temp = population[i];
                    population[i] = population[j];
                    population[j] = temp;
                }
            }
        }
    }

    // Return the best fitness of the population
    public int getBestFitness(){
        int bestFitness = population[0].getFitness();
        for(int i = 1; i < population.length; i++){
            if(population[i].getFitness() < bestFitness)
                bestFitness = population[i].getFitness();
        }
        return bestFitness;
    }
}
