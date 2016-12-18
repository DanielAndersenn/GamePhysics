package classimpl;


public class CheatSheet {
	
	/**
	 * 			 ( ͡° ͜ʖ ͡°)
	 * ( ͡° ͜ʖ ͡°)	Magic time!	( ͡° ͜ʖ ͡°)
	 * 			 ( ͡° ͜ʖ ͡°)
	 * @return 
	 */
	public static void main(String[] args) {
		
		forskyd(new V2(4,3), new V2(1,-2));
		forskyd(new V3(4,3,2), new V3(1,-2,0));
		
		
	}

	
	
	public static void forskyd(V3 punkt, V3 vektor){
		System.out.println(punkt.add(vektor));
	}

	public static void forskyd(V2 punkt, V2 vektor) {
		
		System.out.println(punkt.add(vektor));
	}
	
}
