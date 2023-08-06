package shop.bank;

import shop.interfaces.BankInterface;

public abstract class AbstractBank implements BankInterface {

    // количество заявок по всем банкам (можно также реализовать через коллекцию)
    public static int requestCount;

    private String name;
    private String creditDescription;

    public AbstractBank(String name, String creditDescription) {
        this.name = name;
        this.creditDescription = creditDescription;
    }

    @Override
    public void checkInfo() {
        requestCount++;
    }

    @Override
    public void giveCredit() {
        // Реализуйте метод giveCredit(), специфичный для каждого банка.
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getCreditDescription() {
        return creditDescription;
    }
}
