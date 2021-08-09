package ru.eduprof.sdo.android.proxyChecker.threads.examples;

public class MultiThread {
    public static void main(String[] args) {
        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                System.out.println("Мыть посуду выполнено: " + i + "%");
            }
        });
        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                System.out.println("Стирать белье выполнено: " + i + "%");
            }
        });
        Thread thread3 = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                System.out.println("Мыть полы выполнено: " + i + "%");
            }
        });
        thread1.start();
        thread2.start();
        thread3.start();

        /*
        Второй способ
        Thread myRunnableThread1 = new Thread(new MyRunnableThread("Мыть посуду"));
        Thread myRunnableThread2 = new Thread(new MyRunnableThread("Стирать белье"));
        Thread myRunnableThread3 = new Thread(new MyRunnableThread("Мыть полы"));
        myRunnableThread1.start();
        myRunnableThread2.start();
        myRunnableThread3.start();*/


        /*
        Первый способ
        MyThread myThread1 = new MyThread("Мыть посуду");
        MyThread myThread2 = new MyThread("Стирать белье");
        MyThread myThread3 = new MyThread("Мыть полы");
        myThread1.start();
        myThread2.start();
        myThread3.start();*/
    }
}

class MyRunnableThread implements Runnable{
    private String task;
    MyRunnableThread(String task) {
        this.task = task;
    }
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println(this.task + " выполнено на " + i + "%");
        }
    }
}

class MyThread extends Thread {
    private String task;
    MyThread(String task){
        super();
        this.task = task;
    }

    @Override
    public void run(){
        for (int i = 0; i < 100; i++) {
            System.out.println(this.task + " выполнено на " + i + "%");
        }
    }
}
