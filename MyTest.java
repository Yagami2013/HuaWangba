import java.awt.Frame;
import java.awt.Panel;
import java.awt.Graphics;
import java.awt.Color;
public class MyTest{
	public static void main(String[] args){
		Frame w=new Frame();
		w.setSize(300,400);
		MyPanel panel=new MyPanel();
		w.add(panel);
		w.show();
	}
}

class MyPanel extends Panel{
	public void paint(Graphics graphic){
		graphic.drawOval(150,200,100,150);
		graphic.setColor(Color.GREEN);
		graphic.fillOval(150,200,100,150);
	}	
}