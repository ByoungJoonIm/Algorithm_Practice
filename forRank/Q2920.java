package forRank;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Q2920 {
	private static boolean isAscending(int arr[]){
		for (int i = 1; i <= 8; i++) {
			if(arr[i - 1] != i)
				return false;
		}
		return true;
	}
	
	private static boolean isDescending(int arr[]){
		for (int i = 1; i <= 8; i++) {
			if(arr[i - 1] != 9 - i)
				return false;
		}
		return true;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int arr[] = new int[8];
		
		for (int i = 0; i < 8; i++)			
			arr[i] = Integer.parseInt(st.nextToken());
			
		if(isAscending(arr))
			bw.write("ascending\n");
		else if(isDescending(arr))
			bw.write("descending\n");
		else
			bw.write("mixed\n");
		
		br.close();
		bw.close();
	}
}
