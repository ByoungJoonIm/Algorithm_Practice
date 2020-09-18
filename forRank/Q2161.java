package forRank;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class Q2161 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		Queue<Integer> queue = new LinkedList<Integer>();
		
		for (int i = 1; i <= N; i++)
			queue.add(i);
		
		while(queue.size() > 1){
			sb.append(queue.poll()).append(' ');
			queue.add(queue.poll());
		}
		
		sb.append(queue.poll());
		bw.write(sb.toString() + "\n");
		
		br.close();
		bw.close();
	}
}
