package cwiczenie1;


public class Walec extends Punkt {
    
    private int promien,wysokosc;
    
    int getRadius(){
        return this.promien;
    }
    
    int getHeight(){
        return this.wysokosc;
    }
    
    void setRadius(int r){
        this.promien=r;
    }
    
    void setHeight(int l){
        this.wysokosc=l;
    }
    
    public Walec(){ //Konstruktor bez parametrow
        super();
        this.promien=1;
        this.wysokosc=2;
    }
    
    public Walec(int m,int r,int h){    //Konstruktor z trzema parametrami
        super(m);
        this.promien=r;
        this.wysokosc=h;
     }
    
    @Override
    int MainMomOfIner(){    //Przeciazona metoda zwracajaca moment bezwladnosci
        return (int)((double)((this.Mass)*(this.promien)*(this.promien))*0.5);
    }
    
    @Override
    String Descriptor(){    //Przeciazona metoda zwracajaca prosty opis
        return "Walec";   
    }
    
    @Override
    String DescriptAll(){   //Przeciazona metoda opisujaca obiekt
        String txt;
        txt=Descriptor()+" :\n";
        txt=txt+" -Masa :\t"+this.getMass()+"\n";
        txt=txt+" -Promien :\t"+this.getRadius()+"\n";
        txt=txt+" -Wysokosc :\t"+this.getHeight()+"\n";
        txt=txt+" -Moment bezw :\t"+this.MainMomOfIner()+"\n";
        return txt;
    }
}
