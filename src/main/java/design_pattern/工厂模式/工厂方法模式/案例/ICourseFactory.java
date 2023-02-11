package design_pattern.工厂模式.工厂方法模式.案例;


/*
    优点：主要解决产品的扩展问题，随着产品链的丰富，有点像万能工厂，并不变维护，根据单一原则需要进行拆分，专人干专事
         对于新产品的创建只需创建出一个工厂类
    缺点：类的个数容易过多，增加复杂度，抽象产品只能抽象出一种产品
 */
public interface ICourseFactory {
    ICourse create();
}
