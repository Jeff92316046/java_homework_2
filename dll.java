import java.util.Scanner;
import java.lang.Integer;
public class dll {
    public static void main(String args[]){
        String polynomial1;
        String polynomial2;
        String mode;
        Scanner sc = new Scanner(System.in);
        for(;;){
            System.out.println("選擇加(輸入+)or減(輸入-)");
            System.out.println("結束輸入end");
            mode = sc.next();
            if(mode.equals("end")){
                break;
            }
            System.out.println("多項式1:");
            polynomial1 = sc.next();
            System.out.println("多項式2:");
            polynomial2 = sc.next();
            node pFirst = new node(null ,"", null);
            node temp = pFirst;
            String strTemp[] = polynomial1.split("\\+");
            pFirst.data = strTemp[0];
            for(int i=1;i<strTemp.length;i++){
                temp.next = new node(temp,strTemp[i], null);
                temp = temp.next;
            }
            strTemp = polynomial2.split("\\+");
            int flag = 0;
            if(mode.equals("+")){
                for(int i=0;i<strTemp.length;i++){
                    String coeffAndPower[] = strTemp[i].split("\\(|X|^|\\)");//1 and 4
                    temp = pFirst;
                    /**/
                    
                    for(;temp.next != null;){
                        //String.valueOf(Integer.valueOf(coeffAndPower[1])+Integer.valueOf(temp.data));
                        String coeffAndPowertemp[] = temp.data.split("\\(|X|^|\\)");
                        if(coeffAndPower[4].equals(coeffAndPowertemp[4])){
                            temp.data = "(" + String.valueOf(Integer.valueOf(coeffAndPower[1])+Integer.valueOf(coeffAndPowertemp[1])) + ")X^(" + coeffAndPower[4] + ")";
                            flag = 1;
                            
                        }
                        temp = temp.next;
                        
                    }
              
                    if(flag == 1){
                        flag = 0;
                        continue;
                    }
                    temp = pFirst;
                    for(;temp.next != null;){
                        String coeffAndPowertemp1[] = temp.data.split("\\(|X|^|\\)");
                        String coeffAndPowertemp2[] = temp.next.data.split("\\(|X|^|\\)");
                        if(Integer.valueOf(coeffAndPowertemp1[4])<Integer.valueOf(coeffAndPower[4]) && Integer.valueOf(coeffAndPower[4])<Integer.valueOf(coeffAndPowertemp2[4])){
                            temp.next = new node(temp,strTemp[i], temp.next);
                            temp.next.next.pre = temp.next;
                            break;
                            
                        }else if(Integer.valueOf(coeffAndPower[4])>Integer.valueOf(coeffAndPowertemp2[4]) && temp.next.next==null){
                            temp.next.next = new node(temp,strTemp[i], null);
                            break;
                        }else if(Integer.valueOf(coeffAndPowertemp1[4])>Integer.valueOf(coeffAndPower[4])){
                            temp.next.next = new node(null,strTemp[i],temp);
                            break;
                        }
                        temp = temp.next;
                    }
                
                    
                }
                temp = pFirst;
                System.out.print(temp.data);
                temp = temp.next;
                for(;temp.next != null;){
                    System.out.print("+"+temp.data);
                    temp = temp.next;
                }
                System.out.print("+"+temp.data);
                System.out.println("");
            }else if(mode.equals("-")){
                for(int i=0;i<strTemp.length;i++){
                    String coeffAndPower[] = strTemp[i].split("\\(|X|^|\\)");//1 and 4
                    temp = pFirst;
                    /**/
                    for(;temp.next != null;){
                        //String.valueOf(Integer.valueOf(coeffAndPower[1])+Integer.valueOf(temp.data));
                        String coeffAndPowertemp[] = temp.data.split("\\(|X|^|\\)");
                        if(coeffAndPower[4].equals(coeffAndPowertemp[4])){
                            temp.data = "(" + String.valueOf(-Integer.valueOf(coeffAndPower[1])+Integer.valueOf(coeffAndPowertemp[1])) + ")X^(" + coeffAndPower[4] + ")";
                            flag = 1;
                        }
                        temp = temp.next;
                        
                    }
                    if(flag == 1){
                        flag = 0;
                        continue;
                    }
                    temp = pFirst;
                    for(;temp.next != null;){
                        String coeffAndPowertemp1[] = temp.data.split("\\(|X|^|\\)");
                        String coeffAndPowertemp2[] = temp.next.data.split("\\(|X|^|\\)");
                        if(Integer.valueOf(coeffAndPowertemp1[4])<Integer.valueOf(coeffAndPower[4]) && Integer.valueOf(coeffAndPower[4])<Integer.valueOf(coeffAndPowertemp2[4])){
                            temp.next = new node(temp,"(" + String.valueOf(-Integer.valueOf(coeffAndPower[1])) + ")X^(" + coeffAndPower[4] + ")", temp.next);
                            temp.next.next.pre = temp.next;
                            break;
                            
                        }else if(Integer.valueOf(coeffAndPower[4])>Integer.valueOf(coeffAndPowertemp2[4]) && temp.next.next==null){
                            temp.next.next = new node(temp,"(" + String.valueOf(-Integer.valueOf(coeffAndPower[1])) + ")X^(" + coeffAndPower[4] + ")", null);
                            break;
                        }else if(Integer.valueOf(coeffAndPowertemp1[4])>Integer.valueOf(coeffAndPower[4])){
                            temp.next.next = new node(null,"(" + String.valueOf(-Integer.valueOf(coeffAndPower[1])) + ")X^(" + coeffAndPower[4] + ")",temp);
                            break;
                        }
                        temp = temp.next;
                    }
                
                    
                }
                temp = pFirst;
                System.out.print(temp.data);
                temp = temp.next;
                for(;temp.next != null;){
                    System.out.print("+"+temp.data);
                    temp = temp.next;
                }
                System.out.print("+"+temp.data);
                System.out.println("");
            }
        }
    }
    
}

class node{
    node next;
    String data;
    node pre;
    node(node pre,String data,node next){
        this.data = data;
        this.next = next; 
        this.pre = pre;
    }
    
}