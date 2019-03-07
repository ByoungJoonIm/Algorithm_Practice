#include <stdio.h>
#include <stdlib.h>

int execute(){
	int s, t, a, b;
	int n = 0;
	int arr[100000];

	scanf("%d %d %d %d", &s, &t, &a, &b);

	if( s == t )
		return 0;

	if( b == 1 ){
		if( (t-s) % a == 0)
			return (t-s) / a;
		return -1;
	}

	if( a == 1 ){
		while( t / b > s ){
			t = t / b;
			n++;
		}
		return n + (t - s);
	}

	arr[0] = t;
	n = 1;
	while( n < 20 ){
		int cnt = 0;
		int tmp;
		for(int i = (1<<n) - 1; i < (1 << (n+1))-1; i+=2){

			if( arr[i/2] == -1 ){
				arr[i] = -1;
				arr[i+1] = -1;
			}
			if( arr[i/2] - a > s ){
				arr[i] = tmp =  arr[i/2] - a;
				cnt++;
			} else 
				arr[i] = -1;
			if( arr[i/2] % b == 0 && arr[i/2] / b > s){
				arr[i+1] = tmp = arr[i/2] / b;
				cnt++;
			} else
				arr[i+1] = -1;
			if( arr[i/2] - a == s || arr[i/2] / b == s )
				return n;
		}
		if( cnt == 0 )
			return -1;
		if( cnt == 1 ){
			arr[0] = tmp;
			n = 0;
		}
		n++;
	}
}

void main(){
	int rs;
	int test_case;
	int *tmp;

	scanf("%d", &test_case);
	tmp = (int*)malloc(sizeof(int) * test_case);

	for(int i=0; i < test_case; i++)
		tmp[i] = execute();
	for(int i=0; i < test_case; i++)
		printf("#%d %d\n", i+1, tmp[i]);	
}
