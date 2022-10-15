package bll;

import java.util.LinkedList;
import java.util.List;

public class CompositeProduct extends MenuItem{
    public String title;
    List<BaseProduct> productList;
    public CompositeProduct(String title){
        super();
        this.title = title;
       productList = new LinkedList<>();
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public void setTitle(String title) {
        this.title = title;
    }

    public List<BaseProduct> getProductList() {
        return productList;
    }

    public void setProductList(List<BaseProduct> productList) {
        this.productList = productList;
    }
}
