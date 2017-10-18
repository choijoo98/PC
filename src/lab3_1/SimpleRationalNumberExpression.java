package lab3_1;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class SimpleRationalNumberExpression {

	public SimpleRationalNumberExpression() {
		Scanner input = new Scanner(System.in);

		while (true) {
			System.out.println("expression: ");
			String expression = input.nextLine();
			System.out.println(calculate(lex(expression)));
		}
	}

	enum TokenType {
		NUM("\\d+/\\d+"), OPMUL("\\*"), OPDIV("/"), OPADD("\\+"), UNKNOWN(".+");

		public final String pattern;

		private TokenType(String pattern) {
			this.pattern = pattern;
		}
	}

	class Token {
		public TokenType type;
		public String data;

		public Token(TokenType type, String data) {
			this.type = type;
			this.data = data;
		}

		@Override
		public String toString() {
			return String.format("(%s %s)", type.name(), data);
		}
	}

	/**
	 * String expression split tokens
	 * 
	 * @param input
	 *            Simple rational number expression string
	 * @return Tokens list
	 */
	private ArrayList<Token> lex(String input) {
		// The tokens to return
		ArrayList<Token> tokens = new ArrayList<Token>();

		// Lexer logic begins here
		StringBuffer tokenPatternsBuffer = new StringBuffer();
		for (TokenType tokenType : TokenType.values())
			tokenPatternsBuffer.append(String.format("|(?<%s>%s)", tokenType.name(), tokenType.pattern));
		Pattern tokenPatterns = Pattern.compile(new String(tokenPatternsBuffer.substring(1)));

		// Begin matching tokens
		Matcher matcher = tokenPatterns.matcher(input);
		while (matcher.find()) {
			if (matcher.group(TokenType.NUM.name()) != null) {
				tokens.add(new Token(TokenType.NUM, matcher.group(TokenType.NUM.name())));
				continue;
			} else if (matcher.group(TokenType.OPMUL.name()) != null) {
				tokens.add(new Token(TokenType.OPMUL, matcher.group(TokenType.OPMUL.name())));
				continue;
			} else if (matcher.group(TokenType.OPDIV.name()) != null) {
				tokens.add(new Token(TokenType.OPDIV, matcher.group(TokenType.OPDIV.name())));
				continue;
			} else if (matcher.group(TokenType.OPADD.name()) != null) {
				tokens.add(new Token(TokenType.OPADD, matcher.group(TokenType.OPADD.name())));
				continue;
			} else if (matcher.group(TokenType.UNKNOWN.name()) != null) {
				tokens.add(new Token(TokenType.UNKNOWN, matcher.group(TokenType.UNKNOWN.name())));
				continue;
			}
		}

		return tokens;
	}

	public BigRational calculate(ArrayList<Token> tokens) {
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < tokens.size(); i++) {
			sb.append(tokens.get(i).type);
		}
		if (Pattern.matches(".*(UNKNOWN).*", sb.toString())) {
			return new BigRational();
		} else if (Pattern.matches("((NUM)((OPMUL)|(OPDIV)|(OPADD)))*(NUM)", sb.toString())) {
			BigRational val = new BigRational(tokens.get(0).data);
			for (int i = 1; i < tokens.size(); i += 2) {
				if (tokens.get(i).type == TokenType.OPMUL) {
					val.multiply(new BigRational(tokens.get(i + 1).data));
				} else if (tokens.get(i).type == TokenType.OPDIV) {
					val.divide(new BigRational(tokens.get(i + 1).data));
				} else if (tokens.get(i).type == TokenType.OPADD) {
					val.add(new BigRational(tokens.get(i + 1).data));
				}
			}
			System.out.println(val.toString());
			return val;
		} else {
			BigRational val = null;
			return val;
		}
	}

	public static void main(String[] args) {
		new SimpleRationalNumberExpression();
	}
}
