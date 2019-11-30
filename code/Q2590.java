package olympiad;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Q2590 {
	private static final int MAXSIZE = 6;
	private static int coloredPaper[];
	
	/*
	 * 해당 사이즈를 numbers 만큼 차감 
	 * return 양수 : 해당 사이즈 종이 아직 남음
	 * return 0 : 해당 사이즈의 종이를 정확히 소모함
	 * return 음수 : 해당 사이즈의 종이가 음수의 크기만큼 부족
	 * */
	private static int attach(int paperSize, int numbers){
		if(numbers <= 0)
			return 0;
		int dist = coloredPaper[paperSize] - numbers;
		if(dist >= 0)
			coloredPaper[paperSize] = dist;
		else
			coloredPaper[paperSize] = 0;
		
		return dist;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		coloredPaper = new int[MAXSIZE + 1];
		int total;
		
		//inputs
		for (int i = 1; i <= MAXSIZE; i++) {
			coloredPaper[i] = Integer.parseInt(br.readLine());
		}
		
		//6
		total = coloredPaper[6];
		attach(6, coloredPaper[6]);
		
		//5, 1
		total += coloredPaper[5];
		attach(1, coloredPaper[5] * 11);
		attach(5, coloredPaper[5]);
		
		//4, 2, 1
		total += coloredPaper[4];
		attach(1, -attach(2, coloredPaper[4] * 5) * 4);
		attach(4, coloredPaper[4]);
		
		//3, 2, 1
		total += coloredPaper[3] / 4;
		attach(3, coloredPaper[3] - coloredPaper[3] % 4);
		for (int i = 0; i < 3; i++) {
			if(coloredPaper[3] == 3 - i){
				total++;
				attach(1, -attach(2, 1 + 2 * i) * 4);
				attach(1, 5 + i);
			}
		}
		
		//2, 1
		while(coloredPaper[1] > 0 || coloredPaper[2] > 0){
			total++;
			attach(1, -attach(2, 9) * 4);
		}
		
		bw.write(total + "\n");
		
		br.close();
		bw.close();
	}
}
