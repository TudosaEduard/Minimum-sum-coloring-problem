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

3. Algoritmul DSATUR (Degree of Saturation): Acesta este un algoritm euristic care se bazează pe ideea de a alege nodurile cu gradul maxim și de a le atribui culori care nu au fost încă utilizate în vecinătatea lor. Acest algoritm este capabil să furnizeze soluții de calitate ridicată, dar nu garantează întotdeauna soluții optime.

4. Algoritmul de optimizare prin căutare cu încărcare (Load Balancing Search): Acest algoritm este o metodă de căutare euristică care încearcă să minimizeze diferența de încărcare dintre noduri prin atribuirea de culori. Acesta poate furniza soluții bune, dar nu garantează întotdeauna soluții optime.

5. Algoritmul de optimizare prin împărțire în clusteri (Cluster First, Route Second): Acest algoritm împarte graful în clusteri și încearcă să atribuie culori în fiecare cluster înainte de a le combina pentru a obține o soluție finală. Acesta poate furniza soluții bune, dar poate fi ineficient pentru grafuri mari.
