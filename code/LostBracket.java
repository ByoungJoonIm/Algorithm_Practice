package greedy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class LostBracket {
	public static void main(String[] args) throws Exception {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		int total = 0;
		String operand = "";
		boolean isMinus = false;
		
		for (int i = 0; i < input.length(); i++) {
			char ch = input.charAt(i);
			int number;
			
			switch(ch){
			case '+':
			case '-':
				number = Integer.parseInt(operand);
				if(isMinus)
					total -= number;
				else
					total += number;
				operand = "";
				break;
			default:
				operand += ch;
			}
			if(ch == '-')
				isMinus = true;
		}
		int number = Integer.parseInt(operand);
		if(isMinus)
			total -= number;
		else
			total += number;
		
		bw.write(total + "\n");
		bw.flush();
	}

}
