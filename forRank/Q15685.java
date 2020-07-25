package forRank;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Q15685 {
	private static class Point{
		int x;
		int y;
		
		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
		
		public Point(Point point){
			this(point.x, point.y);
		}
	}

	private static class DragonCurve{
		Point start;
		int gen;
		int direction;
		ArrayList<Point> subMap;
		private static boolean map[][] = new boolean[201][201];
		
		public DragonCurve(String str){
			StringTokenizer st = new StringTokenizer(str);
			start = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			this.direction = Integer.parseInt(st.nextToken());
			this.gen = Integer.parseInt(st.nextToken());
			subMap = new ArrayList<Point>();
			subMap.add(start);
		}
		
		public void generate(){
			//0 gen
			Point nextPoint;
			if(direction == 0){	//©Л
				nextPoint = new Point(start.x + 1, start.y);
			} else if(direction == 1){	//го
				nextPoint = new Point(start.x, start.y - 1);
			} else if(direction == 2){	//аб
				nextPoint = new Point(start.x - 1, start.y);
			} else {// if(direction == 3){	//╩С
				nextPoint = new Point(start.x, start.y + 1);
			}
			
			subMap.add(nextPoint);
			Point lastPoint = nextPoint;
			
			//1~gen	
			for (int i = 1; i <= gen; i++) {
				int size = subMap.size();
				
				for (int j = 0; j < size; j++){
					Point target = subMap.get(j);
					Point rotatedPoint = rotate(lastPoint, subMap.get(j));
					if(target.x != rotatedPoint.x || target.y != rotatedPoint.y)
						subMap.add(rotatedPoint);
				}
				
				lastPoint = rotate(lastPoint, start);
			}
		}
		
		public void mark(){
			DragonCurve.mark(subMap);
		}
		
		private Point rotate(Point base, Point target){
			Point rotatedPoint = new Point(target);
			rotatedPoint.x -= base.x;
			rotatedPoint.y -= base.y;
			
			int tempY = rotatedPoint.y;
			
			rotatedPoint.y = rotatedPoint.x;
			rotatedPoint.x = -tempY;
			
			rotatedPoint.x += base.x;
			rotatedPoint.y += base.y;
			
			return rotatedPoint;
		}
		
		private static int convert(int coord){
			if(coord < 0)
				return 100 + Math.abs(coord);
			if(coord <= 100)
				return coord;
			return -(coord - 100);
		}
		
		private static void mark(ArrayList<Point> subMap){
			for (int i = 0; i < subMap.size(); i++) {
				Point cur = subMap.get(i);
				map[convert(cur.x)][convert(cur.y)] = true;
			}
		}
		
		private static int getSquareCount(){
			int result = 0;
			
			for (int x = -100; x < 100; x++) {
				for (int y = -100; y < 100; y++) {
					if(map[convert(x)][convert(y)] &&
							map[convert(x + 1)][convert(y)] &&
							map[convert(x)][convert(y + 1)] &&
							map[convert(x + 1)][convert(y + 1)])
						result++;
				}
			}
			
			return result;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < N; i++) {
			DragonCurve dc = new DragonCurve(br.readLine());
			dc.generate();
			dc.mark();
		}
		
		bw.write(DragonCurve.getSquareCount() + "\n");
		
		br.close();
		bw.close();
	}
}
