package scrabble;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Validator {
 private ArrayList<String> lijst= new ArrayList<String>();
	public Validator(){
		
	}
	
	public void permutate(StringBuffer str, int index) throws IOException{
		if(index <= 0){			
			System.out.println(str);lijst.add(str.toString());				
		}
	    else {
	        permutate(str, index-1);
	        int currPos = str.length()-index;
	        for (int i = currPos+1; i < str.length(); i++) {
	            swap(str,currPos, i);
	            permutate(str, index-1);
	            swap(str,i, currPos);
	        }
	    }
	
	}
	
	private void swap(StringBuffer str, int pos1, int pos2){
	    char t1 = str.charAt(pos1);
	    str.setCharAt(pos1, str.charAt(pos2));
	    str.setCharAt(pos2, t1);
	}
	
	public void removeDupe(){
		Set<String> hs = new HashSet<>();
		hs.addAll(lijst);
		lijst.clear();
		lijst.addAll(hs);
		System.out.println("sorted");
		for(String b: lijst){
			System.out.println(b);
		}
	}
	
	public void scoreWord() throws IOException{
		highestWord word= new highestWord();
		for(String s: lijst){
			if(checkViable(s)==true){
				int score = 0;
				StringBuffer chars=new StringBuffer(s);
				for(int i=0;i<chars.length();i++){
					switch(chars.charAt(i)){
					case 'z':
					case 'x':
					case 'q': score+=10;break;
					case 'y': score+=8;break;
					case 'c':
					case 'o':
					case 'u': score +=5;break;
					case 'f':
					case 'i':
					case 'l':
					case 'v':score+=4;break;
					case 'a':
					case 'e':
					case 'g':
					case 'h':
					case 'k':
					case 'n':
					case 'p': score+=3;break;
					case 'b':
					case 'd':
					case 'j':
					case 'r':
					case 't':
					case 'w': score+=2;break;
					case 'm':
					case 's': score+=1;break;
					default: score+=0;break;
					}
				}
				if(score>word.getScore()){
					word.setWord(score, s);
				}
			}
			else{
				lijst.remove(s);
			}
		}
		System.out.println("word with highest value is: "+word.getWord()+" with a value of: "+word.getScore());
	}
	
	
	
	private Boolean checkViable(String str) throws IOException{
		Boolean check= false;		
		Scanner text = new Scanner(new File("D:\\workspace\\scrabble\\bin\\scrabble\\words.txt"));
		while (text.hasNextLine() || check==false){
			String woord=text.nextLine();
			if(woord.equals(str)){
				check= true;
				break;
			}
			//System.out.println(woord);
	
		}
		text.close();
		return check;			
	}
	
}