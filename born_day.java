import java.text.SimpleDateFormat;
import java.util.Date;
import java.text.ParseException;
import java.util.Scanner;;

public class born_day {
    public static void main(String arg[]){
        System.out.print("enter your born year(ROC era) :"); //hint to input 
        Scanner y = new Scanner(System.in);// input
        int year = y.nextInt();//read vaule 
        System.out.print("enter your born month :"); //hint to input
        Scanner m = new Scanner(System.in);// input 
        int month = m.nextInt();//read  vaule
        System.out.print("enter your born day :"); //hint to input
        Scanner d = new Scanner(System.in);// input
        int day = d.nextInt();//read  vaule
        System.out.print("enter your born hour :"); //hint to input
        Scanner h = new Scanner(System.in);// input 
        int hour = h.nextInt();//read  vaule
        
        leap_year(year+1911); //execute leap year funtion 
        star_sign(month, day);//execute star_sign funtion
        lunar_year(year);//execute lunar year funtion
        weekday(year+1911, month, day);//execute weekday funtion
        hour(hour);//execute hour funtion
    }

    public static void leap_year(int year){
        
        if((year % 4 == 0 && year % 100 != 0)||(year % 400 == 0 && year % 100 == 0)) {  
            System.out.println("the year is leap year");
        }else {        
            System.out.println("the year is not leap year");
        }  
    }
    public static void hour(int hour){
        String chinese_hour ="";
        switch(((hour+1)/2)+1){
            case 1:
                chinese_hour = "子";
                break;
            case 2:
                chinese_hour = "丑";
                
                break;
            case 3:
                chinese_hour = "寅";
                
                break;
            case 4:
                chinese_hour = "卯";
          
                break;
            case 5:
                chinese_hour = "辰";
          
                break;
            case 6:
                chinese_hour = "巳";
         
                break;
            case 7:
                chinese_hour = "午";
          
                break;
            case 8:
                chinese_hour = "未";
      
                break;
            case 9:
                chinese_hour = "申";

                break;
            case 10:
                chinese_hour = "酉";

                break;
            case 11:
                chinese_hour = "戌";

                break;
            case 12:
                chinese_hour = "亥";

                break;
        }
        System.out.println("your born (chinese)hour is "+chinese_hour);
    }
    public static void lunar_year(int year){
        String Heavenly_Stems = "" ;
        String Earthly_Branches = "";
        String chinese_Zodiac = "";
        switch(year%10){
            case 1:
                Heavenly_Stems = "壬";
                break;
            case 2:
                Heavenly_Stems = "癸";
                break;
            case 3:
                Heavenly_Stems = "甲";
                break;
            case 4:
                Heavenly_Stems = "乙";
                break;
            case 5:
                Heavenly_Stems = "丙";
                break;
            case 6:
                Heavenly_Stems = "丁";
                break;
            case 7:
                Heavenly_Stems = "戊";
                break;
            case 8:
                Heavenly_Stems = "己";
                break;
            case 9:
                Heavenly_Stems = "庚";
                break;
            case 0:
                Heavenly_Stems = "辛";
                break;
        }
        switch(year%12){
            case 1:
                Earthly_Branches = "子";
                chinese_Zodiac = "鼠";
                break;
            case 2:
                Earthly_Branches = "丑";
                chinese_Zodiac = "牛";
                break;
            case 3:
                Earthly_Branches = "寅";
                chinese_Zodiac = "虎";
                break;
            case 4:
                Earthly_Branches = "卯";
                chinese_Zodiac = "兔";
                break;
            case 5:
                Earthly_Branches = "辰";
                chinese_Zodiac = "龍";
                break;
            case 6:
                Earthly_Branches = "巳";
                chinese_Zodiac = "蛇";
                break;
            case 7:
                Earthly_Branches = "午";
                chinese_Zodiac = "馬";
                break;
            case 8:
                Earthly_Branches = "未";
                chinese_Zodiac = "羊";
                break;
            case 9:
                Earthly_Branches = "申";
                chinese_Zodiac = "猴";
                break;
            case 10:
                Earthly_Branches = "酉";
                chinese_Zodiac = "雞";
                break;
            case 11:
                Earthly_Branches = "戌";
                chinese_Zodiac = "狗";
                break;
            case 0:
                Earthly_Branches = "亥";
                chinese_Zodiac = "豬";
                break;
        }
        System.out.println("the lunar year is " + Heavenly_Stems + Earthly_Branches);
        System.out.println("your chinese zodiac is " + chinese_Zodiac );
    }
    
    public static void weekday(int year,int month,int day){
        String date_String = String.valueOf(year) + "-" + String.valueOf(month) + "-" + String.valueOf(day);
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        try {  
            Date date = format.parse(date_String);//string to date format 
            SimpleDateFormat date2DayFormat = new SimpleDateFormat( "u" );
            System.out.println("your born weekday is "+date2DayFormat.format(date)); 
        } catch (ParseException e) {  

        } 
    }
    public static void star_sign(int month,int day){
        switch(month){
            case 1:
                System.out.println("your star sign is "+ (day<21?"Capricorn\nyour personality is Ambitious, reserved and patient":
                                                                "Aquarius\nyour personality is Intellectual, independent and contemplative"));
                break;
            case 2:
                System.out.println("your star sign is "+ (day<20? "Aquarius\nyour personality is Intellectual, independent and contemplative":
                                                                "Pisces\nyour personality is Imaginative, intuitive and emotional"));
                break;
            case 3:
                System.out.println("your star sign is "+ (day<21?"Pisces\nyour personality is Imaginative, intuitive and emotional":
                                                                "Aries\nyour personality is Bold, pioneering and courageous"));
                break;
            case 4:
                System.out.println("your star sign is "+ (day<21?"Aries\nyour personality is Bold, pioneering and courageous":
                                                                "Taurus\nyour personality is Sensual, determined and loyal"));
                break;
            case 5:
                System.out.println("your star sign is "+ (day<22?"Taurus\nyour personality is Sensual, determined and loyal":
                                                                "Gemini\nyour personality is Quick-witted, excitable and inquisitive"));
                break;
            case 6:
                System.out.println("your star sign is "+ (day<22?"Gemini\nyour personality is Quick-witted, excitable and inquisitive":
                                                                "Cancer\nyour personality is Sensitive, emotional and receptive"));
                break;
            case 7:
                System.out.println("your star sign is "+ (day<23?"Cancer\nyour personality is Sensitive, emotional and receptive":
                                                                "Leo\nyour personality is Creative, enthusiastic and dramatic"));
                break;
            case 8:
                System.out.println("your star sign is "+ (day<24?"Leo\nyour personality is Creative, enthusiastic and dramatic":
                                                                "Virgo\nyour personality is Practical, hardworking and analytical"));
                break;
            case 9:
                System.out.println("your star sign is "+ (day<24?"Virgo\nyour personality is Practical, hardworking and analytical":
                                                                "Libra\nyour personality is Charming, social and diplomatic"));
                break;
            case 10:
                System.out.println("your star sign is "+ (day<24?"Libra\nyour personality is Charming, social and diplomatic":
                                                                "Scorpio\nyour personality is Intense, passionate and cunning"));
                break;
            case 11:
                System.out.println("your star sign is "+ (day<23?"Scorpio\nyour personality is Intense, passionate and cunning":
                                                                "Sagittarius\nyour personality is Adventurous, spontaneous and optimistic"));
                break;
            case 12:
                System.out.println("your star sign is "+ (day<22?"Sagittarius\nyour personality is Adventurous, spontaneous and optimistic":
                                                                "Capricorn\nyour personality is Ambitious, reserved and patient"));
                break;
        }


    }
}
    


