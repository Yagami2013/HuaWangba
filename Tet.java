import java.lang.Math;
public class Tet{
	public static void main(String[] args){
		double a=45.0;
		double b=Math.tan(Math.toRadians(a));
		double degrees=Math.toDegrees(Math.atan(b));
		System.out.println(b);
		System.out.println(degrees);
	}
}