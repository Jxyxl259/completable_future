package com.jiang.CompletableFutureTest_01;

import java.util.concurrent.CompletableFuture;

/**
 * @ClassName CompletableFutureTest_01
 * @Description
 *      最简单的一个Demo 主干分支处理主干业务，另起一个线程去执行非必要业务（封装了CompletablaFuture对象的Task任务类），
 *      可以为次要业务的处理设置超时时间， get(long timeout，TimeUnit unit)
 *          超时会报 java.util.concurrent.TimeoutException 异常
 * @Author jiangxy
 * @Date 2018\11\27 0027 10:40
 * @Version 1.0.0
 */
public class CompletableFutureTest_01 {



    public static void main (String[] agrs){

        CompletableFuture<String> cf_1 = new CompletableFuture<>();

        Task t_1 = new Task(cf_1);

        // 主线业务开始执行，分散任务给多个 CompletableFuture 线程池？
        long main_start = System.currentTimeMillis();
        System.out.println("主干业务开始执行..."+ main_start);

        new Thread(() -> {

            try {

                // 线程睡两秒后返回字符串，此过程中主线程下面的ask.get()方法会一直阻塞。
                long start = System.currentTimeMillis();

                System.out.println(" 分支业务开始执行 "+System.currentTimeMillis());

                Thread.currentThread().sleep(2000);

                Boolean executed = t_1.executeTask();
                System.out.println("task executed? "+executed);

                long end = System.currentTimeMillis();

                System.out.println(" 分支业务执行结束 "+System.currentTimeMillis() + "耗费时间 "+(end-start)/100D);


            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }, "branch_biz").start();

        //cft_01.ask().complete("result");


        System.out.println("主干业务执行中" +System.currentTimeMillis());

        String result = t_1.getResult();

        System.out.println("result:" + result);

        long main_end = System.currentTimeMillis();

        System.out.println("主干业务执行结束"+ main_end + "耗费时间" + (main_end -main_start)/100D);




    }


}
