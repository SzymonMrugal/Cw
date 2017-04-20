public class SimEngine {
    
    private float m,k,c,l0,mx,my,sx,sy,gw;
    private Vector2D ml,sl,mv,g;
                                        //Konstruktor z parametrami
    public SimEngine(float m,float k,float c,float l0,float mx,float my,float sx,float sy,float mvx,float mvy,float gw){
        this.m=m;this.k=k;this.c=c;this.l0=l0;
        this.ml = new Vector2D (mx,my);
        this.sl = new Vector2D (sx,sy);
        this.mv = new Vector2D (mvx,mvy);
        this.g = new Vector2D (0,-gw);
    }
                                //Akcesory
    float getMass(){return m;}
    
    void setMass(float m){if(m>0) this.m=m; else this.m=0;}
    
    float getSpringiness(){return k;}
    
    void setSpringiness(float k){this.k=k;}
     
    float getDamping(){return c; }
    
    void setDamping(float c){this.c=c;}
      
    float getSpringStartLength(){return l0;}
    
    void setSpringStartLength(float l0){this.l0=l0;}
       
    Vector2D getMassLocation(){return ml;}
    
    void setMassLocation(Vector2D ml){this.ml=ml;}
        
    Vector2D getMassSpeed(){return mv;}
    
    void setMassSpeed(Vector2D mv){this.mv=mv;}
    
    Vector2D getHangPoint(){return sl; }
    
    void setHangPoint(Vector2D sl){this.sl=sl;}
    
    Vector2D getEarthAcc(){return g;}
    
    void setEarthAcc(Vector2D g){this.g=g;}
                            //Metoda obliczajaca przebieg symulacji
    void sym(float time){   
        float newvx,newvy;
        float len=ml.length();
                
        newvx = time * ( (-k*(len-l0)* (ml.x/ml.y) - c*mv.x*(ml.x/ml.y))/m ) + mv.x ;
        newvy = time * ( g.y + (-k*(len-l0)* (ml.y/ml.x) - c*mv.y*(ml.y/ml.x))/m ) + mv.y ;
        
        mv.x=newvx;
        mv.y=newvy;
        
        ml.x=mv.x*time + ml.x;
        ml.y=mv.y*time + ml.y;

    }
                    //Metoda resetujaca predkosc masy
    void reset(){this.mv=new Vector2D(0,0);}
    
}
