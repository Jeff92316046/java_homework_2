package engtest;

import java.io.FileReader;
import java.net.URL;
import java.nio.charset.Charset;
import java.security.SecureRandom;
import java.util.ResourceBundle;
import java.util.Scanner;
import java.lang.Integer;
import java.io.OutputStreamWriter;
import java.io.FileOutputStream;
import javafx.event.ActionEvent;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.fxml.Initializable;

public class Controller implements Initializable{
    
    @FXML
    private Label label1; //題數
    @FXML
    private Label label2; //模式
    @FXML
    private Label label3; //題目
    @FXML
    private Label label4; //模式
    @FXML
    private Label label5; //模式
    @FXML
    private Label label6; //第?題
    @FXML
    private Label label7; //第?題
    @FXML
    private Label label8; //對錯
    @FXML
    private Label label11;
    @FXML 
    private Label label12;
    @FXML
    private TextField textfield1;//題數
    @FXML
    private TextField textfield2;//模式
    @FXML
    private TextField textfield3;//回答
    @FXML
    private Button button1;
    @FXML
    private Button button2;
    fileloader fl = new fileloader();
    writefile fw = new writefile();
    SecureRandom sr = new SecureRandom();
    int mode = 0;
    int quest_num = 0 ;
    int quest_counter = 0;
    int have_used [] = new int[20];
    int correct_flag [] = new int[20];
    int ans_times [] = new int[20];
    int score = 0;
    int turn = 1;
    int tmp = -1;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        label3.setVisible(false);
        textfield3.setVisible(false);
        button2.setVisible(false);
        label6.setVisible(false);
        label7.setVisible(false);
        label8.setVisible(false);
        label11.setVisible(false);
        label12.setVisible(false);

    }

    //
    public void press_button2(ActionEvent event)throws Exception{
        if(mode == 1){
            label6.setText("第"+(quest_counter+2)+"題");
            if(fl.eng_word_list[tmp].equals(textfield3.getText())){
                label8.setText("正確");
                label8.setVisible(true);
                score += 10;
            }else{
                label8.setText("錯誤");
                fw.content_increase(fl.eng_word_list[tmp]+","+fl.chin_word_list[tmp]);
                label8.setVisible(true);
            }
            textfield3.setText("");
            for(;;){
                tmp = sr.nextInt(20);
                if(have_used[tmp]==0){
                    quest_counter++;
                    have_used[tmp] = 1;
                    break;
                }
            }
            label3.setText(fl.chin_word_list[tmp]);
            if(quest_counter == quest_num){
                button1.setVisible(false);
                label1.setVisible(false);
                label2.setVisible(false);
                label4.setVisible(false);
                label5.setVisible(false);
                label7.setVisible(false);
                textfield1.setVisible(false);
                textfield2.setVisible(false);
                label3.setVisible(false);
                textfield3.setVisible(false);
                button2.setVisible(false);
                label6.setVisible(false);
                label7.setVisible(false);
                label8.setVisible(false);
                label11.setVisible(true);
                label12.setVisible(true);
                label12.setText(score + "/" + (quest_num*10));
            }
        }else if (mode == 2){
            if(turn <= quest_num-1){
                label6.setText("第一輪第"+(turn+1)+"題");
                if(fl.eng_word_list[tmp].equals(textfield3.getText())){
                    label8.setText("正確");
                    quest_counter++; 
                    correct_flag[tmp] = 1;
                    label8.setVisible(true);
                    score += 10;
                }else{
                    label8.setText("錯誤");
                    fw.content_increase(fl.eng_word_list[tmp]+","+fl.chin_word_list[tmp]);
                    ans_times[tmp]++;
                    label8.setVisible(true);
                }
                textfield3.setText("");
                for(;;){
                    tmp = sr.nextInt(20);
                    if(have_used[tmp]==0){
                        turn++;
                        have_used[tmp] = 1;
                        break;
                    }
                }
                label3.setText(fl.chin_word_list[tmp]);
                if(turn == quest_counter){
                    for(;;){
                        tmp = sr.nextInt(20);
                        if(have_used[tmp]==1 && correct_flag[tmp]==0){
                            turn++;
                            have_used[tmp] = 1;
                            break;
                        }
                    }
                    label3.setText(fl.chin_word_list[tmp]+"("+fl.eng_word_list[tmp].charAt(0)+"..."+fl.eng_word_list[tmp].charAt(fl.eng_word_list[tmp].length()-1)+")");
                }
            }else{
                label6.setText("第二輪");
                
                if(fl.eng_word_list[tmp].equals(textfield3.getText())){
                    label8.setText("正確");
                    quest_counter++; 
                    correct_flag[tmp] = 1;
                    label8.setVisible(true);
                    score += (10-ans_times[tmp]);
                }else{
                    label8.setText("錯誤");
                    
                    ans_times[tmp]++;
                    label8.setVisible(true);
                }
                textfield3.setText("");
                
                for(;;){
                    tmp = sr.nextInt(20);
                    if(have_used[tmp]==1 && correct_flag[tmp]==0){
                        turn++;
                        have_used[tmp] = 1;
                        break;
                    }
                    if(quest_counter == quest_num)break;
                }
                label3.setText(fl.chin_word_list[tmp]+"("+fl.eng_word_list[tmp].charAt(0)+"..."+fl.eng_word_list[tmp].charAt(fl.eng_word_list[tmp].length()-1)+")");
            }
            if(quest_counter == quest_num){
                button1.setVisible(false);
                label1.setVisible(false);
                label2.setVisible(false);
                label4.setVisible(false);
                label5.setVisible(false);
                label7.setVisible(false);
                textfield1.setVisible(false);
                textfield2.setVisible(false);
                label3.setVisible(false);
                textfield3.setVisible(false);
                button2.setVisible(false);
                label6.setVisible(false);
                label7.setVisible(false);
                label8.setVisible(false);
                label11.setVisible(true);
                label12.setVisible(true);
                
                label12.setText(score + "/" + (quest_num*10));
            }
        }
        
    }

    public void press_button1(ActionEvent event)throws Exception{
        quest_num = Integer.valueOf(textfield1.getText());
        mode = Integer.valueOf(textfield2.getText());
        if(quest_num <= 0 || quest_num >=21 || mode <= 0 || mode >= 3){
            label7.setVisible(true);
        }else {
            button1.setVisible(false);
            label1.setVisible(false);
            label2.setVisible(false);
            label4.setVisible(false);
            label5.setVisible(false);
            label7.setVisible(false);
            textfield1.setVisible(false);
            textfield2.setVisible(false);
            init_test();
            tmp = sr.nextInt(20);
            have_used[tmp] = 1;
            label3.setText(fl.chin_word_list[tmp]);
            label3.setVisible(true);
            textfield3.setVisible(true);
            button2.setVisible(true);
            if(mode==2)label6.setText("第一輪第"+turn+"題");
            label6.setVisible(true);
            
            
        }
    }
    public void init_test()throws Exception{
        fl.init_file();
        fl.get_eng_quest();
        fw.init_file();
    }
    
    
}
class fileloader{
    FileReader fr ;
    Scanner sr ;
    String eng_word_list [];
    String chin_word_list [];
    fileloader(){
    }
    public void init_file() throws Exception{
        fr =  new FileReader("src/engtest/eng.txt",Charset.forName("UTF-8"));
        sr = new Scanner(fr);
    }
    
    public void get_eng_quest() throws Exception{
        String tmp = sr.nextLine();
        eng_word_list = tmp.split(",");
        tmp = sr.nextLine();
        chin_word_list = tmp.split(",");
        fr.close();
    }   
    
}
class writefile{
    
    OutputStreamWriter out ;
    String content = "";
    int first = 0;
    writefile(){

    }

    public void init_file()throws Exception{
        OutputStreamWriter out = new OutputStreamWriter(new FileOutputStream("src/engtest/wrongquest.txt"),"UTF-8");
        out.write("");
        out.flush();
        out.close();
    }
    public void content_increase(String str)throws Exception{
        if(first == 0){
            content = str ;
            first++;
        }
        else{
            content = content + "\n" + str;
        }
        OutputStreamWriter out = new OutputStreamWriter(new FileOutputStream("src/engtest/wrongquest.txt"),"UTF-8");
        out.write(content);
        out.flush();
        out.close();
        
    }

}
