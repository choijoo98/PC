package lab3;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Register {

	private static Scanner input;

	public static boolean checkValidId(String studentId, Pattern pattern) {
		Matcher matcher = pattern.matcher(studentId);
		return matcher.matches();
	}

	public static void main(String[] args) {

		Pattern p = Pattern.compile("([\\u0410-\\u045f\\u04af\\u04e9\\u0451]{2})([0-9]{2})([012][0-9]|3[012])([012][0-9]|3[01])([0-9]{2})");
		input = new Scanner(System.in);
		String register;
		
		register = input.nextLine();
		if (checkValidId(register, p) == true)
			System.out.println("Correct");
		else
			System.out.println("Incorrect");
	}
}
