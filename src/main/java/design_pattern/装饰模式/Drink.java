package design_pattern.装饰模式;

public abstract class Drink {
    private String des;
    private float price = 0.0f;

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
    /*
        计算费用的方法，由子类实现
     */
    public abstract float cost();
}
