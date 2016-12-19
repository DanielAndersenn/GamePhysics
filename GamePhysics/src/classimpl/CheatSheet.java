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
		//basisChangeAngle(45,new V2(1,5),new V2(3,1));
		//basisChangeLine(0.5,0.5,new V2(2,7),new V2(1,1));
	
		//constAccAtSpeedT(0,9.82,2.43);
		//constAccPositionAtT(0,41.15,-9.82,2.9);
		//constAccSPLAT(41.15,9.82);
		
		
		System.out.println(kmhTOms(89));
		System.out.println(msTOkmh(kmhTOms(89)));
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
	
	//Metode taget fra BrooklynBridge V();
	public static void constAccAtSpeedT(double v0, double acc, double t){
	//v0 = Start hastighed - m/s
	//acc = Acceleration - m/s^2
	//t = Den �nskede tid - s
	double result = v0+acc*t;
	System.out.println("v(t) = v0 + a * t = "+v0+" + " + acc +" * "+ t +" \n= " + result+" m/s");
	}
	
	public static void constAccPositionAtT(double v0, double x0, double acc, double t){
		//v0 = start hastighed - m/s
		//x0 = start position - m
		//Acc = Acceleration - m/s^2
		//t = tid - s
		double result = x0 + v0 * t + 0.5 * acc * Math.pow(t, 2);
		System.out.println("x(t) = "+x0+" + "+v0+" * "+t+" + 0.5 * "+acc+" * "+t+"^2 \n= "+result+" m");
		
	}
	
	public static void constAccSPLAT(double x0, double acc){
		//x0 = start position - m
		//Acc = Acceleration - m/s^2
		double result = Math.sqrt((2*x0)/acc);
		System.out.println("t = sqrt(2 * "+x0+"/ "+acc+") = " + result + " s" );
		
	}
	
	//Input Y = a*X+b
	//Done
	public static void basisChangeAngle(double angle, V2 P, V2 O){
		double radian = (Math.PI/180)*angle;
		System.out.print("OP = ");
		V2 OP = P.sub(O); System.out.println(OP);
		
		//U og V er enhedsvektorer i det nye Basis, med O som nyt Centrum
		System.out.println("\nU = \n[Cos("+angle+") \n Sin("+angle+")] \n= \n("+Math.cos(radian)+" \n "+Math.sin(radian)+")");
		System.out.println("\nV = \n[-Sin("+angle+") \n Cos("+angle+")] \n= \n("+-Math.sin(radian)+" \n "+Math.cos(radian)+")");
		
		//Punktet P i forhold til ny Basis
		System.out.println("\nP' = [U | V]^-1 * OP");
		System.out.println("\nP' = \n[" + Math.cos(radian) + "\t" + Math.sin(radian) + "\t   ("+OP.x+
				"\n"+ -Math.sin(radian) + "\t" + Math.cos(radian) + "] * \t     " + OP.y+")");
		
		
		M2 Aminus = new M2(Math.cos(radian),Math.sin(radian),-Math.sin(radian),Math.cos(radian));
		System.out.println("\nP' = "+Aminus.mul(OP));
	}
	
	//Input Y = a*X+b
	//Done
	public static void basisChangeLine(double a, double b, V2 P, V2 O){
		System.out.print("OP = ");
		V2 OP = P.sub(O); 
		
		
		System.out.println(OP);
		double x = 2;
		double y = a*x;
		double h = Math.sqrt(Math.pow(x,2)+Math.pow(y, 2));
		System.out.println("\nh = sqrt( x^2 + y^2) = "+h);
		
		double cosAngle = x/h;//*(180/Math.PI);
		double sinAngle = y/h;//*(180/Math.PI);

		
		//"\U+0395"
		
		System.out.println("\nU = "
				+ "\n[cos(epsilon) = x/h \n sin(epsilon) = y/h]\n="
				+ "\n["+cosAngle+" \n "+sinAngle+"]\n ");
		System.out.println("\nV = "
				+ "\n[-sin(epsilon) = -y/h \n cos(epsilon) = x/h]\n="
				+ "\n[-"+sinAngle+" \n "+cosAngle+"] \n");
		
		System.out.println("P' = [U | V]^-1 * OP");
		System.out.println("P' = \n[" + Math.cos(cosAngle) + "\t" + Math.sin(sinAngle) + "\t     ("+OP.x+" \n"
				+ -Math.sin(sinAngle) + "\t" + Math.cos(cosAngle) + "]  \t*     " + OP.y+")\n");
		
		
		M2 Aminus = new M2 (x/h,y/h,-y/h,x/h);
		System.out.println("P' = "+Aminus.mul(OP));
	}
	
	public static double kmhTOms(double kmh){
		return kmh*1000/(60*60);
	}
	
	public static double msTOkmh(double ms){
		return ms*(60*60)/1000;
	}
}
