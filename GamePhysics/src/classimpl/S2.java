package classimpl;

import java.awt.Color;
import java.awt.Graphics;

public class S2 {

    V2 O;
    M2 S;
    M2 F;
    M2 T;
    
    S2(double sx,double sy,double ox,double oy){
        O = new V2(ox,oy);
        S = new M2(sx,0,0,sy);
        F = new M2(1,0,0,-1);
        T = S.mul(F);
    }
    
    void drawPoint(Graphics g, V2 v){
       V2 vp= transform(v);
       g.fillOval((int)vp.x, (int)vp.y, 2, 2);       
    }
    
    public void drawPoint(Graphics g, V2 v, int size) {
      V2 p = transform(v);                // v in pixels
      g.fillOval((int)(p.x-size/2.0), (int)(p.y-size/2.0), size, size);
    }

    public void drawPoint(Graphics g, V2 v, Color c, int size) {
      Color oldColor = g.getColor();
      g.setColor(c);
      drawPoint(g, v, size);
      g.setColor(oldColor);
    }

    void drawLine(Graphics g,V2 v1,V2 v2){
      V2 vp1 = transform(v1);
      V2 vp2 = transform(v2);
      g.drawLine((int)vp1.x, (int)vp1.y, 
                 (int)vp2.x, (int)vp2.y);
  }
  
    void drawLine(Graphics g,V2 v1,V2 v2, Color c){
      Color oldColor = g.getColor();
      g.setColor(c);
      drawLine(g, v1, v2);
      g.setColor(oldColor);
  }
  
    void drawAxis(Graphics g){
        drawLine(g,new V2(0,0), new V2(0,1));
        drawLine(g,new V2(0,0), new V2(1,0));                
    }

    V2 transform(V2 p){
        return T.mul(p).add(O);
    }
}
