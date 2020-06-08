package forRank;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Q17140 {
	private static final int INIT_SIZE = 3;
	
	private static int map[][];
	private static int R, C;
	private static int targetRow, targetCol, targetValue;
	
	private static class Number implements Comparable<Number>{
		int number;
		int count;
		
		public Number(int number, int count) {
			this.number = number;
			this.count = count;
		}
		
		@Override
		public int compareTo(Number number){
			if(this.count == number.count)
				return this.number - number.number;
			return this.count - number.count;
		}
	}
	
	private static int sort(boolean isRowSort, int index){
		int maxLen = 0;
		HashSet<Integer> hs = new HashSet<Integer>();
		ArrayList<Number> al = new ArrayList<Number>(128);
		int counts[] = new int[101];
		
		
		if(isRowSort){
			for (int i = 0; i < 100; i++) {
				if(map[index][i] > 0){
					counts[map[index][i]]++;
				} 
			}
		} else {
			for (int i = 0; i < 100; i++) {
				if(map[i][index] > 0)
					counts[map[i][index]]++;
			}
		}
		
		for (int i = 1; i <= 100; i++) {
			if(counts[i] > 0)
				al.add(new Number(i, counts[i]));
		}
		
		Collections.sort(al);
		maxLen = al.size() * 2;
		
		if(maxLen > 100)
			maxLen = 100;
		
		if(isRowSort){
			for (int i = 0; i < maxLen / 2; i++) {
				Number cur = al.get(i);
				map[index][i * 2] = cur.number;
				map[index][i * 2 + 1] = cur.count;
			}
			for (int i = maxLen; i < C; i++)
				map[index][i] = 0;
		} else {
			for (int i = 0; i < maxLen / 2; i++) {
				Number cur = al.get(i);
				map[i * 2][index] = cur.number;
				map[i * 2 + 1][index] = cur.count;
			}
			for (int i = maxLen; i < R; i++) {
				map[i][index] = 0;
			}
		}
		
		return maxLen;
	}
	
	private static void sortAll(){
		boolean isRowSort = R >= C;
		int tempLen = 0;
		
		
		if(isRowSort){
			for (int i = 0; i < R; i++)
				tempLen = Math.max(tempLen, sort(isRowSort, i));
			C = tempLen;
		} else {
			for (int i = 0; i < C; i++)
				tempLen = Math.max(tempLen, sort(isRowSort, i));
			R = tempLen;
		}
	}
	
	private static boolean checked(){
		return map[targetRow][targetCol] == targetValue;
	}
	
	private static void test(){
		for (int i = 0; i < 100; i++) {
			printMap();
			System.out.println("----------------------" + i);
			sortAll();	
		}
		printMap();
	}
	
	private static void printMap(){
		System.out.println("R : " + R + "\nC : " + C);
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	private static int getTime(){
		for (int i = 0; i <= 100; i++) {
			if(checked())
				return i;
			sortAll();
		}
		
		return -1;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		R = INIT_SIZE;
		C = INIT_SIZE;
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		targetRow = Integer.parseInt(st.nextToken()) - 1;
		targetCol = Integer.parseInt(st.nextToken()) - 1;
		targetValue = Integer.parseInt(st.nextToken());
		map = new int[100][100];
		
		for (int i = 0; i < INIT_SIZE; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < INIT_SIZE; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		bw.write(getTime() + "\n");
		
		br.close();
		bw.close();
	}
}
