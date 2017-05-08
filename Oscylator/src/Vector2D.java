public class Vector2D {
    
    public double x,y;   //Pola wspolrzednych
                
    public Vector2D(){  //konstruktor bez parametrow
        this.x=0; this.y=0;
    }
    
    public Vector2D(double x, double y){  //konstruktor z parametrami
        this.x=x; this.y=y;
    }
    
    public Vector2D sum(Vector2D second){   //suma wektorow
        Vector2D ans=new Vector2D();
        ans.x=this.x+second.x;
        ans.y=this.y+second.y;
        return ans;        
    }
    
    public Vector2D substract(Vector2D second){ //roznica wektorow
        Vector2D ans=new Vector2D();
        ans.x=this.x-second.x;
        ans.y=this.y-second.y;
        return ans;        
    }
    
    public Vector2D multiples(double number){    //wektor przemnozony przez skalar
        Vector2D ans=new Vector2D();
        ans.x=this.x*number;
        ans.y=this.y*number;
        return ans;        
    }
    
    public double length(){  //dlugos wektora
        return( (float)Math.sqrt((double)(this.x*this.x) + (double)(this.y*this.y))  );
    }
    
    public Vector2D normalize(){    //normalizacja wektora
        Vector2D ans=new Vector2D();
        if(this.length() != 0){
            ans.x = this.x/this.length();
            ans.y = this.y/this.length();
            return ans;
        } else {
            return new Vector2D(0,0);
        }
    }
    
}
