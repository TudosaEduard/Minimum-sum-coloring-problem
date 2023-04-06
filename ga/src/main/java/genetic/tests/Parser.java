package genetic.tests;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Parser {

    private String filePath;
    private int n;
    private int m;
    private int [][] g;

    public Parser(String filename){
        this.filePath = "E:/Dizertatie/Algoritmi/GA/ga/src/main/java/genetic/tests/benchmarks/" + filename;
    }

    public void parseFile(){
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) 
                if(line.charAt(0) == 'p'){
                    String[] parts = line.split(" ");

                    n = Integer.parseInt(parts[2]);
                    m = Integer.parseInt(parts[3]);

                    g = new int[n + 1][n + 1];
                    for(int i = 0; i <= n; i++)
                        for(int j = 0; j <= n; j++)
                            g[i][j] = 0;

                    for(int i = 0; i < m; i++){
                        line = br.readLine();
                        parts = line.split(" ");
                        int x = Integer.parseInt(parts[1]);
                        int y = Integer.parseInt(parts[2]);

                        g[x][y] = 1;
                        g[y][x] = 1;
                    }

                    break;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getFilePath() {
        return filePath;
    }

    public int getN() {
        return n;
    }

    public int getM() {
        return m;
    }

    public int[][] getG() {
        return g;
    }

}

