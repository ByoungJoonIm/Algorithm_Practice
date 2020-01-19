package forRank;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Q6603 {
	private static int N;
	private static int numbers[];
	private static boolean isSelected[];
	private static BufferedWriter bw;
	
	private static void print() throws IOException{
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++){
			if(isSelected[i])
				sb.append(numbers[i] + " ");
		}
		
		bw.write(sb.toString().trim() + "\n");
	}
	
	private static void getCase(int cnt) throws IOException{
		if(cnt == 6){
			print();
			return;
		}
		for (int i = cnt; i < N; i++) {
			if(!isSelected[i]){
				isSelected[i] = true;
				getCase(cnt + 1);
				isSelected[i] = false;
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		while(true){
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			
			if(N == 0)
				break;
			
			numbers = new int[N];
			isSelected = new boolean[N];
			
			for (int i = 0; i < N; i++)
				numbers[i] = Integer.parseInt(st.nextToken());
			
			getCase(0);
			bw.write("\n");
		}
		
		br.close();
		bw.close();
	}
}
