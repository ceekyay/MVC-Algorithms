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
import java.util.ArrayList;


public class mvc {
	
	public static final String FileLocation = "/Users/CK/Desktop/input.txt";

	public static void main(String[] args) {
		//To parse the input file. 
		//HashMap IOAdjList = InputGraph();
	}
	
	
	/*
	 * @param Input file for ex: .txt 
	 * 	      containing non-negative integers
	 * @return Adjacency List of a graph using HashMap 
	 * 		   and ArrayLists
	 */
	
	public static HashMap<Integer,ArrayList<Integer>> InputGraph() throws FileNotFoundException {
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
