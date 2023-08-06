package shop.bank;

public class DKB extends AbstractBank {


    public DKB(String name, String creditDescription) {
        super(name, creditDescription);
    }

    @Override
    public void checkInfo() {
        super.checkInfo();
    }

    @Override
    public void giveCredit() {
        System.out.println("Банк " + getName() + " предоставляет кредит по программе: " + getCreditDescription());
    }


    public void checkInfo(boolean critical){

    }
}
