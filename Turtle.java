import java.awt.Frame;
import java.awt.Panel;
import java.awt.Graphics;
import java.awt.Color;
import java.lang.Math;
import java.awt.Graphics2D;
import java.awt.BasicStroke;
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
	public int turtleWidth=200,turtleHeight=250;
	public int legWidth=turtleWidth/5,legHeight=turtleHeight/5;
	public int eyeW=legWidth/4,eyeH=legHeight/5;
	
	
	public void paint(Graphics g){
		int[][] num=getOvalPoint(centerX,centerY,turtleWidth/2,turtleHeight/2);
		g.setColor(Color.GREEN);
		//body
		g.fillOval(centerX-turtleWidth/2,centerY-turtleHeight/2,turtleWidth,turtleHeight);
		//head
		g.fillOval(centerX-legWidth/2,centerY-turtleHeight/2-legHeight,legWidth,legHeight);
		//legs
		g.fillOval(centerX-turtleWidth/2,centerY-turtleHeight/2,legWidth,legHeight);//left-front
		g.fillOval(centerX+turtleWidth/2-legWidth,centerY-turtleHeight/2,legWidth,legHeight);//right-front
		g.fillOval(centerX-turtleWidth/2,centerY-turtleHeight/2+turtleHeight-legHeight,legWidth,legHeight);//left-back
		g.fillOval(centerX+turtleWidth/2-legWidth,centerY+turtleHeight/2-legHeight,legWidth,legHeight);//right-back

		//tail
		int x=num[4][0],y=num[4][2];
		int len=num[4][0]-num[3][0];	
		g.fillArc(x-len,y-len,len*2,len*2,-90,-90);
		
		g.setColor(this.getBackground());
		//System.out.println(len);
		double sqr2=Math.sqrt(2);
		//System.out.println(len*sqr2);
		//System.out.println((int)(len*sqr2));
		int len2=(int)(len*sqr2);
		g.fillArc(x-(len2-len)/2,y-(len2-len)/2,len2,len2,135,90);

		/*g.drawRect(x-len,y-len,len*2,len*2);
		g.drawRect(x,y,len,len);
		g.drawRect(x-(len2-len)/2,y-(len2-len)/2,len2,len2);
		g.setColor(Color.RED);
		
		for(int i=0;i<num.length;i++){
			for(int j=0;j<3;j++){
				g.drawOval(num[i][0],num[i][1],3,3);
				g.drawOval(num[i][0],num[i][2],4,4);
			}
		}*/
		
		//eye
		g.setColor(Color.YELLOW);
		g.fillOval(centerX-2*eyeW,centerY-turtleHeight/2-legHeight+eyeH,eyeW,eyeH);//left
		g.fillOval(centerX,centerY-turtleHeight/2-legHeight+eyeH,eyeW,eyeH);//right
		
		//figure
		g.setColor(Color.BLACK);
		Graphics2D g2=(Graphics2D)g;
		g2.setStroke(new BasicStroke(3.0f));
		g.drawOval(centerX-turtleWidth/2,centerY-turtleHeight/2,turtleWidth,turtleHeight);
		int dx=turtleWidth/6,dy=turtleHeight/5;
		int[] xs={centerX-dx,centerX+dx,centerX+dx*2,centerX+dx,centerX-dx,centerX-dx*2};
		int[] ys={centerY-dy,centerY-dy,centerY,centerY+dy,centerY+dy,centerY};
		g.drawPolygon(xs,ys,6);
		
		g.drawLine(xs[0],ys[0],num[1][0],num[1][1]);
		g.drawLine(xs[1],ys[1],num[6][0],num[6][1]);
		g.drawLine(xs[2],ys[2],num[7][0],num[7][2]);
		g.drawLine(xs[3],ys[3],num[5][0],num[5][2]);
		g.drawLine(xs[4],ys[4],num[2][0],num[2][2]);
		g.drawLine(xs[5],ys[5],num[0][0],num[0][2]);
		

		
		
		
	}
	public void testOvalPoint(){
		int[][] num=getOvalPoint(centerX,centerY,turtleWidth/2,turtleHeight/2);
		for(int i=0;i<num.length;i++){
			for(int j=0;j<3;j++){
				System.out.print(num[i][j]+",");
			}
			System.out.println();
		}
	}

	public int[][] getOvalPoint(int h,int k,int a,int b){
		//int h=250,a=250,b=200,k=200;
		if(h<a||k<b){return null;}
		int[][] num=new int[8][3];
		int i=0;
		for(int x=h-a+1;x<h+a;x++){
			double[] y=countOvalPoint(h,k,a,b,x);
			int y0=(int)y[0];
			if(y0<y[0])
			{
				
			}else if(x==h){ 

			}
			else{
				num[i][0]=x;
				num[i][1]=(int)y[0];
				num[i][2]=(int)y[1];
				i++;
			}
		}
		return num;
	}
	public static double[] countOvalPoint(double h,double k,double a,double b,double x){
		double y1,y2;
		y1=k+b/a*Math.sqrt(a*a-h*h-x*x+2*x*h);
		y2=k-b/a*Math.sqrt(a*a-h*h-x*x+2*x*h);
		double[] y={y1<y2?y1:y2,y1<y2?y2:y1};
		return y;
	}
}