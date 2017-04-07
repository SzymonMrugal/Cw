public class Vector2D {
    
    public float x,y;   //Pola wspolrzednych
                
    public Vector2D(){  //konstruktor bez parametrow
        this.x=0; this.y=0;
    }
    
    public Vector2D(float x, float y){  //konstruktor z parametrami
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
    
    public Vector2D multiples(float number){    //wektor przemnozony przez skalar
        Vector2D ans=new Vector2D();
        ans.x=this.x*number;
        ans.y=this.y*number;
        return ans;        
    }
    
    public float length(){  //dlugos wektora
        return( (float)Math.sqrt((double)(this.x*this.x) + (double)(this.y*this.y))  );
    }
    
    public Vector2D normalize(){    //normalizacja wektora
        Vector2D ans=new Vector2D();
        ans.x = this.x/this.length();
        ans.y = this.y/this.length();
        return ans;
    }
    
}
