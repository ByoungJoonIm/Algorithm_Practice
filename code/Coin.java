/*
 * coin change problem
 * ref : http://comganet.github.io/dp/2016/06/03/dp-1002
 * */

import java.util.Scanner;

public class Coin {

	public static void main(String[] args) {
		coinChange1();
		//coinChange2();
	}
	
	//2 dimention array
	public static void coinChange2(){
		/*
		 * init and inputs
		 * */
		final int INF = Integer.MAX_VALUE - 2;
		Scanner scan = new Scanner(System.in);
		int coinN = scan.nextInt();		//the number of coins
		int coins[] = new int[coinN + 1];
		for(int i = 1; i < coins.length; i++)
			coins[i] = scan.nextInt();
		int target = scan.nextInt();	//the money which we need to meet		
		int d[][] = new int[coinN+1][target+1];
		
		
		for(int i = 1; i < target+1; i++)
			d[0][i] = INF;
		
		for(int i = 0; i < coinN + 1; i++)
			d[i][0] = 0;
		
		/*
		 * algorithm
		 * */
		
		for(int i = 1; i < coinN + 1; i++){
			for(int j = 1; j < target + 1; j++){
				if(coins[i] > j)
					d[i][j] = d[i-1][j];
				else if(d[i-1][j] > d[i][j-coins[i]] + 1)
					d[i][j] = d[i][j-coins[i]] + 1;
				else
					d[i][j] = d[i-1][j];
			}
		}
		
		if(d[coinN][target] == INF)
			System.out.println("impossible");
		else
			System.out.println(d[coinN][target]);
	}
	
	//1 demension array
	public static void coinChange1(){
		final int INF = Integer.MAX_VALUE - 2;
		Scanner scan = new Scanner(System.in);
		int coinN = scan.nextInt();
		int coins[] = new int[coinN + 1];
		for (int i = 1; i < coins.length; i++)
			coins[i] = scan.nextInt();
		
		int target = scan.nextInt();
		int d[] = new int[target + 1];
		
		for (int i = 1; i < target + 1; i++)
			d[i] = INF;
		//d[0] = 0;
		
		/*
		 * algorithm
		 * */
		for (int i = 1; i < coinN + 1; i++) {
			for (int j = coins[i]; j < target + 1; j++) {
				//if(coins[i] < j)
				if(d[j] > d[j-coins[i]] + 1)
					d[j] = d[j-coins[i]] + 1;
			}
		}
		
		if(d[target] == INF)
			System.out.println("impossible");
		else
			System.out.println(d[target]);
	}
	
}
