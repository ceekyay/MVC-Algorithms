/*
 * @author Chaitanya Kovuri
 * Algorithms Spring 2017
 * Homework 4
 */
package hw4;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import java.util.HashMap;
import java.util.LinkedList;


public class mvc {
	
	public static final String FileLocation = "/Users/CK/Desktop/input.txt";
	//LinkedList<Integer> adjList;
	HashMap<Integer, LinkedList<Integer>> adjListMap;

	public static void main(String[] args) {
		//To parse the input file. 
		//HashMap IOAdjList = InputGraph();
	}
	
	/*
	 * @param number of nodes to be created.
	 * @return nothing. 
	 * @Description (Creates keys in HashMap after parsing 
	 * the # of nodes from input) 
	 */
	public void createVertices (int nodes){
		adjListMap = new HashMap<>();
		for (int i=1; i<=nodes; i++){
			adjListMap.put(i, new LinkedList<Integer>());
		}
	}
	
	
	
	/*
	 * @param Input file for ex: .txt 
	 * 	      containing non-negative integers
	 * @return Adjacency List of a graph using HashMap 
	 * 		   and ArrayLists
	 */
	
	public HashMap<Integer,ArrayList<Integer>> InputGraph() throws FileNotFoundException {
		File inputFile = new File(FileLocation);
		Scanner sc = new Scanner(inputFile);
		ArrayList<Integer> adjListArray = new ArrayList<>();
		HashMap<Integer, ArrayList<Integer>> adjListMap = new HashMap<>();
		int nodes = sc.nextInt();
		int edges = sc.nextInt();
		int count = 0;
		//Input file must have an int and iteration < edges 
		//so another graph will not be added.
		//Should I prep the code for having multiple graphs in the txt file?
		while (sc.hasNextInt() && (count<edges)){
			
		}
		
	}
	
	return adjListMap;

}
