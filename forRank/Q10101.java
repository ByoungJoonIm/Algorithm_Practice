package forRank;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;

public class Q10101 {
	private static String getResult(int angles[]){
		HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
		int sum = 0;
		
		for (int i = 0; i < angles.length; i++) {
			if(hm.containsKey(angles[i])){
				hm.put(angles[i], hm.get(angles[i]) + 1);
			} else
				hm.put(angles[i], 1);
			
			sum += angles[i];
		}
		
		if(sum != 180)
			return "Error";
		
		if(hm.size() == 1)
			return "Equilateral";
		if(hm.size() == 2)
			return "Isosceles";
		return "Scalene";
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int angles[] = new int[] {
				Integer.parseInt(br.readLine()),
				Integer.parseInt(br.readLine()),
				Integer.parseInt(br.readLine())
		};
		
		bw.write(getResult(angles) + "\n");
		
		br.close();
		bw.close();
	}
}
