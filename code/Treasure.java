import java.util.Scanner;

public class Treasure {
	public static void main(String[] args) {
		solution1();
	}
	
	public static void swap(int arr[], int n, int m){
		int temp = arr[n];
		arr[n] = arr[m];
		arr[m] = temp;
	}
	
	public static void bubble(int dest[]){
		for (int i = dest.length - 1; i > 0; i--) {
			for (int j = 0; j < i; j++) {
				if(dest[j] > dest[j+1]){
					swap(dest, j, j+1);
				}
			}
		}
	}
	
	public static void solution1(){
		Scanner scan = new Scanner(System.in);
		int N;
		int A[];
		int B[];
		int Ss[];
		int S = 0;
		
		N = scan.nextInt();
		A = new int[N];
		B = new int[N];
		Ss = new int[N];
		
		for (int i = 0; i < N; i++) {
			A[i] = scan.nextInt();
		}
		for (int i = 0; i < N; i++) {
			B[i] = scan.nextInt();
		}
		
		Ss = B.clone();
		bubble(Ss);
		bubble(A);
		for (int i = 0; i < Ss.length; i++) {
			S += (Ss[i] * A[N - i - 1]);
		}
		
		System.out.println(S);
		scan.close();
	}
}
