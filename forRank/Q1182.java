package forRank;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Q1182 {
	private static int array[];
	private static int N;
	private static int S;
	private static int rs = 0;
	
	private static void getNumbers(int index, int sum){
		if(index >= N)
			return;
		
		sum += array[index];
		
		if(sum == S)
			rs++;
		
		getNumbers(index + 1, sum);
		getNumbers(index + 1, sum - array[index]);
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		array = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++)
			array[i] = Integer.parseInt(st.nextToken());

		getNumbers(0, 0);
		
		bw.write(rs + "\n");
		
		br.close();
		bw.close();
	}
}
