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
		//mirrorLine(3, new V2(5,2));
	
		//focus(new V3(2,1,4),new V3(3,0,1));
		basisChange(45,new V2(1,5),new V2(3,1));
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
	
	public static void focus(V3 E, V3 P){
		Camera cam = new Camera();
		cam.moveTo(E);
		cam.focus(P);
		System.out.println("Values for Cam: D = "+cam.D+"\nR = "+cam.R+"\nU = "+cam.U);
	}
	
	public static void terminalHastighed(double dragCoefficient){
		System.out.println("Terminal hastighed: = "+9.82/dragCoefficient);
		
	}
	
	public static void coordinatesInCameraPerspective(V3 Q, V3 E,V3 O){
		V3 OQ = Q.sub(O);
		V3 OE = E.sub(O);
		System.out.println(OQ.sub(OE));
	}
	
	public static void constAccAtSpeedT(){
		
	}
	
	public static void constAccPositionAtT(){
		
	}
	
	public static void constAccSPLAT(){
		
	}
	
	public static void basisChange(double angle, V2 P, V2 O){
		double radian = (Math.PI/180)*angle;
		V2 OP = P.sub(O);
		System.out.println("OP = "+ OP);
		System.out.println("U = [Cos("+angle+") , Sin("+angle+")] = ("+Math.cos(radian)+" , "+Math.sin(radian)+")");
		System.out.println("V = [-Sin("+angle+") , Cos("+angle+")] = ("+-Math.sin(radian)+" , "+Math.cos(radian)+")");
		//System.out.println( "+Math.cos(radian)+"\n");
		
		M2 Aminus = new M2(Math.cos(radian),Math.sin(radian),-Math.sin(radian),Math.cos(radian));
		System.out.println(Aminus.mul(OP));
	}
	
}
