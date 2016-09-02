package cracking.dataStructures.TreesAndGraphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cracking.dataStructures.helper.graph.*;

public class Q4_2 {
	// Given a directed graph, design an algorithm to find out whether there is
	// a route between two nodes.
	public static boolean routeExists(Vertex vStart, Vertex vEnd) {
		Map<String, Path> paths = new HashMap<String, Path>();
		boolean found = false;

		Path<Vertex> path = new Path<>();

		if (found == true) {
			paths.put("success", path);
		} else {
			paths.put("fail", path);
		}

		return found;
	}

	public static void main(String[] args) {
		DirectedGraph<Integer> digraph = new DirectedGraph<Integer>();

		Vertex<Integer> v1 = new Vertex<Integer>("1", 1);
		Vertex<Integer> v2 = new Vertex<Integer>("2", 2);
		Vertex<Integer> v3 = new Vertex<Integer>("3", 3);
		Vertex<Integer> v4 = new Vertex<Integer>("4", 4);
		Vertex<Integer> v5 = new Vertex<Integer>("5", 5);

		Edge<Integer> e12 = new Edge<Integer>(v1, v2, 40);
		Edge<Integer> e43 = new Edge<Integer>(v4, v3, 20);
		Edge<Integer> e14 = new Edge<Integer>(v1, v4, 10);
		Edge<Integer> e24 = new Edge<Integer>(v2, v4, 5);
		Edge<Integer> e23 = new Edge<Integer>(v2, v3, 30);
		Edge<Integer> e35 = new Edge<Integer>(v3, v5, 10);

	}

	public static class Path<T> {
		List<Vertex> path = new ArrayList<Vertex>();
		boolean successful = false;

		public void addVertex(Vertex<T> v) {
			path.add(v);
		}

		public void setSuccess() {
			successful = true;
		}

		public int getTotalCost() {
			int totalCost = 0;
			if (successful = false) {
				try {

					throw new Exception("path was not successful, cost not relevant");
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} else {
				for (int i = 0; i < path.size() - 1; i++) {
					totalCost = path.get(i).cost(path.get(i + 1));
				}
			}
			return totalCost;
		}
	}
}
