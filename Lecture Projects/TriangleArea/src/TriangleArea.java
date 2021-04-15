
public class TriangleArea {
	public static void main(String[] args) {
		int base = 5;
		int height = 3;
		double area = base * height/2;
			System.out.println("The area is: " + area);
	double baseSquared = Math.pow(base,2.0);
	double heightSquared = Math.pow(height,2.0);
		double hypotenuse = Math.sqrt(baseSquared + heightSquared);
	System.out.println("The hypotenuse is:" + hypotenuse);
	}

}
