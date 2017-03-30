package cwiczenie1;


public class Pret extends Punkt {
    
    private int promien,dlugosc;
    
    int getRadius(){
        return this.promien;
    }
    
    int getLength(){
        return this.dlugosc;
    }
    
    void setRadius(int r){
        this.promien=r;
    }
    
    void setLength(int l){
        this.dlugosc=l;
    }
    
     public Pret(){ //Konstruktor bez parametrow
         super();
        this.promien=1;
        this.dlugosc=10;
    }
    
     public Pret(int m,int r,int l){    //Konstruktor z trzema parametrami
        super(m);
        this.promien=r;
        this.dlugosc=l;
     }
     
     @Override
     int MainMomOfIner(){   //Przeciazona metoda zwracajaca moment bezwladnosci
        return (int)((double)((this.Mass)*(this.promien)*(this.promien))*0.083);
    }
     
    @Override
    String Descriptor(){    //Przeciazona metoda zwracajaca prosty opis
        return "Pret";   
    }
    
    @Override
    String DescriptAll(){   //Przeciazona metoda opisujaca obiekt
        String txt;
        txt=Descriptor()+" :\n";
        txt=txt+" -Masa :\t"+this.getMass()+"\n";
        txt=txt+" -Promien :\t"+this.getRadius()+"\n";
        txt=txt+" -Dlugosc :\t"+this.getLength()+"\n";
        txt=txt+" -Moment bezw :\t"+this.MainMomOfIner()+"\n";
        return txt;
    }
     
}
