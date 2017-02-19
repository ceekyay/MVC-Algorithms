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
	 * @param int u, int v
	 * u,v are vertex pairs (edges)
	 * @return nothing
	 * @Description vertices of an edge
	 * are added to the list of the vertex. 
	 */
	
	public void createEdges(int u, int v){
		//Make sure vertices u & v are within the range of given nodes.
		if (u > adjListMap.size() || v > adjListMap.size()){
			System.out.println("These vertices dont belong to this graph");
		}
		//Grab the corresponding edge lists of the vertices.
		LinkedList<Integer> uVertex = adjListMap.get(u);
		LinkedList<Integer> vVertex = adjListMap.get(v);
		//Adds the v vertex as a corresponding edge to vertex u.
		uVertex.add(v);
		//Adds the u vertex as a corresponding edge to vertex v.
		vVertex.add(u);
	}
	
	
	
	/*
	 * @param Input file for ex: .txt 
	 * 	      containing non-negative integers
	 * @return Adjacency List of a graph using HashMap 
	 * 		   and ArrayLists
	 */
	
	public HashMap<Integer,LinkedList<Integer>> InputGraph() throws FileNotFoundException {
		File inputFile = new File(FileLocation);
		Scanner sc = new Scanner(inputFile);
		int nodes = sc.nextInt();
		int edges = sc.nextInt();
		//Create the HashMap using nodes as Keys
		createVertices(nodes);
		int count = 0;
		//Should I prep the code for having multiple graphs in the txt file?
		while (sc.hasNextInt() && (count<edges)){
			int u = sc.nextInt();
			int v = sc.nextInt();
			createEdges(u,v);
			count += 1;
		}
		sc.close();
		return adjListMap;
	}
	
}
