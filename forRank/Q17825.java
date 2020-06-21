package forRank;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Q17825 {
	private static final int NUMBER_OF_PLAYER = 4;
	private static final int NUMBER_OF_TIMES = 10;
	
	private static Node start, finish;
	private static Node player[];
	private static int seq[];
	private static int dice[];
	private static int maxScore = 0;
	
	private static class Node{
		int value;
		Node redNext;
		Node blueNext;
		boolean onPlayer;
		
		public Node(int value) {
			this.value = value;
			redNext = null;
			blueNext = null;
			onPlayer = false;
		}
	}
	
	private static void connectNode(int startValue, int endValue, int weight, Node startNode, Node lastNode, boolean isBlueLine){
		Node cur = startNode;
		int i = startValue;
		
		if(isBlueLine){
			Node newNode = new Node(i);
			cur.blueNext = newNode;
			cur = cur.blueNext;
			i += weight;
		}
		
		if(weight > 0){
			for (; i <= endValue; i += weight) {
				Node newNode = new Node(i);
				cur.redNext = newNode;
				cur = cur.redNext;
			}
		} else {
			for (; i >= endValue; i += weight) {
				Node newNode = new Node(i);
				cur.redNext = newNode;
				cur = cur.redNext;
			}
		}
		cur.redNext = lastNode;
	}
	
	private static void init(){
		player = new Node[NUMBER_OF_PLAYER];
		dice = new int[NUMBER_OF_TIMES];
		seq = new int[NUMBER_OF_TIMES];
		start = new Node(0);
		finish = new Node(0);

		for (int i = 0; i < NUMBER_OF_PLAYER; i++)
			player[i] = start;
		
		ArrayList<Node> branch = new ArrayList<Node>();
		
		//바깥족 노드 구성
		connectNode(2, 40, 2, start, finish, false);
		Node centerNode = new Node(25);
		
		Node cur = start.redNext;
		while(cur.redNext!= null){
			if(cur.value % 10 == 0)
				branch.add(cur);
			cur = cur.redNext;
		}
		
		//분기 구성
		connectNode(13, 19, 3, branch.get(0), centerNode, true);
		connectNode(22, 24, 2, branch.get(1), centerNode, true);
		connectNode(28, 26, -1, branch.get(2), centerNode, true);
		connectNode(30, 35, 5, centerNode, branch.get(3), false);
	}
	
	private static void clearState(){
		for (int i = 0; i < NUMBER_OF_PLAYER; i++) {
			player[i].onPlayer = false;
			player[i] = start;
		}
	}
	
	private static int getScore(){
		int sum = 0;
		
		for (int i = 0; i < NUMBER_OF_TIMES; i++) {
			Node cur = player[seq[i]];

			if(cur == finish)
				return 0;
			
			cur.onPlayer = false;
			if(cur.blueNext == null){
				cur = cur.redNext;
			} else {
				cur = cur.blueNext;
			}
			
			for (int j = 0; j < dice[i] - 1; j++) {
				if(cur == finish)
					break;
				cur = cur.redNext;
			}
			
			if(cur != finish){
				if(cur.onPlayer)
					return 0;
				cur.onPlayer = true;
			}
			
			sum += cur.value;
			player[seq[i]] = cur;
		}
		
		return sum;
	}
	
	private static void setMaxScore(int depth){
		if(depth == NUMBER_OF_TIMES){
			clearState();
			maxScore = Math.max(maxScore, getScore());
			return;
		}
		
		for (int j = 0; j < NUMBER_OF_PLAYER; j++) {
			int temp = seq[depth];
			seq[depth] = j;
			setMaxScore(depth + 1);
			seq[depth] = temp;
		}
	}
	
	private static void printNode(Node node){
		if(node == null)
			return;
		
		String redNext = node.redNext == null ? "null" : node.redNext.value + "";
		String blueNext = node.blueNext == null ? "null" : node.blueNext.value + "";
		
		System.out.println(node.value + " / " + redNext + " / " + blueNext);

		printNode(node.redNext);
		printNode(node.blueNext);
	}
	
	private static void test(){
		printNode(start);
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		init();
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < NUMBER_OF_TIMES; i++) {
			dice[i] = Integer.parseInt(st.nextToken());
		}

		setMaxScore(0);

		bw.write(maxScore + "\n");
		
		br.close();
		bw.close();
	}
}
