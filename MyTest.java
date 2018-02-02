import java.awt.Frame;
import java.awt.Panel;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Color;
import java.awt.BasicStroke;
public class MyTest{
	public static void main(String[] args){
		Frame w=new Frame();
		w.setSize(300,400);
		w.setTitle("TestWindow");
		MyPanel panel=new MyPanel();
		w.add(panel);
		w.show();
	}
}

class MyPanel extends Panel{
	public void paint(Graphics graphic){
		Graphics2D graphic2d=(Graphics2D)graphic;
		graphic2d.setStroke(new BasicStroke(3.0f));
		graphic.drawOval(75,100,150,200);
		graphic.setColor(Color.GREEN);
		graphic.fillOval(75,100,150,200);
	}	
}