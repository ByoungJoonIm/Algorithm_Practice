package string;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;

public class GroupWordChecker {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		int cnt = 0;
		
		for (int i = 0; i < T; i++) {
			String str = br.readLine();
			HashSet<Character> hs = new HashSet<Character>();
			char beforeChar = str.charAt(0);
			
			for (int j = 1; j < str.length(); j++) {
				char ch = str.charAt(j);
				if(ch == beforeChar)
					continue;
				if(hs.contains(ch)){
					cnt--;
					break;
				}
				hs.add(beforeChar);
				beforeChar = ch;
			}
			cnt++;
		}

		System.out.println(cnt);
		br.close();
	}
}
