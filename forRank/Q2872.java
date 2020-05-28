package forRank;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;

public class Q2872 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		//solution1
//		int N = Integer.parseInt(br.readLine());
//		int books[][] = new int[N][2];
//		
//		for (int i = 0; i < N; i++) {
//			books[i][0] = Integer.parseInt(br.readLine());
//			books[i][1] = i;
//		}
//		
//		Arrays.sort(books, new Comparator<int[]>(){
//			@Override
//			public int compare(int[] o1, int[] o2){
//				if(o1[0] == o2[0])
//					return o2[1] - o1[1];
//				return o1[0] - o2[0];
//			}
//		});
//		
//		boolean isPrinted = false;
//		
//		for (int i = N - 2; i >= 0 ; i--) {
//			//최대값보다 아래에 있는 경우
//			if(books[i][0] < books[N - 1][0] && books[i][1] > books[N - 1][1]){
//				bw.write(i + 1 + "\n");
//				isPrinted = true;
//				break;
//			}
//			
//			//이전 값이 현재값보다 크면서 자리가 맞지 않는 경우
//			if(books[i][0] < books[i + 1][0] && books[i][1] > books[i + 1][1]){
//				bw.write(i + 1 + "\n");
//				isPrinted = true;
//				break;
//			}
//		}
//		
//		if(!isPrinted)
//			bw.write("0\n");
//		
		
		//solution2
		int N = Integer.parseInt(br.readLine());
		int arr[] = new int[N];
		
		for (int i = 0; i < N; i++)
			arr[i] = Integer.parseInt(br.readLine());
		
		int last = N;
		int cnt = 0;
		
		for (int i = N - 1; i >= 0; i--) {
			if(arr[i] == last)
				last--;
			else
				cnt++;
		}
		
		bw.write(cnt + "\n");
		
		br.close();
		bw.close();
	}
}
