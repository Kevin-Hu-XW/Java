package design_pattern.工厂模式.简单工厂模式.案例;

public class CourseFactory {
    /*
    public ICourse create(String name){
        //痛点：当增加新的课程时，还需要修改代码，不符合开闭原则，需要采用反射技术
        if ("java".equals(name))
            return new JavaCourse();
        else if ("Python".equals(name))
            return new PythonCourse();
        else
            return null;
    }
     */
    /*
    public ICourse create(String className) {
        //痛点：此方法利用反射技术通过全路径名来创建对象的实例,但需要强制类型转换，且参数是字符串
        try {
            if (null != className || "".equals(className)) {
                return (ICourse) Class.forName(className).newInstance();
            }
        } catch (Exception e) {

        }
        return null;
    }
    */
    //通过传入类对象来创建对象实例,调用无参构造器，如果没有会报错
    public ICourse create(Class<? extends ICourse> clazz){
        if (clazz!=null){
            try {
                return clazz.newInstance();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
