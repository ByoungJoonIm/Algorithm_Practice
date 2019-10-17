package sort;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

class Coordinates implements Comparable<Coordinates>{
	int x;
	int y;
	
	public Coordinates(int x, int y){
		this.x = x;
		this.y = y;
	}
	
	@Override
	public int compareTo(Coordinates coordinates){
		if(x == coordinates.x)
			return y - coordinates.y;
		return x - coordinates.x;
	}
	
	@Override
	public String toString(){
		return this.x + " " + this.y;
	}
}

public class CoordinatesSort {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N;
		ArrayList<Coordinates> arr = new ArrayList<Coordinates>();
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			arr.add(new Coordinates(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
		}
		
		Collections.sort(arr);
		for (int i = 0; i < N; i++) {
			System.out.println(arr.get(i));
		}	
	}
}
