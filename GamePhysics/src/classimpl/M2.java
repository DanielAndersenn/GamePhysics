package classimpl;

public class M2 {
	
	double a,b;
    double c,d;

    public M2(double a, double b, double c, double d) {
    	this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
    }

    // Matrix * vector
    V2 mul( V2 v){
    	
    	System.out.println("M * V = \n\n"
    					 + "a * Vx + b * Vy\n"
    					 + "c * Vx + d * Vy = \n");
    	
        return new V2(a * v.x + b * v.y, c * v.x + d * v.y);
    }
    
    // Matrix * Matrix
    M2 mul (M2 m){
    	
    	// System.out.println("M1 * M2 = \n\n"
    			         // +"");
    	
        return new M2(a * m.a + b * m.c, a * m.b + b * m.d,
                      c * m.a + d * m.c, c * m.b + d * m.d);
    }

}
