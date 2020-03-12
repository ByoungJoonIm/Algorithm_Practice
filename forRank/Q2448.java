package forRank;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Q2448 {
	private static String createSpace(int n){
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < n; i++)
			sb.append(' ');
		
		return sb.toString();
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		int copiedN = N;
		int spaceCounter = N;
		int pow2 = 0;
		ArrayList<String> al = new ArrayList<String>();
		String tower[] = {"*", "* *", "*****"};
		
		//몇승인지 구하기
		copiedN /= 3;
		while( copiedN > 1){
			copiedN /= 2;
			pow2++;
		}
		
		//배열의 초기상태 셋팅 및 처음 3라인 출력
		for (int i = 0; i < tower.length; i++) {
			al.add(tower[i]);
			bw.write(createSpace(--spaceCounter) + tower[i] + createSpace(spaceCounter) + "\n");
		}
		
		//알고리즘
		for (int i = 1; i <= pow2; i++) {
			int size = al.size();
			for (int j = 0; j < size; j++) {
				StringBuilder sb = new StringBuilder(al.get(j));
				sb.append(createSpace(3 * (1 << i) - 1 - j * 2));
				sb.append(al.get(j));
				al.add(sb.toString());
				bw.write(createSpace(--spaceCounter) + sb.toString()  + createSpace(spaceCounter) +  "\n");
			}
		}
		
		br.close();
		bw.close();
	}
}
