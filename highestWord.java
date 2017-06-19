package scrabble;

public class highestWord {
private int score;
private String word;

public highestWord(){
	score = 0;
	word = "";
}
public void setWord(int s, String w){
	score=s;
	word=w;
}
public int getScore(){
	return score;
}
public String getWord(){
	return word;
}
}