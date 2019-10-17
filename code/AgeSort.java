package sort;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

class Person implements Comparable<Person>{
	int age;
	String name;
	
	public Person(int age, String name){
		this.age = age;
		this.name = name;
	}
	
	public int compareTo(Person person){
		return age - person.age;
	}
	
	@Override
	public String toString(){
		return age + " " + name;
	}
}

public class AgeSort {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N;
		ArrayList<Person> people = new ArrayList<Person>();
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			people.add(new Person(Integer.parseInt(st.nextToken()), st.nextToken()));
		}
		Collections.sort(people);
		
		for (int i = 0; i < N; i++) {
			bw.write(people.get(i) + "\n");
		}
		br.close();
		bw.close();
	}
}
