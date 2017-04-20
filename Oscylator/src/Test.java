public class Test {
    
    public static void main(String[] args) {
        SimEngine sil = new SimEngine(5,20,2,1,-150,-200,0,0,0,0,10);
        SpringApplet aplet = new SpringApplet();
        
        SimTask a = new SimTask(sil, aplet, 1);
        a.run();
        //a.paint();
        
    }
    
}
