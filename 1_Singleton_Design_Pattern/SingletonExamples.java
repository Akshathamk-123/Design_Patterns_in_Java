public class SingletonExamples {

    // Lazy Initialization Singleton
    public static class LazySingleton {
        private static LazySingleton instance;

        private LazySingleton() {
            // private constructor to prevent instantiation
        }

        public static LazySingleton getInstance() {
            if (instance == null) {
                instance = new LazySingleton();
            }
            return instance;
        }

        public void showMessage() {
            System.out.println("Lazy Singleton Instance");
        }
    }

    // Eager Initialization Singleton
    public static class EagerSingleton {
        private static final EagerSingleton instance = new EagerSingleton();

        private EagerSingleton() {
            // private constructor to prevent instantiation
        }

        public static EagerSingleton getInstance() {
            return instance;
        }

        public void showMessage() {
            System.out.println("Eager Singleton Instance");
        }
    }

    // Thread-Safe Singleton
    public static class ThreadSafeSingleton {
        private static ThreadSafeSingleton instance;

        private ThreadSafeSingleton() {
            // private constructor to prevent instantiation
        }

        public static synchronized ThreadSafeSingleton getInstance() {
            if (instance == null) {
                instance = new ThreadSafeSingleton();
            }
            return instance;
        }

        public void showMessage() {
            System.out.println("Thread-Safe Singleton Instance");
        }
    }

    // Double-Checked Locking Singleton
    public static class DoubleCheckedLockingSingleton {
        private static volatile DoubleCheckedLockingSingleton instance;

        private DoubleCheckedLockingSingleton() {
            // private constructor to prevent instantiation
        }

        public static DoubleCheckedLockingSingleton getInstance() {
            if (instance == null) {
                synchronized (DoubleCheckedLockingSingleton.class) {
                    if (instance == null) {
                        instance = new DoubleCheckedLockingSingleton();
                    }
                }
            }
            return instance;
        }

        public void showMessage() {
            System.out.println("Double-Checked Locking Singleton Instance");
        }
    }

    public static void main(String[] args) {
        // Test Lazy Initialization Singleton
        LazySingleton lazySingleton = LazySingleton.getInstance();
        lazySingleton.showMessage();

        // Test Eager Initialization Singleton
        EagerSingleton eagerSingleton = EagerSingleton.getInstance();
        eagerSingleton.showMessage();

        // Test Thread-Safe Singleton
        ThreadSafeSingleton threadSafeSingleton = ThreadSafeSingleton.getInstance();
        threadSafeSingleton.showMessage();

        // Test Double-Checked Locking Singleton
        DoubleCheckedLockingSingleton doubleCheckedLockingSingleton = DoubleCheckedLockingSingleton.getInstance();
        doubleCheckedLockingSingleton.showMessage();
    }
}
