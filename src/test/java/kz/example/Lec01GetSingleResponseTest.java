package kz.example;

import org.springframework.web.reactive.function.client.WebClient;

public class Lec01GetSingleResponseTest extends BaseTest{

    private final WebClient webClient;

    public Lec01GetSingleResponseTest(WebClient webClient) {
        this.webClient = webClient;
    }
}
