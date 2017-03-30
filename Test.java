package cwiczenie1;


public class Test {

    public static void main(String[] args) {
        
        Walec cylinder = new Walec(50,5,10);    //Tworzenie trzech obiektow
        Kula ball = new Kula(50,5);
        Pret wand = new Pret(50,5,20);
        
        System.out.println(cylinder.DescriptAll());  //Wyswietlanie opisu walca
        
        System.out.println(ball.DescriptAll());  //Wyswietlanie opisu kuli

        System.out.println(wand.DescriptAll());    //Wyswietlanie opisu pretu
        
                                //Tworzenie tablicy obiektow
        Punkt[] solids = {new Kula(),new Walec(),new Pret()};
        
                                //Wyswietlanie opisu obiektow
        System.out.println("-Obiekty w tablicy:-");
        for(int i=0;i<3;i++){
            System.out.print(solids[i].DescriptAll());
        }
        System.out.println();
        
        System.out.println("Momenty bezwladnosci wzgledem osi oddalonej o 5 :");
        for(int i=0;i<3;i++){
            System.out.println(solids[i].MomOfIner(5)+",");
        }
        System.out.println();
        
        /*BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("\nAbyprzejsc do menu wcisnij dowolny przycisk");
        in.readLine();
        while(true){
            int temp = Integer.parseInt(in.readLine());
            

        }*/
    }
}