package olympiad;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Q10799 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String str = br.readLine();
		int cnt = 0;
		int rs = 0;
		
		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			
			if(ch == '('){
				char nextCh = str.charAt(i + 1);
				
				if(nextCh == ')'){	//cutting
					rs += cnt;
					i++;
				} else				// (°ýÈ£
					cnt++;
			} else if(ch == ')'){	// )°ýÈ£
				cnt--;
				rs++;
			}
		}
		
		bw.write(rs + "\n");
		
		br.close();
		bw.close();
	}
}
