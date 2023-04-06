package genetic.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Graph {

    private int n;
    private int m;
    private int[][] graph;
    private Map<Integer, List<Integer>> adjacencyList = new HashMap<Integer, List<Integer>>();

    public Graph() {
        this.n = 0;
        this.m = 0;
        this.graph = null;
    }

    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }

    public int getM() {
        return m;
    }

    public void setM(int m) {
        this.m = m;
    }

    public int[][] getGraph() {
        return graph;
    }

    public void setGraph(int[][] graph) {
        this.graph = graph;
    }

    public Map<Integer, List<Integer>> getAdjacencyList() {
        return adjacencyList;
    }

    public void createAdjacencyList() {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (graph[i][j] == 1) {
                    {
                        List<Integer> neighbors = adjacencyList.get(i);
                        if(neighbors == null)
                            neighbors = new ArrayList<>();
                        neighbors.add(j);
                        adjacencyList.put(i, neighbors);
                    }
                }
            }
        }
    }

    public void printGraph() {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                System.out.print(graph[i][j] + " ");
            }
            System.out.println();
        }
    }

    public void printAdjacencyList() {
        for (int i = 1; i <= n; i++) {
            System.out.print(i + ": ");
            for (int j = 0; j < adjacencyList.get(i).size(); j++) {
                System.out.print(adjacencyList.get(i).get(j) + " ");
            }
            System.out.println();
        }
    }

    public int greedyColoring() {
        int[] color = new int[n + 1];
        boolean[] usedColors = new boolean[n + 1];
        int cromaticNumber = 0;

        color[1] = 1;
        Arrays.fill(usedColors, true);

        for (int i = 2; i <= n; i++) {
            int lowestColor = 1;
            for (int j = 0; j < adjacencyList.get(i).size(); j++) {
                int adjacentVertex = adjacencyList.get(i).get(j);
                if (color[adjacentVertex] != 0) {
                    usedColors[color[adjacentVertex]] = false;
                }
            }
            while (!usedColors[lowestColor]) {
                lowestColor++;
            }
            color[i] = lowestColor;
            Arrays.fill(usedColors, true);
            cromaticNumber = Math.max(cromaticNumber, lowestColor);
        }

        return cromaticNumber;
    }
}
