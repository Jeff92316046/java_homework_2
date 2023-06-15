package cardgame;



import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

public class Controller {

    @FXML
    private Label title;
    @FXML
    private Button pair3;
    @FXML
    private Button pair4;
    @FXML
    private Button pair5;
    @FXML
    private Button exit;
    @FXML
    private Pane pane;

    

    String imageAddress[] = {"apple.png","banana.png","grapes.png","orange.png","starryberry.png"};
    int randamOrder[] = {0,0,0,0,0};
    int clickRecord_x = 0; 
    int clickRecord_y = 0;
    public void initialize() {
        
    }
    public void pair3(ActionEvent event)throws Exception{
        //Image image = new Image(getClass().getResourceAsStream("./images/apple.png"));
        //iv.setImage(image);
        GridPane gridpane = new GridPane();
        gridpane.setPadding(new Insets(5)); 
        gridpane.setHgap(5);
        gridpane.setVgap(5);
        pane.getChildren().add(gridpane);
        random(randamOrder,5);
        
        ImageView iv[][] = new ImageView[2][3];
        int order[] = {0,0,0};
        int acessOrder[] = {0,0,0};
        int cardPosition[][] = new int[2][3]; 
        int clickTimes = 0;
        
        random(acessOrder,3);
        for(int i=0;i<3;i++){
            cardPosition[0][i] = acessOrder[i];
        }
        for(int i=0;i<3;i++){
            for(int j=0;j<randamOrder.length;j++){
                if(randamOrder[j]==i){
                    order[i] = j;
                }
            }
        }
        for(int i=0;i<3;i++){
            iv[0][i] = new ImageView();
            iv[0][i].setImage(new Image(getClass().getResourceAsStream("./images/"+imageAddress[order[acessOrder[i]]])));
            iv[0][i].setFitHeight(80);
            iv[0][i].setFitWidth(80);
        }
        random(acessOrder,3);
        for(int i=0;i<3;i++){
            cardPosition[1][i] = acessOrder[i];
        }
        for(int i=0;i<3;i++){
            iv[1][i] = new ImageView();
            iv[1][i].setImage(new Image(getClass().getResourceAsStream("./images/"+imageAddress[order[acessOrder[i]]])));
            iv[1][i].setFitHeight(80);
            iv[1][i].setFitWidth(80);
        }
        idButton idbutton[][] = new idButton[2][3];
        for(int i=0;i<2;i++){
            for(int j=0;j<3;j++){
                idbutton[i][j] = new idButton(iv[i][j],i,j);
                final int index_i = i;
                final int index_j = j;
                idbutton[i][j].button.setOnAction(new EventHandler<ActionEvent>() {
                        @Override
                        public void handle(ActionEvent event) {
                            System.out.println("hello world!!");
                        }
                    }
                );
            }
        }
        
        for(int i=0;i<2;i++){
            for(int j=0;j<3;j++){
                gridpane.add(idbutton[i][j].button,j,i);
            }
        }
        for(int i=0;i<2;i++){
            for(int j=0;j<3;j++){
                System.out.print(cardPosition[i][j]+" ");
            }
            System.out.println("");
        }
        
        
        /* for(int i=0;i<3;i++){
            for(int j=0;j<randamOrder.length;j++){
                if(randamOrder[j] == i+1){
                    iv[0][i].setImage(new Image(getClass().getResourceAsStream("./images/"+imageAddress[j])));
                    iv[1][i].setImage(new Image(getClass().getResourceAsStream("./images/"+imageAddress[j])));
                    break;
                }
            }
        }
        System.out.println("owo1");
        for(int i=0;i<2;i++){
            for(int j=0;j<3;j++){
                gribpair3.add(iv[i][j], i, j);
            }
        } */

        changeStage(1);

    }
    
    
    public void pair4(ActionEvent event)throws Exception{
        changeStage(1);
    }
    public void pair5(ActionEvent event)throws Exception{
        changeStage(1);
    }
    public void random(int arr[],int max){
        int tmp,flag=0;
        for(int i=0;i<arr.length;i++){
            tmp = (int)(Math.random()*(max))+0;
            for(int j=0;j<i;j++){
                if(tmp == arr[j]){
                    i--;
                    flag = 1;
                    break;
                }
            }
            if(flag == 1){
                flag = 0;
                continue;
            }
            arr[i] = tmp;
        }
    }
    public void changeStage(int stageNum){
        if(stageNum==1){
            title.setVisible(false);
            pair3.setVisible(false);
            pair4.setVisible(false);
            pair5.setVisible(false);
            exit.setVisible(false);
            
        }
    }

    public void exit(){
        System.exit(0);
    }
}
class idButton{
    int i;
    int j;
    Button button ;
    idButton(ImageView iv,int i,int j){
        this.button = new Button("", iv);
        this.i = i;
        this.j = j;
    }

}