package dynamicProgramming;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Stairs {
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(bf.readLine());
		int d[] = new int[N + 1];
		int arr[] = new int[N + 1];
		
		for (int i = 1; i <= N; i++)
			arr[i] = Integer.parseInt(bf.readLine());
		
		d[1] = arr[1];
		if (N > 1) 
			d[2] = d[1] + arr[2];
			
		for (int i = 3; i <= N; i++)
			d[i] = Math.max(arr[i] + d[i - 2], arr[i] + arr[i - 1] + d[i - 3]);
		
		System.out.println(d[N]);
		bf.close();
	}
}
