import java.util.Scanner;

class Solution{
	public static void main(String args[]){
 		Scanner scan = new Scanner(System.in);
        
        int tc, N,M;
        tc = scan.nextInt();
        
        for(int t = 0; t < tc; t++){
            int sub_max = -1;
            
        	N = scan.nextInt();
        	M = scan.nextInt();
        	int arr[][] = new int[N][N];
        
        	for(int i = 0; i < N; i++){
         		for(int j = 0; j < N; j++){
                	arr[i][j] = scan.nextInt();
            	}
        	}
        
        	for(int i = 0; i < N - M + 1; i++){
         		for(int j = 0; j < N - M + 1; j++){
                	//get a sum
                    int sum = 0;
                    for(int a = 0; a < M; a++){
                     	for(int b = 0; b < M; b++){
                         	sum += arr[i+a][j+b];   
                        }
                    }
                    if( sum > sub_max)
                        sub_max = sum;
            	}
        	}
            
            System.out.println("#" + (t+1) + " " + sub_max);
        }
        
	}
}
