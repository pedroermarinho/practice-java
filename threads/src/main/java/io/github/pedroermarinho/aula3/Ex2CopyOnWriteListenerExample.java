package io.github.pedroermarinho.aula3;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Ex2CopyOnWriteListenerExample {

    interface EventListener {
        void onEvent(String event);
    }

    static class Notifier {
        private final List<EventListener> listeners = new CopyOnWriteArrayList<>();

        public void addListener(EventListener listener) {
            listeners.add(listener);
            IO.println("Listener adicionado. Lista atual: " + listeners.size());
        }

        public void notifyListeners(String event) {
            IO.println("Notificando: "+ listeners.size() + " listeners sobre o evento: " + event);

            for (EventListener listener : listeners) {
                listener.onEvent(event);
                try{
                    Thread.sleep(10);
                }  catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        }
    }


    static void main() throws InterruptedException {
        Notifier notifier = new Notifier();
        notifier.addListener( event -> IO.println("Listener A recebeu: "+event));
        notifier.addListener( event -> IO.println("Listener B recebeu: "+event));

        try(ExecutorService executor = Executors.newFixedThreadPool(2)){

            executor.submit(()->{
                for (int i = 0; i < 5; i++) {
                    notifier.notifyListeners("Evento "+i);
                }
            });

            executor.submit(()->{
                try{
                    Thread.sleep(50);
                    notifier.addListener( event -> IO.println("Listener C (novo) recebeu: "+event));
                }  catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            });

            executor.shutdown();
            executor.awaitTermination(10, TimeUnit.SECONDS);

        }
    }
}
