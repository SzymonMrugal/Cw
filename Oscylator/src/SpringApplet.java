import javax.swing.*;
import java.awt.*;
import java.util.Timer;
import java.awt.event.*;

public class SpringApplet extends JApplet implements MouseListener, MouseMotionListener, ActionListener{
                    //prywatne pola
    private SimEngine silnik;
    private SimTask zadanie;
    private Timer scheduler;
    private boolean isDragging;
    private JTextField mass, springness, damping, earthacc, spring0length;
    private JButton resetButton;
    
    @Override       //metoda potrzebna do mplementacji ActionListener
    public void actionPerformed(ActionEvent evt) {
        if( evt.getSource() == resetButton ){   //czy zrodlem jest przycisk reset?
            scheduler.cancel();     //zatrzymanie symulacji
            scheduler = new Timer();
            zadanie = new SimTask(silnik, this, 20);
            scheduler.scheduleAtFixedRate(zadanie,1,(long)zadanie.getTimeStep());   //utworzenie nowej symulacji
            silnik.reset();
                        //Przypisanie parametrow symulacji z pol tekstowyh
            silnik.setMass(Double.parseDouble(mass.getText()));
            silnik.setSpringiness(Double.parseDouble(springness.getText()));
            silnik.setDamping(Double.parseDouble(damping.getText()));
            silnik.setEarthAcc(new Vector2D(0, Double.parseDouble(earthacc.getText()) ));
            silnik.setSpringStartLength(Double.parseDouble(spring0length.getText()));
            
            repaint();
        }
    }
    
    @Override   //metody potrzebne do implementacji MouseListener, MouseMotionListener
    public void mouseDragged(MouseEvent e) {
        if(isDragging){
            int x = e.getX();
            int y = e.getY();
                                    //usstawienie pozycji masy tam gdzie kursor
            silnik.setMassLocation(new Vector2D(x-this.getSize().width/2, y-this.getSize().height/2));
            repaint();
        }
        e.consume();
    }
 
    @Override
    public void mouseMoved(MouseEvent e) {
        
    }
 
    @Override
    public void mouseClicked(MouseEvent e) {
        
    }
 
    @Override
    public void mouseEntered(MouseEvent e) {
        
    }
 
    @Override
    public void mouseExited(MouseEvent e) {
        
    }
 
    @Override
    public void mousePressed(MouseEvent e) {
        int x = e.getX();
        int y = e.getY();
                                //obliczenie odleglosci klikniecia od masy
        int deltaX=Math.abs(x- this.getSize().width/2 - (int)silnik.getMassLocation().x);
        int deltaY=Math.abs(y- this.getSize().height/2- (int)silnik.getMassLocation().y);
        
        if( deltaX<=10 && deltaY<=10 ){ //czy klikniecie nastapilo wystarczajaco blisko masy?
            scheduler.cancel();     //wylaczenie symulacji
            silnik.reset();
            isDragging = true;
            e.consume();
        }
    }
        
 
    @Override
    public void mouseReleased(MouseEvent e) {
       if(isDragging){
           scheduler = new Timer();     //utworzenie symulacji od poczatku
           zadanie = new SimTask(silnik, this, 20);
           scheduler.scheduleAtFixedRate(zadanie,1,(long)zadanie.getTimeStep());
           isDragging = false;
       }
       e.consume();
    }
    
    @Override
    public void init() {        //przeciazona metoad init()
        isDragging=false;
        
                // implementacja obiektow TextField
        mass = new JTextField("2"); 
        springness  = new JTextField("20"); 
        damping  = new JTextField("0.7"); 
        earthacc  = new JTextField("-9.81"); 
        spring0length = new JTextField("10");
        
                 // implementacja obiektu Button
        resetButton = new JButton("Reset");
                
                 // dodanie elementow do appletu
        setLayout(null);         
        
        mass.setBounds(80, 20, 150, 15);    //rozmiszczenie elementow
        springness.setBounds(80, 40, 150, 15);
        damping.setBounds(80, 60, 150, 15);
        earthacc.setBounds(80, 80, 150, 15);
        spring0length.setBounds(80, 100, 150, 15);
        resetButton.setBounds(157, 120, 150, 15);
            //dodawanie elementow
        add(mass);
        add(springness);
        add(damping);
        add(earthacc);
        add(spring0length);
        add(resetButton);      
            //dodanie "nasluchiwacza" do przycisku
        resetButton.addActionListener(this);
        
                 //ustalanie rozmiaru okna
        this.setSize(1000, 600);
                //dodawanie "nasluchiwaczy" myszy
        addMouseListener(this);
        addMouseMotionListener(this);
        
                //tworzenie obietow
        silnik=new SimEngine(1,50,0.3,100,0,150,0,0,0,0,-9.81);
        zadanie=new SimTask(silnik, this, 20);
        scheduler=new Timer();
                //tworzenie zadania ktore bedzie sie powtarzac
        scheduler.scheduleAtFixedRate(zadanie,1,(long)zadanie.getTimeStep());
        
    }
    
    @Override
    public void paint(Graphics g){        //Przeciazona metoda paint()
        Vector2D masloc=silnik.getMassLocation();
        
        int middlex=this.getSize().width/2;
        int middley=this.getSize().height/2;
        int endx=middlex+(int)(masloc.x);
        int endy=middley+(int)(masloc.y);
        
        g.clearRect(0, 150,  this.getSize().width, this.getSize().height );  //Czyszczenie powierzchni
        
        g.drawLine( middlex,middley, endx,endy ); //rysowanie sprezyny jako linii
        g.fillOval( endx-10,endy-10, 20,20 );   //rysowanie masy jako owalu

    }    
}
