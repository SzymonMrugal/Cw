import java.util.TimerTask;

public class SimTask extends TimerTask{
    
    private SimEngine silnik;
    private SpringApplet apl;
    private double timeStep;
                                //Konstruktor z parametrami
    public SimTask(SimEngine sil, SpringApplet aplet,long time){
        silnik=sil;
        apl=aplet;
        timeStep=time;
    }
    
    double getTimeStep(){   //akcesor
        return this.timeStep;
    }
    
    @Override           //Przeciazona metoda run()
    public void run(){
            
            silnik.sym(timeStep);   //uruchomienie obliczania kroku symulacji
            apl.repaint();        
    }
    
}
