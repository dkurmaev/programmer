package shop.client;

import shop.interfaces.GoodsInterface;

public class VipVisitor extends AbstractVisitor {

    public VipVisitor(float discount) {
        this.discount = discount;
    }

    public VipVisitor(String name, float discount) {
        super(name);
        this.discount = discount;
    }

    // private String name; не нужно дублировать переменную, она уже есть в родительском классе Visitor
    private float discount;

    @Override
    public void buy(GoodsInterface goods) {
        if (!checkDiscount()) {
            super.buy(goods);
        }else{
            applyDiscount(goods); // Применяем скидку к товару
        }
    }

    private boolean checkDiscount(){
        return discount>0;
    }
    private void applyDiscount(GoodsInterface goods) {
        double discount = 0.1; // 10% скидка
        double discountedPrice = goods.getPrice() * (1 - discount);
        System.out.println("Вы купили " + goods.getName() + " со скидкой " + (discount * 100) + "%.");
        System.out.println("Цена без скидки: " + goods.getPrice() + ", Цена со скидкой: " + discountedPrice);
    }
}
