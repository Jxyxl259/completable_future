package com.jiang.CompletableFutureTest_01;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * @ClassName task
 * @Description
 * @Author jiangxy
 * @Date 2018\11\27 0027 11:45
 * @Version 1.0.0
 */
public class Task {

    CompletableFuture<String> future;

    public Task(CompletableFuture<String> future) {
        this.future = future;
    }


    /**
     * 执行业务操作
     * @return
     */
    public Boolean executeTask(){
        // ... 业务处理
        boolean complete = this.future.complete("业务处理结果");
        return complete;
    }


    /**
     * 获取结果
     * @return
     */
    public String getResult(){

        String result = null;

        try {
            result = this.future.get(1000L, TimeUnit.MILLISECONDS);
            //result = this.future.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }catch (TimeoutException e) {
            e.printStackTrace();
        }

        return result;
    }

}
