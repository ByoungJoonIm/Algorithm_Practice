package forRank;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Q10409 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int T = Integer.parseInt(st.nextToken());
		
		int completedTasks = 0;
		
		st = new StringTokenizer(br.readLine());
		while(T > 0 && completedTasks < n){
			T -= Integer.parseInt(st.nextToken());
			completedTasks++;
		}
		
		if(T < 0)
			completedTasks--;
		
		bw.write(completedTasks + "\n");
		
		br.close();
		bw.close();
	}
}
