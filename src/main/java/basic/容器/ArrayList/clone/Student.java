package basic.容器.ArrayList.clone;

public class Student implements Cloneable{
    private String sid;
    private int age;
    private String name;
    private String address;
    private Skill skill;

    public Student() {
    }

    @Override
    public  Object clone() throws CloneNotSupportedException {
        //深拷贝不能简单的调用父类的方法
        //先克隆一个学生对象
        Student stu = (Student) super.clone();
        Skill skill = (Skill) this.skill.clone();
        this.setSkill(skill);
        return stu;
    }

    public Student( String name,int age) {
        //this.sid = sid;
        this.age = age;
        this.name = name;
        //this.address = address;
    }

    public void setSkill(Skill skill) {
        this.skill = skill;
    }

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Student{" +
                "sid='" + sid + '\'' +
                ", age=" + age +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
