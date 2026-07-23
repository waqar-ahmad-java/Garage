import java.sql.Time;

void main() throws ExecutionException, InterruptedException {
    ExecutorService executorService = Executors.newFixedThreadPool(3);

    Runnable runnableTask = () ->{
        String threadName = Thread.currentThread().getName();
        IO.println(threadName+" Runnable task");
    };

    Callable<String> callableTask = () -> {
        String threadName = Thread.currentThread().getName();
        return threadName + " Executing task 1";
    };
    Callable<String> callableTask2 = () -> {
        String threadName = Thread.currentThread().getName();
        return threadName + " Executing task 2";
    };


    IO.println("--------------------------------- Executing tasks");


    executorService.execute(runnableTask);
    Future<String> callableFeature = executorService.submit(callableTask);
    Future<String> callableFeature2 = executorService.submit(callableTask2);
    IO.println(callableFeature.get());
    IO.println(callableFeature2.get());


    IO.println("----------------------------------- Executing Any one Task");



    List<Callable<String>> callableTasks = new ArrayList<>();
    callableTasks.add(callableTask);
    callableTasks.add(callableTask2);

    String result = executorService.invokeAny(callableTasks);
    IO.println(result);



    IO.println("-------------------------------------Executing All tasks");


    List<Future<String>> futures = executorService.invokeAll(callableTasks);

    for (Future<String> future:futures){
        IO.println(future.get());
    }


    executorService.shutdown();

//    executorService.shutdownNow();
//      executorService.awaitTermination(1, TimeUnit.MILLISECONDS);
}