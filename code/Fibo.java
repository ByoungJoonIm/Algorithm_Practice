
public class Fibo {

	public static void main(String[] args) {
		fibo_test(45);
	}
	
	public static void fibo_test(int n){
		long before_time;
		long after_time;
		long total_time;
		
		before_time = System.currentTimeMillis();
		System.out.println(fibo(n));
		after_time = System.currentTimeMillis();
		
		total_time = after_time - before_time;
		
		System.out.println("time : " + total_time);
		System.out.println("============================");
		
		before_time = System.currentTimeMillis();
		System.out.println(fibo_dp(n));
		after_time = System.currentTimeMillis();
		
		total_time = after_time - before_time;
		
		System.out.println("time : " + total_time);
		
	}

	/*
	 * This is recursive and top-down solution
	 * */
	public static int fibo(int n){
		if(n <= 2)
			return 1;
		return fibo(n-2) + fibo(n-1);
	}
	
	/*
	 * This is bottom-up solution
	 * */
	public static int fibo_dp(int n){
		if(n <= 2)
			return 1;
		
		int dp[] = new int[n + 1];
		dp[1] = 1;
		dp[2] = 1;
		
		for(int i = 3; i <= n; i++){
			dp[i] = dp[i-2] + dp[i-1];
		}
		
		return dp[n];
	}
	
}
