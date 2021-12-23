import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * This class stores a decision tree that will run through a series of tests to determine the answer to the initial question. 
 * All tests will have yes/no answers.
 * 
 * @author williammacfarland
 * @version 11/10/2021
 */

public class DecisionTree {
	protected TreeNode<String> root;
	//location in the tree
	protected TreeNode<String> currNode;
	private Scanner file;
	
	/*
	 * Implementation of an inner TreeNode class so that 
	 * our DecisionTree can have Nodes
	 */
	protected class TreeNode<String> {
		private String data;
		private boolean fightNode;
		private TreeNode<String> right;
		private TreeNode<String> left;
		
		public TreeNode(String d, boolean f, TreeNode<String> l, TreeNode<String>  r) {
			this.data = d;
			this.fightNode = f;
			this.left = l;
			this.right = r;
		}
		
		public String getData() {
			return this.data;
		}
		
		public boolean isFightNode() {
			return this.fightNode;
		}
		
		public  TreeNode<String> getLeft() {
			return this.left;
		}
		
		public  TreeNode<String> getRight() {
			return this.right;
		}
		
		public void setLeft(TreeNode<String> newLeft) {
			this.left=newLeft;
		}
		
		public void setRight(TreeNode<String> newRight) {
			this.right=newRight;
		}
		
	}
	
	/**
	 * Creates a decision tree based on the specified file. 
	 * If the file does not exist, it prints that they file can't be found and exits the program.
	 * @param filename - - the file containing the data for the tree in preorder traversal. 
	 * The first line in the file will contain the question the decision tree is 
	 * answering then the following lines represent the tree itself. There is one test/result per line in the file. 
	 * All tests will have their last non-whitespace character be a question mark and any results will not end in a question mark.
	 */
	public DecisionTree(String filename) {
		currNode = root;
		try {
			this.file = new Scanner(new File(filename));
			this.root = add(file);
		} catch (FileNotFoundException e) {
			System.out.println("File not found");
		}
	}
	
	/**
	 * Determines if the current location is a test or the result of the decision tree
	 * @return true if the line in the file IS NOT a question
	 */
	public boolean isResult() {
		String data = currNode.getData();
		if (data.charAt(data.length()-1) == '?') {
			return false;
		}
		else {
			return true;
		}
	}
	
	
	public boolean isFightNode() {
		if (currNode.isFightNode()) {
			return true;
		}
		return false;
	}
	
	/**
	 * Restarts back at the start of the decision tree
	 */
	public void reset()  {
		currNode = root;
	}
	
	
	/**
	 * Gets the current test or result that the decision tree is currently at
	 * @return string format of the data where the current node is located
	 */
	public String getCurrentText() {
		String words = currNode.getData();
		words=words.replaceAll("\\.\\s?","\\.\n\n");
		return words;
	}
	
	
	/**
	 * 
	 * Determines the next test the decision tree will ask (or the result the decision tree will provide) if there is one.
	 *  If there is not another test (e.g. you are currently at the result or give an unacceptable answer), it throws an error.
	 * @param answer - the answer to the current test, must be yes or not
	 */
	public void nextQuestion(String answer) {
		if (!isResult() && answer.toLowerCase().charAt(0) == 'y') {
			currNode = currNode.getLeft();
		}
		else if (!isResult() && answer.toLowerCase().charAt(0) == 'n'){
			currNode = currNode.getRight();
		}
		else {
			throw new java.util.NoSuchElementException();
		}
	}
	
    public String toString() {        
    	String recStr = this.toString(this.root);        
    	return "[" + recStr.substring(0,recStr.length()-1) + "]";    
    }
    
    private String toString(TreeNode<String> current) {        
    	if (current ==  null) {            
    		return "";        
    	}        
    	return current.getData().toString() + "," + this.toString(current.getLeft()) + this.toString(current.getRight());    
   }
	
	/**
	 * private helper method that populates the tree from a file in pre-order 
	 * @param file - the file that the user has named 
	 * @return a TreeNode 
	 */
	private TreeNode<String> add(Scanner file) {
		String situation = "";
		while (file.hasNextLine()) {
			String line = file.nextLine();
			if (line.equals("#")) {
				break;
			}
			else {
				situation += line;
			}
		}
		
		if (situation.charAt(situation.length()-1) != '~') {
			TreeNode<String> newNode = new TreeNode<String>(situation, false, null, null);
			return newNode;
		}
		else {
			//create a node  --> next line
			if (situation.charAt(0) != '+') {
				TreeNode<String> newNode = new TreeNode<String>(situation.substring(0, situation.length()-1), false, null, null);
				//node.set left
				newNode.setLeft(this.add(file));
				//node.set right
				newNode.setRight(this.add(file));
				return newNode;
				
			}
			else {
				TreeNode<String> newNode = new TreeNode<String>(situation.substring(0, situation.length()-1), true, null, null);
				//node.set left
				newNode.setLeft(this.add(file));
				//node.set right
				newNode.setRight(this.add(file));
				return newNode;
			}

		}
	}
	
	
	
	
	
	
	

}
