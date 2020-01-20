package forRank;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Q1991 {
	private static String preOrderRs = "";
	private static String midOrderRs = "";
	private static String postOrderRs = "";
	
	private static Tree findTree(Tree tree, char value){
		if(tree == null)
			return null;
		
		if(tree.value == value)
			return tree;
		
		Tree left = findTree(tree.left, value);
		Tree right = findTree(tree.right, value);
		
		if(left == null)
			return right;
		return left;
	}
	
	private static class Tree{
		char value;
		Tree left;
		Tree right;
		
		public Tree(char value){
			this.value = value;
			left = null;
			right = null;
		}
	}
	
	private static void preOrder(Tree tree){
		if(tree == null)
			return;
		preOrderRs += tree.value;
		preOrder(tree.left);
		preOrder(tree.right);
	}
	
	private static void midOrder(Tree tree){
		if(tree == null)
			return;
		midOrder(tree.left);
		midOrderRs += tree.value;
		midOrder(tree.right);
	}
	
	private static void postOrder(Tree tree){
		if(tree == null)
			return;
		postOrder(tree.left);
		postOrder(tree.right);
		postOrderRs += tree.value;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		Tree root = new Tree('A');
		
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			Tree tree = findTree(root, st.nextToken().charAt(0));
			char left = st.nextToken().charAt(0);
			char right = st.nextToken().charAt(0);
			
			if(left != '.')
				tree.left = new Tree(left);
			if(right != '.')
				tree.right = new Tree(right);
		}
		
		preOrder(root);
		midOrder(root);
		postOrder(root);
		bw.write(String.format("%s\n%s\n%s\n", preOrderRs, midOrderRs, postOrderRs));
		
		br.close();
		bw.close();
	}
}
