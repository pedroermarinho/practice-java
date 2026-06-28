package dev.ia;


public class SecurityContext {
    private static final ThreadLocal<String> currentUser = new ThreadLocal<>();


    public static String getCurrentUser() {
        return currentUser.get();
    }

    public static void setCurrentUser(String user) {
        currentUser.set(user);
    }

    public static void clear() {
        currentUser.remove();
    }


}
