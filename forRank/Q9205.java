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

public class Q9205 {
	private static class Point{
		int x;
		int y;
		
		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
		
		public static int getDist(Point point1, Point point2){
			return Math.abs(point1.x - point2.x) + Math.abs(point1.y - point2.y);
		}
	}
	
	private static String getResult(ArrayList<Point> gs){
		Point start = gs.remove(0);
		Point end = gs.remove(gs.size() - 1);		
		
		Queue<Point> queue = new LinkedList<Point>();
		queue.add(start);
		
		while(!queue.isEmpty()){
			Point cur = queue.poll();
			
			if(Point.getDist(cur, end) <= 1000)
				return "happy";
			
			for (int i = 0; i < gs.size(); i++) {
				Point curGs = gs.get(i);
				
				if(Point.getDist(cur, curGs) <= 1000){
					queue.add(gs.remove(i--));
				}
			}
		}
		
		return "sad";
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int t = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < t; i++) {
			int n = Integer.parseInt(br.readLine());
			ArrayList<Point> gs = new ArrayList<Point>();
			
			for (int j = 0; j < n + 2; j++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				gs.add(new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
			}

			bw.write(getResult(gs) + "\n");
		}
		
		br.close();
		bw.close();
	}
}
