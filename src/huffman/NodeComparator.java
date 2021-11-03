package huffman;

import java.util.Comparator;

public class NodeComparator implements Comparator<Node>{

	@Override
	public int compare(Node o1, Node o2) {
		if(o1.getWeight()>o2.getWeight()) 
			return 1;
		if (o1.getWeight()<o2.getWeight()) 
			return -1;
		if(o1.getWeight()==o2.getWeight()) {
			if(o1.gettimestamp()>o2.gettimestamp())
				return 1;
			if(o1.gettimestamp()<o2.gettimestamp())
				return -1;
		}
		
		return 0;
		
	}
	
	
	

}
