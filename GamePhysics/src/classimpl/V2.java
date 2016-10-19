package classimpl;

public class V2 {
double x,y;

    V2(double x,double y){
        this.x=x;
        this.y=y;
    }

    V2 add(V2 v){
      return new V2(x+v.x,y+v.y);
  }
 
    V2 sub(V2 v){
      return new V2(x-v.x,y-v.y);
  }

    V2 mul(double d){
      return new V2(x*d,y*d);
  }

    V2 div(double d){
      return new V2(x/d,y/d);
  }

  	double length() {
  		return Math.sqrt(x*x+y*y);
  	}

  	V2 unit() {
  		return new V2(x, y).div(length());
  	}

}
