package olympiad;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Q2608 {
	private static final char roma[] = {'I', 'V', 'X', 'L', 'C', 'D', 'M'};
	private static final int arab[] = {1, 5, 10, 50, 100, 500, 1000};
	private static final String extendedRoma[] = {"IV", "IX", "XL", "XC", "CD", "CM"};
	private static final String sameExpressionRoma[] = {"IIII", "VIIII", "XXXX", "LXXXX", "CCCC", "DCCCC"};
	
	private static String encode(int number){
		String encodedNumber = "";
		while(number > 0){
			for (int i = roma.length - 1; i >= 0; i--) {
				if(number - arab[i] >= 0){
					number -= arab[i];
					encodedNumber += roma[i];
					break;
				}
			}
		}
		
		for (int i = extendedRoma.length - 1; i >= 0; i--)
			encodedNumber = encodedNumber.replaceAll(sameExpressionRoma[i], extendedRoma[i]);
		
		return encodedNumber;
	}
	
	private static int decode(String number){
		int decodedNumber = 0;
		
		for (int i = 0; i < extendedRoma.length; i++)
			number = number.replaceAll(extendedRoma[i], sameExpressionRoma[i]);
		
		for (int i = 0; i < number.length(); i++) {
			char ch = number.charAt(i);
			for (int j = 0; j < roma.length; j++) {
				if(ch == roma[j]){
					decodedNumber += arab[j];
					break;
				}
			}
		}
		return decodedNumber;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String number1 = br.readLine();
		String number2 = br.readLine();
		
		int sum = decode(number1) + decode(number2);
		
		bw.write(sum + "\n");
		bw.write(encode(sum) + "\n");
		
		br.close();
		bw.close();
	}
}
