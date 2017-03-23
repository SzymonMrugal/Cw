package cwiczenie1;

public class Bryla {
    
    int punkty[][]; //Tablica punktow ze wspolrzednymi i masa
    
    Bryla(int amount){ //Konstruktor z parametrem
        this.punkty = new int[amount][4]; //Trzy wspolrzedne i masa
            
        for(int i=0;i<punkty.length;i++){
            for(int j=0;j<punkty[i].length;j++){
                this.punkty[i][j]=(int)(Math.random()*30); //Pseudolosowe wartosci wspolrzednych i mas
            }  
        }
    }
    
    int[] get3Distances(int[] coor1,int[] coor2){  //Odleglosc punktow wzgledem osi 
            int[] temp=new int[3];
            for(int i=0;i<3;i++){
                temp[i]=coor1[i]-coor2[i];
            }
            return temp;
    }
    
    int[] getCenMassPoint(){  //Srodek masy
        int temp1=0, temp2=0;
        int[] temp=new int[3];
        
        for(int j=0;j<3;j++){
            for(int i=0;i<punkty.length;i++){
                temp1=temp1 + punkty[i][j]*punkty[i][3];
                temp2=temp2 + punkty[i][3];
            }
            temp[j]=temp1/temp2;
            temp1=0; temp2=0;
        }
        return temp;
    }
    
    int[] getMomOfIner(){   //Moment bezwladnosci wzgledem trzech osi
        int[] cenPoint = getCenMassPoint();
        int[] temp=new int[3];
        int temp1,temp2;
        
        for(int i=0;i<punkty.length;i++){
            temp1 = get3Distances(punkty[i],cenPoint)[1];
            temp2 = get3Distances(punkty[i],cenPoint)[2];
            temp1 = (int)(Math.sqrt(temp1*temp1 + temp2*temp2));
            temp[0] = temp1*punkty[i][3];  //Os OX
        }
        for(int i=0;i<punkty.length;i++){
            temp1 = get3Distances(punkty[i],cenPoint)[0];
            temp2 = get3Distances(punkty[i],cenPoint)[2];
            temp1 = (int)(Math.sqrt(temp1*temp1 + temp2*temp2));
            temp[1] = temp1*punkty[i][3];  //Os OY
        }
        for(int i=0;i<punkty.length;i++){
            temp1 = get3Distances(punkty[i],cenPoint)[0];
            temp2 = get3Distances(punkty[i],cenPoint)[1];
            temp1 = (int)(Math.sqrt(temp1*temp1 + temp2*temp2));
            temp[2] = temp1*punkty[i][3];  //Os OZ
        }
        
        return temp;    
    }
}