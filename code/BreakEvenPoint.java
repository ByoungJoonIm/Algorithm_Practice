package mathmatics;

import java.util.Scanner;

public class BreakEvenPoint {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int A = scan.nextInt();
		int B = scan.nextInt();
		int C = scan.nextInt();
		int distance = C - B;
		
		if(distance <= 0)
			System.out.println(-1);
		else
			System.out.println(A / distance + 1);
	}
}
