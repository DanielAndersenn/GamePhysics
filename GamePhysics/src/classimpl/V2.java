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
  		return "(" + x + ", " + y + ")";
  	}

}
