//private int  counter =0;
private AtomicInteger counter = new AtomicInteger(0);

private LongAdder count = new LongAdder();

private Integer intCount = 0;

void main() {
    count.add(0);
    var thread1 = Thread.ofPlatform().start(this::incrementCounter);
    var thread2 = Thread.ofPlatform().start(this::incrementCounter);
    thread2.setName("thread2");
    thread1.setName("thread1");

    Executors.newVirtualThreadPerTaskExecutor();

    try{
        thread1.join();
        thread2.join();
    }catch(InterruptedException e){
        Thread.currentThread().interrupt();
        IO.println("thread interrupted");

    }
    IO.println("Atomic: "+counter+ " LongAddr: "+count+ " intCount: "+intCount);

}
//synchronized
 void  incrementCounter() {

     IO.println("Atomic: "+counter+ " LongAddr: "+count);
    for (int i = 0; i < 100000; i++) {
        counter.incrementAndGet();
        count.increment();
        intCount++;
    }
}
