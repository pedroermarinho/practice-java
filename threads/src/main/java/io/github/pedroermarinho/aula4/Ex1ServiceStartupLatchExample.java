package io.github.pedroermarinho.aula4;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Ex1ServiceStartupLatchExample {

    static class ServiceInitializer implements Runnable {
        private final String serviceName;
        private final CountDownLatch latch;
        private final int startupTime;

        ServiceInitializer(String serviceName, int startupTime ,CountDownLatch latch) {
            this.serviceName = serviceName;
            this.latch = latch;
            this.startupTime = startupTime;
        }

        @Override
        public void run() {
            try {
                IO.println("Inicializando " + serviceName + "...");
                Thread.sleep(startupTime);
                IO.println(serviceName + " inicializado.");
                latch.countDown();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }


    static void main() throws InterruptedException {
        int numberOfServices = 3;
        CountDownLatch startupLatch = new CountDownLatch(numberOfServices);

        try(ExecutorService executor = Executors.newFixedThreadPool(numberOfServices)){
            executor.submit(new ServiceInitializer("DatabaseService", 3000,startupLatch));
            executor.submit(new ServiceInitializer("CacheService", 5000,startupLatch));
            executor.submit(new ServiceInitializer("MessagingService", 7000,startupLatch));


            IO.println("Thread principal aguardando a inicialização dos serviços...");
            startupLatch.await();

            IO.println("Todos os serviços foram inicializados. Aplicação pronta!");
        }
    }
}
