package classimpl;

public class V2 {
	
	double x, y;

    V2(double x, double y) {
    	this.x = x;
        this.y = y;
    }
    
    // Add 2D-vectors together
    V2 add(V2 v) {
    	System.out.print(x + " + " + v.x + ", " + y + " + " + v.y + " = ");
    	return new V2(x + v.x, y + v.y);    	
    }
    
    // Substract 2D-vectors
    V2 sub(V2 v) {
    	System.out.print("\n("+x + " - " + v.x + " \n " + y + " - " + v.y + ") \n= ");
    	return new V2(x - v.x, y - v.y);
    }
    
    // Mult 2D-vectors
    V2 mul(double d) {	
      return new V2(x * d, y * d);
    }
    
    // Divide 2D-vectors
    V2 div(double d) {
      return new V2(x / d, y / d);
    }
    
    // Determine length of 2D-vector
  	double length() {
  		return Math.sqrt(x * x + y * y);
  	}
  	
  	// Enhedsvektor
  	V2 unit() {
  		return new V2(x, y).div(length());
  	}
  	
  	public String toString(){
  		return "\n("+x+"\n"+y+")";
  		//return "(" + x + ", " + y + ")";
  	}
  	
    // Vector rotation
    V2 rotatematrix(double angle, V2 centrum) {
    	
    	double radian = Math.PI/180 * angle;
		
    	M2 A = new M2(Math.cos(radian), -Math.sin(radian), Math.sin(radian), Math.cos(radian));
    	
    	System.out.println("P' = \n"
    			         + "[cos("+angle+") \t -sin("+angle+")\n"
    			         + "sin("+angle+") \t  cos("+angle+")]\n"
    			         + "*\n"
    			         + "OP\n"
    			         + "+\n"
    			         + "O'\n"
    			         + "=");
    	
    	System.out.print(A.a + " * " + this.x + "\t" + A.b + " * " + this.y + "\n" +
    					 A.c + " * " + this.x + "\t" + A.d + " * " + this.y + " =\n \n");
    	
    	/* System.out.print(A.a * this.x + "\t" + A.b * this.y + "\n" +
    					 A.c * this.x + "\t" + A.d * this.y + " = "); */
    	
    	return A.mul(this).add(centrum);
    	// return new V2(A.a * this.x + A.b * this.y, A.c * this.x + A.d * this.y);
    	
    }
    
    V2 mirrorX() {
    	
    	M2 A = new M2(1, 0, 0, -1);
    	
    	System.out.println("P' = \n"
    					  +"[1 \t 0\n"
    					  + "0 \t -1]\n"
    					  + "* \n"
    					  + "P = \n");
    	
    	System.out.print(A.a + " * " + this.x + "\t" + A.b + " * " + this.y + "\n" +
				 		 A.c + " * " + this.x + "\t" + A.d + " * " + this.y + " = \n");
    	
    	return A.mul(this);
    }
    
    V2 mirrorY() {
    	
    	M2 A = new M2(-1, 0, 0, 1);
    	
    	System.out.println("P' = \n"
				  		  +"[-1 \t 0\n"
				  		  + "0 \t 1]\n"
				  		  + "* \n"
				  		  + "P = \n");
    		
    	System.out.print(A.a + " * " + this.x + "\t" + A.b + " * " + this.y + "\n" +
				 		 A.c + " * " + this.x + "\t" + A.d + " * " + this.y + " = \n");
    	
    	return A.mul(this);
    }
    
    V2 mirrorLine(double a) {
    	
    	double h = Math.sqrt(Math.pow(1, 2) + Math.pow(a, 2));
    	
    	double cos = 1/h;
    	double sin = a/h;
    	
    	M2 mNeg = new M2(cos, sin, -sin, cos);
    	M2 mNorm = new M2(cos, -sin, sin, cos);
    	M2 F = new M2(1, 0, 0, -1);
    	
    	return (mNorm.mul((F.mul(mNeg)))).mul(this);
    	
    	
    }
    

}
