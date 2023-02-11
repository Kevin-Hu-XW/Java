import java.util.Random;

public class test {
    public static void main(String[] args) {
        int loop = 1000;
        double x,y;
        int k,count=0;
        for (int j =0;j<10;j++){
            k=0;
            for (int i=0;i<loop;i++){
                x = Math.random();
                y = Math.random();
                if (x*x<y) k++;
            }
            System.out.println(k);
            count = count+k;
        }
        System.out.println("*****************");
        System.out.println("k averange:"+count/10);

    }
}
