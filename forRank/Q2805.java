package forRank;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Q2805 {
	private static final int TREE_HEIGHT_MAX = 1000000000;
	private static int N;	//나무 수
	private static int M;	//집에 가져가려는 나무의 길이
	private static int trees[];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		//inputs
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		trees = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++)
			trees[i] = Integer.parseInt(st.nextToken());
		
		//algorithm
		int low = 0;					//L
		int high = TREE_HEIGHT_MAX;		//R
		int mid = 0;					//M
		
		//이 문제에서는 (탐색값 < arr[0])인 경우를 고려하지 않아도, 데이터 자체가 조건을 만족하게 주어짐
		while(low <= high){
			mid = (low + high) / 2;
			long sum = 0;
			
			for (int i = 0; i < N; i++)
				sum += ((trees[i] <= mid) ? 0: trees[i] - mid);
			
			if(sum == M){			//이진 탐색이 성공한 경우. 이 이외 경우는 모두 탐색 실패
				high = mid;			//탐색 실패시 high(R)를 사용하므로, 결과를 high에 저장
				break;
			} else if(sum > M){
				low = mid + 1;
			} else {
				high = mid - 1;
			}
		}
		
		bw.write(high + "\n");		//결과로 R번째 인덱스 출력. 이 문제에서는 인덱스를 바로 출력
		
		br.close();
		bw.close();
	}
}
