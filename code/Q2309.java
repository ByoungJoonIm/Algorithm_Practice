package olympiad;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Q2309 {	
	public static void main(String[] args) throws Exception {
		final int NUMOFPEOPLE = 9;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int sum = 0;
		int index1 = -1;
		int index2 = -1;
		int people[] = new int[NUMOFPEOPLE];
		
		for (int i = 0; i < NUMOFPEOPLE; i++){
			people[i] = Integer.parseInt(br.readLine());
			sum += people[i];
		}
		Arrays.sort(people);
		
		for (int i = 1; i < NUMOFPEOPLE; i++) {
			if(index1 > -1)
				break;
			for (int j = 0; j < i; j++) {
				if(sum - people[i] - people[j] == 100){
					index1 = i;
					index2 = j;
					break;
				}
			}
		}
		
		for (int i = 0; i < NUMOFPEOPLE; i++) {
			if(i != index1 && i != index2)
				bw.write(people[i] + "\n");
		}
		bw.close();
		br.close();
	}
}
