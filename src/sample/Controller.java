package sample;
import javafx.scene.control.*;
public class Controller {
    public TextField nameTxt;
    public TextField rateTxt;
    public TextField quantityTxt;
    public TextField toppingsTxt;
    public TextField amountTxt;
    public Button calculateBut;
    public Button clearBut;
    public RadioButton regularRB;
    public ToggleGroup pizza;
    public RadioButton panRb;
    public CheckBox capsicumCB;
    public CheckBox pepperoniCB;
    public CheckBox cheeseCB;
    private int costOfToppings(){//function to calculate the rate of toppings
        int costOfToppings =0;
        if (cheeseCB.isSelected())
            costOfToppings+=10;
        if (pepperoniCB.isSelected())
            costOfToppings+=10;
        if (capsicumCB.isSelected())
            costOfToppings+=10;
        toppingsTxt.setText(String.valueOf(costOfToppings));
        return costOfToppings;

    }
    private int costOfPizza(){//function to calculate the rate of pizza
        int costOfPizza=0;
       if (regularRB.isSelected())
           costOfPizza +=60;
       if (panRb.isSelected())
           costOfPizza +=60;
       rateTxt.setText(String.valueOf(costOfPizza));
       return costOfPizza;
    }
    private int numOfPizza(){
        int numOfPizza ;
        if(quantityTxt.getText().isEmpty())
            return 1;
    numOfPizza = Integer.parseInt( quantityTxt.getText());
      return numOfPizza;
    }
    private void totalCost(int costOfPizza,int costToppings,int numOfPizza){

       int totalCost = (costOfPizza + costToppings)*numOfPizza;
        amountTxt.setText(String.valueOf(totalCost));

    }
    public void clickCalculateBut(){//the function for the calculate button
        String text = quantityTxt.getText();
        if(text.matches("^[1-9]\\d*$")){
            costOfPizza();
            costOfToppings();
            numOfPizza();
            totalCost(costOfPizza(),costOfToppings(),numOfPizza());
        }
        else{ Alert alert = new Alert(Alert.AlertType.INFORMATION, "can't take string in quantity only numbers", ButtonType.OK);
            alert.setResizable(true);
            alert.getDialogPane().setPrefSize(377, 233);
            alert.show();
        }


    }
        public void clickClearBut(){
            nameTxt.clear();
         rateTxt.clear();
            quantityTxt.clear();
             toppingsTxt.clear();
             amountTxt.clear();
              capsicumCB.setSelected(false);
              pepperoniCB.setSelected(false);
              cheeseCB.setSelected(false);
              regularRB.setSelected(false);
              panRb.setSelected(false);

        }






}

