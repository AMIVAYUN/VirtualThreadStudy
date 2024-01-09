
public class Main {
    public static void main(String[] args) {

        Thread vthr = Thread.ofVirtual().name("1").unstarted(  new task01() );

        Thread thr = new Thread( new task01() );

        Thread vthr2 = Thread.ofVirtual().name("2").unstarted( new task02() );

        vthr.start();
        //run으로 실행하면 메인 메소드 안에서 run()을 써버리면 쓰레드 안에서 직접 run을 주입시켜서 사용하기에 멀티쓰레딩 환경이 x
        // 일반 Thread 호출 시 호출 Main Thread의 이름을 따라감.

        vthr2.start();

        thr.start();


    }
}


class task01 implements Runnable{

    @Override
    public void run() {
        System.out.println( Thread.currentThread().getName() + " " + Thread.currentThread().getThreadGroup() );
    }
}

class task02 implements Runnable{

    @Override
    public void run() {
        Thread vthr = Thread.ofVirtual().name("2").unstarted(  new task01() );
        vthr.start();
    }
}

