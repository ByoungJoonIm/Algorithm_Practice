package dynamicProgramming;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


//¹Ý·Ê Ã£´ÂÁß
public class LongestIncreasingSub {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int arr[] = new int[N];
		int d[] = new int[N];
		
		for (int i = 0; i < N; i++)
			arr[i] = Integer.parseInt(st.nextToken());
		
		for (int i = 0; i < N; i++) {
			d[i] = 1;
			for (int j = 0; j < i; j++) {
				if(arr[i] > arr[j] && d[i] < d[j] + 1)
					d[i] = d[j] + 1;
			}
		}
		
		int max = d[0];
		for (int i = 1; i < N; i++) {
			if(d[i] > max)
				max = d[i];
		}
		
		System.out.println(max);
	}
}
