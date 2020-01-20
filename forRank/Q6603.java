package forRank;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Q6603 {
	private static int N;
	private static int numbers[];
	private static ArrayList<Integer> tmp;
	private static BufferedWriter bw;
	
	private static void print() throws IOException{
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < 6; i++)
			sb.append(tmp.get(i) + " ");
		
		bw.write(sb.toString().trim() + "\n");
	}
	
	private static void getCase(int cnt, int preVal) throws IOException{
		if(cnt == 6){
			print();
			return;
		}
		for (int i = 0; i < N; i++) {
			if(!tmp.contains(numbers[i]) && numbers[i] > preVal){
				tmp.add(numbers[i]);
				getCase(cnt + 1, numbers[i]);
				tmp.remove((Integer)numbers[i]);
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		tmp = new ArrayList<Integer>();
		
		while(true){
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			
			if(N == 0)
				break;
			
			numbers = new int[N];
			
			for (int i = 0; i < N; i++)
				numbers[i] = Integer.parseInt(st.nextToken());
			
			getCase(0, 0);
			bw.write("\n");
		}
		
		br.close();
		bw.close();
	}
}
