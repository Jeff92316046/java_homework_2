    import java.util.Scanner;
    import java.util.InputMismatchException;

    public class pyramid { 
        public static void main(String[] args){
            do{                                         
                int num = 0;
                String str = "";
                int choise = -1;
                System.out.print("輸入 n (金字塔高度)(n為-1時結束程式)(n為奇數,n>=1):"); //hint to input 
                try {
                    Scanner n = new Scanner(System.in);// input
                    num = n.nextInt();//read vaule
                    if(num<=1 || num%2==0){
                        if(num==-1){
                            break;
                        }else{
                            System.out.println("輸入錯誤,請輸入大於等於1的奇數整數");
                            continue;
                        }
                    }
                }   catch(InputMismatchException ex){
                    System.out.println("輸入錯誤,請輸入大於等於2的正整數");
                    continue;
                }
                System.out.print("輸入 s (金字塔字元)(字數限制1)"); //hint to input 
                try {
                    Scanner s = new Scanner(System.in);// input
                    str = s.next();//read vaule
                    if(str.length()>1){
                        System.out.println(str.length());
                        System.out.println("輸入錯誤,請重新輸入");
                        continue;
                    
                    }
                }   catch(InputMismatchException ex){
                    System.out.println("輸入錯誤,請重新輸入");
                    continue;
                }
                System.out.print("選擇輸出形狀\nX輸入1\n*輸入2\nY輸入3\n"); //hint to input 
                try {
                    Scanner s = new Scanner(System.in);// input
                    choise = s.nextInt();//read vaule
                    if(choise != 1 && choise != 2 && choise != 3 ){
                        System.out.println(choise);
                        System.out.println("輸入錯誤,請重新輸入");
                        continue;
                    
                    }
                }   catch(InputMismatchException ex){
                    System.out.println("輸入錯誤,請重新輸入");
                    continue;
                }
                if(choise == 1){
                    for(int i = 0;i < num;i++){ 
                        for(int j = 0;j < ((num-1)/2)-Math.abs(i-((num-1)/2)); j++){
                            System.out.print(" ");     
                        }
                        if((num-1)/2 != i){
                            System.out.print(str);  
                        }
                        for(int j = 0;j < 2*(Math.abs(i-((num-1)/2)))-1;j++){
                            System.out.print(" ");
                        }
                        System.out.print(str);
                        for(int j = 0;j < ((num-1)/2)-Math.abs(i-((num-1)/2)); j++){
                            System.out.print(" ");     
                        }
                        System.out.print("\n"); 
                    }
                }else if(choise == 2){
                    for(int i = 0;i < num;i++){
                        if((num-1)/2 != i){
                            //System.out.print(2-(Math.abs(i-((num-1)/2))+1));
                            for(int j = 0;j < ((num-1)/2)-Math.abs(i-((num-1)/2)); j++){
                                System.out.print(" ");     
                            }
                            System.out.print(str);  
                            for(int j = 0;j < 2*(Math.abs(i-((num-1)/2)))-1;j++){
                                System.out.print(" ");
                            }
                            System.out.print(str);
                            
                            System.out.print("\n"); 
                        }else{
                            for(int j = 0;j < num;j++){
                                System.out.print(str);
                            }
                            System.out.print("\n");
                        }             
                    }
                }else{
                    for(int i = 0;i < num;i++){
                        for(int j = 0;j < i; j++){
                            System.out.print(" ");     
                        }
                        if(i!=(num-1)){
                            System.out.print(str);  
                        }
                        for(int j = 0;j < ((num-i-1)*2)-1;j++){
                            System.out.print(" ");
                        }
                        System.out.print(str);
                        
                        System.out.print("\n"); 
                    }
                } 
                while(true)break;
            }while(true);
        }
    }

