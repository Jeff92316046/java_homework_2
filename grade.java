import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;
import java.util.Scanner;


public class grade {
    
    public static void main(String arg[])throws Exception{
        String tab[] = {"丁","丙","乙","甲","優","優"};
        fileloader fl = new fileloader();
        filewriter fw = new filewriter(); 
        String sno[] = new String[100];
        String name[] = new String[100];
        int cn_a[] = {0,0,0,0,0,0};
        int cn_c[] = {0,0,0,0,0,0};
        int cn_m[] = {0,0,0,0,0,0};
        String RN[] = new String[7];
        int chin[] = new int[100];
        int math[] = new int[100];
        float avg[] = new float[100];
        double variance_c = 0.0;
        double variance_m = 0.0;
        fl.init_file();
        fl.getData(sno, name, chin, math);
        Scanner sr = new Scanner(System.in);
        String mode,target,choice;
        boolean hava_done = true;
        for(;;){
            System.out.print("$");
            mode = sr.next();
            if(mode.equals("avg")){
                average(chin, math, avg,fl.length);
            }else if(mode.equals("sd")){
                variance_c = standardization(chin,fl.length);
                variance_m = standardization(math,fl.length);
            }else if(mode.equals("rk")){
                rank(avg, RN, tab,fl.length);
            }else if(mode.equals("ctnum")){
                rank2(avg, cn_a, hava_done,fl.length);
                rank2(chin, cn_c, hava_done,fl.length);
                rank2(math, cn_m, hava_done,fl.length);
                if(hava_done)hava_done = false;
            }else if(mode.equals("ls")){
                show(name, avg, sno, RN, cn_c, cn_m, fl.length, variance_c, variance_m);
            }else if(mode.equals("bs")){
                bubbleSort(avg, name, sno, math, chin,fl.length);
            }else if(mode.equals("ss")){
                selectionSort(avg, name, sno, math,chin,fl.length);
            }else if(mode.equals("lsh")){
                System.out.print("學號(輸入no),名字(輸入name)");

                choice = sr.next();
                if(choice.equals("no")){
                    System.out.print("輸入想查詢學號:");
                    target = sr.next();
                    int temp = linearSearch(target, sno,fl.length);
                    if(temp == -1){
                        System.out.println("查無此人");
                    }else{
                        System.out.printf("math   :%4d\nchinese:%4d\naverage:%4.2f\n",math[temp],chin[temp],avg[temp]);
                    }
                }else if(choice.equals("name")){
                    System.out.print("輸入想查詢姓名:");
                    target = sr.next();
                    int temp = linearSearch(target, name,fl.length);
                    if(temp == -1){
                        System.out.println("查無此人");
                    }else{
                        System.out.printf("math   :%4d\nchinese:%4d\naverage:%4.2f\n",math[temp],chin[temp],avg[temp]);
                    }
                }else {
                    System.out.println("輸入錯誤");
                }
                
            }else if(mode.equals("bsh")){
                System.out.print("學號(輸入no),名字(輸入name)");

                choice = sr.next();
                if(choice.equals("no")){
                    System.out.print("輸入想查詢學號:");
                    target = sr.next();
                    int temp = linearSearch(target, sno,fl.length);
                    if(temp == -1){
                        System.out.println("查無此人");
                    }else{
                        System.out.printf("math   :%4d\nchinese:%4d\naverage:%4.2f\n",math[temp],chin[temp],avg[temp]);
                    }
                }else if(choice.equals("name")){
                    System.out.print("輸入想查詢姓名:");
                    target = sr.next();
                    int temp = linearSearch(target, name,fl.length);
                    if(temp == -1){
                        System.out.println("查無此人");
                    }else{
                        System.out.printf("math   :%4d\nchinese:%4d\naverage:%4.2f\n",math[temp],chin[temp],avg[temp]);
                    }
                }else {
                    System.out.println("輸入錯誤");
                }
            }else if(mode.equals("help")){
                System.out.println("avg   : 算平均");
                System.out.println("sd    : 標準差");
                System.out.println("rk    : 算等第");
                System.out.println("ctnum : 算區間人數");
                System.out.println("ls    : 顯示處理結果");
                System.out.println("bs    : bubble sort");
                System.out.println("ss    : selection sort");
                System.out.println("lsh   : linear search");
                System.out.println("bsh   : binary search");
                System.out.println("exit  : 離開系統");
            }else if(mode.equals("exit")){
                break;
            }else{
                System.out.println("指令錯誤");
            }


        }
        fw.init_file();
        fw.refresh_data(sno, name, chin, math,fl.length);
    }

    static void average(int a[],int b[],float avg[],int length){
        for(int i=0;i<length;i++){
            avg[i] = (a[i]+b[i])/2f;
        }
    }
    static void rank(float a[],String RN[],String tab[],int length){
        for(int i=0;i<length;i++){
            RN[i] = tab[((int)(a[i]-60)/10.0)>=0?(int)((a[i]-60)/10.0)+1:0];
        }
    }
    static void rank2(float a[],int cn[],boolean hava_done,int length){
        if(!hava_done) return;
        for(int i=0;i<length;i++){
            cn[((int)(a[i]-60)/10.0)>=0?(int)((a[i]-60)/10.0)+1:0]++;
        }
    }
    static void rank2(int a[],int cn[],boolean hava_done,int length){
        if(!hava_done) return;
        for(int i=0;i<length;i++){
            cn[((int)(a[i]-60)/10.0)>=0?(int)((a[i]-60)/10.0)+1:0]++;
        }
    }
    static double standardization(int a[],int length){
        double temp = 0,avg=0;
        for(int i=0;i<length;i++){
            avg += a[i];
        }
        avg/=(double)length;
        for(int i=0;i<length;i++){
            temp += Math.pow(avg-a[i],2);
        }
        return Math.sqrt(temp/length);
    }
    static void show(String name[],float avg[],String sno[],String RN[],int cn_c[],int cn_m[],int length,double v_c,double v_m){
        System.out.printf("%-8s","name");
        for(int i=0;i<length;i++){
            System.out.printf("%-9s",name[i]);
        }
        System.out.println("");
        System.out.printf("%-8s","no");
        for(int i=0;i<length;i++){
            System.out.printf("%-9s",sno[i]);
        }
        System.out.println("");
        System.out.printf("%-8s","average");
        for(int i=0;i<length;i++){
            System.out.printf("%-9.1f",avg[i]);
        }
        System.out.println("");
        System.out.printf("%-8s","rank");
        for(int i=0;i<length;i++){
            System.out.printf("%-8s",RN[i]);
        }
        System.out.println("");
        System.out.println("");
        System.out.printf("%-8s","range");
        for(int i=0;i<cn_c.length;i++){
            System.out.printf("%-8s",i==0?("0~59"):i==5?("100"):((i*10+50)+"~"+(i*10+59)));
        }
        System.out.println("");
        System.out.printf("%-8s","math");
        for(int i=0;i<cn_c.length;i++){
            System.out.printf("%-8d",cn_m[i]);
        }
        System.out.println("");
        System.out.printf("%-8s","chinese");
        for(int i=0;i<cn_c.length;i++){
            System.out.printf("%-8d",cn_c[i]);
        }
        System.out.println("");
        System.out.printf("chinese standardization:%5.5f",v_c);
        System.out.println("");
        System.out.printf("math standardization   :%5.5f",v_m);
        System.out.println("");

        
    }
    static void bubbleSort(float[] arr,String[] arr2,String[] arr3,int arr4[],int arr5[],int length) {  
        
        int n = length;  
        float temp = 0;
        int temp4 = 0,temp5=0;
        String temp2 = "";
        String temp3 = "";   
         for(int i=0; i < n; i++){  
            for(int j=1; j < (n-i); j++){  
                if(arr[j-1] > arr[j]){  
                    temp = arr[j-1];  
                    arr[j-1] = arr[j];  
                    arr[j] = temp;  
                    temp2 = arr2[j-1];  
                    arr2[j-1] = arr2[j];  
                    arr2[j] = temp2;
                    temp3 = arr3[j-1];  
                    arr3[j-1] = arr3[j];  
                    arr3[j] = temp3;
                    temp4 = arr4[j-1];  
                    arr4[j-1] = arr4[j];  
                    arr4[j] = temp4;
                    temp5 = arr5[j-1];  
                    arr5[j-1] = arr5[j];  
                    arr5[j] = temp5;
                }  
                    
            }  
        }  
  
    }  
    static void selectionSort(float[] arr,String[] arr2,String[] arr3,int arr4[],int arr5[],int length) {  
        String  temp = "";
        for (int i = 0; i < length - 1; i++)  {  
            int index = i;  
            for (int j = i + 1; j < length; j++){  
                if (arr[j] < arr[index]){  
                    index = j;
                }  
            }  
            float smallerNumber = arr[index];   
            arr[index] = arr[i];  
            arr[i] = smallerNumber;  
            temp = arr2[index];
            arr2[index] = arr2[i];
            arr2[i] = temp;
            temp = arr3[index];
            arr3[index] = arr3[i];
            arr3[i] = temp;
            int smallerNumber_i = arr4[index];
            arr4[index] = arr4[i];
            arr4[i] = smallerNumber_i;
            smallerNumber = arr5[index];
            arr5[index] = arr5[i];
            arr5[i] = smallerNumber_i;

        }  
  
    }  
    static int linearSearch(String target,String arr[],int length){
        for(int i=0;i<length;i++){
            if(arr[i].equals(target))return i;
        }
        return -1;
    }
    static int binarySearch(String[] arr, String x,int length){
        int l = 0, r = length - 1;
        while (l <= r) {
            int m = l + (r - l) / 2;
 
            int res = x.compareTo(arr[m]);
 
            // Check if x is present at mid
            if (res == 0)
                return m;
 
            // If x greater, ignore left half
            if (res > 0)
                l = m + 1;
 
            // If x is smaller, ignore right half
            else
                r = m - 1;
        }
 
        return -1;
    }
    
}
class fileloader{
    FileReader fr ;
    Scanner sr ;
    String temp_arr[];
    int length=0;
    fileloader(){
    }
    public void init_file() throws Exception{
        fr =  new FileReader("test.txt",Charset.forName("UTF-8"));
        sr = new Scanner(fr);
    }
    
    public void getData(String sno[],String name[],int chin[],int math[]) throws Exception{
        while(sr.hasNextLine()){
            temp_arr = sr.nextLine().split(" ");
            sno[length] = temp_arr[0];
            name[length] = temp_arr[1];
            chin[length] = Integer.valueOf(temp_arr[2]);    
            math[length] = Integer.valueOf(temp_arr[3]);
            length++;
        }
        fr.close(); 
        
    }  
   
    
}
class filewriter{
    
    OutputStreamWriter out ;
    String content = "";
    filewriter(){

    }

    public void init_file()throws Exception{
        out = new OutputStreamWriter(new FileOutputStream("test.txt"),"UTF-8");
        out.write("");
        out.flush();
        out.close();
    }
    public void refresh_data(String sno[],String name[],int chin[],int math[],int length)throws Exception{
        
        out = new OutputStreamWriter(new FileOutputStream("test.txt"),"UTF-8");
        for(int i=0;i<length;i++){
            content = content + sno[i]+" "+name[i]+" "+chin[i]+" "+math[i]+"\n";
        }
        out.write(content);
        out.flush();
        out.close();
        
    }

}
