package src;

import java.io.FileNotFoundException;
import java.util.Scanner;

import src.algorithm.BreadthFirstSearch;
import src.algorithm.DepthFirstSearch;
import src.algorithm.IterativeDeepeningSearch;
import src.algorithm.UniformCostSearch;
import src.algorithm.GreedyBestFirstSearch;
import src.algorithm.AStarSearch;
import src.algorithm.SearchAlgorithm;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Maze maze = readMaze(scanner);

        boolean run = true;
        while (run) {
            System.out.print("\n1. Change Maze\n" +
                    "2. Depth First Search\n" +
                    "3. Breadth First Search\n" +
                    "4. Iterative Deepening Search\n" +
                    "5. Uniform Cost Search\n" +
                    "6. Greedy Best First Search\n" +
                    "7. A* Heuristic Search\n" +
                    "8. Exit\n\n" +
                    "Your selection: ");
            String selection = scanner.nextLine();
            switch (selection) {
                case "1":
                    maze = readMaze(scanner);
                    break;
                case "2":
                    applyDFS(maze);
                    break;
                case "3":
                    applyBFS(maze);
                    break;
                case "4":
                    applyIterativeDeepening(maze);
                    break;
                case "5":
                    applyUniformCostSearch(maze);
                    break;
                case "6":
                    applyGreedy(maze);
                    break;
                case "7":
                    applyAStar(maze);
                    break;
                case "8":
                    run = false;
                    break;
                default:
                    System.out.println("Please enter a valid number.");
                    break;
            }
        }
        scanner.close();
    }

    private static Maze readMaze(Scanner scanner) {
        while (true) {
            System.out.print("\nEnter an input file for maze: ");
            String mazeFileName = scanner.nextLine();
            try {
                return new Maze(mazeFileName);
            } catch (FileNotFoundException e) {
                System.out.println("Maze file \"" + mazeFileName + "\" could not be found.");
            }
        }
    }

    private static void applyDFS(Maze maze) {
        System.out.println("\nApplying Depth First Search...");
        SearchAlgorithm search = new DepthFirstSearch(maze);
        search.search();
        search.printSolutions();
    }

    private static void applyBFS(Maze maze) {
        System.out.println("\nApplying Breadth First Search...");
        SearchAlgorithm search = new BreadthFirstSearch(maze);
        search.search();
        search.printSolutions();
    }

    private static void applyIterativeDeepening(Maze maze) {
        System.out.println("\nApplying Iterative Deepening Search...");
        SearchAlgorithm search = new IterativeDeepeningSearch(maze);
        search.search();
        search.printSolutions();
    }

    private static void applyUniformCostSearch(Maze maze) {
        System.out.println("\nApplying Uniform Cost Search...");
        SearchAlgorithm search = new UniformCostSearch(maze);
        search.search();
        search.printSolutions();
    }

    private static void applyGreedy(Maze maze) {
        System.out.println("\nApplying Greedy Best First Search...");
        SearchAlgorithm search = new GreedyBestFirstSearch(maze);
        search.search();
        search.printSolutions();
    }

    private static void applyAStar(Maze maze) {
        System.out.println("\nApplying A Star Heuristic Search...");
        SearchAlgorithm search = new AStarSearch(maze);
        search.search();
        search.printSolutions();
    }

}
