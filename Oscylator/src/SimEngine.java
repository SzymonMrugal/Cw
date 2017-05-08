public class SimEngine {
    
    private double m,k,c,l0;
    private Vector2D ml,sl,mv,g;
                                        //Konstruktor z parametrami
    public SimEngine(double m,double k,double c,double l0,double mx,double my,double sx,double sy,double mvx,double mvy,double gw){
        this.m=m;this.k=k;this.c=c;this.l0=l0;
        this.ml = new Vector2D (mx,my);
        this.sl = new Vector2D (sx,sy);
        this.mv = new Vector2D (mvx,mvy);
        this.g = new Vector2D (0,gw);
    }
                                //Akcesory
    double getMass(){return m;}
    
    void setMass(double m){if(m>0) this.m=m; else this.m=0;}
    
    double getSpringiness(){return k;}
    
    void setSpringiness(double k){this.k=k;}
     
    double getDamping(){return c; }
    
    void setDamping(double c){this.c=c;}
      
    double getSpringStartLength(){return l0;}
    
    void setSpringStartLength(double l0){this.l0=l0;}
       
    Vector2D getMassLocation(){return ml;}
    
    void setMassLocation(Vector2D ml){this.ml=ml;}
        
    Vector2D getMassSpeed(){return mv;}
    
    void setMassSpeed(Vector2D mv){this.mv=mv;}
    
    Vector2D getHangPoint(){return sl; }
    
    void setHangPoint(Vector2D sl){this.sl=sl;}
    
    Vector2D getEarthAcc(){return g;}
    
    void setEarthAcc(Vector2D g){this.g=g;}
                            //Metoda obliczajaca przebieg symulacji
    void sym(double time){   
                
        time= time/1000;  //czas jest podawany w ms
       
       Vector2D Fg = g.multiples(m); //sila ciezkosci
       Vector2D temp = ml.normalize().multiples(l0);
       Vector2D Fk = ml.substract(temp).multiples(k);   //sila sprezystosci
       Vector2D Fc = mv.multiples(c);   //sila tlumienia
       
       Vector2D Fw = Fg.sum(Fk).sum(Fc); //sila wypadkowa
       Vector2D a = Fw.multiples(-1/m); //przyspieszenie
       
       mv = a.multiples(time).sum(mv);
       ml = mv.multiples(time).sum(ml);

    }
                    //Metoda resetujaca predkosc masy
    void reset(){this.mv=new Vector2D(0,0);}
    
}
