package singleton;

/**
 * Created by zhengjie on 2020/1/12.
 * 懒汉（线程安全） 不推荐
 */
public class Singleton4 {
    private  static Singleton4 instance;

    private Singleton4(){

    }
    public synchronized static Singleton4 getInstance(){
        if(instance ==null){
            instance=new Singleton4();
        }
        return instance;
    }
}
