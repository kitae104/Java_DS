package graph.test;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.jgrapht.ext.JGraphXAdapter;
import org.jgrapht.graph.DefaultDirectedGraph;
import org.jgrapht.graph.DefaultEdge;

import com.mxgraph.layout.mxCircleLayout;
import com.mxgraph.layout.mxIGraphLayout;
import com.mxgraph.util.mxCellRenderer;

public class GraphTest2
{

	public static void main(String[] args) throws IOException
	{
		File imgFile = new File("src/graph/test/graph.png");
		// imgFile.createNewFile();

		DefaultDirectedGraph<String, DefaultEdge> g = new DefaultDirectedGraph<String, DefaultEdge>(DefaultEdge.class);

		String x1 = "x1";
		String x2 = "x2";
		String x3 = "x3";

		g.addVertex(x1);
		g.addVertex(x2);
		g.addVertex(x3);

		g.addEdge(x1, x2);
		g.addEdge(x2, x3);
		g.addEdge(x3, x1);

		JGraphXAdapter<String, DefaultEdge> graphAdapter = new JGraphXAdapter<String, DefaultEdge>(g);
		mxIGraphLayout layout = new mxCircleLayout(graphAdapter);
		layout.execute(graphAdapter.getDefaultParent());

		BufferedImage image = mxCellRenderer.createBufferedImage(graphAdapter, null, 2, Color.WHITE, true, null);
		ImageIO.write(image, "PNG", imgFile);
	}

}
