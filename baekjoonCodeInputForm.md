# 입력 방법
- 백준은 기본적으로 (아마도) 파일 기반의 입력이 사용된다. 즉, 마지막 라인은 EOF로 판단이 가능한 것이다. 따라서 일반 IDE에서 정상 작동하지 않는 코드가 정상 작동될 수 있다. 예를 들어, 다음 코드는 IDE에서 정상 작동하지 않지만, 백준에서는 정답으로 간주된다.
  - 문제 : [백준 11718](https://www.acmicpc.net/problem/11718)
  - 코드
  ``` java
  package forRank;

  import java.io.BufferedReader;
  import java.io.BufferedWriter;
  import java.io.IOException;
  import java.io.InputStreamReader;
  import java.io.OutputStreamWriter;

  public class Q11718 {
	  public static void main(String[] args) throws IOException {
		  BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		  BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		  String str;
		
		  while((str = br.readLine()) != null)
			  bw.write(str + "\n");
		
		  bw.close();
	  }
  }

  ```
