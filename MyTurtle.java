import java.awt.Frame;
import java.awt.Panel;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Color;
import java.awt.BasicStroke;
import java.lang.Math;
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
		
		pen4color.setColor(Color.GREEN);
		
		//draw legs
		int x0=start_x,y0=start_y;
		int x1=x0+turtle_width-leg_width,
			y1=y0+turtle_hight-leg_hight;
		
		pen4line.fillOval(x0,y0,leg_width,leg_hight);
		pen4line.fillOval(x1,y0,leg_width,leg_hight);		
		pen4line.fillOval(x0,y1,leg_width,leg_hight);
		pen4line.fillOval(x1,y1,leg_width,leg_hight);
			

		//draw head
		int dy=leg_hight/5;
		int x2=start_x+turtle_width/2-leg_width/2;
		int y2=start_y-leg_hight+dy;
		pen4line.fillOval(x2,y2,leg_width,leg_hight);
		
		//draw tail
		int y3=y0+turtle_hight-dy;
		int x3=x0+turtle_width/2-turtle_width/10;
		int x4=x0+turtle_width/2+turtle_width/10;
		int[] xs={x3,x4,x0+turtle_width/2};
		int[] ys={y3,y3,y3+leg_hight};		
		
		pen4line.fillPolygon(xs,ys,3);
		
		pen4line.setColor(Color.BLACK);
		//legs
		pen4line.drawOval(x0,y0,leg_width,leg_hight);
		pen4line.drawOval(x1,y0,leg_width,leg_hight);		
		pen4line.drawOval(x0,y1,leg_width,leg_hight);
		pen4line.drawOval(x1,y1,leg_width,leg_hight);
		//head
		pen4line.drawOval(x2,y2,leg_width,leg_hight);
		//tail
		pen4line.drawPolygon(xs,ys,3);
		
		pen4color.setColor(Color.GREEN);
		pen4color.fillOval(start_x,start_y,turtle_width,turtle_hight);
			
		//draw body
		pen4line.setColor(Color.BLACK);
		pen4line.drawOval(start_x,start_y,turtle_width,turtle_hight);
		
		//draw turtle shell
		//x0=0;
		//y0=0;
		int dx=turtle_width/6;
		dy=turtle_hight/4;
		int m1=x0+dx*2,m2=x0+dx*4,m3=x0+dx*5,m4=x0+dx*4,m5=x0+dx*2,m6=x0+dx;
		int n1=y0+dy,n2=y0+dy,n3=y0+dy*2,n4=y0+dy*3,n5=y0+dy*3,n6=y0+dy*2;
		int[] xs2={m1,m2,m3,m4,m5,m6};
		int[] ys2={n1,n2,n3,n4,n5,n6};
		pen4line.drawPolygon(xs2,ys2,6);
		
		dy=turtle_hight/10;
		int[] ys3={y0+dy*2,y0+dy*6,y0+dy*9};
		int b=turtle_hight/2;
		int a=turtle_width/2;
		int h=x0+a;
		int k=y0+b;
		double[] xx1=countOvalPoint(h,k,a,b,ys3[0]);
		double[] xx2=countOvalPoint(h,k,a,b,ys3[1]);
		double[] xx3=countOvalPoint(h,k,a,b,ys3[2]);
		
		pen4line.drawLine(m1,n1,(int)xx1[0],ys3[0]);
		pen4line.drawLine(m2,n2,(int)xx1[1],ys3[0]);
		pen4line.drawLine(m3,n3,(int)xx2[0],ys3[1]);
		pen4line.drawLine(m4,n4,(int)xx2[1],ys3[1]);
		pen4line.drawLine(m5,n5,(int)xx3[0],ys3[2]);
		pen4line.drawLine(m6,n6,(int)xx3[1],ys3[2]);
		
		
		
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
	}
	public static double[] countOvalPoint(int h,int k,int a,int b,double x){
		double y1,y2;
		y1=k+b/a*Math.sqrt(a*a-h*h-x*x+2*x*h);
		y2=k-b/a*Math.sqrt(a*a-h*h-x*x+2*x*h);
		double[] y={y1<y2?y1:y2,y1<y2?y2:y1};
		return y;
	}
}