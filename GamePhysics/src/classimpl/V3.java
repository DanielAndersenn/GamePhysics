package classimpl;

/*
 * 3D vector
 */

public class V3 {
	double x, y, z;

	public V3(double x, double y, double z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}

	public double length() {
		return Math.sqrt(x * x + y * y + z * z);
	}

	public V3 unit() {
		return this.mul( 1 / length());
	}

	public V3 add(V3 v) {
		return new V3(x + v.x, y + v.y, z + v.z);
	}

	public V3 sub(V3 v) {
		return new V3(x - v.x, y - v.y, z - v.z);
	}

	public V3 mul(double k) {
		return new V3(x * k, y * k, z * k);
	}

	public double dot(V3 v) {
		return x * v.x + y * v.y + z * v.z;
	}

	public V3 cross(V3 v) {
		return new V3(y * v.z - z * v.y,
				      z * v.x - x * v.z,
				      x * v.y - y * v.x);
	}

	public String toString() {
		return "("+x+","+y+","+z+")";
	}

	public static void main(String[] args) {
		System.out.println("Test V2 - 3D vector");
		V3 a = new V3(1, 1, 2);
		V3 b = new V3(2, -1, 1);
		System.out.println("a = " + a);
		System.out.println("a.add(a) = " + a.add(a));
		System.out.println("a.sub(a) = " + a.sub(a));
		System.out.println("a.mul(3) = " + a.mul(3));
		System.out.println("a.mul(-1) = " + a.mul(-1));
		System.out.println("a.dot(a) = " + a.dot(a));
		System.out.println("a.cross(b) = " + a.cross(b));
	} // main()
}
