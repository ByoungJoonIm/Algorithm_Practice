package sort;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;

public class Statistics {

	public static void main(String[] args) throws Exception {
		final int Range = 8000;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int counts[] = new int[Range + 1];							//this is for counting sort
		int sortedArr[];											
		long sum = 0;												//this is for average
		int mode = 1;												//It will point frequent number.
		ArrayList<Integer> modeValues = new ArrayList<Integer>();	//It will have values in same frequent number.
		int maxValue = -4000;										//It and next value will use for range
		int minValue = 4000;
		int N;
		
		N = Integer.parseInt(br.readLine());
		sortedArr = new int[N];
		
		for (int i = 0; i < N; i++) {
			int temp = Integer.parseInt(br.readLine());
			sum += temp;
			if(temp > maxValue)
				maxValue = temp;
			if(temp < minValue)
				minValue = temp;
			temp = temp + Range/2;
			counts[temp]++;
		}
		
		int base = 0;
		for (int i = 0; i < Range + 1; i++) {
			if(counts[i] > 0){
				for (int j = 0; j < counts[i]; j++)
					sortedArr[j + base] = i - Range/2;
				base += counts[i];
				
				if(counts[i] == mode)
					modeValues.add(i - Range/2);
				else if(counts[i] > mode){
					modeValues.clear();
					modeValues.add(i - Range/2);
					mode = counts[i];
				}	
			}
		}

		Collections.sort(modeValues);
		
		System.out.println(Math.round((double)sum / N));
		System.out.println(sortedArr[N/2]);
		if(modeValues.size() > 1)
			System.out.println(modeValues.get(1));
		else
			System.out.println(modeValues.get(0));
		System.out.println(maxValue - minValue);
		
	}

}
