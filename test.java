import java.util.Scanner;
public class test {
    public static void main(String[] args) {
        String s1;  
        int nn;
        Scanner input = new Scanner(System.in);
        a aa = new a();
        a a1 = aa;
        System.out.println(aa+"\n"+a1);
    }
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
class a{
    a(){

    }
}