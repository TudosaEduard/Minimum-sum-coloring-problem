package genetic.algorithm;

public class Parameters {
    
    private int populationSize;
    private double mutationRate;
    private double crossoverRate;
    private int maxGeneration;
    private int epoch;

    public Parameters(int populationSize, double mutationRate, double crossoverRate, int maxGeneration, int epoch) {
        this.populationSize = populationSize;
        this.mutationRate = mutationRate;
        this.crossoverRate = crossoverRate;
        this.maxGeneration = maxGeneration;
        this.epoch = epoch;
    }

    public int getPopulationSize() {
        return populationSize;
    }

    public double getMutationRate() {
        return mutationRate;
    }

    public double getCrossoverRate() {
        return crossoverRate;
    }

    public int getMaxGeneration() {
        return maxGeneration;
    }

    public int getEpoch() {
        return epoch;
    }
}
