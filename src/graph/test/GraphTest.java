package graph.test;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.jgrapht.ext.JGraphXAdapter;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.Multigraph;

import com.mxgraph.layout.mxCircleLayout;
import com.mxgraph.layout.mxIGraphLayout;
import com.mxgraph.util.mxCellRenderer;

public class GraphTest
{

	public static void main(String[] args) throws IOException
	{
		File imgFile = new File("src/graph/test/graph1.png");
		// imgFile.createNewFile();

		Multigraph<String, DefaultWeightedEdge> multiGraph = new Multigraph<>(DefaultWeightedEdge.class);
	    multiGraph.addVertex("v1");
	    multiGraph.addVertex("v2");
	    DefaultWeightedEdge edge1 = multiGraph.addEdge("v1", "v2");
	    multiGraph.setEdgeWeight(edge1, 5.0);

	    DefaultWeightedEdge edge2 = multiGraph.addEdge("v1", "v2");
	    multiGraph.setEdgeWeight(edge2, 3.0);

		JGraphXAdapter<String, DefaultWeightedEdge> graphAdapter = new JGraphXAdapter<String, DefaultWeightedEdge>(multiGraph);
		mxIGraphLayout layout = new mxCircleLayout(graphAdapter);
		layout.execute(graphAdapter.getDefaultParent());

		BufferedImage image = mxCellRenderer.createBufferedImage(graphAdapter, null, 2, Color.WHITE, true, null);
		ImageIO.write(image, "PNG", imgFile);
	}

}
