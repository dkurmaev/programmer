package shop.service;

import shop.enums.ConsultResult;
import shop.interfaces.VisitorInterface;

import java.util.List;

public class Consultant extends AbstractEmployee {


    public Consultant() {
    }


    public Consultant(String name) {
        super(name);
    }

    public ConsultResult consult(VisitorInterface visitor){
        super.setFree(false);
        // здесь должна быть логика, купит или пойдет домой
        double budget = visitor.getBudget();
        List<String> preferences = visitor.getPreferences();
        double itemPrice = 100;
        // Проверяем, может ли посетитель купить товар
        if (budget >= itemPrice) {
            // Посетитель может купить товар
            return ConsultResult.BUY;
        } else {
            // Посетитель не может купить товар
            return ConsultResult.GO_HOME;
        }
    }


    public void send(){

    }

}
