package forRank;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class Q18870 {
	public static final int INIT_CAPACITY = 1000000;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		int inputs[] = new int[N];
		int sorted[] = new int[INIT_CAPACITY];
		int index = 0;
		
		Set<Integer> hs = new HashSet<Integer>(INIT_CAPACITY);
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			inputs[i] = Integer.parseInt(st.nextToken());;
			
			if(!hs.contains(inputs[i])){
				hs.add(inputs[i]);
				sorted[index++] = inputs[i];
			}
		}

		sorted = Arrays.copyOf(sorted, index);
		Arrays.sort(sorted);
		
		for (int i = 0; i < N; i++)
			bw.write(Arrays.binarySearch(sorted, inputs[i]) + " ");
		
		br.close();
		bw.close();
	}
}
