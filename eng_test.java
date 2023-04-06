import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
import java.lang.Math;


public class eng_test {
    public static void main(String[] args){
        int question_num = 0;
        int mode = 0;      
        ArrayList<String> phrase = new ArrayList<String>(Arrays.asList("blow up","bring up","call off","do over","fill out","fill up","find out","give away","give back","hand in","hang up","hold up","leave out","look over","look up","make up","pick out","pick up","point out","put away"));
        ArrayList<String> pharse_ts = new ArrayList<String>(Arrays.asList("爆炸","提起","取消","重複","填好","填滿","發現","贈送","歸還","繳交","懸掛","使延遲","省略","檢查","尋找","虛構","挑選","舉起","引起注意","儲蓄"));
        //"blow up","bring up","call  off","do over","fill out","fill up","find out","give away","give back","hand in","hang up","hold up","leave out","look over","look up","make up","pick out","pick up","point out","put away"	
        //"爆炸","提起","取消","重複","填好","填滿","發現","贈送","歸還","繳交","懸掛","使延遲","省略","檢查","尋找","虛構","挑選","舉起","引起注意","儲蓄"
        ArrayList<Integer> flag = new ArrayList<Integer>(Arrays.asList(0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0));
        ArrayList<Integer> flag_2 = new ArrayList<Integer>(Arrays.asList(0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0));
        String a1_str = "";
        String a2_str = "";
        //ystem.out.println(rd);
        
        for(;;){
            System.out.print("輸入題數n (n為-1時結束程式)(n>0):");
            Scanner n = new Scanner(System.in);// input
            question_num = n.nextInt();//read vaule
            if(question_num<=0){
                if(question_num==-1){
                    break;
                }else{
                    System.out.println("輸入錯誤,請輸入大於等於2的正整數");
                    continue;
                }
            }
            System.out.println("輸入模式m\n純測驗模式m輸入1\n練習+提示模式輸入2");
            Scanner m = new Scanner(System.in);// input
            mode = m.nextInt();//read vaule
            if(mode != 1 && mode != 2){
                System.out.println("輸入錯誤,請輸入1或2");
                continue;
            }
            int Max = phrase.size()-1;
            int min = 0;
            int rd = (int)(Math.random()*(Max-min+1))+min;
            int point_counter = 0 ;
            int correct_num = 0;
            if(mode == 1){
                System.out.println("");
                for(int i=0;i<question_num;i++){
                    for(int j=0;j<flag.size();j++){
                        rd = (int)(Math.random()*(Max-min+1))+min;
                        System.out.println(rd);
                        if(flag.get(rd)==0){
                            System.out.print(pharse_ts.get(rd)+" : ");
                            flag.set(rd, flag.get(rd)+1);
                            
                            Scanner a1 = new Scanner(System.in);// input
                            //Scanner a2 = new Scanner(System.in);// input
                            a1_str = a1.nextLine();//read vaule
                            //a2_str = a2.next();
                            
                            if(phrase.get(rd).equals(a1_str+""+a2_str)){
                                System.out.println("正確");
                                point_counter += 10 ;
                                
                            }else{
                                System.out.println("錯誤");
                            }
                            break;
                            
                        }
                    }
                }
                for(int i=0;i<flag.size();i++){
                    flag.set(i,0);
                }
                System.out.println("你的分數 : " + point_counter + "/" + question_num*10);
            }else if(mode == 2){
                for(int first_check = 0;;first_check++){
                    if(first_check == 0){
                        for(int i=0;i<question_num;i++){
                            for(int j=0;j<flag.size();j++){
                                rd = (int)(Math.random()*(Max-min+1))+min;
                                if(flag.get(rd)==0 && flag_2.get(rd)==0){
                                    System.out.print(pharse_ts.get(rd)+" : ");
                                    flag.set(rd, 1);
                                    Scanner a1 = new Scanner(System.in);// input
                                    //Scanner a2 = new Scanner(System.in);// input
                                    a1_str = a1.nextLine();//read vaule
                                    //a2_str = a2.next();
                                    if(phrase.get(rd).equals(a1_str)){
                                        System.out.println("正確");
                                        point_counter += (10-first_check) ;
                                        flag_2.set(rd, 1);
                                        correct_num ++;
                                    }else{
                                        System.out.println("錯誤");
                                        
                                    }
                                    break;
                                }
                            }
                            
                            
                        }
                        System.out.println("答對的總題數 : " + correct_num + "/" +question_num );
                    }else{
                        System.out.println("請問要繼續測驗嗎");
                        System.out.println("輸入1結束本輪測驗\n輸入2繼續測驗");
                        Scanner check = new Scanner(System.in);// input
                        int c = check.nextInt();//read vaule
                        if(c != 1 && c != 2){
                            System.out.println("輸入錯誤,請輸入1或2");
                            continue;
                        }
                        System.out.println("");
                        if (c == 1)break;
                        for(int i=0;i<question_num-correct_num;i++){
                            for(int j=0;j<phrase.size();j++){
                                if(flag.get(j)==0 && flag_2.get(j)==0){
                                    System.out.print(pharse_ts.get(rd)+" : ");
                                    flag.set(rd, 1);
                                    Scanner a1 = new Scanner(System.in);// input
                                    //Scanner a2 = new Scanner(System.in);// input
                                    a1_str = a1.nextLine();//read vaule
                                    //a2_str = a2.next();
                                    if(phrase.get(rd).equals(a1_str)){
                                        System.out.println("正確");
                                        point_counter += (10-first_check) ;
                                        flag_2.set(rd, 1);
                                        correct_num ++;
                                    }else{
                                        System.out.println("錯誤");
                                        
                                    }
                                    break;
                                }
                            }
                            
                            
                        }
                        System.out.println("答對的總題數 : " + correct_num + "/" +question_num );
                    }
                    
                    if(correct_num == question_num)break;
                    
                    
                }
                System.out.println("你的分數 : " + point_counter + "/" + question_num*10);
                for(int i=0;i<flag.size();i++){
                    flag.set(i,0);
                    flag_2.set(i, 0);
                }
            }

        }
        
    }
}
