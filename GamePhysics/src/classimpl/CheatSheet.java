package classimpl;


public class CheatSheet {
	
	/**
	 * 			 ( ͡° ͜ʖ ͡°)
	 * ( ͡° ͜ʖ ͡°)	Magic time!	( ͡° ͜ʖ ͡°)
	 * 			 ( ͡° ͜ʖ ͡°)
	 * @return 
	 */
	public static void main(String[] args) {
		
		// forskyd(new V2(4,3), new V2(1,-2));
		// forskyd(new V3(4,3,2), new V3(1,-2,0));
		
		//rotate(new V2(4,3), 30, new V2(0,0));
		mirrorLine(3, new V2(5,2));
	}

	public static void forskyd(V2 punkt, V2 vektor) {
		
		System.out.println(punkt.add(vektor));
	}
	
	public static void forskyd(V3 punkt, V3 vektor) {
		
		System.out.println(punkt.add(vektor));
	}
	
	public static void rotate(V2 punkt, double vinkel, V2 centrum) {
		
		V2 temp = punkt.sub(centrum);
		
		System.out.println(temp);
		System.out.println(temp.rotatematrix(vinkel, centrum));
	}
	
	public static void mirrorX(V2 v2) {
		
		System.out.println(v2.mirrorX());
	}
	
	public static void mirrorY(V2 v2) {
		
		System.out.println(v2.mirrorY());
	}
	
	public static void mirrorLine(double a, V2 punkt) {
		
		System.out.println(punkt.mirrorLine(a));
	}
	
	public static void matriceMult(M2 matrice1, M2 matrice2) {
		
		matrice1.mul(matrice2);
	}
	
	public static void matriceMult(M2 matrice, V2 vector) {
		
		matrice.mul(vector);
	}
	
}
