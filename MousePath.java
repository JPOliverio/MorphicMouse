
import java.lang.Math;
import java.util.ArrayList;

public class MousePath{
ArrayList<Integer> xpath;
ArrayList<Integer> ypath;


/*intiates the path by creating the arrays it needs.
*/
  public MousePath(){
    xpath = new ArrayList<Integer>();
    ypath = new ArrayList<Integer>();
  }




  /*This method develops the path between two points using the Bezier Curve.
    This Bezier has four nodes meaning it will have two curves. One in the middle
    and another near the end. X1 Y1 and X2 Y2 create the two curves. these points
    are randomly generated to make them look more human like. This method
    is not capable of finding everypoint. It requires another method called
    PathPatch to fill in the missing points. This class stoes the path in a list
    array.
  */
  public void MousePathN4(int xstart, int ystart, int xend, int yend){
    double x0=xstart;
    double y0=ystart;
    double x3=xend;
    double y3=yend;
    double x1= x3+(x3*Math.random()/3)*(Math.random()>.5?-1:1); //these percentage values need work.
    double y1= y3+(y3*Math.random()/3)*(Math.random()>.6?-1:1);
    double x2= x3+(x3*Math.random()/4);
    double y2= y3+(y3*Math.random()/4)*(Math.random()>.8?-1:1);
    int xt;
    int yt;
    xpath.add(xstart);
    ypath.add(ystart);

    //System.out.println("x1 "+x1+" y1 "+y1+" x2 "+x2+" y2 "+y2);
//below is the Bezier equation for x and y.
    for(double t=0; t<=1.01; t+=.01){
      xt=(int)Math.round((x3-3*x2+3*x1-x0)*Math.pow(t,3)+(3*x2-6*x1+3*x0)*Math.pow(t,2)+(3*x1-3*x0)*t+x0);
      yt=(int)Math.round((y3-3*y2+3*y1-y0)*Math.pow(t,3)+(3*y2-6*y1+3*y0)*Math.pow(t,2)+(3*y1-3*y0)*t+y0);
      PathPatch(xt,yt);
    }
  }




/*The PatchPath method is used to find the missing points. A majority of the path
  is generated from this method. It's complicated but works perfectly.
*/
    public void PathPatch(int xt, int yt){
      int x;
      int y;
      int xLength=xpath.size()-1;
      int yLength=ypath.size()-1;
      double xDiff=xt-xpath.get(xLength);
      double yDiff=yt-ypath.get(yLength);
      double b;

      if(yDiff!=0 && xDiff!=0){
        b=yt-(yDiff/xDiff)*xt;
          if(Math.abs(yDiff) > Math.abs(xDiff)){
          for(int i=(ypath.get(yLength)+1*(yDiff>0?1:-1)); yt!=i; i=(yDiff>0?++i:--i)){
            x=(int)(((double)i-b)*xDiff/yDiff);
            xpath.add(x);
            ypath.add(i);
          }
        }else if(Math.abs(yDiff) < Math.abs(xDiff)){
          for(int i=(xpath.get(xLength)+1*(xDiff>0?1:-1)); xt!=i; i=(xDiff>0?++i:--i)){
            y=(int)(((double)i*yDiff/xDiff)+b);
            xpath.add(i);
            ypath.add(y);
          }
        }else if(Math.abs(xDiff)==Math.abs(yDiff)){
          x=xpath.get(xLength);
          y=ypath.get(yLength);
          for(int i=0; i!=Math.abs(xDiff); i++){
            xpath.add(x+(xDiff>0?1:-1));
            ypath.add(y+(yDiff>0?1:-1));
          }
        }
      xpath.add(xt);
      ypath.add(yt);
    }
  }



    public int returnxPath(){
      int x = xpath.get(0);
      xpath.remove(0);
      return x;
    }

    public int returnyPath(){
      int y = ypath.get(0);
      ypath.remove(0);
      return y;
    }

    public int getPathLength(){
      return xpath.size(); // xpath and ypath will always be the same. this method can be used for boths paths.
    }





}
