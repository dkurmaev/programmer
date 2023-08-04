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
            // купить со скидкой
        }
    }

    private boolean checkDiscount(){
        return discount>0;
    }
}
