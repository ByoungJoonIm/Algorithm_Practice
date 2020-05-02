package forRank;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Q2810 {
	private static boolean isRemain(int index, boolean visited[]){
		if(!visited[index]){
			visited[index] = true;
			return true;
		}
		if(!visited[index + 1]){
			visited[index + 1] = true;
			return true;
		}
		return false;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		String chairs = br.readLine();
		boolean visited[] = new boolean[n + 1];
		int counter = 0;
		
		for (int i = 0; i < n; i++) {
			char cur = chairs.charAt(i);
			
			if(cur == 'L' && chairs.charAt(i + 1) == 'L'){
				visited[i + 1] = true;
				if(isRemain(i, visited))
					counter++;
				i++;
			}
			if(isRemain(i, visited))
				counter++;
		}
		
		bw.write(counter + "\n");
		
		br.close();
		bw.close();
	}
}
