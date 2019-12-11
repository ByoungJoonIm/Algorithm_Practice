package olympiad;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Q2526 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int P = Integer.parseInt(st.nextToken());
		HashSet<Integer> allElem = new HashSet<Integer>();
		HashSet<Integer> cycle = new HashSet<Integer>();
		
		int number = N;
		while(true){
			number = number * N % P;
			if(cycle.contains(number))
				break;
			if(allElem.contains(number))
				cycle.add(number);
			else
				allElem.add(number);
		}

		bw.write(cycle.size() + "\n");
		
		br.close();
		bw.close();
	}
}
