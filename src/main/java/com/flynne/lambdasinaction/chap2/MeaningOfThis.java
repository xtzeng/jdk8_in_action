package com.flynne.lambdasinaction.chap2;

/**
 * @author xiaoti
 * @date 2024/11/6 22:08
 */
public class MeaningOfThis {

    public final int value = 4;
    public void doIt() {
        int value = 6;
        Runnable r = new Runnable(){
            public final int value = 5;
            public void run(){
                int value = 10;
                System.out.println(this.value);
            }
        };
        r.run();
    }
    public static void main(String...args) {
        MeaningOfThis m = new MeaningOfThis();
        m.doIt(); // ???
    }
}
