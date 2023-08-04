package shop.bank;

public class Sberbank extends AbstractBank {



    public Sberbank(String name, String creditDescription) {
        super(name, creditDescription);
    }

    @Override
    public void checkInfo() {
        super.checkInfo();
    }

    @Override
    public void giveCredit() {
        // доработанная реализация
    }


    // сбербанк умеет также рассматривать срочные заявки с помощью перегруженного метода
    public void checkInfo(boolean critical){

    }
}
