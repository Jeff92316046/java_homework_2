import java.util.Scanner;
import java.lang.Integer;
import java.util.HashMap;
import java.util.Map ;
import java.lang.Math;


public class Bodh_recursive {
    
    public static void main(String[] args){
        int mode = 0;
        int bodh = 0;
        String num = "";
        int [] Q_sum = {0,0,0,0};
        int [] Q_correct = {0,0,0,0};
        for(;;){
            System.out.println("輸入模式m (m為-1時結束程式)");
            System.out.print("m=1,教學模式\nm=2,測驗模式\n");
            Scanner m = new Scanner(System.in);// input
            mode = m.nextInt();//read vaule 
            if(mode==1){
                System.out.println("輸入模式b");
                System.out.print("b=2,二進位\nb=8,八進位\nb=10,十進位\nb=16,十六進位\n");
                Scanner b = new Scanner(System.in);// input
                bodh = b.nextInt();//read vaule
                if(bodh==2){
                    System.out.println("輸入數值n(n>0)");
                    Scanner n = new Scanner(System.in);// input
                    num = n.next();//read vaule
                    System.out.println("八進位");
                    System.out.println(Oct_t(num,0,-1));
                    System.out.println("十進位");
                    System.out.println(dec_t(num.split("\\."),0,-1));
                    System.out.println("十六進位");
                    System.out.println(Hex_t(num,0,-1));
                }else if(bodh==8){
                    System.out.println("輸入數值n(n>0)");
                    Scanner n = new Scanner(System.in);// input
                    num = n.next();//read vaule
                    String [] num_list = num.split("\\.");
                    System.out.println("二進位");
                    String temp_1 = int_bin_t(num_list[0], bodh,0);
                    String temp_2 = dec_bin_t(num_list[1], bodh,0);
                    System.out.println(temp_1+"."+temp_2);
                    System.out.println("十進位");
                    System.out.println(dec_t((temp_1+"."+temp_2).split("\\."),0,-1));
                    System.out.println("十六進位");
                    System.out.println(Hex_t((temp_1+"."+temp_2),0,-1));
                }else if(bodh==10){
                    System.out.println("輸入數值n(n>0)");
                    Scanner n = new Scanner(System.in);// input
                    num = n.next();//read vaule
                    String [] num_list = num.split("\\.");
                    System.out.println("二進位");
                    String temp_1 = int_bin_t(num_list[0], bodh,0);
                    String temp_2 = dec_bin_t(num_list[1], bodh,0);
                    System.out.println(temp_1+"."+temp_2);
                    System.out.println("八進位");
                    System.out.println(Oct_t((temp_1+"."+temp_2),0,-1));
                    System.out.println("十六進位");
                    System.out.println(Hex_t((temp_1+"."+temp_2),0,-1));
                }
                else if(bodh==16){
                    System.out.println("輸入數值n(n>0)");
                    Scanner n = new Scanner(System.in);// input
                    num = n.next();//read vaule
                    String [] num_list = num.split("\\.");
                    System.out.println("二進位");
                    String temp_1 = int_bin_t(num_list[0], bodh,0);
                    String temp_2 = dec_bin_t(num_list[1], bodh,0);
                    System.out.println(temp_1+"."+temp_2);
                    System.out.println("八進位");
                    System.out.println(Oct_t((temp_1+"."+temp_2),0,-1));
                    System.out.println("十六進位");
                    System.out.println(dec_t((temp_1+"."+temp_2).split("\\."),0,-1));
                }else{
                    System.out.println("輸入錯誤");
                    continue;
                }
            }else if(mode==2){
                System.out.println("開始測驗");
                System.out.println("總共三題(累積答對率)");
                for(int i=0;i<3;i++){
                    bodh = (int)(Math.random()*4);   
                    
                    String b = "";
                    String o = "";
                    String d = "";
                    String h = "";
                    for(int j=0;j<8;j++){
                        b = b + Integer.toString((int)(Math.random()*2));
                    }
                    b = b +".";
                    for(int j=0;j<3;j++){
                        b = b + Integer.toString((int)(Math.random()*2));
                    }
                    System.out.println(b);
                    o = Oct(b);
                    d = dec(b);
                    h = Hex(b);
                    System.out.println("第"+(i+1)+"題");
                    if(bodh==0){
                        System.out.println(b+"(二進位)");
                        System.out.print("八進位:");
                        Scanner n = new Scanner(System.in);// input
                        num = n.next();//read vaule
                        Q_sum[1]++;
                        if(num.equals(o)){
                            System.out.println("正確");
                            Q_correct[1]++;
                        }else{
                            System.out.println("錯誤");
                            System.out.println(Oct_t(b,0,-1));

                        }
                        System.out.print("十進位:");
                        num = n.next();//read vaule
                        Q_sum[2]++;
                        if(num.equals(d)){
                            System.out.println("正確");
                            Q_correct[2]++;
                        }else{
                            System.out.println("錯誤");
                            System.out.println(dec_t(b.split("\\."),0,-1));
                        }
                        System.out.print("十六進位:");
                        num = n.next();//read vaule
                        Q_sum[3]++;
                        if(num.equals(h)){
                            System.out.println("正確");
                            Q_correct[3]++;
                        }else{
                            System.out.println("錯誤");
                            System.out.println(Hex_t(b,0,-1));
                        }
                    } else if(bodh==1){
                        System.out.println(o+"(八進位)");
                        System.out.print("二進位:");
                        Scanner n = new Scanner(System.in);// input
                        num = n.next();//read vaule
                        Q_sum[0]++;
                        if(num.equals(b)){
                            System.out.println("正確");
                            Q_correct[0]++;
                        }else{
                            System.out.println("錯誤");
                            String [] num_list = o.split("\\.");
                            
                            String temp_1 = int_bin_t(num_list[0], 8,0);
                            String temp_2 = dec_bin_t(num_list[1], 8,0);
                            System.out.println(temp_1+"."+temp_2);

                        }
                        System.out.print("十進位:");
                        num = n.next();//read vaule
                        Q_sum[2]++;
                        if(num.equals(d)){
                            System.out.println("正確");
                            Q_correct[2]++;
                        }else{
                            System.out.println("錯誤");
                            System.out.println(dec_t(b.split("\\."),0,-1));
                        }
                        System.out.print("十六進位:");
                        num = n.next();//read vaule
                        Q_sum[3]++;
                        if(num.equals(h)){
                            System.out.println("正確");
                            Q_correct[3]++;
                        }else{
                            System.out.println("錯誤");
                            System.out.println(Hex_t(b,0,-1));
                        } 
                    }else if(bodh==2){
                        System.out.println(d+"(十進位)");
                        System.out.print("二進位:");
                        Scanner n = new Scanner(System.in);// input
                        num = n.next();//read vaule
                        Q_sum[0]++;
                        if(num.equals(b)){
                            System.out.println("正確");
                            Q_correct[0]++;
                        }else{
                            System.out.println("錯誤");
                            String [] num_list = d.split("\\.");
                            System.out.println(num_list[0]);
                            String temp_1 = int_bin_t(num_list[0], 10,0);
                            String temp_2 = dec_bin_t(num_list[1], 10,0);
                            System.out.println(temp_1+"."+temp_2);

                        }
                        System.out.print("八進位:");
                        num = n.next();//read vaule
                        Q_sum[1]++;
                        if(num.equals(o)){
                            System.out.println("正確");
                            Q_correct[1]++;
                        }else{
                            System.out.println("錯誤");
                            System.out.println(Oct_t(b,0,-1));
                        }
                        System.out.print("十六進位:");
                        num = n.next();//read vaule
                        Q_sum[3]++;
                        if(num.equals(h)){
                            System.out.println("正確");
                            Q_correct[3]++;
                        }else{
                            System.out.println("錯誤");
                            System.out.println(Hex_t(b,0,-1));
                        }
                    } else if(bodh==3){
                        System.out.println(h+"(十六進位)");
                        System.out.print("二進位:");
                        Scanner n = new Scanner(System.in);// input
                        num = n.next();//read vaule
                        Q_sum[0]++;
                        if(num.equals(b)){
                            System.out.println("正確");
                            Q_correct[0]++;
                        }else{
                            System.out.println("錯誤");
                            String [] num_list = h.split("\\.");
                            
                        
                            String temp_1 = int_bin_t(num_list[0], 16,0);
                            String temp_2 = dec_bin_t(num_list[1], 16,0);
                            System.out.println(temp_1+"."+temp_2);

                        }
                        System.out.print("八進位:");
                        num = n.next();//read vaule
                        Q_sum[1]++;
                        if(num.equals(o)){
                            System.out.println("正確");
                            Q_correct[1]++;
                        }else{
                            System.out.println("錯誤");
                            System.out.println(Oct_t(b,0,-1));
                        }
                        System.out.print("十進位:");
                        num = n.next();//read vaule
                        Q_sum[2]++;
                        if(num.equals(d)){
                            System.out.println("正確");
                            Q_correct[2]++;
                        }else{
                            System.out.println("錯誤");
                            System.out.println(dec_t(b.split("\\."),0,-1));
                        }
                    } 
                    
                    System.out.println("二進位答對率  :"+ ((double)(Q_correct[0])/(double)(Q_sum[0]))*100 + "%");
                    System.out.println("八進位答對率  :"+ ((double)(Q_correct[1])/(double)(Q_sum[1]))*100 + "%");
                    System.out.println("十進位答對率  :"+ ((double)(Q_correct[2])/(double)(Q_sum[2]))*100 + "%");
                    System.out.println("十六進位答對率:"+ ((double)(Q_correct[3])/(double)(Q_sum[3]))*100 + "%");
                } 
            }else if(mode == -1){
                break;
            }else{
                System.out.println("輸入錯誤");
                continue;
            }
                
                
            }
        }
              
        //System.out.println(Hex("1011110.101"));
        
    /*
    static String int_bin(String str,int bodh){
        String bin = "";
        
        if (bodh == 10){
            int temp = Integer.valueOf(str);
            for (;;){
                bin = (temp%2) + bin;
                temp/=2;
            }
        }else if(bodh == 8){
            Map<Character,String> Oct = new HashMap<>();
            Oct.put('0', "000");
            Oct.put('1', "001");
            Oct.put('2', "010");
            Oct.put('3', "011");
            Oct.put('4', "100");
            Oct.put('5', "101");
            Oct.put('6', "110");
            Oct.put('7', "111");
            for (int i=0;i<str.length();i++){
                bin = bin + Oct.get(str.charAt(i));
            }
        }else if(bodh == 16){
            Map<Character,String> Hex = new HashMap<>();
            Hex.put('0', "0000");
            Hex.put('1', "0001");
            Hex.put('2', "0010");
            Hex.put('3', "0011");
            Hex.put('4', "0100");
            Hex.put('5', "0101");
            Hex.put('6', "0110");
            Hex.put('7', "0111");
            Hex.put('8', "1000");
            Hex.put('9', "1001");
            Hex.put('A', "1010");
            Hex.put('B', "1011");
            Hex.put('C', "1100");
            Hex.put('D', "1101");
            Hex.put('E', "1110");
            Hex.put('F', "1111");
            for (int i=0;i<str.length();i++){
                bin = bin + Hex.get(str.charAt(i));
            }
        }
        return bin;
    }
    */
    static String int_bin_t(String str,int bodh,int len){
        String bin = "";
        
        if (bodh == 10){
            int temp = Integer.valueOf(str);
            
            /*
            for (;;){
                bin = (temp%2) + bin;
                System.out.println(temp+"->"+(temp%2));
                temp -= temp%2;
                temp/=2;
                
                if(temp==0)break;
            }
            */
            if(temp==0)return "";
            System.out.println(temp+"->"+(temp%2));
            return int_bin_t(Integer.toString(temp/2),bodh,0) + (temp%2);
        }else if(bodh == 8){
            Map<Character,String> Oct = new HashMap<>();
            System.out.println("八進位:");
            System.out.println("整數:");
            Oct.put('0', "000");
            Oct.put('1', "001");
            Oct.put('2', "010");
            Oct.put('3', "011");
            Oct.put('4', "100");
            Oct.put('5', "101");
            Oct.put('6', "110");
            Oct.put('7', "111");
            /*
            for (int i=0;i<str.length();i++){
                bin = bin + Oct.get(str.charAt(i));
                System.out.println(str.charAt(i)+"->"+Oct.get(str.charAt(i)));
            }
            */
            if(len==str.length())return"";
            System.out.println(str.charAt(len)+"->"+Oct.get(str.charAt(len)));
            return Oct.get(str.charAt(len)) + int_bin_t(str, bodh, len++);
            
        }else if(bodh == 16){
            Map<Character,String> Hex = new HashMap<>();
            System.out.println("十六進位:");
            System.out.println("整數:");
            Hex.put('0', "0000");
            Hex.put('1', "0001");
            Hex.put('2', "0010");
            Hex.put('3', "0011");
            Hex.put('4', "0100");
            Hex.put('5', "0101");
            Hex.put('6', "0110");
            Hex.put('7', "0111");
            Hex.put('8', "1000");
            Hex.put('9', "1001");
            Hex.put('A', "1010");
            Hex.put('B', "1011");
            Hex.put('C', "1100");
            Hex.put('D', "1101");
            Hex.put('E', "1110");
            Hex.put('F', "1111");
            /*
            for (int i=0;i<str.length();i++){
                bin = bin + Hex.get(str.charAt(i));
                System.out.println(str.charAt(i)+"->"+Hex.get(str.charAt(i)));
            }
            */
            if(len==str.length())return"";
            System.out.println(str.charAt(len)+"->"+Hex.get(str.charAt(len)));
            return Hex.get(str.charAt(len)) + int_bin_t(str, bodh, len++);
        }
        return bin;
    }
    /*
    static String dec_bin(String str,int bodh){
        String bin = "";
        
        if (bodh == 10){
            Double temp = (Integer.valueOf(str))*Math.pow(0.1,str.length());
            for (;;){
                bin = Math.floor(temp*2) + bin;
                temp*=2;
                if(temp>=1)temp-=1;
                if(temp==0)break;
            }
        }else if(bodh == 8){
            Map<Character,String> Oct = new HashMap<>();
            Oct.put('0', "000");
            Oct.put('1', "001");
            Oct.put('2', "010");
            Oct.put('3', "011");
            Oct.put('4', "100");
            Oct.put('5', "101");
            Oct.put('6', "110");
            Oct.put('7', "111");
            for (int i=0;i<str.length();i++){
                bin = bin + Oct.get(str.charAt(i));
            }
        }else if(bodh == 16){
            Map<Character,String> Hex = new HashMap<>();
            Hex.put('0', "0000");
            Hex.put('1', "0001");
            Hex.put('2', "0010");
            Hex.put('3', "0011");
            Hex.put('4', "0100");
            Hex.put('5', "0101");
            Hex.put('6', "0110");
            Hex.put('7', "0111");
            Hex.put('8', "1000");
            Hex.put('9', "1001");
            Hex.put('A', "1010");
            Hex.put('B', "1011");
            Hex.put('C', "1100");
            Hex.put('D', "1101");
            Hex.put('E', "1110");
            Hex.put('F', "1111");
            for (int i=0;i<str.length();i++){
                bin = bin + Hex.get(str.charAt(i));
            }
        }
        return bin;
    }
    */
    static String dec_bin_t(String str,int bodh,int len){
        String bin = "";
        
        if (bodh == 10){
            int temp = Integer.valueOf(str);
            
            /*
            for (;;){
                bin = Math.floor(temp*2) + bin;
                System.out.println((temp*2>1)?temp+"->1":temp+"->0");
                temp*=2;
                if(temp>=1)temp-=1;
                if(temp==0)break;
            }
            */
            if(temp==0)return "" ;
            System.out.println(str.length()<Integer.toString(temp*2).length()?(temp*2/(Math.pow(10,Integer.toString(temp*2).length()-1)))+"->1":"0."+temp*2+"->0");
            System.out.println(str.length()+"   "+Integer.toString(temp*2).length());
            temp*=2;
            return   str.length()<Integer.toString(temp).length()?"1":"0"+ dec_bin_t(str.length()<Integer.toString(temp).length()?Integer.toString((int)(Integer.valueOf(str)*2-Math.pow(10,Integer.toString(temp).length()-1))):Integer.toString(Integer.valueOf(str)*2), bodh, len);
            

        }else if(bodh == 8){
            Map<Character,String> Oct = new HashMap<>();
            System.out.println("小數:");
            Oct.put('0', "000");
            Oct.put('1', "001");
            Oct.put('2', "010");
            Oct.put('3', "011");
            Oct.put('4', "100");
            Oct.put('5', "101");
            Oct.put('6', "110");
            Oct.put('7', "111");
            /*
            for (int i=0;i<str.length();i++){
                bin = bin + Oct.get(str.charAt(i));
                System.out.println(str.charAt(i)+"->"+Oct.get(str.charAt(i)));
            }
            */
            if(len==str.length())return"";
            System.out.println(str.charAt(len)+"->"+Oct.get(str.charAt(len)));
            return Oct.get(str.charAt(len)) + int_bin_t(str, bodh, len++);
        }else if(bodh == 16){
            Map<Character,String> Hex = new HashMap<>();
            System.out.println("小數:");
            Hex.put('0', "0000");
            Hex.put('1', "0001");
            Hex.put('2', "0010");
            Hex.put('3', "0011");
            Hex.put('4', "0100");
            Hex.put('5', "0101");
            Hex.put('6', "0110");
            Hex.put('7', "0111");
            Hex.put('8', "1000");
            Hex.put('9', "1001");
            Hex.put('A', "1010");
            Hex.put('B', "1011");
            Hex.put('C', "1100");
            Hex.put('D', "1101");
            Hex.put('E', "1110");
            Hex.put('F', "1111");
            /*
            for (int i=0;i<str.length();i++){
                bin = bin + Hex.get(str.charAt(i));
                System.out.println(str.charAt(i)+"->"+Hex.get(str.charAt(i)));
            }
            */
            if(len==str.length())return"";
            System.out.println(str.charAt(len)+"->"+Hex.get(str.charAt(len)));
            return Hex.get(str.charAt(len)) + int_bin_t(str, bodh, len++);
        }
        return bin.split("\\.")[0];
    }   
    static String dec(String str){
        Double dec = 0.0;
        String [] bin = str.split("\\.");
        for (int i=0;i<bin[0].length();i++){
            dec = dec + Math.pow(2,bin[0].length()-i-1 )*(Integer.valueOf(bin[0].charAt(i))-48);
        }
        for(int i=0;i<bin[1].length();i++){
            dec += Math.pow(2,-(i+1))*(bin[1].charAt(i)-48);
        }
        return dec.toString();
    }
    static Double dec_t(String bin[],int len,int DorI){
        /*
        for (int i=0;i<bin[0].length();i++){
            dec = dec + Math.pow(2,bin[0].length()-i-1 )*(Integer.valueOf(bin[0].charAt(i))-48);
            //System.out.println(Math.pow(2,bin[0].length()-i-1 )+"  "+Integer.valueOf(bin[0].charAt(i)));
            System.out.println(bin[0].charAt(i)+" * 2^"+(bin[0].length()-i-1));
        }
        */
        if(DorI == 1){
            if(len==bin[0].length())return 0.0 ;
            System.out.println(bin[0].charAt(len)+" * 2^"+(bin[0].length()-len-1));
            //System.out.println(len+"  "+bin[0].length());
            return Math.pow(2,bin[0].length()-len-1 )*(Integer.valueOf(bin[0].charAt(len))-48) + dec_t(bin, ++len, DorI);
        }
        /*
        System.out.println("小數:");
        for(int i=0;i<bin[1].length();i++){
            dec += Math.pow(2,-(i+1))*(bin[1].charAt(i)-48);
            System.out.println(bin[1].charAt(i)+" * 2^"+(-(i+1)));
        }
        */
        if(DorI == 2){
            if(len==bin[1].length())return 0.0;
            System.out.println(bin[1].charAt(len)+" * 2^"+(-(len+1)));
            return (Math.pow(2,-(len+1))*(bin[1].charAt(len)-48)) + dec_t(bin, ++len, DorI);
        }
        return dec_t(bin, len, 1)+dec_t(bin, len, 2);
    }
    static String Oct(String str){
        String oct = "";
        
        Map<String,Character> Oct_list = new HashMap<>();
        Oct_list.put("000", '0');
        Oct_list.put("001", '1');
        Oct_list.put("010", '2');
        Oct_list.put("011", '3');
        Oct_list.put("100", '4');
        Oct_list.put("101", '5');
        Oct_list.put("110", '6');
        Oct_list.put("111", '7');
        String [] bin = str.split("\\.");
        
        if(bin[0].length()%3==1){
            bin[0] = "00" + bin[0];
        }else if(bin[0].length()%3==2){
            bin[0] = "0" + bin[0];
        }
        
        if(bin[1].length()%3==1){
            bin[1] = bin[1] + "00";
        }else if(bin[1].length()%3==2){
            bin[1] = bin[1] + "0";
        }
        
        for (int i=0;i<bin[0].length();i+=3){
            oct = oct + Oct_list.get(bin[0].subSequence(i, i+3));
            
        }
        oct = oct +".";
        for(int i=0;i<bin[1].length();i+=3){
            oct = oct + Oct_list.get(bin[1].subSequence(i, i+3));
            
        }
        return oct;
    }
    static String Oct_t(String str,int len,int DorI){
        String oct = "";
        
        Map<String,Character> Oct_list = new HashMap<>();
        Oct_list.put("000", '0');
        Oct_list.put("001", '1');
        Oct_list.put("010", '2');           
        Oct_list.put("011", '3');
        Oct_list.put("100", '4');
        Oct_list.put("101", '5');
        Oct_list.put("110", '6');
        Oct_list.put("111", '7');
        String [] bin = str.split("\\.");
        if(bin[0].length()%3==1){
            bin[0] = "00" + bin[0];
        }else if(bin[0].length()%3==2){
            bin[0] = "0" + bin[0];
        }
        
        if(bin[1].length()%3==1){
            bin[1] = bin[1] + "00";
        }else if(bin[1].length()%3==2){
            bin[1] = bin[1] + "0";
        }
        /*
        for (int i=0;i<bin[0].length();i+=3){
            oct = oct + Oct_list.get(bin[0].subSequence(i, i+3));
            System.out.println(bin[0].subSequence(i, i+3).toString()+"->"+Oct_list.get(bin[0].subSequence(i, i+3)));
        }
        oct = oct +".";
        System.out.println("小數:");
        for(int i=0;i<bin[1].length();i+=3){
            oct = oct + Oct_list.get(bin[1].subSequence(i, i+3));
            System.out.println(bin[1].subSequence(i, i+3).toString()+"->"+Oct_list.get(bin[1].subSequence(i, i+3)));
            
        }
        */
        if(DorI == 1){
            if(len==bin[0].length())return "" ;
            System.out.println(bin[0].subSequence(len, len+3).toString()+"->"+Oct_list.get(bin[0].subSequence(len, len+3)));
            //System.out.println(len+"  "+bin[0].length());
            int temp = len +3;
            return Oct_list.get(bin[0].subSequence(len, len+3)) + Oct_t(str,temp,DorI);
        }
        if(DorI == 2){
            if(len==bin[1].length())return "";
            System.out.println(bin[1].subSequence(len, len+3).toString()+"->"+Oct_list.get(bin[1].subSequence(len, len+3)));
            int temp = len +3;
            return  Oct_list.get(bin[1].subSequence(len, len+3))+Oct_t(str,temp,DorI) ;
        }
        return Oct_t(str,len,1)+"."+Oct_t(str, len, 2);
        
    }
    static String Hex_t(String str,int len,int DorI){
        String hex = "";
        
        
        Map<String,Character> Hex_list = new HashMap<>();
        Hex_list.put("0000", '0');
        Hex_list.put("0001", '1');
        Hex_list.put("0010", '2');
        Hex_list.put("0011", '3');
        Hex_list.put("0100", '4');
        Hex_list.put("0101", '5');
        Hex_list.put("0110", '6');
        Hex_list.put("0111", '7');
        Hex_list.put("1000", '8');
        Hex_list.put("1001", '9');
        Hex_list.put("1010", 'A');
        Hex_list.put("1011", 'B');
        Hex_list.put("1100", 'C');
        Hex_list.put("1101", 'D');
        Hex_list.put("1110", 'E');
        Hex_list.put("1111", 'F');
        String [] bin = str.split("\\.");
        
        
        if(bin[0].length()%4==1){
            bin[0] = "000" + bin[0];
        }else if(bin[0].length()%4==2){
            bin[0] = "00" + bin[0];
        }else if(bin[0].length()%4==3){
            bin[0] = "0" + bin[0];
        }
        
        if(bin[1].length()%4==1){
            bin[1] =  bin[1]+"000" ;
        }else if(bin[1].length()%4==2){
            bin[1] =  bin[1]+"00";
        }else if(bin[1].length()%4==3){
            bin[1] =  bin[1]+"0";
        }
        /*
        System.out.println("將整數部分與小數部分分開並補零 "+bin[0]+" "+bin[1]);
        System.out.println("整數:");
        for (int i=0;i<bin[0].length();i+=4){
            hex = hex + Hex_list.get(bin[0].subSequence(i, i+4));
            System.out.println(bin[0].subSequence(i, i+4).toString()+"->"+Hex_list.get(bin[0].subSequence(i, i+4)));
            
        }
        hex = hex +".";
        System.out.println("小數:");
        for(int i=0;i<bin[1].length();i+=4){
            hex = hex + Hex_list.get(bin[1].subSequence(i, i+4));
            System.out.println(bin[1].subSequence(i, i+4).toString()+"->"+Hex_list.get(bin[1].subSequence(i, i+4)));
            
        }
        */
        if(DorI == 1){
            if(len==bin[0].length())return "" ;
            System.out.println(bin[0].subSequence(len, len+4).toString()+"->"+Hex_list.get(bin[0].subSequence(len, len+4)));
            //System.out.println(len+"  "+bin[0].length());
            int temp = len +4;
            return Hex_list.get(bin[0].subSequence(len, len+4)) + Hex_t(str,temp,DorI);
        }
        if(DorI == 2){
            if(len==bin[1].length())return "";
            System.out.println(bin[1].subSequence(len, len+4).toString()+"->"+Hex_list.get(bin[1].subSequence(len, len+4)));
            int temp = len +4;
            return  Hex_list.get(bin[1].subSequence(len, len+4))+ Hex_t(str,temp,DorI);
        }
        return Hex_t(str,len,1)+"."+Hex_t(str, len, 2);
    }
    static String Hex(String str){
        String hex = "";
        
        Map<String,Character> Hex_list = new HashMap<>();
        Hex_list.put("0000", '0');
        Hex_list.put("0001", '1');
        Hex_list.put("0010", '2');
        Hex_list.put("0011", '3');
        Hex_list.put("0100", '4');
        Hex_list.put("0101", '5');
        Hex_list.put("0110", '6');
        Hex_list.put("0111", '7');
        Hex_list.put("1000", '8');
        Hex_list.put("1001", '9');
        Hex_list.put("1010", 'A');
        Hex_list.put("1011", 'B');
        Hex_list.put("1100", 'C');
        Hex_list.put("1101", 'D');
        Hex_list.put("1110", 'E');
        Hex_list.put("1111", 'F');
        String [] bin = str.split("\\.");
      
        if(bin[0].length()%4==1){
            bin[0] = "000" + bin[0];
        }else if(bin[0].length()%4==2){
            bin[0] = "00" + bin[0];
        }else if(bin[0].length()%4==3){
            bin[0] = "0" + bin[0];
        }
        
        if(bin[1].length()%4==1){
            bin[1] =  bin[1]+"000" ;
        }else if(bin[1].length()%4==2){
            bin[1] =  bin[1]+"00";
        }else if(bin[1].length()%4==3){
            bin[1] =  bin[1]+"0";
        }
        
        for (int i=0;i<bin[0].length();i+=4){
            hex = hex + Hex_list.get(bin[0].subSequence(i, i+4));
            
        }
        hex = hex +".";
        for(int i=0;i<bin[1].length();i+=4){
            hex = hex + Hex_list.get(bin[1].subSequence(i, i+4));
            
        }
        return hex;
    }
    static String remove_zero(int a){
        /*
        int temp = a;
        for(;;){
            if (temp%10==0){
                temp/=10;
            }else break;
        }        
        */
        return Integer.toString(a);
    }
    
}
