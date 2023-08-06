package shop.bank;

public class Sparkasse extends AbstractBank {

    public Sparkasse(String name, String creditDescription) {
        super(name, creditDescription);
    }

    @Override
    public void checkInfo() {
        super.checkInfo();
    }

    @Override
    public void giveCredit() {
        System.out.println("Банк " + getName() + " выдает кредит согласно условиям: " + getCreditDescription());
    }



}
