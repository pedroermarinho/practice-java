package io.github.pedroermarinho.aula02;

import java.sql.Time;
import java.time.LocalTime;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Ex3ScheduledTasksExample {

    static void main() throws InterruptedException {
        try(ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(2)){

            scheduler.schedule(()->{
                IO.println("Tarefa de execução unica executada às "+ LocalTime.now());
            },3, TimeUnit.SECONDS);


            scheduler.scheduleAtFixedRate(()->{
                IO.println("Tareafa periótica (fixed rate) executada às "+ LocalTime.now());
                try{
                    Thread.sleep(1000);
                }catch (InterruptedException e){
                    Thread.currentThread().interrupt();
                }
            }, 1, 5, TimeUnit.SECONDS);

            scheduler.scheduleWithFixedDelay(()->{
                IO.println("Tarefa periotica (fiexed delay) executada às "+ LocalTime.now());
                try{
                    Thread.sleep(2000);
                }catch (InterruptedException e){
                    Thread.currentThread().interrupt();
                }
            }, 1, 5 , TimeUnit.SECONDS);


            Thread.sleep(20000);
        }
    }
}
