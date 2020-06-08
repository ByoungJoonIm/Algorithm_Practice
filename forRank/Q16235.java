package forRank;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q16235 {
	private static final int DEFAULT_CAPACITY = 1024;
	
	private static final int rowAdder[] = {-1, -1, -1, 0, 0, 1, 1, 1};
	private static final int colAdder[] = {-1, 0, 1, -1, 1, -1, 0, 1};
	
	private static int N, M, K;
	private static int map[][];
	private static int adder[][];
	private static ArrayList<Tree> treeMap[][];

	private static class Point{
		int row;
		int col;
		
		public Point(int row, int col){
			this.row = row;
			this.col = col;
		}
		
		public boolean isValid(){
			if(row > 0 && col > 0 && row <= N && col <=N)
				return true;
			return false;
		}
	}
	
	private static class Tree{
		int age;
		
		public Tree(int age){
			this.age = age;
		}
		
		public int eat(int food){
			int rest = food - age;
			
			if(rest >= 0){
				age++;
				return rest;
			}
			return -1;
		}
		
		@Override
		public boolean equals(Object obj){
			Tree tree = (Tree)obj;
			return this.age == tree.age;
		}
	}
	
	private static void insert(ArrayList<Tree> trees, Tree tree){
		if(trees.size() == 0 || trees.get(0).age >= tree.age){
			trees.add(0, tree);
			return;
		}
		
		int left = 0;
		int right = trees.size() - 1;
		
		while(left <= right){
			int mid = (left + right) / 2;
			
			if(tree.age == trees.get(mid).age){
				right = mid;
				break;
			} else if(tree.age > trees.get(mid).age){
				left = mid + 1;
			} else if(tree.age < trees.get(mid).age){
				right = mid -1;
			}
		}
		trees.add(right, tree);
	}
	
	private static int delete(ArrayList<Tree> trees, int index){
		int sum = 0;
		int size = trees.size();
		
		while(size > index){
			sum += trees.get(size - 1).age / 2;
			trees.remove(size - 1);
			size--;
		}
		
		return sum;
	}
	
	private static void year(){
		springSummer();
		fall();
		winter();
	}
	
	private static void springSummer(){
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				ArrayList<Tree> cur = treeMap[i][j];
				
				for (int k = 0; k < cur.size(); k++) {
					int eatResult = cur.get(k).eat(map[i][j]);
					
					if(eatResult >= 0){
						map[i][j] = eatResult;
					} else {
						map[i][j] += delete(cur, k);
						break;
					}
				}
			}
		}
	}
	
	private static void fall(){
		Queue<Point> queue = new LinkedList<Point>();
		
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				ArrayList<Tree> cur = treeMap[i][j];
				
				for (int k = 0; k < cur.size(); k++) {
					if(cur.get(k).age % 5 == 0){
						for (int l = 0; l < rowAdder.length; l++) {
							Point point = new Point(i + rowAdder[l], j + colAdder[l]);
							if(point.isValid())
								queue.add(point);
						}
					}
				}
			}
		}
		
		while(!queue.isEmpty()){
			Point cur = queue.poll();
			treeMap[cur.row][cur.col].add(0, new Tree(1));
		}
	}
	
	private static void winter(){
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				map[i][j] += adder[i][j];
			}
		}
	}
	
	private static int getTreeCount(){
		int sum = 0;
		
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				sum += treeMap[i][j].size();
			}
		}
		
		return sum;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		map = new int[N + 2][N + 2];
		adder = new int[N + 2][N + 2];
		treeMap = new ArrayList[N + 2][N + 2];
		
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				adder[i][j] = Integer.parseInt(st.nextToken());
				map[i][j] = 5;
				treeMap[i][j] = new ArrayList<Tree>(DEFAULT_CAPACITY);
			}
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int row = Integer.parseInt(st.nextToken());
			int col = Integer.parseInt(st.nextToken());
			int age = Integer.parseInt(st.nextToken());
			
			insert(treeMap[row][col], new Tree(age));
		}
		
		for (int i = 0; i < K; i++) {
			year();
		}
		
		bw.write(getTreeCount() + "\n");
		
		br.close();
		bw.close();
	}
}
