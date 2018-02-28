import java.awt.Frame;
import java.awt.Toolkit;
import java.awt.Dimension;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Panel;
import java.awt.BasicStroke;
import java.lang.Math;
import java.lang.Thread;
public class MovingBall{
	public static Dimension screenSize=Toolkit.getDefaultToolkit().getScreenSize();
	public static int Height=300,Width=400;
	public static void main(String[] args){
		Frame w=new Frame();		
		//w.setSize(screenSize);//why not as large as the screen?
		w.setSize(Width,Height);
		w.setBackground(new Color(19,19,70));
		Ball ball=new Ball();
		Thread myBall=new Thread(ball);
		myBall.start();
		w.add(ball);
		w.show();
	}

}
class Ball extends Panel implements Runnable{
	/*public static Dimension screenSize=Toolkit.getDefaultToolkit().getScreenSize();
	public int Height=(int)screenSize.height;
	public int Width=(int)screenSize.width;*/
	public int Height=300,Width=400;
	public int x=50,y=Height/2;
	public int direction=0;
	public void paint(Graphics g){
		
		g.setColor(Color.YELLOW);
		g.fillOval(x,y,50,50);

		
	}
	public void run(){	
		while(true){
			move(direction);
			if(y>Height-50){direction=(direction==0?1:2);}
			if(x>Width-50){direction=(direction==1?2:3);}
			if(y<0){direction=(direction==2?3:0);}
			if(x<0){direction=(direction==3?0:1);}
			try{
				Thread.sleep(10);				
			}catch(Exception e){}	
			repaint();
			//System.out.println(x+","+y);
		}	
			
	}
	public void move(int d){
		switch(d){
		case 0:
			y+=2;
			x++;
			break;
		case 1:
			y-=2;
			x++;
			break;
		case 2:
			y-=2;
			x--;
			break;
		case 3:
			y+=2;
			x--;
			break;	
		}
			
	}
	
}