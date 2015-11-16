import java.util.*;

public class StringExercises {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(forgivingPrompt("Are you 18 years old?"));
		System.out.println();
		System.out.println(parseName("Turing,Alan,Mathison"));
		System.out.println();
		System.out.println(add("0+31+4+81+9+10"));
	}

	public static boolean forgivingPrompt(String question) {
		System.out.println(question);
		Scanner scanner = new Scanner(System.in);
		String answer = scanner.next();
		if (answer.toLowerCase().equals("y") ||
				answer.toLowerCase().equals("yes") ||
				answer.toLowerCase().equals("yep"))
			return true;
		if (answer.toLowerCase().equals("n") ||
				answer.toLowerCase().equals("no") ||
				answer.toLowerCase().equals("nope")) 
			return false;
		System.out.println("Invalid input, try again");
		return forgivingPrompt(question);
	}
	
	public static String parseName(String s) {
		String lastName = "";
		String firstName = "";
		String middleName = "";
		String tempStr = s;
		int j = 0;
		for (j = 0; tempStr.charAt(j) != ','; j++);
		lastName = tempStr.substring(0, j);
		tempStr = tempStr.substring(++j);
		for (j = 0; tempStr.charAt(j) != ','; j++);
		firstName = tempStr.substring(0, j);
		middleName = tempStr.substring(++j);
		return firstName + " " + middleName + " " + lastName;
	}
	
	public static int add(String line) {
		if (line.isEmpty())
			return 0;
		String number = "";
		int i = 0;
		int startIndex = 0;
		int endIndex = 0;
		for (i = 0; i < line.length(); i++)
			if (Character.isDigit(line.charAt(i)))
				startIndex = i;
		for (; i < line.length() && Character.isDigit(line.charAt(i)); i++);
		endIndex = i;
		number = line.substring(--startIndex, endIndex);
		return  Integer.parseInt(number) + add(line.substring(endIndex));
	}
}

