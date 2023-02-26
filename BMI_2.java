import java.util.Scanner;//import scanner library

public class BMI_2{
    public static void main(String[] args){
        System.out.print("enter your height(cm) :"); //hint to input height  
        Scanner h = new Scanner(System.in);// input height 
        float height = h.nextFloat();//read height 
        System.out.print("enter your weight(kg) :");//hint to input weight 
        Scanner w = new Scanner(System.in);//input weight 
        float weight = w.nextFloat();//read weight 
        int flag = 1;//flag for judge height and weight rationality
        if (height > 300 || height < 0){
            System.out.println("your height is irrational");//output height is irrational
            flag = 0;//judge height rationality
        } 
        if (weight > 400 || weight < 0){
            System.out.println("your weight is irrational");//output weight is irrational
            flag = 0;//judge weight rationality
        } 
        float bmi = weight/((height*height)/(100*100));//calculate bmi
        if(flag == 1){
            System.out.println("your bmi is : " + bmi);//outputb bmi
            //bmi suggestion
            System.out.println((bmi < 18.5) ? ("you are Underweight\nyou should increase "+((18.5*height*height)/(100*100)-weight)+"kg"):
                                ((bmi < 24) ? ("you are Normal\nyou should keep your weight"):
                                ((bmi < 27) ? ("you are Overweight(a little)\nyou should decrease"+((24*height*height)/(100*100)-weight)+"kg"):
                                ((bmi < 30) ? ("you are Overweight(middle)\nyou should decrease"+((24*height*height)/(100*100)-weight)+"kg"):
                                ((bmi < 35) ? ("you are Obese\nyou should decrease"+((24*height*height)/(100*100)-weight)+"kg"):
                                ("you are Extremely Obese\nyou should decrease"+((24*height*height)/(100*100)-weight)+"kg"))))));
        }
    }
}