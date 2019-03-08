/////////////////////////////////////////////////////////////////////////////////////////////
// 기본 제공코드는 임의 수정해도 관계 없습니다. 단, 입출력 포맷 주의
// 아래 표준 입출력 예제 필요시 참고하세요.
// 표준 입력 예제
// int a;
// float b, c;
// double d, e, f;
// char g;
// char var[256];
// long long AB;
// scanf(&quot;%d&quot;, &a);                      // int 변수 1개 입력받는 예제
// scanf(&quot;%f %f&quot;, &b, &c);               // float 변수 2개 입력받는 예제 
// scanf(&quot;%lf %lf %lf&quot;, &d, &e, &f);     // double 변수 3개 입력받는 예제
// scanf(&quot;%c&quot;, &g);                      // char 변수 1개 입력받는 예제
// scanf(&quot;%s&quot;, &var);                    // 문자열 1개 입력받는 예제
// scanf(&quot;%lld&quot;, &AB);                   // long long 변수 1개 입력받는 예제
/////////////////////////////////////////////////////////////////////////////////////////////
// 표준 출력 예제
// int a = 0;                            
// float b = 1.0, c = 2.0;               
// double d = 3.0, e = 0.0; f = 1.0;
// char g = &apos;b&apos;;
// char var[256] = &quot;ABCDEFG&quot;;
// long long AB = 12345678901234567L;
// printf(&quot;%d&quot;, a);                      // int 변수 1개 출력하는 예제
// printf(&quot;%f %f&quot;, b, c);                // float 변수 2개 출력하는 예제
// printf(&quot;%lf %lf %lf&quot;, d, e, f);       // double 변수 3개 출력하는 예제
// printf(&quot;%c&quot;, g);                      // char 변수 1개 출력하는 예제
// printf(&quot;%s&quot;, var);                    // 문자열 1개 출력하는 예제
// printf(&quot;%lld&quot;, AB);                   // long long 변수 1개 출력하는 예제
/////////////////////////////////////////////////////////////////////////////////////////////
#include <stdio.h>
#include <stdlib.h>
int main(void)
{
	int test_case;
	int T;
    char str[31];
    int cnt[26];
	/* 아래의 freopen 함수는 input.txt 를 read only 형식으로 연 후,
	앞으로 표준 입력(키보드) 대신 input.txt 파일로부터 읽어오겠다는 의미의 코드입니다.
	여러분이 작성한 코드를 테스트 할 때, 편의를 위해서 input.txt에 입력을 저장한 후,
	freopen 함수를 이용하면 이후 scanf 를 수행할 때 표준 입력 대신 파일로부터 입력을 받아올 수 있습니다.
	따라서 테스트를 수행할 때에는 아래 주석을 지우고 이 함수를 사용하셔도 좋습니다.
	단, 채점을 위해 코드를 제출하실 때에는 반드시 freopen 함수를 지우거나 주석 처리 하셔야 합니다.
	*/
	// freopen(&quot;input.txt&quot;, &quot;r&quot;, stdin);
	/* 아래 코드를 수행하지 않으면 여러분의 프로그램이 제한 시간 초과로 강제 종료 되었을 때,
	출력한 내용이 실제 표준 출력에 기록되지 않을 수 있습니다.
	따라서 안전을 위해 반드시 setbuf(stdout, NULL); 을 수행하시기 바랍니다.
	*/
	setbuf(stdout, NULL);
	scanf("%d", &T);
	/*
	여러 개의 테스트 케이스를 처리하기 위한 부분입니다.
	*/
	for (test_case = 1; test_case <= T; ++test_case)
	{
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