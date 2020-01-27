package forRank;

public class Q15596 {
	long sum(int a[]){
		long amount = 0;
		
		for (int i = 0; i < a.length; i++)
			amount += a[i];
		
		return amount;
	}
}
