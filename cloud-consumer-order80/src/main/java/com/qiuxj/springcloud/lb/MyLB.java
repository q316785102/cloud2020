package com.qiuxj.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Component
public class MyLB implements LoadBalancer {
    private AtomicInteger atomicInteger = new AtomicInteger(0);

    public final int getAndIncrement() {
        int current;
        int next;
        do {
            current = this.atomicInteger.get();
            // 超过最大值,为0,重新计数 2147483647 Integer.MAX_VALUE
            next = current >= 2147483647 ? 0 : current + 1;
            // 自旋锁
        } while (!atomicInteger.compareAndSet(current, next));
        System.out.println("****第几次访问,次数next:" + next);
        return next;
    }

    /**
     * 负载均衡算法:rest接口第几次请求数%服务器集群总数量=实际调用服务器位置下标,每次服务重启动后rest接口计数从1开始.
     *
     * @param serviceInstances
     * @return
     */
    @Override
    public ServiceInstance instances(List<ServiceInstance> serviceInstances) {
        int index = getAndIncrement() % serviceInstances.size();
        return serviceInstances.get(index);
    }


















    public ServiceInstance getInstance(List<ServiceInstance> instances){
        int index = getAndIncrement2() % instances.size();
        return instances.get(index);
    }

    private AtomicInteger nextInt = new AtomicInteger(0);

    public int getAndIncrement2(){
        int current;
        int next;
        do{
            current = nextInt.get();
            next = current >= Integer.MAX_VALUE ? 0 : current++;
        }while(!nextInt.compareAndSet(current,next));
        return next;
    }

    public static void main(String[] args) {
        System.out.println(Integer.MAX_VALUE);
    }
}