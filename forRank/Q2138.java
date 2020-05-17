package forRank;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Q2138 {
	private static void click(int index, boolean array[]){
		for (int i = -1; i <= 1; i++)
			array[index + i] = !array[index + i];
	}
	
	private static int getSubCount(int N, boolean[] origin, boolean[] target, boolean firstClicked){
		int counter = 0;
		boolean copied[] = Arrays.copyOf(origin, origin.length);
		
		if(firstClicked){
			click(1, copied);
			counter++;
		}
		
		for (int i = 2; i <= N ; i++) {
			if(copied[i - 1] != target[i - 1]){
				click(i, copied);
				counter++;
			}
		}
		
		if(copied[N] == target[N])
			return counter;
		
		return -1;
	}
	
	private static int getCount(int N, boolean origin[], boolean target[]){
		int count = getSubCount(N, origin, target, false);
		
		return (count == - 1) ? getSubCount(N, origin, target, true) : count;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		boolean origin[] = new boolean[N + 2];
		boolean target[] = new boolean[N + 2];
		
		//inputs
		String line1 = br.readLine();
		String line2 = br.readLine();

		for (int i = 1; i <= N; i++) {
			if(line1.charAt(i - 1) == '1')
				origin[i] = true;
			if(line2.charAt(i - 1) == '1')
				target[i] = true;
		}
		
		bw.write(getCount(N, origin, target) + "\n");
		
		br.close();
		bw.close();
	}
}
