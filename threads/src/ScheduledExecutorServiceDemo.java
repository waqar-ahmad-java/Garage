
private static int count = 0;
void main() throws ExecutionException, InterruptedException {
    ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(1);

    IO.println("--------------------------------- Executing task 1");

    Runnable task = ()->{
        IO.println("Executing task 1 at: "+Thread.currentThread().getName()+ " "+LocalDateTime.now());
    };
    ScheduledFuture<?> scheduledFuture = scheduledExecutorService.schedule(task,5,TimeUnit.SECONDS);

    IO.println(scheduledFuture.get());



    IO.println("--------------------------------- Executing task 2");
    Runnable task2 = ()->{
        count++;
        IO.println("Counting: "+count+ " at "+LocalDateTime.now());
    };
//    ScheduledFuture<?> scheduledFuture2 = scheduledExecutorService.scheduleAtFixedRate(task2,5,1,TimeUnit.SECONDS);

    ScheduledFuture<?> scheduledFuture2 = scheduledExecutorService.scheduleWithFixedDelay(task2,5,3,TimeUnit.SECONDS);
    while(count != 5){
        TimeUnit.MILLISECONDS.sleep(100);
    }

    IO.println("Count is 5 cancel the scheduledFuture2");

    scheduledFuture2.cancel(true);

    scheduledExecutorService.shutdown();
}
