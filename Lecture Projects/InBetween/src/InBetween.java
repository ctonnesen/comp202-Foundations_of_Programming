public class InBetween {
	public static void main(String[] args) {
		int x = Integer.parseInt(args[0]);
		int y = Integer.parseInt(args[1]);
		int z = Integer.parseInt(args[2]);
	boolean InBetween = x < y && y < z || x >y && y > z;
	System.out.println(InBetween);
	}

}
