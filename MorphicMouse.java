


import java.awt.Robot;
import java.awt.PointerInfo;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.AWTException;
import java.lang.Math;

public class MorphicMouse{
  Robot mouse;

  public MorphicMouse() throws AWTException{
  mouse =  new Robot();
  }

  public void MorphicMouseMove(int xend, int yend) throws AWTException{

    //get pointer location
    int speed, speed1, speed2, speed3, speed4;
    int pathLength;
    int startLength;
    PointerInfo a = MouseInfo.getPointerInfo();
    Point b = a.getLocation();
    int xstart = (int) b.getX();
    int ystart = (int) b.getY();

    MousePath mousePath = new MousePath();
    mousePath.MousePathN4(xstart, ystart, xend, yend);
    pathLength=mousePath.getPathLength();
    startLength=pathLength;

    speed1=10+(int)Math.random()*10/5*(Math.random()>.5?-1:1);
    speed2=6+(int)Math.random()*10/5*(Math.random()>.5?-1:1);
    speed3=1+(int)Math.random()*10/5*(Math.random()>.5?-1:1);
    speed4=4+(int)Math.random()*10/5*(Math.random()>.5?-1:1);


    while(pathLength!=0){
      if(pathLength<=startLength*.05){speed=speed1;
      }else if(pathLength<=startLength*.15){speed=speed2;
      }else if(pathLength<=startLength*.99){speed=speed3;
            }else {speed=speed4;}
      mouse.mouseMove(mousePath.returnxPath(), mousePath.returnyPath());
      pathLength=mousePath.getPathLength();
      mouse.delay(speed);
    }

  }

}
