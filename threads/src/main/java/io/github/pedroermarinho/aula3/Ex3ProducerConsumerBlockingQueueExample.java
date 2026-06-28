package io.github.pedroermarinho.aula3;

import java.util.concurrent.*;

public class Ex3ProducerConsumerBlockingQueueExample {

    static void main() {
        BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(10);

        try(ExecutorService executor = Executors.newVirtualThreadPerTaskExecutor()){

            executor.submit(()->{
                try{
                    for (int i = 0; i < 100; i++) {
                        IO.println("Produzindo: "+i);
                        queue.put(i);
                        Thread.sleep(1000);
                    }
                } catch (InterruptedException e){
                    Thread.currentThread().interrupt();
                }
            });


            executor.submit(()->{
                try{
                    while (true){
                        Integer value = queue.take();
                        IO.println("Consumidor: "+value);
                        Thread.sleep(100);
                        if (value == 99) break;
                    }
                } catch (InterruptedException e){
                    Thread.currentThread().interrupt();
                }

            });

        }
    }
}
