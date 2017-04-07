import javax.swing.*;
import java.awt.*;

public class SpringApplet extends JApplet {
    

    @Override
    public void init() {
        
        Vector2D wektor1 = new Vector2D(2,1);   //utworzenie wektorow
        Vector2D wektor2 = new Vector2D(5,1);
        Vector2D wektorsum = wektor1.sum(wektor2);  //suma wektorow
        Vector2D wektorsub = wektor1.substract(wektor2);    //roznica wektorow
        Vector2D wektor1norm=  wektor1.normalize(); //wektor 1 znormalizowany
        Vector2D wektor2norm=  wektor2.normalize(); //wektor 2 znormalizowany
        float len1 = wektor1.length();  //dlugosc wektora 1
        float len2 = wektor2.length();  //dlugosc wektora 2
        Vector2D wektormult = wektor1.multiples(3); //wektor 1 przemnozony przez 3
                
        System.out.println("Wyniki:");      //Wyswietlenie wynikow i wpolrzednych wektorow
        System.out.println("Pierwszy wektor: "+wektor1.x+","+wektor1.y);
        System.out.println("Drugi wektor: "+wektor2.x+","+wektor2.y);
        System.out.println("Suma wektorow: "+wektorsum.x+","+wektorsum.y);
        System.out.println("Roznica wektorow: "+wektorsub.x+","+wektorsub.y);
        System.out.println("Znormalizowany wektor  1: "+wektor1norm.x+","+wektor1norm.y);
        System.out.println("Znormalizowany wektor  2: "+wektor2norm.x+","+wektor2norm.y);
        System.out.println("Dlugosc wektor 1: "+len1);
        System.out.println("Dlugosc wektor 2: "+len2);
        System.out.println("Wektor 1 pomnozony przez 3: "+wektormult.x+","+wektormult.y);        
        System.out.println();
        }
    
    //@Override
    public void paint(Graphics g){
        
    }    
}
