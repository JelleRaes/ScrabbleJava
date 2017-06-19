package scrabble;

import java.io.IOException;
import java.util.Scanner;

public class Scrabble {
public static void main(String[] args) throws IOException{
	Validator val = new Validator();
	@SuppressWarnings("resource")
	Scanner scan = new Scanner(System.in);
	String chars = scan.nextLine();
	StringBuffer str = new StringBuffer(chars);
	val.permutate(str,chars.length());
	val.removeDupe();
	val.scoreWord();
}
	
}
