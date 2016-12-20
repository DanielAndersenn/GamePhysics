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
	
		//VelocityAtT(0,9.82,2.43);
		//PositionAtT(0,0,2.35,11.8);
		//SPLAT(50,2.35);
		//DistanceDrivenAtVelocity(0,0,2.35,190);
		
		
		//standardAirDrop(new V2(0,300),9.82,new V2(kmhTOms(500),0));
		//projectileDistance(45,65);
		projectileAngle(20,65);
		
		//calcAcc(100,0,11.8,0);
		//System.out.println(kmhTOms(89));
		//System.out.println(msTOkmh(kmhTOms(89)));
	}

	public static void forskyd(V2 punkt, V2 vektor) {
		System.out.println("## forskyd V2, V2 ##");
		System.out.println(punkt.add(vektor));
	}
	
	public static void forskyd(V3 punkt, V3 vektor) {
		System.out.println("## forskyd V3, V3 ##");
		System.out.println(punkt.add(vektor));
	}
	
	public static void rotate(V2 punkt, double vinkel, V2 centrum) {
		System.out.println("## rotate ##");
		V2 temp = punkt.sub(centrum);
		
		System.out.println(temp);
		System.out.println(temp.rotatematrix(vinkel, centrum));
	}
	
	public static void mirrorX(V2 v2) {
		System.out.println("## mirrorX ##");
		System.out.println(v2.mirrorX());
	}
	
	public static void mirrorY(V2 v2) {
		System.out.println("## mirrorY ##");
		System.out.println(v2.mirrorY());
	}
	
	//y = a*x + b
	public static void mirrorLine(double a, V2 punkt) {
		System.out.println("## mirrorLine ##");
		System.out.println(punkt.mirrorLine(a));
	}
	
	public static void matriceMult(M2 matrice1, M2 matrice2) {
		System.out.println("## matriceMult M2*M2 ##");
		matrice1.mul(matrice2);
	}
	
	public static void matriceMult(M2 matrice, V2 vector) {
		System.out.println("## matriceMult M2*V2 ##");
		matrice.mul(vector);
	}
	
	public static void focus(V3 E, V3 P){
		System.out.println("## focus ##");
		Camera cam = new Camera();
		cam.moveTo(E);
		cam.focus(P);
		System.out.println("Values for Cam: D = "+cam.D+"\nR = "+cam.R+"\nU = "+cam.U);
	}
	
	public static void terminalHastighed(double dragCoefficient){
		System.out.println("## terminalHastighed ##");
		System.out.println("Terminal hastighed: = "+9.82/dragCoefficient);	
	}
	
	public static void coordinatesInCameraPerspective(V3 Q, V3 E,V3 O){
		System.out.println("## coordinatesInCameraPerspective ##");
		V3 OQ = Q.sub(O);
		V3 OE = E.sub(O);
		System.out.println(OQ.sub(OE));
	}
	
	
	//****************************************************
	//Constant acceleration methods
	
		//Beregner hastighed ved tidspunktet t
		//DONE
	public static void VelocityAtT(double v0, double acc, double t){
		System.out.println("## VelocityAtT ##");
		//v0 = Start hastighed - m/s
		//acc = Acceleration - m/s^2
		//t = Den oenskede tid - s
		double result = v0+acc*t;
		System.out.println("v(t) ="
			+ "\nv0 + acc * t = "
			+"\n"+v0+" + " + acc +" * "+ t +" ="
					+ "\n" + result+" m/s");
	}
	
		//Beregner position ved tidspunktet t
		//DONE
	public static void PositionAtT(double v0, double x0, double acc, double t){
		System.out.println("## PositionAtT ##");
		//v0 = start hastighed - m/s
		//x0 = start position - m
		//Acc = Acceleration - m/s^2
		//t = tid - s
		double result = x0 + v0 * t + 0.5 * acc * Math.pow(t, 2);
		System.out.println("x(t) = "
				+ "\nx0 + v0 * t + 0.5 * acc * t^2 ="
				+ "\n"+x0+" + "+v0+" * "+t+" + 0.5 * "+acc+" * "+t+"^2 ="
						+ "\n"+result+" m");
		
	}
	
		//Hvornaar rammer man 0
		//DONE
	public static void SPLAT(double x0, double acc){
		System.out.println("## SPLAT ##");
		//x0 = start position - m
		//Acc = Acceleration - m/s^2
		double result = Math.sqrt((2*x0)/acc);
		System.out.println("t = "
				+ "\nsqrt(2 * x0 / acc) ="
				+ "\nsqrt(2 * "+x0+"/ "+acc+") = "
						+ "\n" + result + " s" );
		
	}
	
		//Beregner distance ved en given opnåeet hastighed
		//DONE
	public static void DistanceDrivenAtVelocity(double v0, double x0, double acc, double topSpeed){
		System.out.println("## DistanceDrivenAtVelocity ##");
		//double v0 = start hastighed - km/t
		//double x0 = start position - m
		//double acc = Acceleration - m/s^2
		//double topSpeed = oenskede opnaaet hastighed
		double tempTS = kmhTOms(topSpeed);
		double timeNeeded = tempTS/acc;
		System.out.println("topSpeed omregnet til m/s = tempTS = "+tempTS+" m/s");
		System.out.println("Tiden det tager at ramme topfart = tempTS/acc = "+timeNeeded+" s");
		PositionAtT(v0,x0,acc,timeNeeded);
	}
	
	
	//****************************************************
	
	
	
	//****************************************************
	//Basis change methods
	
		//Input Y = a*X+b
		//Skifter base baseret paa vinkel
		//Done
	public static void basisChangeAngle(double angle, V2 P, V2 O){
		System.out.println("## basisChangeAngle ##");
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
		//Skifter base baseret paa linje
		//Done
	public static void basisChangeLine(double a, double b, V2 P, V2 O){
		System.out.println("## basisChangeLine ##");
		System.out.print("OP = ");
		V2 OP = P.sub(O); 
		
		
		System.out.println(OP);
		double x = 2;
		double y = a*x;
		double h = Math.sqrt(Math.pow(x,2)+Math.pow(y, 2));
		System.out.println("\nh = sqrt( x^2 + y^2) = "+h);
		
		double cosAngle = x/h;//*(180/Math.PI);
		double sinAngle = y/h;//*(180/Math.PI);
		
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
	//****************************************************
	
	
	
	//****************************************************
	//Airdrop methods
	
		//Udregner et standard airdrop scenarie
		//Fungerer kun ved vandret drop
		//#TODO
	public static void standardAirDrop(V2 r0, double acc, V2 v0){
		System.out.println("## standardAirDrop ##");
		//r0 = start position (x,y) - m
		//acc = Accelerationen - m/s^2
		//v0 = velocity / hastighed - m/s
		
		double distance = v0.x * Math.sqrt(2*r0.y/acc);
		System.out.println("d =\nv0x * sqrt(2*r0y / acc) =\n"+v0.x+" * sqrt(2*"+r0.y+" / "+acc+") =\n"
				+distance+" m\n");
		System.out.println("t = \n"
				+ "sqrt(2*r0y / acc) ="
				+ "\nsqrt(2*"+r0.y+" / "+acc+") =\n"
				+ Math.sqrt(2*r0.y/acc)+" s");
		
	}
	
		//Udregner hvor langt et projektil rejser
		//DONE
	public static void projectileDistance(double angle, double velocity){
		System.out.println("## projectileDistance ##");
		//angle = udgangsvinkel - grader
		//velocity = udgangshastighed - km/t
		double radian = angle*(Math.PI/180);
		double speed = kmhTOms(velocity);
		V2 V = new V2(Math.cos(radian)*speed, Math.sin(radian)*speed); 
		System.out.println("y(t) = 0 =>"
				+ "\nt=0 V t = (2*V0y) / g" );
		System.out.println("Position: x(t)=V0x*t =>\nV0x * (2*V0y) / g =>");
		System.out.println(V.x + " * " + "(2 * "+V.y +" ) / 9.82 = ");
		double result = V.x * ((2 * V.y)/9.82);
		System.out.println("Distance = "+result);
	}
	
		//Udregner hvad udgangsvinklen er baseret paa distancen
	public static void projectileAngle(double distance ,double velocity){
		double speed = kmhTOms(velocity);
		
		System.out.println("## projectileAngle ##");
		System.out.println("x ="
				+ "\ncos(epsilon) * velocity * ((2 * sin(epsilon) * velocity)/ g) = distance =>");
		System.out.println("sin(2*epsilon) = (distance * g) / velocity ^2 = ");
		System.out.println("sin(2*epsilon) = ("+distance+" * 9.82) / "+speed+"^2 =");
		double result = (distance*9.82)/Math.pow(speed, 2);
		System.out.println("Radianer = "+ result);
		double radianerResult = result*(180/Math.PI);
		System.out.println("2*epsilon = "+radianerResult);
		System.out.println("epsilon = "+radianerResult/2);
	}
	
	//****************************************************
	
	
	
	
	//****************************************************
	//Help methods
		//km/h til m/s
		//DONE
	public static double kmhTOms(double kmh){
		System.out.println("## kmTOms ##");
		return kmh*1000/(60*60);
	}
	
		//m/s til km/h
		//DONE
	public static double msTOkmh(double ms){
		System.out.println("## msTOkmh ##");
		return ms*(60*60)/1000;
	}
	
		//udregner Acc baseret paa final og initial vaerdier
		//DONE
	public static double calcAcc(double vf, double vi, double tf, double ti){
		System.out.println("## calcAcc ##");
		//vf = velocity final - km/t
		//vi = velocity intial - km/t
		//tf = time final - s
		//ti = time initial - s
		double Vtempf = kmhTOms(vf);
		double Vtempi = kmhTOms(vi);
		
		System.out.println("Omregn vf og vi til m/s = "
				+ "\nVtempf = "+Vtempf
				+ "\nVtempi = "+Vtempi);
		System.out.println("\nAcc = (Vtempf - Vtempi) / (tf - ti) = "
				+ "\n("+Vtempf+" - "+ Vtempi+") / ("+tf + " - " + ti +") =");
		double result = (Vtempf-Vtempi) / (tf - ti);
		
		System.out.println(result+" m/s^2");
		
		
		
		return result;
		
	}
	
	//****************************************************
	

}
