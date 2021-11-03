package huffman;

import java.util.Calendar;
import java.util.Date;

public class Node {
	private static int serialnumber=0;
	
	private float weight;
	private String character;
	private Node left;
	private Node right;
	private long timestamp;
	private String binaryCode;
	
	public Node(float weight, String character) {
		this.weight=weight;
		this.character=character;
		this.left=null;
		this.right=null;
	    this.timestamp = ++serialnumber;
	    this.binaryCode="";
	}
	
	public Node getLeft() {
		return this.left;
	}
	
	public Node getRight() {
		return this.right;
	}
	
	public long gettimestamp() {
		return this.timestamp;
	}
	public String getBinaryCode() {
		return this.binaryCode;
	}
	
	public void setBinaryCode(String s) {
		this.binaryCode=s;
	}
	
	
   public void setWeight(float w) {
	   weight=w;
   }
   public void setLeft(Node leftSon) {
	   left=leftSon;
   }
   
   public void setRight(Node rightSon) {
	   right=rightSon;
   }
   
   public float getWeight() {
	   return this.weight;
   }
   
   public String getCharacter() {
	   return this.character;
   }
}
