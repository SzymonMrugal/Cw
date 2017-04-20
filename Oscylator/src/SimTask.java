import java.util.TimerTask;

public class SimTask extends TimerTask{
    
    private SimEngine silnik = new SimEngine(5,20,2,1,-1,-5,0,0,0,0,10);
    private SpringApplet apl = new SpringApplet();
    private float timeStep;
                                //Konstruktor z parametrami
    public SimTask(SimEngine sil, SpringApplet aplet, float time){
        silnik=sil;
        apl=aplet;
        timeStep=time;
    }
    
    @Override           //Przeciazona metoda run()
    public void run(){
        
        while(true){
            silnik.sym(timeStep);   //uruchomienie obliczania kroku symulacji
            apl.repaint();
        }
        
    }
    
}
