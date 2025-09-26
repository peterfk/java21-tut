package com.mycompany.java21.tut;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

public class VirtualThreadIOBoundExample {

    public static void main(String[] args) {
        // Use a virtual thread per task executor
        try (ExecutorService executor = Executors.newVirtualThreadPerTaskExecutor()) {
            // Submit a large number of I/O-bound tasks
            for (int i = 0; i < 100; i++) {
                int taskId = i;
                executor.submit(() -> {
                    try {
                        // Simulate a network call to a web service
                        HttpResponse<String> response = makeRequest(taskId);
                        System.out.println("Response " + taskId + ": " + response.statusCode() + " on thread " + Thread.currentThread());
                    } catch (IOException | InterruptedException e) {
                        // Simplified error handling for example
                        e.printStackTrace();
                    }
                });
            }

            // The try-with-resources statement will implicitly call executor.close(),
            // which waits for all submitted tasks to complete.
        }
        System.out.println("All requests completed.");
    }

    private static HttpResponse<String> makeRequest(int i) throws IOException, InterruptedException {
        // Using a public test API for the I/O-bound operation
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
            .uri(URI.create("https://jsonplaceholder.typicode.com/posts/" + (i + 1)))
            .build();
        return client.send(request, HttpResponse.BodyHandlers.ofString());
    }
}
