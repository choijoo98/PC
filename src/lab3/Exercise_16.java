package lab3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Exercise_16 {

	private static Scanner input;
	private static BigRational ans;
	private static BigRational[] answers = new BigRational[9];
	

	public static void main(String[] args) {

		input = new Scanner(System.in);
		String a = input.nextLine();
		String[] token = a.split(" ");
		ArrayList<String> aList = new ArrayList<String>(Arrays.asList(token));
		BigRational[] operands = new BigRational[100];
		int a1 = isValidOperator(token);
		if (a1 == 1) {

			for (int i = 0; i < token.length; i++) {
				if (i % 2 == 0) {
					operands[i] = new BigRational(token[i]);
				} else
					operands[i] = null;
			}
			disjoin(operands, token);
			answers[2] = disjoinPlusOperation(aList, token);
			System.out.println(sum());

		} else {
			System.out.println(a1);
			System.exit(1);
		}

	}

	public static BigRational sum() {

		if (answers[0] == null && answers[1] != null && answers[2] == null) {
			ans = answers[1];
		} else if (answers[0] == null && answers[1] != null && answers[2] != null) {
			ans = answers[1];
			ans = ans.add(answers[2]);
		} else if (answers[0] != null && answers[1] == null && answers[2] != null) {
			ans = answers[0];
			ans = ans.add(answers[2]);
		} else if (answers[1] == null && answers[0] == null) {
			ans = answers[2];

		} else if (answers[1] != null && answers[0] != null && answers[2] == null) {
			ans = answers[0];
			ans = ans.add(answers[1]);

		} else if (answers[2] == null && answers[0] != null && answers[1] == null) {
			ans = answers[0];

		} else if (answers[2] == null && answers[1] != null && answers[0] == null) {
			ans = answers[1];

		} else if (answers[2] != null && answers[1] != null && answers[0] != null) {
			ans = answers[0];
			ans = ans.add(answers[1]);
			ans = ans.add(answers[2]);
		}
		return ans;
	}

	public static BigRational disjoinPlusOperation(ArrayList<String> aList, String[] token) {
		for (int i = 0; i < token.length; i++) {

			if (i % 2 != 0) {
				switch (token[i]) {
				case "*":
					aList.set(i, "x");
					aList.set(i + 1, "x");
					aList.set(i - 1, "x");
					break;
				case "/":
					aList.set(i, "x");
					aList.set(i + 1, "x");
					aList.set(i - 1, "x");
					break;
				}
			}
		}
		for (int i = 0; i < 100; i++) {

			aList.remove("x");
			aList.remove("+");
		}
		String[] array = aList.toArray(new String[aList.size()]);
        System.out.println("niilber: " + aList);
		int i = 0;
		int j1 = 0;
		BigRational ansList;
		BigRational[] listAnswers = new BigRational[9];
		while (j1 < aList.size()) {
			listAnswers[i] = new BigRational(array[j1]);
			i++;
			j1++;
		}
		ansList = listAnswers[0];
		for (int k = 1; k < aList.size(); k++) {

			ansList = ansList.add(listAnswers[k]);
		}
		System.out.println("niilber hariu: " + ansList);
		return ansList;
	}

	public static BigRational[] disjoin(BigRational[] operands, String[] token) {

		int i;
		ArrayList<String> aList1 = new ArrayList<String>();
		for (i = 0; i < token.length; i++) {
			if (i % 2 != 0) {
				switch (token[i]) {
				case "*":
					aList1.add(token[i - 1]);
					aList1.add(token[i]);
					aList1.add(token[i + 1]);
					token[i + 1] = " ";
					break;
				case "/":
					aList1.add(token[i - 1]);
					aList1.add(token[i]);
					aList1.add(token[i + 1]);
					token[i + 1] = " ";
					break;
				}
			}
		}
		for (i = 0; i < token.length; i++) {
			aList1.remove(" ");
		}

		ArrayList<String> aList2 = new ArrayList<String>();
		String[] array = aList1.toArray(new String[aList1.size()]);
		for (i = 0; i < array.length; i++) {
			switch (array[i]) {
			case "/":
				aList2.add(array[i - 1]);
				aList2.add(array[i + 1]);
				array[i + 1] = " ";
				aList1.set(i, "*");
				aList1.set(i + 1, "*");
				aList1.set(i - 1, "*");
				break;
			}
		}

		for (i = 0; i < 100; i++) {
			aList1.remove("*");
		}
		for (i = 0; i < aList2.size(); i++) {
			aList2.remove(" ");
		}
		String[] array1 = aList1.toArray(new String[aList1.size()]);
		String[] array2 = aList2.toArray(new String[aList2.size()]);

		BigRational[] list1Answers = new BigRational[9];
		BigRational[] list2Answers = new BigRational[9];
		int j = 0;
		i = 0;
		while (j < aList1.size()) {
			list1Answers[i] = new BigRational(array1[j]);
			i++;
			j++;
		}
        System.out.println(aList1);
        System.out.println(aList2);
		int d = 0;
		int l = 0;
		while (d < aList2.size()) {
			list2Answers[l] = new BigRational(array2[d]);
			l++;
			d++;
		}
		BigRational ansList1;
		BigRational ansList2;
		ansList1 = list1Answers[0];
		for (int k = 1; k < aList1.size(); k++) {

			ansList1 = ansList1.multiply(list1Answers[k]);
		}

		ansList2 = list2Answers[0];
		for (int k = 1; k < aList2.size(); k++) {

			ansList2 = ansList2.divide(list2Answers[k]);
		}

		answers[0] = ansList1;
		answers[1] = ansList2;
		System.out.println("urjver hariu: " + answers[0]);
		System.out.println("huvaah hariu: " + answers[1]);
		return answers;
	}

	public static int isValidOperator(String[] token) {

		int count1 = 0;
		int count2 = 0;
		for (int i = 0; i < token.length; i++) {

			if (i % 2 == 0) {
				if (token[i].matches("[\\d]*[0-9]/[\\d]*[0-9]")) {
					count1++;
				}
				if (token[i].matches("[\\-\\+\\*\\/]")) {
					return -1;
				}
			} else if (token[i].matches("[\\-\\+\\*\\/]")) {
				count2++;
			}

		}

		if (count1 == count2 + 1)
			return 1;
		else if (count2 > count1 && count2 + count1 == token.length
				|| count1 == count2 && count2 + count1 == token.length)
			return -1;
		else if (count2 + count1 < token.length)
			return 0;

		return 5;
	}

}
