import java.util.Scanner;
public class test {
    public static void main(String[] args) {
        String s1;  
        int nn;
        Scanner input = new Scanner(System.in);
        while (true){
          System.out.print("輸入層數(如5)：");
          nn=input.nextInt();
          if (nn<=2) System.exit(-1);
          System.out.print("輸入符號(如#)：");
          s1 = input.next();      
          printsign(s1,0,nn); //從0開始到nn-1層
             }//while
         }//main
     //write here
     static void printsign(String s1,int b, int e){
        for(int i=0;i<e-(2*b+1);i++){
           System.out.print(" ");
        }
        for(int i=0;i<2*b+1;i++){
           System.out.print(s1);
        }
        System.out.println("");
        if(b!=e){
               printsign(s1,++b,e);
        }
     
    }
}//class