package generatebeer;

public class Tokenizer {
	private String s;
	private int current;
	public Tokenizer(String s){
		this.s = s;
		current = 0;
	}
	
	public boolean hasMoreTokens(){
		return s.length() > current;
	}
	
	public String nextToken(){		
		String token = Character.toString(s.charAt(current));
		current ++;
		return token;
	}
	
	public String toString(){
		return s;
	}
	
	public String peekAtNextToken(){
		return Character.toString(s.charAt(current));
	}
	
}
