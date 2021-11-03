package huffman;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Main {

	public void creatingOutput(String inputFileName, String outputFileName) {
		File inputFile= new File("test/input.txt");
		File outputFile = new File("test/output.txt");
		try {
			outputFile.createNewFile();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void main(String[] args) throws IOException {
		
		File source = new File("test/input.txt"); //replace with command line argument
	    FileReader fileReader= new FileReader(source);
	    BufferedReader bufferedReader = new BufferedReader(fileReader);
	    int c= 0;
	    HashMap<String, Float> charactersMap = new HashMap<String, Float>();
    	
	    while((c=bufferedReader.read())!= -1) {
	    	char character = (char) c;
	    	String charToString = Character.toString(character);
	    	//System.out.print(character);
	    	float value = charactersMap.containsKey(charToString) ? charactersMap.get(charToString)+1 : 1;
	    	charactersMap.put(charToString, value);
	    	
	    }
	   
	    System.out.println("Number of characters in message: " + charactersMap.size());
	    charactersMap.forEach((key, val) -> charactersMap.put(key, val/charactersMap.size()));
	    if(!charactersMap.isEmpty()) {
	    	/*Iterator<Map.Entry<String, Integer>> iterator = charactersMap.entrySet().iterator();
	    	while(iterator.hasNext()) {
	    		System.out.println("character: " + iterator.next().getKey() + ", probability: " + iterator.next().getValue());
	    	}*/
	    	charactersMap.forEach((key, value) -> System.out.println("Character: " + key + ", probability: " + value));
	    	System.out.println("*****Priority queue*****");
	    	HuffmansTree ht = new HuffmansTree(charactersMap);
	    	Node root=ht.huffmansAlgorithm();
	    	if(root != null) {
	    		ht.levelOrder(root);
	    		
	    		File outputFile = new File("test/output.txt");
	    		try {
	    			outputFile.createNewFile();
	    			StringBuilder sb = new StringBuilder();
	    			File src = new File("test/input.txt");
	    		    FileReader fr = new FileReader(src);
	    		    BufferedReader br= new BufferedReader(fr);
	    		    int c1=0;
	    		    while((c1=br.read())!= -1) {
	    		    	char character = (char) c1;
	    		    	String charToString = Character.toString(character);
	    		    	System.out.print(character);
	    		    	sb.append(ht.codeMap.get(charToString));
	    		    	
	    		    	
	    		    }
	    		    
	    		    fr.close();
	    		    br.close();
	    		    FileWriter fw= new FileWriter(outputFile);
	    		    fw.write(sb.toString());
	    		    fw.close();
	    		    
	    			
	    			
	    		} catch (IOException e) {
	    			// TODO Auto-generated catch block
	    			e.printStackTrace();
	    		}
	    		
	    		
	    	}else {
	    		///empty
	    	}
	    	}
	    }
		
		

	}


