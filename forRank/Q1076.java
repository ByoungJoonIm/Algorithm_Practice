package forRank;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Q1076 {
	private static int getValue(String color){
		switch(color){
		case "black":	return 0;
		case "brown":	return 1;
		case "red":		return 2;
		case "orange":	return 3;
		case "yellow":	return 4;
		case "green":	return 5;
		case "blue":	return 6;
		case "violet":	return 7;
		case "grey":	return 8;
		case "white":	return 9;
		}
		return -1;
	}
	
	private static long getMult(String color){
		return (long)Math.pow(10, getValue(color));
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String color1 = br.readLine();
		String color2 = br.readLine();
		String color3 = br.readLine();
		
		bw.write(((getValue(color1) * 10 + getValue(color2)) * getMult(color3)) + "\n");
		
		br.close();
		bw.close();
	}
}
