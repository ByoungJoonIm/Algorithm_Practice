package sort;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;

class Word implements Comparable<Word>{
	int len;
	String word;
	
	public Word(String word){
		this.len = word.length();
		this.word = word;
	}
	
	@Override
	public int compareTo(Word wd){
		if(len == wd.len){
			for (int i = 0; i < len; i++) {
				char wordc = word.charAt(i);
				char wdc = wd.word.charAt(i);
				if(wordc != wdc)
					return (int)wordc - (int)wdc;
			}
		}
		return len - wd.len;
	}
}

public class WordSort {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		ArrayList<Word> words = new ArrayList<Word>();
		int N;
		
		N = Integer.parseInt(br.readLine());
		for (int i = 0; i < N; i++)
			words.add(new Word(br.readLine()));
		
		Collections.sort(words);
		
		String beforeWord = null;		
		for (int i = 0; i < N; i++) {
			String temp = words.get(i).word;
			if(!temp.equals(beforeWord)){
				bw.write(temp + "\n");
			}
			beforeWord = temp;
		}
		br.close();
		bw.close();
	}
}
