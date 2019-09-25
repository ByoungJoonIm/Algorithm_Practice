package greedy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class ConferenceRoom {

	public static void main(String[] args) throws Exception {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N;
		int start[];
		int end[];
		int curTime = 0;
		int rs = 0;

		/*
		 * inputs
		 */
		N = Integer.parseInt(br.readLine());
		start = new int[N];
		end = new int[N];

		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			start[i] = Integer.parseInt(str.split(" ")[0]);
			end[i] = Integer.parseInt(str.split(" ")[1]);
		}

		quickSort(end, start);

		for (int i = 0; i < N; i++) {
			if (start[i] < curTime)
				continue;
			
			int minIndex = i;
			for (int j = i; j < N; j++) {
				if (end[i] != end[j])
					break;
				if (start[j] < start[i]){
					minIndex = j;
				}
					
			}
			int temp = start[minIndex];
			start[minIndex] = start[i];
			start[i] = temp;
			
			curTime = end[i];
			rs++;
		}
		

		bw.write(rs + "\n");
		bw.flush();
	}

	private static void quickSort(int[] start, int[] end) { // quick 정렬
		internalQuickSort(start, end, 0, start.length - 1);
	}

	private static void internalQuickSort(int[] start, int[] end, int left, int right) { // quick정렬
																							// 내부
																							// 메소드.
																							// 재귀를
																							// 이용
		if (left > right) // 시작인덱스가 더 큰 경우 종료
			return;
		int p = partition(start, end, left, right); // p는 파티션이 끝난 뒤에 사용된 피봇의 인덱스
		internalQuickSort(start, end, left, p - 1); // 앞부분
		internalQuickSort(start, end, p + 1, right); // 뒷부분
	}

	private static int partition(int start[], int end[], int left, int right) {
		int tmp = start[left]; // pivot을 중간값과 바꿔서 평균 O(nlogn)이 되도록 함
		start[left] = start[(left + right) / 2];
		start[(left + right) / 2] = tmp;
		tmp = end[left];
		end[left] = end[(left + right) / 2];
		end[(left + right) / 2] = tmp;

		int pivot = start[left]; // 맨 좌측 원소값을 pivot으로 잡음

		int p = left; // p는 두 파티션의 경계 인덱스

		for (int i = left + 1; i <= right; i++) { // a[i+1] ~ a[j]에 있는 모든 원소를
													// 검사하여
			if (start[i] < pivot) { // a[k]가 pivot보다 작으면
				p++; // p를 1 증가시켜 a[k]를 p인덱스 범위 안으로 포함되게 함
				int temp = start[p]; // a[p] 와 a[k] 위치 교환
				start[p] = start[i];
				start[i] = temp;
				temp = end[p];
				end[p] = end[i];
				end[i] = temp;
			}
		}

		int temp = start[left]; // a[i]와 a[p]위치 교환
		start[left] = start[p];
		start[p] = temp;
		temp = end[left];
		end[left] = end[p];
		end[p] = temp;

		return p;
	}

}
