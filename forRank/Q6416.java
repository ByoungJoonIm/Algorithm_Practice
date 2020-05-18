package forRank;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Q6416 {
	private static class Node{
		int start;
		int end;
		
		public Node(int start, int end){
			this.start = start;
			this.end = end;
		}
	}
	
	private static class Tree{
		int nodeNumber;
		ArrayList<Tree> subTree;
		int enterCounter;
		
		public Tree(int nodeNumber){
			this.nodeNumber = nodeNumber;
			subTree = new ArrayList<Tree>();
			enterCounter = 0;
		}
	}

	private static int getConnectedCount(int root, HashMap<Integer, Tree> hm){
		int count = 1;
		Tree curTree = hm.get(root);
		for (int i = 0; i < curTree.subTree.size(); i++) {
			count += getConnectedCount(curTree.subTree.get(i).nodeNumber, hm);
		}
		return count;
	}
	
	private static boolean isTree(ArrayList<Node> nodes){
		if(nodes.size() == 0)
			return true;
		
		HashMap<Integer, Tree> hm = new HashMap<Integer, Tree>();	//노드 찾을 때 사용
		ArrayList<Tree> al = new ArrayList<Tree>();					//루트를 찾을 때 사용
		
		for (int i = 0; i < nodes.size(); i++) {
			Node cur = nodes.get(i);
			if(!hm.containsKey(cur.start)){
				Tree tree = new Tree(cur.start);
				hm.put(cur.start, tree);
				al.add(tree);
			}
			if(!hm.containsKey(cur.end)){
				Tree tree = new Tree(cur.end);
				hm.put(cur.end, tree);
				al.add(tree);
			}
			
			Tree startTree = hm.get(cur.start);
			Tree endTree = hm.get(cur.end);
			
			startTree.subTree.add(endTree);
			endTree.enterCounter++;
		}
		
		int rootNumber = -1;
		
		for (int i = 0; i < al.size(); i++) {	//루트 찾기
			Tree tree = al.get(i);
			
			if(tree.enterCounter >= 2)
				return false;
			if(tree.enterCounter == 0){
				if(rootNumber > -1)	//root is already exist
					return false;
				rootNumber = tree.nodeNumber;
			}
		}
		
		if(rootNumber == -1)
			return false;
		
		return getConnectedCount(rootNumber, hm) == hm.size();	//노드수와 루트에 연결된 노드 수 비교
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		boolean isRunning = true;
		ArrayList<Boolean> result = new ArrayList<Boolean>();
		ArrayList<Node> nodes = new ArrayList<Node>();
		
		while (isRunning) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			while (st.hasMoreElements()) {
				int start = Integer.parseInt(st.nextToken());
				int end = Integer.parseInt(st.nextToken());

				if (start == -1) {
					isRunning = false;
					break;
				}
				
				if(start == 0){
					result.add(isTree(nodes));
					nodes.clear();
					break;
				}
				
				nodes.add(new Node(start, end));
			}

		}
		
		for (int i = 0; i < result.size(); i++) {
			bw.write("Case " + (i + 1) + " is ");
			if(!result.get(i))
				bw.write("not ");
			bw.write("a tree.\n");
		}

		br.close();
		bw.close();
	}
}
