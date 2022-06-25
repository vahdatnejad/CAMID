import javax.microedition.lcdui.Canvas;
import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;


public class map extends Canvas {
    int x;
    int y;     
    // Moteghayer e Tasavir
    Image img = null;
    Image visitor=null;
    
    public map(Start m)
    {
        try{
            //Load e tasvir
            img = Image.createImage("/map.jpg");
            visitor = Image.createImage("/visitor.png");
        }catch(Exception e){}
    }
    
    public void set(int sx,int sy)
    {
        x=sx;
        y=sy;
    }
    
    public void paint(Graphics g)
    {
        //Set kardan e range sefid
        g.setColor(0xffffff);
        //Rasm e morabae too por dar kole safhe baraye Pak sazi
        g.fillRect(0, 0, getWidth(), getHeight());
        //Amaliate chap e tasvir
        g.drawImage(img, 0, 0, Graphics.LEFT|Graphics.TOP);
        g.drawImage(visitor,x,y, Graphics.VCENTER | Graphics.HCENTER);         
    }
}