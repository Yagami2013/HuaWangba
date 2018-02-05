import java.awt.Frame;
import java.awt.Panel;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Color;
import java.awt.BasicStroke;
public class MyTurtle{
	public static int width=400;
	public static int hight=500;
	public static void main(String[] args){
		Frame window=new Frame();
		window.setSize(width,hight);
		window.setTitle("Turtle");
		MyPanel canvas=new MyPanel(width,hight);
		canvas.init(25);
		window.add(canvas);
		window.show();
	}
}
class MyPanel extends Panel{
	private int width;
	private int hight;
	private int turtle_width;
	private int turtle_hight;
	private int start_x;
	private int start_y;
	
	private int leg_hight;
	private int leg_width;
	MyPanel(){
		this.width=300;
		this.hight=400;
	}
	MyPanel(int width,int hight){
		this.width=width;
		this.hight=hight;
	}
	public void paint(Graphics pen4color){
		Graphics2D pen4line =(Graphics2D)pen4color;
		pen4line.setStroke(new BasicStroke(3.0f));
		

		//draw body
		pen4line.drawOval(start_x,start_y,turtle_width,turtle_hight);
		
		//draw legs
		int x0=start_x,y0=start_y;
		int x1=x0+turtle_width-leg_width,
			y1=y0+turtle_hight-leg_hight;
		pen4line.drawOval(x0,y0,leg_width,leg_hight);
		pen4line.drawOval(x1,y0,leg_width,leg_hight);		
		pen4line.drawOval(x0,y1,leg_width,leg_hight);
		pen4line.drawOval(x1,y1,leg_width,leg_hight);
		//draw head
		int dy=leg_hight/5;
		int x2=start_x+turtle_width/2-leg_width/2;
		int y2=start_y+leg_hight-dy;
		pen4line.drawOval(x2,y2,leg_width,leg_hight);
		
		pen4color.setColor(Color.GREEN);
		pen4color.fillOval(start_x,start_y,turtle_width,turtle_hight);
		//pen4color.fillOval(75,100,150,200);		
		
	}
	public void init(int n){
		if(n<0)return;
		if(width>=300){
			start_x=50;
			turtle_width=100;
			leg_width=20;
		}else if(width>=0&&width<300){
			start_x=2*n;
			turtle_width=4*n;
			leg_width=n/5+1;
		}else return;	
		
		if(hight>=400){
			start_y=50;
			turtle_hight=125;
			leg_hight=25;
		}else if(hight>=0&&hight<400){
			start_y=2*n;
			turtle_hight=5*n;
			leg_hight=n/5+1;
		}else return;
		
		//System.out.println("start_x,start_y,width,hight,turtle_width,turtle_hight,leg_width,leg_hight");		
		//System.out.println(start_x+","+start_y+","+width+","+hight+","+turtle_width+","+turtle_hight+","+leg_width+","+leg_hight);
	}
}