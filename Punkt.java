package cwiczenie1;


public class Punkt {
    
    private int Mass;   //Prywatna zmienna
    
    int getMass(){      //Zwracanie wartosci prywatnej zmiennej
        return this.Mass;
    }
    
    void setMass(int newMass){  //Przypisanie wartosci prywatnej zmiennej
        this.Mass=newMass;
    }
    
    Punkt(){    //Konstruktor domyślny
        this.Mass=5;
    }   
    
    Punkt(int newMass){ //Konstruktor z parametrem
        if (newMass>0)
            this.Mass=newMass;
        else
            this.Mass=5;
    }
    
    int MainMomOfIner(){    //Glowny moment bezwladnsci = 0 
        return this.Mass*0*0;
    }
    
    int MomOfIner(int r){   //Moment bezwladnosci wzgledem osi odleglej o r
        return (this.MainMomOfIner()+this.Mass*r*r);
    }
    
    String Descriptor(){    
     return "Punkt materialny";   
    }
}
