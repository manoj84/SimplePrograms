package trees.execute;

import org.graphstream.graph.Edge;
import org.graphstream.graph.Graph;
import org.graphstream.graph.Node;
import org.graphstream.graph.implementations.SingleGraph;

import java.util.Iterator;
import java.util.Stack;

/**
 * Created by Manoj on 11/22/15.
 */

public class TopologicalSort {

    private static Stack<Node> stack = new Stack<Node>();

    public static void main(String args[]) {
        Graph graph = new SingleGraph("TopplogicalSort");
        graph.addNode("Algorithms").addAttribute("ui.label", "Algorithms");
        graph.addNode("Complexity Theory").addAttribute("ui.label", "Complexity Theroy");
        graph.addNode("Artificial Intelligence").addAttribute("ui.label", "Artificial Intelligence");
        graph.addNode("Intro to CS").addAttribute("ui.label", "Intro to CS");
        graph.addNode("Cryptography").addAttribute("ui.label", "Cryptography");
        graph.addNode("Scientific Computing").addAttribute("ui.label", "Scientific Computing");
        graph.addNode("Advanced Programming").addAttribute("ui.label", "Advanced Programming");

        graph.addEdge("1", "Algorithms", "Complexity Theory", true);
        graph.addEdge("2", "Algorithms", "Artificial Intelligence", true);
        graph.addEdge("3", "Algorithms", "Scientific Computing", true);
        graph.addEdge("4", "Complexity Theory", "Cryptography", true);
        graph.addEdge("5", "Intro to CS", "Cryptography", true);
        graph.addEdge("6", "Intro to CS", "Scientific Computing", true);
        graph.addEdge("7", "Intro to CS", "Artificial Intelligence", true);
        graph.addEdge("8", "Intro to CS", "Advanced Programming", true);
        graph.addEdge("9", "Advanced Programming", "Cryptography", true);
        graph.addEdge("10", "Advanced Programming", "Algorithms", true);
        graph.addEdge("11", "Scientific Computing", "Artificial Intelligence", true);

        TopologicalSort topologicalSort = new TopologicalSort();
        topologicalSort.compute(graph, graph.getNode("Algorithms"));
        graph.getNode("Algorithms").setAttribute("visited", "visited");


        //Now complete the remaining
        Iterator<Node> nodeIterator = graph.getNodeIterator();
        while (nodeIterator.hasNext()) {
            Node tempNode = nodeIterator.next();
            if (!tempNode.hasAttribute("visited")) {
                topologicalSort.compute(graph, tempNode);
            }
        }

        stack.push(graph.getNode("Algorithms"));
        System.out.println(stack);
        graph.display();
    }

    private void compute(Graph graph, Node root) {

        Iterable<Edge> edgeIterable = root.getEachLeavingEdge();
        Iterator<Edge> edgeIterator = edgeIterable.iterator();

        while (edgeIterator.hasNext()) {
            Edge edge = edgeIterator.next();
            Node node = edge.getOpposite(root);
            if (!node.hasAttribute("visited")) {
                compute(graph, node);
                stack.push(node);
                node.setAttribute("visited", "visited");
                edge.setAttribute("ui.label", "visited");
            }
        }
    }
}
