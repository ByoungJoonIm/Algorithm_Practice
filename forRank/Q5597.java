package forRank;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Q5597 {
	private static final int studentNumber = 30;
	private static final int notSubmittedStudentNumber = 2;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		boolean submitted[] = new boolean[studentNumber + 1];
		
		for (int i = 0; i < studentNumber - notSubmittedStudentNumber; i++) {
			submitted[Integer.parseInt(br.readLine())] = true;
		}
		
		for (int i = 1; i <= studentNumber; i++) {
			if(!submitted[i])
				bw.write(i + "\n");
		}
		
		br.close();
		bw.close();
	}
}
