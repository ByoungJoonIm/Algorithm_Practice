import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;

public class Hearsee {

	public static void main(String[] args) {
		solution1();
	}
	
	public static void solution1(){
		Scanner scan = new Scanner(System.in);
		int N;
		int M;
		String see[];
		HashSet<String> hear = new HashSet<String>();
		ArrayList<String> rs = new ArrayList<String>();
		
		N = scan.nextInt();
		M = scan.nextInt();
		
		see = new String[M];
		for (int i = 0; i < N; i++) {
			hear.add(scan.next());
		}
		for (int i = 0; i < M; i++) {
			see[i] = scan.next();
		}

		for (int i = 0; i < M; i++) {
			if(hear.contains(see[i]) && !rs.contains(see[i]))
				rs.add(see[i]);
		}

		Collections.sort(rs);
		System.out.println(rs.size());
		for (int i = 0; i < rs.size(); i++) {
			System.out.println(rs.get(i));
		}
		scan.close();
	}

}
