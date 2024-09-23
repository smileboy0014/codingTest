package com.example.algorithm.exc;

import java.util.List;
import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class com {

    // Simulate an HTTP request to a third-party server
    private static CompletableFuture<String> sendRequestToServer(String serverName) {


        Random random = new Random();
        int randomValue = (random.nextInt(10) + 1) * 1000;
        return CompletableFuture.supplyAsync(() -> {
            // Simulate network call (e.g., using HttpClient)
            try {
                if (serverName.equals("Server 7")) {
                    throw new RuntimeException();
                }
                Thread.sleep(randomValue); // Simulate delay
                System.out.println("serverName is " + serverName + " time is " + randomValue);
                return "Response from " + serverName;
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {


        // Create a thread pool for asynchronous tasks
        ExecutorService executor = Executors.newFixedThreadPool(10);

        // Simulate sending requests to two different third-party servers
        CompletableFuture<String> request1 = sendRequestToServer("Server 1");
        CompletableFuture<String> request2 = sendRequestToServer("Server 2");
        CompletableFuture<String> request3 = sendRequestToServer("Server 3");
        CompletableFuture<String> request4 = sendRequestToServer("Server 4");
        CompletableFuture<String> request5 = sendRequestToServer("Server 5");
        CompletableFuture<String> request6 = sendRequestToServer("Server 6");
        CompletableFuture<String> request7 = sendRequestToServer("Server 7");

        // Use CompletableFuture.allOf to wait for both requests to complete
        CompletableFuture<Void> allOf = CompletableFuture.allOf(request1, request2, request3, request4, request5, request6, request7);

        // When both are completed, combine the results
        CompletableFuture<List<String>> combinedFuture = allOf.thenApply(v -> List.of(
                request1.join(), // Waits for and retrieves the result of request 1
                request2.join(),  // Waits for and retrieves the result of request 2,
                request3.join(),  // Waits for and retrieves the result of request 2,
                request4.join(),  // Waits for and retrieves the result of request 2,
                request5.join(),  // Waits for and retrieves the result of request 2,
                request6.join(),  // Waits for and retrieves the result of request 2,
                request7.join()  // Waits for and retrieves the result of request 2,
        ));

        // Get the combined result
        List<String> responses = combinedFuture.join();

        // Print the responses or send back to the client
        responses.forEach(System.out::println);

        // Shutdown the executor
        executor.shutdown();
    }
}
