package 基础.容器;

import java.util.ArrayList;
import java.util.List;
/*
    java中采用链地址法来解决hash冲突
    好的Hash算法和扩容机制来控制map使得Hash碰撞的概率又小，哈希桶数组（Node[] table）占用空间又少
 */
public class MyHashMap<K,V> implements MyMap<K,V> {
    //HashMap中默认的成员变量
    private static int defaultLength = 16;    //默认数组长度
    private static double Loader = 0.75;      //默认的负载因子0.75是对空间和时间效率的一个平衡选择
    Node<K,V>[] table = new Node[defaultLength];         //Node数组
    private int size = 0;                     //HashMap的大小
    static class Node<K,V> implements MyMap.Entry<K,V> {
        int hash;
        K key;
        V value;
        Node<K,V> next;

        public Node(int hash, K key, V value, Node<K, V> next) {
            this.hash = hash;
            this.key = key;
            this.value = value;
            this.next = next;
        }
        @Override
        public K getKey() {
            return key;
        }

        @Override
        public V getValue() {
            return value;
        }
    }
    /*
        自定义长度和负载因子0.75
     */
    public MyHashMap(int length,double loader){
        defaultLength = length;
        Loader = loader;
        table = new Node[length];
    }
    /*
        使用默认值
     */
    public MyHashMap(){
        this(defaultLength,Loader);
    }
    /*
        自定义Hash函数
        hash(key)%length运算效率很低，所以JDK1.7采用hash(key)&(length-1)
        但在JDK1.8中使用(h = key.hashCode()) ^ (h >>> 16)，这样可以使高16位参与到运算中来，高16位与低16位异或后，
        使得低16位有高16 位的特征，这样可以降低hash冲突，从而在一定程度上保证了数据的均匀分布
     */
    public int hash(K key){
        int h = key.hashCode();
        return ((key==null)?0:h^(h>>>16));
    }

    public void resize(){
        //创建一个大小是原来两倍的Node数组
        Node<K,V>[] newtable = new Node[2*defaultLength];
        //重新散列,进行数据转移
        rehash(newtable);
    }

    private void rehash(Node<K,V>[] newtable){
        Node<K,V>[] oldtable = table;
        List<Node<K,V>> list = new ArrayList<Node<K,V>>();
        //将所有对象加载到list当中
        for (int i=0;i<oldtable.length;i++){
            Node<K,V> e = oldtable[i];
            if (e == null)
                continue;
            while (e!=null){
                list.add(e);
                e = e.next;
            }
        }
        if (list.size()>0){
            table = newtable;
            defaultLength = 2*defaultLength;
            for (int i=0;i<list.size();i++){
                //把所有Node的next指针置为空
                if (list.get(i).next!=null)
                    list.get(i).next = null;
                put(list.get(i).key,list.get(i).value);
            }
        }
    }

    @Override
    public V put(K key, V value) {
        //判断是否达到扩容的标准
        if (size>defaultLength*Loader){
            resize();
        }
        int length = table.length;
        //根据hash值算出下标
        int index= hash(key)&(length-1);
        if (table[index]==null){
            /*
                说明当前下标没有数据，直接创建Node节点对象即可
             */
            table[index] = new Node<>(hash(key),key,value,null);
            size++;
        }
        else {
            /*
                JDK1.7若当前数据不为空，说明当前位置已近有数据了
                则采用头查法进行插入
                JDK1.8采用尾插法
             */
            Node<K,V> node = new Node<>(hash(key),key,value,table[index]);
            table[index] = node;
        }
        return table[index].getValue();
    }

    @Override
    public V get(K key) {
        int index = hash(key)&(table.length-1);
        if (table[index] == null)
            return null;
        else {
            Node node = table[index];
            while (node!=null){
                if (key==node.getKey()||key.equals(node.getKey()))
                    return (V) node.getValue();
                else{
                    node = node.next;
                }
            }
        }
        return null;
    }
    @Override
    public int size() {
        return size;
    }



}
