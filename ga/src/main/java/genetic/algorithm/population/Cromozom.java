package genetic.algorithm.population;

public class Cromozom {
    private int [] cromozom;
    private int cromozomSize;
    private int fitness;
    private int cromaticNumber;

    public Cromozom(int n, int k){
        this.cromozomSize = n;
        this.cromozom = new int[n];
        this.fitness = 0;
        this.cromaticNumber = k;
    }

    public int[] getCromozom() {
        return cromozom;
    }

    public void setCromozom(int[] cromozom) {
        this.cromozom = cromozom;
    }

    public int getCromozomSize() {
        return cromozomSize;
    }

    public void setGene(int index, int value){
        this.cromozom[index] = value;
    }

    public int getGene(int index){
        return this.cromozom[index];
    }

    public int getCromaticNumber() {
        return cromaticNumber;
    }

    public void setCromaticNumber(int cromaticNumber) {
        this.cromaticNumber = cromaticNumber;
    }

    // Generate a random cromozom with number between 1 and cromaticNumber
    public void generateCromozom(){
        for(int i = 0; i < cromozom.length; i++){
            cromozom[i] = (int) (Math.random() * cromaticNumber) + 1;
        }
    }

    //Calculate fitness of a cromozom (sum_color + sum_conflict)
    public int calculateFitness(int[][] g){
        int n = cromozom.length;
        int fitness = 0; 

        for(int i = 0; i < n; i++){
            for(int j = i + 1; j < n; j++){
                if(g[cromozom[i]][cromozom[j]] == 1 && cromozom[i] == cromozom[j])
                    fitness++;
            }
        }

        int sumColor = 0;
        for(int i = 0; i < n; i++)
            sumColor += cromozom[i];
        fitness += sumColor;

        return fitness;
    }

    public int getFitness() {
        return fitness;
    }

    public void setFitness(int fitness) {
        this.fitness = fitness;
    }

    public int getSumColor(){
        int sumColor = 0;
        for(int i = 0; i < cromozom.length; i++)
            sumColor += cromozom[i];
        return sumColor;
    }

    //verify if cromozome represent a valid solution
    public boolean isValidSolution(int[][] g){
        int n = cromozom.length;
        for(int i = 0; i < n; i++){
            for(int j = i + 1; j < n; j++){
                if(g[i][j] == 1 && cromozom[i] == cromozom[j])
                    return false;
            }
        }
        return true;
    }

}
