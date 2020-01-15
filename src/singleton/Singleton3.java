package singleton;

/**
 * Created by zhengjie on 2020/1/12.
 * 懒汉（线程不安全）
 */
public class Singleton3 {
    private  static Singleton3 instance;

    private Singleton3(){

    }
    public static Singleton3 getInstance(){
        if(instance ==null){
            instance=new Singleton3();
        }
        return instance;
    }
}
