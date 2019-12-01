import java.io.File;

public class Driver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		runKruskalAndPrim();
	}
	public static void runShortestPath() {
		
	}
	public static void runKruskalAndPrim() {
		
		EdgeWeightedGraph ewg = createEWGraphFromFileName("large.txt");
		
		double kruskalTime = System.currentTimeMillis();
		KruskalMST kmst = new KruskalMST(ewg);
		kruskalTime = System.currentTimeMillis() - kruskalTime; //the time it took for kruskal to finish
		
		System.out.println("	Kruskal Finished in " + kruskalTime + " miliseconds. Result is:");
		for(Edge e : kmst.edges()) {
			System.out.print(e + " -> ");
		}
		
		double primTime = System.currentTimeMillis();
		PrimMST pmst = new PrimMST(ewg);
		primTime = System.currentTimeMillis() - primTime; //the time it took for normal prim to finish
		System.out.println();
		System.out.println("	Prim Finished in " + primTime + " miliseconds. Result is:");
		
		for(Edge e : pmst.edges()) {
			System.out.print(e + " -> ");
		}

		
		double lazyPrimTime = System.currentTimeMillis();
		PrimMST lpmst = new PrimMST(ewg);
		lazyPrimTime = System.currentTimeMillis() - lazyPrimTime; //the time it took for normal prim to finish
		System.out.println();
		System.out.println("	LazyPrim Finished in " + lazyPrimTime + " miliseconds. Result is:");
		for(Edge e : lpmst.edges()) {
			System.out.print(e + " -> ");
		}
	}
	
	private static EdgeWeightedGraph createEWGraphFromFileName(String fileName) {
		In in = new In(new File(fileName));
		EdgeWeightedGraph graph = new EdgeWeightedGraph(in);
		return graph;
		
	}
}
