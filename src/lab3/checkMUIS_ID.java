package lab3;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class checkMUIS_ID {

	private static Scanner input;

	public static boolean checkValidId(String studentId, Pattern pattern) {
		Matcher matcher = pattern.matcher(studentId);
		return matcher.matches();
	}

	public static void main(String[] args) {

		Pattern p = Pattern.compile("^([0-9]{2})[bmBM]([1-2]{1})(seas|SEAS)([0-9]{4})");
		input = new Scanner(System.in);
		String muis_id;
		System.out.print("Sisi ID:  ");
		muis_id = input.nextLine();
		if (checkValidId(muis_id, p) == true)
			System.out.println("Correct");
		else
			System.out.println("Incorrect");
	}
}
