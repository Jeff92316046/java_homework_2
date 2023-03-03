import java.util.Scanner;
import java.util.ArrayList;
import java.util.InputMismatchException;

public class prime_number { 
    public static void main(String[] args){
        for(;;){
            System.out.print("輸入 n (n為-1時結束程式)(n為大於等於2的正整數):"); //hint to input 
            try {
                Scanner n = new Scanner(System.in);// input
                int num = n.nextInt();//read vaule
                if(num<=1){
                    if(num==-1){
                        break;
                    }else{
                        System.out.println("輸入錯誤,請輸入大於等於2的正整數");
                        continue;
                    }
                }
                ArrayList<Integer> fac = new ArrayList<Integer>();//因數陣列
                Boolean prime_number_flag = false;//flag for prime number
                Boolean perfect_number_flag = false;//flag for perfect number
                for(int i=2; i<=num ; i++){//遍歷2~n
                    //找i的因數
                    for(int j=1; j<=i; j++){
                        if(i%j==0){
                            fac.add(j);
                        }
                    }    
                    if (fac.size()==2){
                        prime_number_flag = true;//判斷是否為質數
                    }
                    int sum = 0;
                    for(int j=0;j<fac.size()-1;j++){
                        sum += fac.get(j);//因數和
                    }
                    if(sum == i){
                        perfect_number_flag = true;//判斷是否為完美數
                    }
                    //IO
                    System.out.println(i+"的因數:");
                    for(int j=0;j<fac.size();j++){
                        System.out.print(fac.get(j)+" ");
                        
                    }
                    System.out.print("\n");
                    if(prime_number_flag){
                        System.out.println(i+"是質數");
                    }else{
                        System.out.println(i+"是和數");
                    }
                    if(perfect_number_flag){
                        System.out.println(i+"是完美數");
                    }else{
                        System.out.println(i+"是虧數");
                    }
                    if(i%2==1){
                        System.out.println(i+"是奇數");
                    }else {
                        System.out.println(i+"是偶數");
                    }
                    System.out.print("\n");
                    //重置flag and 因數陣列
                    fac.clear();
                    sum = 0;
                    prime_number_flag = false;
                    perfect_number_flag = false;
                }
            }   catch(InputMismatchException ex){
                System.out.println("輸入錯誤,請輸入大於等於2的正整數");
                continue;
            }
            
            
        
    }
    }
}

