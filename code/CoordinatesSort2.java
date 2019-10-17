package sort;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

class Coordinates2 implements Comparable<Coordinates2>{
	int x;
	int y;
	
	public Coordinates2(int x, int y){
		this.x = x;
		this.y = y;
	}
	
	@Override
	public int compareTo(Coordinates2 coordinates2){
		if(y == coordinates2.y)
			return x - coordinates2.x;
		return y - coordinates2.y;
	}
	
	@Override
	public String toString(){
		return this.x + " " + this.y;
	}
}

public class CoordinatesSort2 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N;
		ArrayList<Coordinates2> arr = new ArrayList<Coordinates2>();
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			arr.add(new Coordinates2(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
		}
		
		Collections.sort(arr);
		for (int i = 0; i < N; i++) {
			System.out.println(arr.get(i));
		}	
	}
}
