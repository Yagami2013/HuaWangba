import java.awt.Frame;
import java.awt.Panel;
import java.awt.Graphics;
import java.awt.Graphics2D;
public class TestArc{
	public static void main(String[] args){
		int width=400,hight=500;
		Frame w=new Frame();
		w.setSize(width,hight);
		MyPanel canvas=new MyPanel();
		w.add(canvas);
		w.show();
	}
}
class MyPanel extends Panel{
	public void paint(Graphics g){
		g.drawRect(100,100,200,1);
		g.drawArc(100,100,200,1,-60,180);
		Graphics2D g2d=(Graphics2D)g;
		g2d.rotate(60.0);
	}
}