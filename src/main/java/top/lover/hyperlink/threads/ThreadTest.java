package top.lover.hyperlink.threads;

/**
 * @author shanfeng
 * @create 2019-12-05 18:10
 */
public class ThreadTest {
    public static void main(String[] args) {
        //3.创建Thread类的子类对象
        MyThread t1 = new MyThread();
        //4.通过此对象调用start():①.启动当前线程，②.调用当前线程的run()
        t1.start();
//        t1.run();
        //如下操作任然实在main线程中执行的。
        for (int i = 0; i < 100; i++){
            if(i % 2 == 0){
                System.out.println(i+"***********************main*****************");
            }
        }
    }
}

//1.创建一个继承于Thread类的子类
class MyThread extends Thread{
    //2.重写Thread类的run()
    @Override
    public void run(){
        for (int i = 0; i < 100; i++){
            if(i % 2 == 0){
                System.out.println(i);
            }
        }
    }
}
