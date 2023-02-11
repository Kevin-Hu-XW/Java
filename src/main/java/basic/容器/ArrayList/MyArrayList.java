package basic.容器.ArrayList;

public class MyArrayList<E> {
    //定义数组，用于存储集合的元素
    private Object[] elementData;
    //定义变量，记录数组元素的个数
    private int size;
    //定义空数组，用于创建集合对象时，给集合初始化
    private Object[] emptyArray = {};
    //定义常量，记录集合的容量
    private final int Default_Capcity = 10;

    //定义构造方法
    public MyArrayList(){
        //给elementData初始化
        elementData = emptyArray;
    }
    /*
        1、判断数组是否需要扩容
        2、把元素添加到集合，并且size++
     */
    public boolean add(E e){
        //判断是否需要扩容
        grow();
        //将元素添加到集合
        elementData[size++] = e;
        return true;
    }
    //简单扩容
    /*
        1、判断数组是否为空，如果为空则进行第一次扩容，数据大小为默认容量
        2、如果数据不为空，并且数组元素个数为数组长度，则进行扩容，新数组的长度为原数组长度的1.5倍，并且通过System.arraycopy
           把原数组的元素拷贝到新数组中，新数组的引用覆盖原数组的引用
     */
    private void grow(){
        //判断集合是否为空，若为空，则进行第一次扩容
        if (elementData==emptyArray){
            //第一次扩容
            elementData = new Object[Default_Capcity];
        }
        //元素个数等于数组长度就进行扩容
        if (size-elementData.length==0){
            int oldCapcity = elementData.length;
            //扩容为原来数组长度的1.5倍
            int newLength = oldCapcity+(oldCapcity>>1);
            //创建新数组
            Object[] obj = new Object[newLength];
            System.arraycopy(elementData,0,obj,0,elementData.length);
            //赋值给原数组
            elementData = obj;
        }

    }
    //返回值
    public E set(int index,E e){
        //对索引进行判断
        checkIndex(index);
        //把对应元素取出来并返回
        E value = (E)elementData[index];
        //替换元素
        elementData[index] = e;
        return value;
    }

    private void checkIndex(int index) {
        if (index<0||index>=size)
            throw new ArrayIndexOutOfBoundsException("索引越界！");
    }
    //删除方法
    /*
        1、先检查要删除元素的索引是否越界
        2、通过索引获取要删除的元素，并赋值给变量value
        3、进行元素的移动
        4、把最后一个元素赋值为null，并且size--
        5、把删除的元素返回
     */
    public E remove(int index){
        checkIndex(index);
        //返回删除的元素
        E value = (E)elementData[index];
        //移动数组元素的个数
        int numMove = size-index-1;
        if (numMove>0)
            System.arraycopy(elementData,index+1,elementData,index,numMove);
        //把最后一个位置上的元素置为null，使尽早回收
        elementData[size--] = null;
        return value;
    }
    //转换方法
    public String toString(){
        if (size==0)
            return "[]";
        //创建StringBuilder
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");
        for (int i=0;i<size;i++){
            if (i==size-1){
                stringBuilder.append(elementData[i]).append("]");
            }
            else {
                stringBuilder.append(elementData[i].toString()).append(",");
            }

        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        MyArrayList<String> list = new MyArrayList<>();
        list.add("kevin");
        list.add("kevin1");
        list.add("kevin2");
        System.out.println(list.toString());
        list.set(0,"james");
        list.remove(0);
        System.out.println(list.toString());
    }
}
