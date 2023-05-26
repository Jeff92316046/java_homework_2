import java.util.Scanner;

public class largenum {
    public static void main(String args[]){
        String num1;
        String num2;
        String mode;
        Scanner sc = new Scanner(System.in);
        node num1First = new node(0, null);
        node num2First = new node(0, null);;
        node temp;
        for(;;){
            System.out.println("選擇加(輸入+)or減(輸入-)");
            System.out.println("結束輸入end");
            mode = sc.next();
            if(mode.equals("end")){
                break;
            }
            System.out.println("數字1(n>0):");
            num1 = sc.next();
            System.out.println("數字2(n>0):");
            num2 = sc.next();
            if(num1.length()>=num2.length()){
                num1First = new node(num1.charAt(num1.length()-1)-'0', null);
                temp = num1First;
                for(int i=1;i<num1.length();i++){ 
                    temp.next = new node(num1.charAt(num1.length()-1-i)-'0', null);
                    temp = temp.next;
                }
                num2First = new node(num2.charAt(num2.length()-1)-'0', null);
                temp = num2First;
                for(int i=1;i<num2.length();i++){ 
                    temp.next = new node(num2.charAt(num2.length()-1-i)-'0', null);
                    temp = temp.next;
                }
            }else{
                num2First = new node(num1.charAt(num1.length()-1)-'0', null);
                temp = num2First;
                for(int i=1;i<num1.length();i++){ 
                    temp.next = new node(num1.charAt(num1.length()-1-i)-'0', null);
                    temp = temp.next;
                }
                num1First = new node(num2.charAt(num2.length()-1)-'0', null);
                temp = num1First;
                for(int i=1;i<num2.length();i++){ 
                    temp.next = new node(num2.charAt(num2.length()-1-i)-'0', null);
                    temp = temp.next;
                }
            }

            if(mode.equals("+")){
                plus(num1First,num2First);
                String sum = "";
                for(node i=num1First;i!=null;i=i.next){
                    sum =  i.data + sum ;
                }
                System.out.println(sum);
            }else if(mode.equals("-")){
                minus(num1First,num2First);
                String afterminus = "";
                for(node i=num1First;i!=null;i=i.next){
                    afterminus =  i.data + afterminus ;
                }
                for(int i=0;i<afterminus.length();i++){
                    if(afterminus.charAt(i)=='0'){
                        //System.out.print("owo");
                        afterminus = afterminus.substring(1);
                    }else break;
                }
                System.out.println(afterminus);
            }else{
                System.out.println("輸入錯誤");
            }
        }
    }
    public static void plus(node num1,node num2){
        for(node temp1 = num1,temp2 = num2;temp2 != null;temp1 = temp1.next,temp2 = temp2.next){
            temp1.data += temp2.data;
        }
        for(node temp1 = num1;temp1 != null;temp1 = temp1.next){
            if(temp1.data>=10){
                temp1.data -= 10;
                temp1.next.data +=1;
            }
        }
    }
    public static void minus(node num1,node num2){
        for(node temp1 = num1,temp2 = num2;temp2 != null;temp1 = temp1.next,temp2 = temp2.next){
            temp1.data -= temp2.data;
        }
        
        for(node temp1 = num1;temp1 != null;temp1 = temp1.next){
            if(temp1.data<0){
                temp1.data += 10;
                temp1.next.data -=1;
            }
    
        }
    }
}

class node{
    node next;
    int data;
    node(int data,node next){
        this.data = data;
        this.next = next; 
    }
    
}