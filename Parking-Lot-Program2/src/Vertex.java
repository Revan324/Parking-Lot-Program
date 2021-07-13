import java.util.*;

public class Vertex {

		private int startVertex;
		private int endVertex;
		private int weight;
		
		public Vertex(int startVertex, int endVertex, int weight) {
			this.startVertex = startVertex;
			this.endVertex = endVertex;
			this.weight = weight;
		}

		public int getStartVertex() {
			return startVertex;
		}

		public void setStartVertex(int startVertex) {
			this.startVertex = startVertex;
		}

		public int getEndVertex() {
			return endVertex;
		}

		public void setEndVertex(int endVertex) {
			this.endVertex = endVertex;
		}

		public int getWeight() {
			return weight;
		}

		public void setWeight(int weight) {
			this.weight = weight;
		}
		

}





