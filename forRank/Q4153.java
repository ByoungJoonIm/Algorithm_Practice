package forRank;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q4153 {
	private static boolean isRight(int arr[]){
		return (int)Math.pow(arr[0], 2) + (int)Math.pow(arr[1], 2) == (int)Math.pow(arr[2], 2); 
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		while(true){
			StringTokenizer st = new StringTokenizer(br.readLine());
			int numbers[] = new int[3];
			for (int i = 0; i < 3; i++) {
				numbers[i] = Integer.parseInt(st.nextToken());
			}
			
			if(numbers[0] == 0 && numbers[1] == 0 && numbers[2] == 0)
				break;
			
			Arrays.sort(numbers);
			if(isRight(numbers))
				bw.write("right\n");
			else
				bw.write("wrong\n");
		}
		
		br.close();
		bw.close();
	}
}
