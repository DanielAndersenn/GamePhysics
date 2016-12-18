package classimpl;

/*
 * 3D matrix
 */

public class M3 {
	
	double a11, a12, a13,
           a21, a22, a23,
           a31, a32, a33;
    
    public M3(double a11, double a12, double a13, 
    		  double a21, double a22, double a23, 
    		  double a31, double a32, double a33) {
    	
    	this.a11 = a11; this.a12 = a12; this.a13 = a13;
    	this.a21 = a21; this.a22 = a22; this.a23 = a23;
    	this.a31 = a31; this.a32 = a32; this.a33 = a33;
    }
    
    public M3(V3 r1, V3 r2, V3 r3) { // matrix from 3 row vectors
    	this(r1.x, r1.y, r1.z,
      		 r2.x, r2.y, r2.z,
      		 r3.x, r3.y, r3.z);
    }

    public M3 transpose() { // matrix transpose
    	return new M3(a11, a21, a31,
    				  a12, a22, a32,
    		          a13, a23, a33);
    }
    
    public M3 add(M3 m) { // matrix addition
    	return new M3(a11 + m.a11, a12 + m.a12, a13 + m.a13,
        			  a21 + m.a21, a22 + m.a22, a23 + m.a23,
        			  a31 + m.a31, a32 + m.a32, a33 + m.a33);
    }
    
    public M3 sub(M3 m) { // matrix subtraction
      return new M3(a11 - m.a11, a12 - m.a12, a13 - m.a13,
      				a21 - m.a21, a22 - m.a22, a23 - m.a23,
      				a31 - m.a31, a32 - m.a32, a33 - m.a33);
    }
    
    public M3 mul(double k) { // scalar multiplication
      return new M3(a11 * k, a12 * k, a13 * k,
      				a21 * k, a22 * k, a23 * k,
      				a31 * k, a32 * k, a33 * k);
    }
    
    public V3 mul(V3 v) { // matrix * vector multiplication
      return new V3(a11 * v.x + a12 * v.y + a13 * v.z,
          		    a21 * v.x + a22 * v.y + a23 * v.z,
				    a31 * v.x + a32 * v.y + a33 * v.z);
    }
    
    public M3 mul(M3 m) { // matrix multiplication
      return new M3(a11 * m.a11 + a12 * m.a21 + a13 * m.a31, a11 * m.a12 + a12 * m.a22 + a13 * m.a32, a11 * m.a13 + a12 * m.a23 + a13 * m.a33, 
      				a21 * m.a11 + a22 * m.a21 + a23 * m.a31, a21 * m.a12 + a22 * m.a22 + a23 * m.a32, a21 * m.a13 + a22 * m.a23 + a23 * m.a33,
      				a31 * m.a11 + a32 * m.a21 + a33 * m.a31, a31 * m.a12 + a32 * m.a22 + a33 * m.a32, a31 * m.a13 + a32 * m.a23 + a33 * m.a33);
    }
    
    public String toString() {
        return "["+a11+" ,"+a12+" ,"+a13+"; "+
        	   a21+" ,"+a22+" ,"+a23+"; "+
        	   a31+" ,"+a32+" ,"+a33+"]";
    }

    public static void main(String[] args) {
        System.out.println("Test M3 - 3x3 matrix");

        M3 A = new M3(1,-1,1, -2,0,3, 0,1,-2);
        M3 B = new M3(0,0,1, 0,2,3, 1,2,3);
        M3 C = new M3(1,2,2, 0,1,1, 1,0,1);
        V3 v = new V3(1,0,1);
        
        System.out.println("A = " + A);
        System.out.println("B = " + B);
        System.out.println("C = " + C);
        System.out.println("A.transpose() = " + A.transpose());
        System.out.println("A.add(B) = " + A.add(B));
        System.out.println("A.sub(B) = " + A.sub(B));
        System.out.println("A.mul(2) = " +A.mul(2));
        System.out.println("A.mul(B) = " + A.mul(B));
        System.out.println("C.mul(v) = " + C.mul(v));

        System.out.println("Change of basis");
        V3 X = new V3(1,1,1);
        V3 E = new V3(0,0,0);
        double phi = Math.PI/4;
        V3 D = new V3(Math.cos(phi), Math.sin(phi),0);
        V3 U = new V3(-Math.sin(phi), Math.cos(phi),0);
        V3 R = D.cross(U);
        M3 M = new M3(D,U,R);
        V3 Y = M.mul(X.sub(E));
        System.out.println("X = " + X);
        System.out.println("E = " + E);
        System.out.println("D = " + D);
        System.out.println("U = " + U);
        System.out.println("R = " + R);
        System.out.println("M = " + M);
        System.out.println("Y = " + Y);

        M3 m1 = new M3(1, 2, 3, 4, 5, 6, 7, 8, 9);
        M3 m2 = new M3(9, 8, 7, 6, 5, 4, 3, 2, 1);
        M3 m3;
        
        final int N = 100000000;
        double start = System.currentTimeMillis();
        
        for (int i = 0; i < N; i++){
        	m3 = m1.mul(m2);
        }
        
        double stop = System.currentTimeMillis();
        double dt = (stop - start)/1000;
        
        System.out.println("dt = " + dt +" s");
        System.out.println("N/dt = " + (int) (N / dt));
        
  } // main()
} // M3
