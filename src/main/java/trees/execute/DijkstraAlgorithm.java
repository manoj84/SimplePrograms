package trees.execute;

import org.graphstream.algorithm.Dijkstra;
import org.graphstream.algorithm.Dijkstra.Element;
import org.graphstream.graph.Edge;
import org.graphstream.graph.Graph;
import org.graphstream.graph.Node;
import org.graphstream.graph.Path;
import org.graphstream.graph.implementations.SingleGraph;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Implementation of Dijkstra Single Source Shortest Path.
 *
 * @author manoj
 */

public class DijkstraAlgorithm {
    public static void main(String args[]) {
        Graph graph = new SingleGraph("First Grpah");
        graph.addNode("A");
        graph.addNode("B");
        graph.addNode("C");
        graph.addNode("D");
        graph.addNode("E");

        graph.addEdge("AB", "A", "B").addAttribute("ui.label", new Double(3));
        graph.addEdge("BC", "B", "C").addAttribute("ui.label", new Double(5));
        graph.addEdge("CD", "C", "D").addAttribute("ui.label", new Double(7));
        graph.addEdge("CE", "C", "E").addAttribute("ui.label", new Double(4));
        graph.addEdge("DE", "D", "E").addAttribute("ui.label", new Double(4));

        for (Node node : graph) {
            node.addAttribute("ui.label", node.getId());
        }

        Dijkstra dijkstra = new Dijkstra(Element.EDGE, null, "ui.label");

        dijkstra.init(graph);
        dijkstra.setSource(graph.getNode("A"));
        dijkstra.compute();
        Path p = dijkstra.getPath(graph.getNode("E"));
        System.out.println(p.toString());
        System.out.println(p.getPathWeight("ui.label"));
        TestDijkstras(graph);
        graph.display();
    }

    public static void TestDijkstras(Graph g) {

        Node startNode = g.getNode("A");
        Queue<Node> nodeQueue = new LinkedList<Node>();
        nodeQueue.add(startNode);
        startNode.setAttribute("Visited", true);
        startNode.addAttribute("ui.length", (double) 0);

        while (!nodeQueue.isEmpty()) {
            Node node = nodeQueue.poll();
            Iterator<Node> nodes = node.getNeighborNodeIterator();
            while (nodes.hasNext()) {
                Node nextNode = nodes.next();
                if (nextNode.getAttribute("Visited") == null) {
                    Edge nextNodeEdge = node.getEdgeBetween(nextNode);
                    Double length;
                    if (nextNodeEdge.getAttribute("ui.label") != null) {
                        length = nextNodeEdge.getAttribute("ui.label");
                    } else {
                        length = (double) 0;
                    }
                    Double totalLength = (Double) node
                            .getAttribute("ui.length") + length;
                    nextNode.setAttribute("ui.length", totalLength);
                    nextNode.setAttribute("Visited", true);
                    nodeQueue.add(nextNode);
                }

            }

        }

        //System.out.println(g.getNode("E").getAttribute("ui.length"));

    }
}
