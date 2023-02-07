package 多线程.线程创建.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TestTimeBoom {
    public static void main(String[] args) {
        //创建线程和启动线程
        //TimeBombThread timeBombThread = new TimeBombThread();
        TimeBombThread timeBombThread = new TimeBombThread();
        //接受控制台输入
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        String line;
        try {
            while (true){
                System.out.println("输入quit结束线程：");
                line =br.readLine();
                if (line.equals("quit")){
                    timeBombThread.Stop();
                    break;
                }
            }

        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
}
