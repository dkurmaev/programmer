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
        // доработанная реализация
    }


}
