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
        return new V2(a * v.x + b * v.y, c * v.x + d * v.y);
    }
    
    // Matrix * Matrix
    M2 mul (M2 m){
        return new M2(a * m.a + b * m.c, a * m.b + b * m.d,
                      c * m.a + d * m.c, c * m.b + d * m.d);
    }

}
