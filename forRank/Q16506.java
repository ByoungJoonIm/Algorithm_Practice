package forRank;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q16506 {
	private static String convert2binCode(String number, int size){
		int num = Integer.parseInt(number);
		char result[] = new char[size];
		
		for (int i = 0; i < result.length; i++)
			result[result.length - 1 - i] = ((1 << i) & num) > 0 ? '1' : '0';
		
		return String.valueOf(result);
	}
	
	private static String dispatcher(String command){
		String resultOP = "";
		StringTokenizer st = new StringTokenizer(command);
		
		String opString = st.nextToken();
		String rD = st.nextToken();
		String rA = st.nextToken();
		String rC = st.nextToken();
		
		switch(opString){
		case "NOT":
			return String.format("010100%s000%s0", convert2binCode(rD, 3), convert2binCode(rC, 3));
		case "ADD":
		case "ADDC":
			resultOP = "0000";
			break;
		case "SUB":
		case "SUBC":
			resultOP = "0001";
			break;
		case "MOV":
		case "MOVC":
			resultOP = "0010";
			break;
		case "AND":
		case "ANDC":
			resultOP = "0011";
			break;
		case "OR":
		case "ORC":
			resultOP = "0100";
			break;
		case "MULT":
		case "MULTC":			
			resultOP = "0110";
			break;
		case "LSFTL":
		case "LSFTLC":			
			resultOP = "0111";
			break;
		case "LSFTR":
		case "LSFTRC":
			resultOP = "1000";
			break;
		case "ASFTR":
		case "ASFTRC":
			resultOP = "1001";
			break;
		case "RL":
		case "RLC":
			resultOP = "1010";
			break;
		case "RR":
		case "RRC":
			resultOP = "1011";
			break;
		}
		
		if(opString.charAt(opString.length() - 1) == 'C')
			return String.format("%s10%s%s%s",
					resultOP, convert2binCode(rD, 3),
					convert2binCode(rA, 3), convert2binCode(rC, 4));
		
		return String.format("%s00%s%s%s0",
				resultOP, convert2binCode(rD, 3),
				convert2binCode(rA, 3), convert2binCode(rC, 3));
	}
		
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		for (int i = 0; i < N; i++) {
			String cmd = br.readLine();
			bw.write(dispatcher(cmd) + "\n");
		}
		
		br.close();
		bw.close();
	}
}
