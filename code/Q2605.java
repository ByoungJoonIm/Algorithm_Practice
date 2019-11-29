package olympiad;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Q2605 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		ArrayList<Integer> order = new ArrayList<Integer>();
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for (int i = 0; i < N; i++) {
			int selected = Integer.parseInt(st.nextToken());
			order.add(i - selected, i + 1);
		}
		
		for (int i = 0; i < N - 1; i++) {
			bw.write(order.get(i) + " ");
		}
		bw.write(order.get(N - 1) + "\n");
		
		br.close();
		bw.close();
	}

}
