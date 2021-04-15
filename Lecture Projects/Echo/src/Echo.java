
public class Echo {
	public static void main(String[] args) {
		String input = args[0] + args[1] + args[2];
		int x = Integer.parseInt(args[0]);
		int y = Integer.parseInt(args[1]);
		int z = Integer.parseInt(args[2]);
		System.out.println("Your Word is " + input);
		System.out.println("Your Word is " + (x + y + z));


	}

}
