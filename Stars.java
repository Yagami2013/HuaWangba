import java.awt.Frame;
import java.awt.Toolkit;
import java.awt.Dimension;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Panel;
import java.awt.BasicStroke;
import java.lang.Math;
public class Stars{
	public static Dimension screenSize=Toolkit.getDefaultToolkit().getScreenSize();
	public static void main(String[] args){
		Frame w=new Frame();		
		w.setSize(screenSize);//why not as large as the screen?
		w.setBackground(new Color(19,19,70));
		DrawStar stars=new DrawStar();
		w.add(stars);
		w.show();
	}
	

}

class DrawStar extends Panel{
	Dimension screenSize=Toolkit.getDefaultToolkit().getScreenSize();
	//why non-static function paint can run immediately when Object is created?
	public void paint(Graphics g){
		Graphics2D pen=(Graphics2D)g;
		pen.setColor(Color.YELLOW);
		pen.setStroke(new BasicStroke(1.0f));
		for(int i=0;i<300;i++){
			pen.drawString("*",(int)(Math.random()*screenSize.width),(int)(Math.random()*screenSize.height));
			//System.out.println((int)Math.random()*screenSize.width+","+(int)Math.random()*screenSize.height);
		}		
	}
}