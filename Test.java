package cwiczenie1;


public class Test {

    public static void main(String[] args) {
        Punkt point1 = new Punkt();         //Tworzenie Nowych punktow
        Punkt point2 = new Punkt(7);        //za pomoca konstruktora z parametrami i bez
        
        System.out.println("Opis pierwszego punktu: ");        //Wyswietlanie pelnego opisu pierwszego punkttu
        System.out.println("  " + point1.Descriptor());
        System.out.println("  Masa: \t\t\t\t" + point1.getMass());
        System.out.println("  Glowny moment bezwladnosci: \t\t" + point1.MainMomOfIner());
        System.out.println("  Moment bezwladnosci wzgledem osi: \t" + point1.MomOfIner(2));
        System.out.println();
        
        System.out.println("Opis drugiego punktu: ");           //Wyswietlanie pelnego opisu drugiego punkttu
        System.out.println("  " + point2.Descriptor());
        System.out.println("  Masa: \t\t\t\t" + point2.getMass());
        System.out.println("  Glowny moment bezwladnosci: \t\t" + point2.MainMomOfIner());
        System.out.println("  Moment bezwladnosci wzgledem osi: \t" + point2.MomOfIner(2));
        System.out.println();
        
        point1.setMass(4);              //Zmiana masy pierwszego punktu
        
        System.out.println("Opis pierwszego punktu po zmianie masy: ");   //Wyswietlanie pelnego opisu pierwszego punktu po zmianie masy
        System.out.println("  " + point1.Descriptor());
        System.out.println("  Masa: \t\t\t\t" + point1.getMass());
        System.out.println("  Glowny moment bezwladnosci: \t\t" + point1.MainMomOfIner());
        System.out.println("  Moment bezwladnosci wzgledem osi: \t" + point1.MomOfIner(2));       
        System.out.println();
        System.out.println();
        
        Punkt[] points = new Punkt[5];          //Tworzenie tablicy punktow
        for (int i=0; i<points.length; i++){    //Zainicjowanie tablicy punktowza pomoca petli
            points[i]= new Punkt(i+7);
        }
        
        System.out.println("--Opis punktow w tablicy: --");     //Wyswietlenie pelnego opisu kazdego punktu z tablicy
        for(int i=0; i<points.length; i++){
            System.out.println("| " + points[i].Descriptor());
            System.out.println("| Masa: \t\t\t\t" + points[i].getMass());
            System.out.println("| Glowny moment bezwladnosci: \t\t" + points[i].MainMomOfIner());
            System.out.println("| Moment bezwladnosci wzgledem osi: \t" + points[i].MomOfIner(2));
        
            System.out.println("|------------------------");
        }       
        System.out.println();
        System.out.println();
            
        //Zadanie na piatke 
        Bryla solid= new Bryla(4);        
        
        System.out.println("----Bryła----");
        System.out.println("Wspolrzedne i masa punktow:");      //Wysietlanie wszpolrzednych punktow
        for(int i=0; i<solid.punkty.length; i++){      
            System.out.print(solid.punkty[i][0] + ",");
            System.out.print(solid.punkty[i][1] + ",");
            System.out.print(solid.punkty[i][2] + ",");
            System.out.println(solid.punkty[i][3]);
        }
        System.out.println("Wspolrzedne srodka ciezkosci:");    //Wysietlanie wspolrzednych srodka ciezkoscci
        for(int i=0; i<3; i++)
             System.out.print(solid.getCenMassPoint()[i] + ",");
        System.out.println();
        
        System.out.println("Moment bezwladnosci wzgledem osi:");    //Wysietlanie momentu bezwladnosci dla osi OX,OY,OZ
        for(int i=0;i<3;i++)
            System.out.print(solid.getMomOfIner()[i] + ",");
         System.out.println();
         System.out.println();        
    }
    
}