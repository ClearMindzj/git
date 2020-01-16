package deadlock;

import java.lang.management.ThreadInfo;

/**
 * Created by zhengjie on 2020/1/15.
 */
public class DiningPhilosophers  {
    public static class Philosopher implements Runnable{
        private Object leftChopstick;
        private Object rightChopstick;

        public Philosopher(Object leftChopstick, Object rightChopstick) {
            this.leftChopstick = leftChopstick;
            this.rightChopstick = rightChopstick;
        }

        @Override
        public void run() {
            try {
            while (true){

                    doAction("Thinking");
                    synchronized (leftChopstick){
                        doAction("pick up left chopstick");
                        synchronized (rightChopstick){
                            doAction("pick up right chopstick");
                            doAction("put down right chopstick");
                        }
                        doAction("put down left chopstick");
                    }
                }
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

        private void doAction(String action) throws InterruptedException {
            System.out.println(Thread.currentThread().getName()+" "+action);
            Thread.sleep((long) (Math.random()*10));
        }

        public static void main(String[] args) {
            Philosopher[] philosophers=new Philosopher[5];
            Object[] chopsticks=new Object[philosophers.length];
            for (int i = 0; i <chopsticks.length ; i++) {
             chopsticks[i]=new Object();   
            }
            for (int i = 0; i <philosophers.length ; i++) {
                Object leftChopstick=chopsticks[i];
                Object rightChopstick=chopsticks[(i+1)%chopsticks.length];
                philosophers[i]=new Philosopher(leftChopstick,rightChopstick);
                new Thread(philosophers[i],"哲学家"+(i+1)+"号").start();
            }
        }
    }


}
