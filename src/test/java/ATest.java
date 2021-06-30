import java.util.concurrent.*;

/**
 * @author huaihai.guan
 * @since 2021/3/9 15:18
 */
public class ATest {

    private static int a = 0;

    private static ThreadLocal<String> threadLocal = new ThreadLocal<>();

    private static Object o = new Object();

    public static void set() {
        a++;
        System.out.println(a);
    }

    public static void main(String[] args) {

//        ThreadPoolExecutor executor = new ThreadPoolExecutor(2, 2, 1, TimeUnit.SECONDS, new ArrayBlockingQueue<>(100));
//        executor.submit(new Thread(ATest::set));
//        executor.submit(new Thread(ATest::set));
//        System.out.println(executor.getCorePoolSize() + "-" + executor.getCompletedTaskCount());
        Thread thread1 = new Thread(ATest::set);
        Thread thread2 = new Thread(ATest::set);
        thread1.start();
        thread2.start();

    }
}
