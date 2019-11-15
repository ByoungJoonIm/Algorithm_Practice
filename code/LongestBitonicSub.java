package dynamicProgramming;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class LongestBitonicSub {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int arr[] = new int[N];
		int di[] = new int[N];	//increase : di[i] = i를 가장 오른쪽으로 가지는 증가하는 부분수열
		int dd[] = new int[N];	//decrease : dd[i] = i를 가장 왼쪽으로 가지는 감소하는 부분수열
		
		for (int i = 0; i < N; i++)
			arr[i] = Integer.parseInt(st.nextToken());
		
		for (int i = 0, ri = N - i - 1; i < N; i++, ri--) {	//ri = reversed i
			di[i] = 1;
			dd[ri] = 1;
			for (int j = 0, rj = N - j - 1; j < i; j++, rj--) {	//rj = reversed j
				if(arr[i] > arr[j] && di[i] < di[j] + 1)
					di[i] = di[j] + 1;
				if(arr[ri] > arr[rj] && dd[ri] < dd[rj] + 1)
					dd[ri] = dd[rj] + 1;
			}
		}
		
		int max = di[0] + dd[0] - 1;
		for (int i = 1; i < N; i++) {
			if(di[i] + dd[i] - 1 > max)
				max = di[i] + dd[i] - 1;
		}
		
		System.out.println(max);
	}
}
