package forRank;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Q5430 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i < T; i++) {
			StringBuilder subSb = new StringBuilder("[");
			String cmd = br.readLine();
			int n = Integer.parseInt(br.readLine());
			String array = br.readLine();
			array = array.substring(1, array.length() - 1);
			StringTokenizer st = new StringTokenizer(array, ",");
			
			LinkedList<Integer> ll = new LinkedList<Integer>();
			
			for (int j = 0; j < n; j++) {
				ll.addLast(Integer.parseInt(st.nextToken()));
			}
			
			boolean isRightOrder = true;
			boolean isError = false;
			for (int j = 0; j < cmd.length(); j++) {
				char cmdChar = cmd.charAt(j);
				
				if(cmdChar == 'R'){
					isRightOrder = !isRightOrder;
				} else if(cmdChar == 'D'){
					if(ll.size() < 1){
						isError = true;
						break;
					}
					
					if(isRightOrder){
						ll.removeFirst();
					} else {
						ll.removeLast();
					}
				}
			}

			if(isError){
				sb.append("error\n");
			} else {
				sb.append('[');
				
				if(isRightOrder){
					while(ll.size() > 1)
						sb.append(ll.removeFirst()).append(',');
				} else {
					while(ll.size() > 1)
						sb.append(ll.removeLast()).append(',');
				}
				if(ll.size() == 1)
					sb.append(ll.removeFirst());
				sb.append("]\n");
			}
		}

		bw.write(sb.toString());
		
		br.close();
		bw.close();
	}
}
