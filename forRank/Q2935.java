package forRank;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Q2935 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		String operand1 = br.readLine();
		String operator = br.readLine();
		String operand2 = br.readLine();
		
		//plus
		if(operator.equals("+")){
			if(!operand1.equals(operand2)){
				for (int i = Math.max(operand1.length() - 1, operand2.length() - 1); i >= 0; i--) {
					if(i == operand1.length() - 1 || i == operand2.length() - 1)
						sb.append("1");
					else
						sb.append("0");
				}	
			} else {
				sb.append(operand1);
				sb.replace(0, 1, "2");
			}
		//mult		
		} else if(operator.equals("*")){
			sb.append(operand1);
			for (int i = 0; i < operand2.length() - 1; i++) {
				sb.append("0");
			}
		}
		
		bw.write(sb.toString() + "\n");
		
		br.close();
		bw.close();
	}
}
