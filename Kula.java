package cwiczenie1;


public class Kula extends Punkt {
    
    private int promien;
    
    int getRadius(){
        return this.promien;
    }
    
    void setRadius(int r){
        this.promien=r;
    }
    
     public Kula(){ //Konstruktor bez parametrow
         super();
        this.promien=1;
    }
     
     public Kula(int m,int r){ //Konstruktor z dwoma parametrami
        super(m);
        this.promien=r;
     }
    
    @Override
    int MainMomOfIner(){    //Przeciazona metoda zwracajaca moment bezwladnosci
        return (int)((double)(this.Mass*this.promien*this.promien)*0.4);
    }
     
    @Override
    String Descriptor(){    //Przeciazona metoda zwracajaca prosty opis
        return "Kula";   
    }
    
    @Override
    String DescriptAll(){   //Przeciazona metoda opisujaca obiekt
        String txt;
        txt=Descriptor()+" :\n";
        txt=txt+" -Masa :\t"+this.getMass()+"\n";
        txt=txt+" -Promien :\t"+this.getRadius()+"\n";
        txt=txt+" -Moment bezw :\t"+this.MainMomOfIner()+"\n";
        return txt;
    }
}
