/*
 * @author Chaitanya Kovuri
 * Algorithms Spring 2017
 * Homework 4
 */
package hw4;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.ArrayList;
import java.util.Random;
import java.util.Collections;


public class Hw4 {
    
    public static final String FileLocation = "/Users/CK/Desktop/input.txt";
    public static HashMap<Integer, LinkedList<Integer>> adjListMap;
    public static int nodes;
    public static int edges;
    
    public static void main(String[] args) {
        /* try{
            InputGraph();
            /*InputGraph() Testing:
            System.out.println("Adjacency List for the graph is: \n");
            for(int i=1; i<=nodes; i++){
                System.out.print(i + "= {");
                LinkedList<Integer> testEdgeList = new LinkedList<>();
		testEdgeList = getEdges(i);
		int maxIndex = testEdgeList.size();
                int count = 1;
		for (int j: testEdgeList){
                    if(count == maxIndex){
                        System.out.print(j + " }");
                    }
                    else{
                        System.out.print(j + ", ");
                        count += 1;
                    }
                }
                System.out.println();
            }
            */
            
            ///*RandomGraph() Testing:
            RandomGraph(20,5,0.5,0.8,0.7);
            System.out.println("Adjacency List for the Random graph is: \n");
            for(int i=1; i<=nodes; i++){
                System.out.print(i + "= {");
                LinkedList<Integer> testEdgeList = new LinkedList<>();
		testEdgeList = getEdges(i);
		int maxIndex = testEdgeList.size();
                int count = 1;
		for (int j: testEdgeList){
                    if(count == maxIndex){
                        System.out.print(j + " }");
                    }
                    else{
                        System.out.print(j + ", ");
                        count += 1;
                    }
                }
                System.out.println();
            }
            
       /* }
        catch (FileNotFoundException ex){
            System.err.println("File not found: " + ex);
        } */
    }
    
    /*
    * @param number of nodes to be created.
    * @return nothing. 
    * @Description (Creates keys in HashMap after parsing
    * the # of nodes from input) 
    */
    public static void createVertices (int nodes){
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
    
    public static void createEdges(int u, int v){
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
    * containing non-negative integers
    * @return Adjacency List of a graph using HashMap 
    * and ArrayLists
    */
    
    public static HashMap<Integer,LinkedList<Integer>> InputGraph() throws FileNotFoundException {
        File inputFile = new File(FileLocation);
	Scanner sc = new Scanner(inputFile);
	nodes = sc.nextInt();
	edges = sc.nextInt();
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
    
    /*
    * Getters for InputGraph()
    */
    
    public static LinkedList<Integer> getEdges (int u){
        LinkedList<Integer> edgesList = new LinkedList<>();
        edgesList = adjListMap.get(u);
        return edgesList;
    }
    
    
    /* Question 2: RandomGraph() begins here
    *
    */
     
     public static ArrayList<Integer> unsortedVertices(int n1n2){
         ArrayList<Integer> vs = new ArrayList<>();
         for (int i=0; i<n1n2; i++ ){
             vs.add(i+1);
         }
         Collections.shuffle(vs);
         return vs;
     }
    
    public static boolean probabilityCheck(double p){
        Random rd = new Random();
        double edgeProbability = rd.nextDouble();
        //Returns TRUE if the (u,v) edge probability is higher or equal to p1.
        return p <= edgeProbability;
    }
    
    public static HashMap<Integer,LinkedList<Integer>> RandomGraph(int n1, int n2, double p1, double p2, double p3){
        nodes = n1;
        int maxVertices = 0;
        if (n1 == 0 && n2 == 0){
            System.out.println("Please enter valid vertices");
        }
        
        if (n1 > 0 && n2 ==0){
            createVertices(n1);
            for (int u=1; u<=n1; u++){
                for (int v=u+1; v<=n1; v++){
                    if(probabilityCheck(p1) == true){
                        createEdges(u,v);
                    }
                }
            }
        }
        if (n1==0 && n2 > 0){
            createVertices(n2);
            for (int u=1; u<=n2; u++){
                for (int v=u+1; v<=n2; v++){
                    if(probabilityCheck(p2) == true){
                        createEdges(u,v);
                    }
                }
            }
        }
        if(n1>0 && n2>0){
        int sumOfPartitions = n1 + n2;
        createVertices(sumOfPartitions);
        ArrayList<Integer> vertices = unsortedVertices(sumOfPartitions);
        for(int u=0; u<n1; u++){
            for(int v=0; v<n2; v++){
                if(probabilityCheck(p3)==true){
                    createEdges(vertices.get(u), vertices.get(n1+v));
                }
            }
        }
        }
        return adjListMap;

    }
}

