package forRank;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;

public class Q2164 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		LinkedList<Integer> ll = new LinkedList<Integer>();
		//À§ -> First
		//¾Æ·¡ -> Last
		
		int N = Integer.parseInt(br.readLine());
		
		for (int i = 1; i <= N; i++) {
			ll.addLast(i);
		}
		
		while(ll.size() > 1){
			ll.removeFirst();
			ll.addLast(ll.removeFirst());
		}
		
		bw.write(ll.removeFirst() + "\n");
		
		br.close();
		bw.close();
	}
}
