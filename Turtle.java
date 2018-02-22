import java.awt.Frame;
import java.awt.Panel;
import java.awt.Graphics;
import java.awt.Color;
public class Turtle{
	public static void main(String[] args){
		
		Frame window=new Frame();
		window.setSize(1000,800);
		window.setTitle("Turtle");
		MyPanel panel=new MyPanel();
		window.add(panel);
		window.show();
	}
}
class MyPanel extends Panel{
	public int centerX=200,centerY=200;
	public int turtleWidth=200,turtleHight=250;
	public int legWidth=turtleWidth/5,legHight=turtleHight/5;
	public int eyeW=legWidth/4,eyeH=legHight/5;
	public void paint(Graphics g){
		g.setColor(Color.GREEN);
		//body
		g.fillOval(centerX-turtleWidth/2,centerY-turtleHight/2,turtleWidth,turtleHight);
		//head
		g.fillOval(centerX-legWidth/2,centerY-turtleHight/2-legHight,legWidth,legHight);
		//legs
		g.fillOval(centerX-turtleWidth/2,centerY-turtleHight/2,legWidth,legHight);//left-front
		g.fillOval(centerX+turtleWidth/2-legWidth,centerY-turtleHight/2,legWidth,legHight);//right-front
		g.fillOval(centerX-turtleWidth/2,centerY-turtleHight/2+turtleHight-legHight,legWidth,legHight);//left-back
		g.fillOval(centerX+turtleWidth/2-legWidth,centerY+turtleHight/2-legHight,legWidth,legHight);//right-back
		//eye
		g.setColor(Color.YELLOW);
		g.fillOval(centerX-2*eyeW,centerY-turtleHight/2-legHight+eyeH,eyeW,eyeH);//left
		g.fillOval(centerX,centerY-turtleHight/2-legHight+eyeH,eyeW,eyeH);//right
		//tail
		
		//figure
		g.setColor(Color.BLACK);
		g.drawOval(centerX-turtleWidth/2,centerY-turtleHight/2,turtleWidth,turtleHight);
		int dx=turtleWidth/6,dy=turtleHight/5;
		int[] xs={centerX-dx,centerX+dx,centerX+dx*2,centerX+dx,centerX-dx,centerX-dx*2};
		int[] ys={centerY-dy,centerY-dy,centerY,centerY+dy,centerY+dy,centerY};
		g.drawPolygon(xs,ys,6);
		
		
	}
}