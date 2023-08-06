package shop.interfaces;

import java.util.List;

public interface VisitorInterface {

    void buy(GoodsInterface goods);

    void returnGoods(GoodsInterface goods);

    String getName();

    List<String> getPreferences();

    double getBudget();
}
