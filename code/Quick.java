package sort;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class Quick {
	public static void main(String[] args) {
		/*
		 * definition
		 * */
		Scanner scan = new Scanner(System.in);
		BufferedWriter bf = new BufferedWriter(new OutputStreamWriter(System.out));
		
		
		int N;
		int arr[];
		
		/*
		 * inputs
		 * */
		N = scan.nextInt();
		arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = scan.nextInt();
		}
		/*
		 * algorithm
		 * */
		quickSort(arr);
	
		for (int i = 0; i < N; i++) {
//			System.out.println(arr[i]);
			try {
				bf.write(arr[i] + "\n");
				bf.flush();
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	}
	public static void quickSort(int[] arr){		//quick 정렬
		internalQuickSort(arr, 0, arr.length-1);
	}
	
	private static void internalQuickSort(int[] arr, int left, int right){		//quick정렬 내부 메소드. 재귀를 이용
		if(left > right)						//시작인덱스가 더 큰 경우 종료
			return ;
		int p = partition(arr,left,right);			//p는 파티션이 끝난 뒤에 사용된 피봇의 인덱스
		internalQuickSort(arr, left, p-1);		//앞부분
		internalQuickSort(arr, p+1, right);		//뒷부분
	}
	
	private static int partition(int arr[], int left, int right){
		int tmp = arr[left];					//pivot을 중간값과 바꿔서 평균 O(nlogn)이 되도록 함
		arr[left] = arr[(left + right) / 2];
		arr[(left + right) / 2] = tmp;
		int pivot = arr[left];		//맨 좌측 원소값을 pivot으로 잡음
		
		
		int p = left;			//p는 두 파티션의 경계 인덱스
		
		for(int i=left+1;i<=right;i++){	//a[i+1] ~ a[j]에 있는 모든 원소를 검사하여
			if(arr[i] < pivot){		//a[k]가 pivot보다 작으면 
				p++;				//p를 1 증가시켜 a[k]를 p인덱스 범위 안으로 포함되게 함
				int temp = arr[p];	//a[p] 와 a[k] 위치 교환
				arr[p] = arr[i];
				arr[i] = temp;
			}
		}
				
		int temp = arr[left];		//a[i]와 a[p]위치 교환
		arr[left] = arr[p];
		arr[p] = temp;
		
		return p;
	}
}


