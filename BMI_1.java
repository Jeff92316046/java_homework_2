import java.util.Scanner;

public class BMI_1{
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
            if(bmi < 18.5){
                System.out.println("you are Underweight");
            } else if (bmi < 24){
                System.out.println("you are Normal");
            } else if (bmi < 27){
                System.out.println("you are Overweight(a little)");
            } else if (bmi < 30){
                System.out.println("you are Overweight(middle)");
            } else if (bmi < 35){
                System.out.println("you are Obese");
            } else {
                System.out.println("you are Extremely Obese");
            }
        } 
        

    }
}