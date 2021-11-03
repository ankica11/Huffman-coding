package huffman;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;



public class HuffmansTree {
	
	
	//priority queue
	PriorityQueue<Node> pq = new PriorityQueue<Node>(new NodeComparator());
	HashMap<String,String> codeMap = new HashMap<String, String>();
	List<Node> visitedNodes = new ArrayList<Node>();
	
	
	//hash map
	HashMap<String, Float> charMap;
	
	public HuffmansTree(HashMap<String, Float> charMap) {
		this.charMap=charMap;
	}
	
	//huffmans algorithm
	public Node huffmansAlgorithm(){
		
		//adding external nodes initializing
		charMap.forEach((k,v) -> pq.add(new Node(v, k)));
		/*while(!pq.isEmpty()) {
		Node curr = pq.poll();
		System.out.println(curr.getWeight() + ": " + curr.getCharacter());
		}*/
		
		
		//creating tree
		int i=1;
		int max=charMap.size()-1;
		Node curr=null;
		while(i<=max) {
			Node left=pq.poll();
			Node right=pq.poll();
			float weight = left.getWeight()+right.getWeight();
		    curr = new Node(weight,"internal node"+i);
			curr.setLeft(left);
			curr.setRight(right);
			pq.add(curr);
			
			System.out.print("Iteration: " + i);
			System.out.print(" (" + left.getCharacter() + "," + left.getWeight() + "," + left.gettimestamp() +") ");
			System.out.print(" (" + right.getCharacter() + "," + right.getWeight() + "," + right.gettimestamp() +") ");
			System.out.println("------>(" + curr.getCharacter() + "," + curr.getWeight() + "," + curr.gettimestamp() +") ");
			
			/*Iterator<Node> itr = pq.iterator();
			while(itr.hasNext()) {
				Node nxt = itr.next();
				System.out.print(" (" + nxt.getCharacter() +"," + nxt.getWeight() + ")");
			}
			System.out.println("**********");
			
			*/
			i++;
		
		
	}
	
		return curr;
	

}
	
	public void levelOrder(Node root) {
		
		Node next = root;
		String bin="";
		visitedNodes.add(next);
		while(!visitedNodes.isEmpty()) {
			next=visitedNodes.remove(0);
			
			bin=next.getBinaryCode();
			if(next.getLeft()!=null) {
				
				next.getLeft().setBinaryCode(bin+"0");
				visitedNodes.add(next.getLeft());
			}
			if(next.getRight()!=null) {
				
				next.getRight().setBinaryCode(bin+"1");
				visitedNodes.add(next.getRight());
			}
			if(next.getLeft()==null && next.getRight()==null) {
				codeMap.put(next.getCharacter(), bin);
			}
			
		}
		
		codeMap.forEach((k,v)->System.out.println(k + ":" +v));
		
	}
}
