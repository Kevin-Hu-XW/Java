package design_pattern.七大软件架构设计原则.开闭原则;
//在不修改源代码的情况下，实现价格优惠个能
public class JavaDiscountCourse extends JavaCource{


    public JavaDiscountCourse(Integer id, String name, Double price) {
        super(id, name, price);
    }

    public Double getOriginPrice(){
        return super.getPrice();
    }

    //实现打折优惠个能
    public Double getDisCoutPrice() {
        return super.getPrice()*0.6;
    }
}
