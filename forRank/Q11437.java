package forRank;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Q11437 {
	private static int N;
	private static int tree[][];	// parent, level
	
	private static int getCommonParent(int node1, int node2){
		int highNode = (tree[node1][1] <= tree[node2][1]) ? node1 : node2;	//레벨이 더 낮은 노드
		int lowNode = node1 == highNode ? node2 : node1;

		while(tree[highNode][1] < tree[lowNode][1])
			lowNode = tree[lowNode][0];
		
		while(highNode != lowNode){
			highNode = tree[highNode][0];
			lowNode = tree[lowNode][0];
		}
		
		return highNode;
	}
	
	private static void setTree(int node, ArrayList<Integer> treeList[]){
		for (int i = 0; i < treeList[node].size(); i++) {
			int child = treeList[node].get(i);
			
			if(tree[child][1] == 0){
				tree[child][0] = node;
				tree[child][1] = tree[node][1] + 1;
				setTree(child, treeList);
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		N = Integer.parseInt(br.readLine());
		tree = new int[N + 1][2];
		
		ArrayList<Integer> treeList[] = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++) {
			treeList[i] = new ArrayList<Integer>();
		}
		
		for (int i = 0; i < N - 1; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int node1 = Integer.parseInt(st.nextToken());
			int node2 = Integer.parseInt(st.nextToken());

			treeList[node1].add(node2);
			treeList[node2].add(node1);
		}
		
		tree[1][0] = 1;
		tree[1][1] = 1;
		setTree(1, treeList);
		
		int M = Integer.parseInt(br.readLine());
		for (int i = 0; i < M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int node1 = Integer.parseInt(st.nextToken());
			int node2 = Integer.parseInt(st.nextToken());
			
			bw.write(getCommonParent(node1, node2) + "\n");
		}
		
		br.close();
		bw.close();
	}
}
