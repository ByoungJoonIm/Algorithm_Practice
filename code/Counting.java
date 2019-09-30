package sort;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Counting {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bf = new BufferedWriter(new OutputStreamWriter(System.out));
		int N;
		int arr[];
		int sortedArr[];
		int max = 0;
		
		/*
		 * inputs
		 * */
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		sortedArr = new int[N];
		for (int i = 0; i < N; i++){
			arr[i] = Integer.parseInt(br.readLine());
			if(arr[i] > max)
				max = arr[i];
		}
		/*
		 * algoritm
		 * */
		
		int counts[] = new int[max + 1];	//0~10000
		
		for (int i = 0; i < N; i++)
			counts[arr[i]]++;
		
		//change to accumulated sum
		int sum = 0;
		for (int i = 0; i < max + 1; i++) {
			sum += counts[i];
			counts[i] = sum;
		}
		
		for (int i = N - 1; i >= 0; i--){
			sortedArr[(counts[arr[i]]) - 1] = arr[i];
			counts[arr[i]]--;
		}
		
		for (int i = 0; i < N; i++)
			bf.write(sortedArr[i] + "\n");
		bf.flush();
	}
}
