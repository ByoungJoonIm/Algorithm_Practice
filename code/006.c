#include <stdio.h>
#include <stdlib.h>
int main(void)
{
	int test_case;
	int T;
	char str[31];
	int cnt[26];
	
	setbuf(stdout, NULL);
	scanf("%d", &T);
	
	
	for (test_case = 1; test_case <= T; ++test_case){
		int i, n;
	        int rs = 0;
	        memset(cnt, 0, 26 * sizeof(int));
	        scanf("%d", &n);
	        getchar();getchar();
	        for(i = 0; i < n ; i++){
	        	gets(str);
		        cnt[str[0] - 'A']++;
	        }  
        
        	for(i = 0; i < 26; i++){
        		if(cnt[i] == 0)
		                break;
	        }
        
        	printf("#%d %d\n", test_case, i);
	}
	return 0; //정상종료시 반드시 0을 리턴해야 합니다.
}
