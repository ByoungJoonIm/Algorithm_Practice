package forRank;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Q15686 {
	private static int N;
	private static int M;
	private static int minDist = Integer.MAX_VALUE;
	
	private static class Point{
		int row;
		int col;
		public Point(int row, int col) {
			this.row = row;
			this.col = col;
		}
	}

	private static class House extends Point{
		int dist;
		
		public House(int row, int col) {
			super(row, col);
		}
	}
	
	private static class ChickenShop extends Point{
		boolean using;
		
		public ChickenShop(int row, int col){
			super(row, col);
		}
	}
	
	private static void updateDist(ArrayList<House> houses, ArrayList<ChickenShop> chickenShops){
		for (int i = 0; i < houses.size(); i++)
			houses.get(i).dist = Integer.MAX_VALUE;
		
		for (int i = 0; i < chickenShops.size(); i++) {
			if(chickenShops.get(i).using){
				for (int j = 0; j < houses.size(); j++) {
					int dist = Math.abs(houses.get(j).row - chickenShops.get(i).row)
							+ Math.abs(houses.get(j).col - chickenShops.get(i).col);
					houses.get(j).dist = Math.min(dist, houses.get(j).dist);
				}	
			}
		}
	}
	
	private static int getTotalDist(ArrayList<House> houses){
		int sum = 0;
		
		for (int i = 0; i < houses.size(); i++) {
			sum += houses.get(i).dist;
		}
		
		return sum;
	}
	
	private static void solve(int depth, int index, ArrayList<House> houses, ArrayList<ChickenShop> chickenShops){
		if(depth == M){
			updateDist(houses, chickenShops);
			minDist = Math.min(minDist, getTotalDist(houses));
			return;
		}
		
		for (int i = index; i < chickenShops.size(); i++) {
			chickenShops.get(i).using = true;
			solve(depth + 1, i + 1, houses, chickenShops);
			chickenShops.get(i).using = false;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		ArrayList<House> houses = new ArrayList<House>();
		ArrayList<ChickenShop> chickenShops = new ArrayList<ChickenShop>();
		
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				int cur = Integer.parseInt(st.nextToken());
				if(cur == 1){
					houses.add(new House(i, j));
				} else if(cur == 2){
					chickenShops.add(new ChickenShop(i, j));
				}
			}
		}
		
		solve(0, 0, houses, chickenShops);
			
		bw.write(minDist + "\n");
		
		br.close();
		bw.close();
	}
}
