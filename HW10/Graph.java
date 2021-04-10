/* Author: Artiom Dolghi
 * Due date: April 24, 2020
 * Purpose: This class outlines a Graph structure and contains methods as well as tests for them
 * Credits: I did not work with anybody else on this assignment
 */

import java.util.ArrayList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;
import java.util.LinkedList;

public class Graph {
	public static class Vertex {
		public char label; // label (e.g. 'A')
		public boolean wasVisited;
		// -------------------------------------------------------------
		public Vertex(char lab) // constructor
		{
			label = lab;
			wasVisited = false;
		}
		// -------------------------------------------------------------
	} // end class Vertex

	private final int MAX_VERTS = 20;
	private Vertex vertexList[]; // list of vertices
	private int adjMat[][]; // adjacency matrix
	private int nVerts; // current number of vertices
	private Queue<Integer> theQueue;
	private Stack<Integer> theStack;

	// ------------------------------------------------------------
	public Graph() // constructor
	{
		vertexList = new Vertex[MAX_VERTS];
		// adjacency matrix
		adjMat = new int[MAX_VERTS][MAX_VERTS];
		nVerts = 0;
		for (int j = 0; j < MAX_VERTS; j++) // set adjacency
			for (int k = 0; k < MAX_VERTS; k++) // matrix to 0
				adjMat[j][k] = 0;
		theQueue = new LinkedList<Integer>();
		theStack = new Stack<Integer>();
	} // end constructor
	
	public void addVertex(char lab) {
		vertexList[nVerts++] = new Vertex(lab);
	}

	// -------------------------------------------------------------
	public void addEdge(int start, int end) {
		adjMat[start][end] = 1;
		adjMat[end][start] = 1;
	}

	// -------------------------------------------------------------
	public void displayVertex(int v) {
		System.out.print(vertexList[v].label);
	}

	// -------------------------------------------------------------
	public void bfs() // breadth-first search
	{ // begin at vertex 0
		vertexList[0].wasVisited = true; // mark it
		displayVertex(0); // display it
		theQueue.add(0); // insert at tail
		int v2;

		while (!theQueue.isEmpty()) // until queue empty,
		{
			int v1 = theQueue.remove(); // remove vertex at head
			// until it has no unvisited neighbors
			while ((v2 = getAdjUnvisitedVertex(v1)) != -1) { // get one,
				vertexList[v2].wasVisited = true; // mark it
				displayVertex(v2); // display it
				theQueue.add(v2); // insert it
			} // end while
		} // end while(queue not empty)

		// queue is empty, so we're done
		for (int j = 0; j < nVerts; j++) // reset flags
			vertexList[j].wasVisited = false;
	} // end bfs()
		// -------------------------------------------------------------
		// returns an unvisited vertex adj to v

	/*
	 * Iterative DFS
	 */
	public void dfs() // depth-first search implemented using iteration
	{ // begin at vertex 0
		vertexList[0].wasVisited = true; // mark it
		displayVertex(0); // display it
		theStack.push(0); // push it

		while (!theStack.isEmpty()) // until stack empty,
		{
			// get an unvisited vertex adjacent to stack top
			int v = getAdjUnvisitedVertex(theStack.peek());
			if (v == -1) // if no such vertex,
				theStack.pop();
			else // if it exists,
			{
				vertexList[v].wasVisited = true; // mark it
				displayVertex(v); // display it
				theStack.push(v); // push it
			}
		} // end while

		// stack is empty, so we're done
		for (int j = 0; j < nVerts; j++) // reset flags
			vertexList[j].wasVisited = false;
	} // end dfs
	
	/*
	 * Recursive DFS
	 */
	public void dfsRecursive(){
		for (int j = 0; j < nVerts; j++) // reset flags
			vertexList[j].wasVisited = false;
		dfsRecursive(0);
	}
	
	public void dfsRecursive(int id){
		vertexList[id].wasVisited=true;
		for (int neighbor = 0; neighbor < nVerts; neighbor++) {
			if (adjMat[id][neighbor]==1 && vertexList[neighbor].wasVisited==false){
				dfsRecursive(neighbor);
			}
		}
	}
	
	public int getAdjUnvisitedVertex(int v) {
		for (int j = 0; j < nVerts; j++)
			if (adjMat[v][j] == 1 && vertexList[j].wasVisited == false)
				return j;
		return -1;
	} // end getAdjUnvisitedVertex()
	
	public void dfs(int id, ArrayList<Integer> theList) {
		
		vertexList[id].wasVisited = true;
		theList.add(id);
		theStack.push(id);

		while (!theStack.isEmpty()) // until stack empty,
		{
			int v = getAdjUnvisitedVertex(theStack.peek());
			if (v == -1)
				theStack.pop();
			else 
			{
				vertexList[v].wasVisited = true;
				theList.add(v);
				theStack.push(v);
			}
		}

		for (int j = 0; j < nVerts; j++)
			vertexList[j].wasVisited = false;
	}

	/*
	 * Detect connected components on an undirected graph.
	 */
	public ArrayList<ArrayList<Integer>> detectConnectedComponent() {
		
		for (int j = 0;j < nVerts;j++) {
			vertexList[j].wasVisited = false;
		}
		
		ArrayList<ArrayList<Integer>> allComponents = new ArrayList<ArrayList<Integer>>();
		
		for (int j = 0;j < nVerts;j++) {
			if (vertexList[j].wasVisited == false) {
				ArrayList<Integer> theList = new ArrayList<Integer>();
				dfs(j, theList);
				allComponents.add(theList);
				
			}
		}
		
		return allComponents;
	}

	/* 
	 * Detect whether there is a path between two given nodes.
	 */
	public boolean findPath(int start, int end){
		
		for (int j = 0;j < nVerts;j++) {
			vertexList[j].wasVisited = false;
		}
		
		for (int i = 0;i < nVerts;i++) {
			if (vertexList[end].wasVisited) {
				return true;
			}
			dfsRecursive(start);
		}
		
		return false;
 	}
	
	public ArrayList<Integer> getNeighbors(int id) {
		ArrayList<Integer> theList = new ArrayList<Integer>();
		for (int j = 0;j < nVerts;j++) {
			if (adjMat[id][j] == 1) {
				theList.add(j);
			}
		}
		return theList;
	}
	
	/*
	 * Detect cycle on an undirected graph
	 */
	public boolean hasCycle() {
		for (int i = 0;i < nVerts;i++) {
			vertexList[i].wasVisited = false;
		}
		
		for (int i = 0;i < nVerts;i++) {
			if (vertexList[i].wasVisited==false) {
				if (hasCycleHelper(i, -1)) return true;
			}
		}
		
		return false;
	}
	
	public boolean hasCycleHelper(int i, int parent) {
		vertexList[i].wasVisited = true;
		for (int neighbor: getNeighbors(i)) {
			if (!vertexList[neighbor].wasVisited) {
				if (hasCycleHelper(neighbor, i)) {
					return true;
				}
			} else {
				if (neighbor != parent) {
					return true;
				}
			}
		}
		return false;
	}

	public static void main(String[] args) {
		Graph theGraph1 = new Graph();
		theGraph1.addVertex('a'); // 0
		theGraph1.addVertex('b'); // 1
		theGraph1.addVertex('c'); // 2
		theGraph1.addVertex('d'); // 3
		theGraph1.addVertex('e'); // 4
		theGraph1.addVertex('f'); // 5
		
		theGraph1.addEdge(0, 1); // ab
		theGraph1.addEdge(0, 2); // ac
		theGraph1.addEdge(0, 4); // ae
		theGraph1.addEdge(1, 3); // bd
		theGraph1.addEdge(2, 3); // cd
		theGraph1.addEdge(3, 5); // df
		theGraph1.addEdge(4, 5); // ef
		
		Graph theGraph2 = new Graph();
		theGraph2.addVertex('a'); // 0
		theGraph2.addVertex('b'); // 1
		theGraph2.addVertex('c'); // 2
		theGraph2.addVertex('d'); // 3
		theGraph2.addVertex('e'); // 4
		theGraph2.addVertex('f'); // 5
		
		theGraph2.addEdge(0, 1); // ab
		theGraph2.addEdge(0, 2); // ac
		theGraph2.addEdge(0, 4); // ae
		theGraph2.addEdge(3, 5); // df
		
		Graph theGraph3 = new Graph();
		theGraph3.addVertex('a'); // 0
		theGraph3.addVertex('b'); // 1
		theGraph3.addVertex('c'); // 2
		theGraph3.addVertex('d'); // 3
		theGraph3.addVertex('e'); // 4
		theGraph3.addVertex('f'); // 5
		
		theGraph3.addEdge(0, 1); // ab
		theGraph3.addEdge(0, 2); // ac
		theGraph3.addEdge(0, 4); // ae
		theGraph3.addEdge(1, 3); // bd
		theGraph3.addEdge(3, 5); // df
		
		/*
		 * Your codes on detecting connected components
		 * on Graph theGraph1 and theGraph2
		 */
		
		ArrayList<ArrayList<Integer>> connectedComps1 = theGraph1.detectConnectedComponent();
		
		int j = 1;
		System.out.println("There are " + connectedComps1.size() + " connected components in Graph 1");
		
		for (ArrayList<Integer> i : connectedComps1) {
			System.out.println(j + ": " + i);
			j++;
		}
		
		System.out.println();
		
		/////////////////////
		
		ArrayList<ArrayList<Integer>> connectedComps2 = theGraph2.detectConnectedComponent();
		
		j = 1;
		System.out.println("There are " + connectedComps2.size() + " connected components in Graph 2");
		
		for (ArrayList<Integer> i : connectedComps2) {
			System.out.println(j + ": " + i);
			j++;
		}
		
		/*
		 * Your codes on finding a path on Graph theGraph1
		 */
		
		Scanner keyboard = new Scanner(System.in);
		
		System.out.print("Enter vertex 1 to find a path from: ");
		int v1 = keyboard.nextInt();
		
		System.out.print("Enter vertex 2 to find a path to: ");
		int v2 = keyboard.nextInt();
		
		if (theGraph1.findPath(v1, v2)) {
			System.out.print("These two vertices are connected on Graph 1");
		} else {
			System.out.print("These two vertices are not connected on Graph 1");
		}
		
		System.out.println();

		keyboard.close();
	
		/*
		 * Your codes on finding cycle on Graph
		 * theGraph1 and theGraph3
		 */
		
		if (theGraph1.hasCycle()) {
			System.out.print("Graph 1 contains cycles");
		} else {
			System.out.print("Graph 1 does not contain cycles");
		}
		
		System.out.println();
		
		if (theGraph3.hasCycle()) {
			System.out.print("Graph 3 contains cycles");
		} else {
			System.out.print("Graph 3 does not contain cycles");
		}
		
	} // end main()
}