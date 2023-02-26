import java.util.Scanner;

public class BMI_2{
    public static void main(String[] args){
        System.out.print("enter your height(cm) :");
        Scanner h = new Scanner(System.in);
        float height = h.nextFloat();
        System.out.print("enter your weight(kg) :");
        Scanner w = new Scanner(System.in);
        float weight = w.nextFloat();
        int flag = 1;
        if (height > 300 || height < 0){
            System.out.println("your height is irrational");
            flag = 0;
        } 
        if (weight > 400 || weight < 0){
            System.out.println("your weight is irrational");
            flag = 0;
        } 
        float bmi = weight/((height*height)/(100*100));
        if(flag == 1){
            System.out.println("your bmi is : " + bmi);
            System.out.println((bmi < 18.5) ? ("you are Underweight"):
                                ((bmi < 24) ? ("you are Normal"):
                                ((bmi < 27) ? ("you are Overweight(a little)"):
                                ((bmi < 30) ? ("you are Overweight(middle)"):
                                ((bmi < 35) ? ("you are Obese"):
                                ("you are Extremely Obese"))))));
        }
    }
}