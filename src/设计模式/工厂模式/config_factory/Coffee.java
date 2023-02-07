package 设计模式.工厂模式.config_factory;

public abstract class Coffee {

    //获得名称
    public abstract String getName();
    //加糖
    public void addsugar(){
        System.out.println("加糖");
    }
    //加奶
    public void addmilk(){
        System.out.println("加奶");
    }
}
