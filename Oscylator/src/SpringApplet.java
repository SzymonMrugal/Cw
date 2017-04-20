import javax.swing.*;
import java.awt.*;
import java.util.Timer;

public class SpringApplet extends JApplet {
    
    private SimEngine silnik;
    private SimTask zadanie;
    private Timer czas;

    @Override
    public void init() {        //przeciazona metoad init()
        setBackground(Color.white);
        
        silnik=new SimEngine(5,20,2,1,-150,-200,0,0,0,0,10);
        zadanie=new SimTask(silnik, this, 1);
        czas=new Timer();
        
        czas.scheduleAtFixedRate(zadanie,1,1);
        
    }
    
    @Override
    public void paint(Graphics g){        //Przeciazona metoda paint()
       // silnik=new SimEngine(5,20,2,1,-150,-200,0,0,0,0,10);
        Vector2D masloc=silnik.getMassLocation();
                
        int middlex=this.getSize().width/2;
        int middley=this.getSize().height/2;
        int endx=middlex+(int)(masloc.x);
        int endy=middley+(int)(-masloc.y);
        
        g.clearRect(0, 0,  this.getSize().width, this.getSize().height );  //Czyszczenie powierzchni
        
        g.drawLine( middlex,middley/2, endx,endy ); //rysowanie sprezyny jako linii
        g.fillOval( endx-10,endy-10, 20,20 );   //rysowanie masy jako ovalu
        
        try
        {
            Thread.sleep(10);
        } catch (InterruptedException e) {} 
        
        silnik.sym(1);
        
    }    
}
