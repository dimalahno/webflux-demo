package kz.example.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.*;

@Configuration
@RequiredArgsConstructor
public class CalculatorRouterConfig {

    private final CalculatorHandler handler;

    @Bean
    public RouterFunction<ServerResponse> highLevelCalculatorRouter() {
        return RouterFunctions.route()
                .path("calculator", this::serverResponseRouterFunction)
                .build();
    }

    private RouterFunction<ServerResponse> serverResponseRouterFunction() {
        return RouterFunctions.route()
                .GET("{a}/{b}", isOperation("+"), handler::additionalHandler)
                .GET("{a}/{b}", isOperation("-"), handler::subtractionHandler)
                .GET("{a}/{b}", isOperation("*"), handler::multiplicationHandler)
                .GET("{a}/{b}", isOperation("/"), handler::divisionHandler)
                .GET("{a}/{b}", request -> ServerResponse.badRequest().bodyValue("OP should be +, -, *, /"))
                .build();
    }

    private RequestPredicate isOperation(String operation) {
        return RequestPredicates.headers(headers -> operation.equals(headers.asHttpHeaders().toSingleValueMap().get("OP")));
    }
}
