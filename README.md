# Minimum sum coloring problem (Introduction)

The optimization problem called "Minimum Sum Coloring Problem" (MSCP) consists of assigning different colors to each node of a graph so that the total cost of assigning colors is minimal. The total cost is defined as the sum of the colors assigned to each node. This is an NP-hard problem, and therefore there are a number of approaches to finding efficient solutions.

## Short historic

The Minimum Sum Coloring Problem (MSCP) is a fundamental combinatorial optimization problem that was first formulated in 1982 by Gary and Johnson, two of the pioneers of computer complexity theory. This problem is a generalization of the classical graph coloring problem, in which one seeks to assign different colors so that no two neighboring nodes have the same.

In MSCP, the objective is to associate node colors such that they are minimal and no two neighboring nodes have the same color. This problem is considered to be NP-hard, and therefore there is no efficient algorithm that provides optimal solutions for all instances. Consequently, many solution methods for MSCP focus on finding an approximate solution that is as close as possible to the optimal solution.

In recent years, coloring problems have been studied within graph theory and algorithms, with applications in various fields such as communication networks, transportation, and circuit design. Thus, research on MSCP problems has continued to be an important research topic in combinatorial computing and with many practical and theoretical applications.

## State of the art

It consists in the approach of using metaheuristic algorithms to provide good and fast solutions for this NP-hard problem.

One of the most popular metaheuristics used for the MSC problem is the Particle Swarm Optimization (PSO) algorithm. This is an algorithm based on collective intelligence, which simulates the behavior of a flock of particles moving in the search space to find the optimal solution.

Another metaheuristic algorithm used for the MSC problem is the Genetic Algorithm (GA). This is an algorithm based on natural selection, which uses a population of candidate solutions to find the optimal solution.

In addition, there are other metaheuristics that have been successfully used to solve the MSC problem, such as Tabu Search, Simulated Annealing, Ant Colony Optimization and the Cuckoo Search algorithm.

Another interesting approach is the use of Integer Linear Programming (ILP) techniques to solve the MSC problem. This approach can be used to obtain exact solutions for small and medium-sized problems, but is not practical for large-sized problems.

## Other solutions

1. Greedy: This is a simple and easy to implement approach that is based on choosing the least used color for each node and assigning it. If two nodes are adjacent and they have the same color, a different color will be chosen for one of them. This approach does not always guarantee the best solution, but it can be effective for small and medium graphs.

2. Local Search Algorithms: These algorithms try to improve the initial solution by exploring the neighborhood of the solution and trying to change the colors of the nodes in an efficient way. This approach can be useful for larger graphs, but can be time-consuming for very large graphs.

3. DSATUR Algorithm (Degree of Saturation): This is a heuristic algorithm that is based on the idea of choosing the nodes with the maximum degree and assigning them colors that have not yet been used in their neighborhood. This algorithm is capable of providing high quality solutions, but does not always guarantee optimal solutions.

4. Load Balancing Search optimization algorithm: This algorithm is a heuristic search method that tries to minimize the load difference between nodes by assigning colors. It can provide good solutions, but it does not always guarantee optimal solutions.

5. Clustering Optimization Algorithm (Cluster First, Route Second): This algorithm divides the graph into clusters and tries to assign colors to each cluster before combining them to get a final solution. It can provide good solutions, but may be inefficient for large graphs.

## Benchmark instances

Represent a set of graphs that are used to evaluate the performance of combinatorial optimization algorithms. These graphs are used to test the effectiveness of algorithms and to compare different approaches in a common environment. They are selected to represent the most critical or difficult cases so that the algorithms can be evaluated in an objective and fair way.

Some reference instances for MSCP:

1. DSJC250.5: This is a benchmark instance that consists of a graph with 250 nodes and 1065 edges. It has been used in many studies to evaluate the performance of algorithms for solving the MSCP problem.

2. DSJC500.5: This is a benchmark instance that consists of a graph with 500 nodes and 6415 edges. It has also been used in many studies to evaluate the performance of algorithms for solving the MSCP problem.

3. DSJC1000.5: This is a reference instance that consists of a graph with 1000 nodes and 24863 edges. This is a very large example and is used to test the performance of algorithms for solving the MSCP problem on large graphs.

4. C125.9 and C250.9: These are benchmark instances consisting of full bipartite graphs with 125 and 250 nodes, respectively.

## Purpose

We want to implement several algorithms that can achieve very good performance in terms of MSCP and to compare the results obtained on different test graphs, and then to decide which algorithm we will use in the realization of a subsequent application.

## First Conclusion

In conclusion, a number of approaches to the MSC problem have been developed over time, and the metaheuristic approach together with the use of appropriate reference data sets represents the current state of the art for this problem.
