package homework.nnoco.hw1;

public class BracketPair {
	public final char open;
	public final char close;
	
	private BracketPair(char open, char close) {
		this.open = open;
		this.close = close;
	}

	public static BracketPair create(char open, char close) {
		return new BracketPair(open, close);
	}
}
