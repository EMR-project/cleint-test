package com.cookiedown.clienttest.config;

import com.cookiedown.clienttest.client.auth.AuthApi;
import com.cookiedown.clienttest.client.auth.AuthOperations;
import com.cookiedown.clienttest.client.nc.NcApi;
import com.cookiedown.clienttest.client.nc.NcOperations;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.codec.json.Jackson2JsonDecoder;
import org.springframework.http.codec.json.Jackson2JsonEncoder;
import org.springframework.web.reactive.function.client.WebClient;

@EnableConfigurationProperties(WebClientProperties.class)
@Configuration(proxyBeanMethods = false)
public class WebClientConfig {

    private final WebClientProperties properties;

    WebClientConfig(WebClientProperties properties) {
        this.properties = properties;
    }

    @Bean
    public AuthApi authApi(@Qualifier("authClient") WebClient authClient) {
        return new AuthOperations(authClient);
    }

    @Bean
    public NcApi ncApi(@Qualifier("ncClient") WebClient ncClient) {
        return new NcOperations(ncClient);
    }

    @Bean(name = "authClient")
    public WebClient authClient() {
        return WebClient.create(properties.getAuth().getBaseUri());
    }

    @Bean(name = "fileClient")
    public WebClient fileClient() {
        return WebClient.create(properties.getFile().getBaseUri());
    }

    @Bean(name = "ncClient")
    public WebClient ncClient(ObjectMapper objectMapper) {
        // mvc(tomcat) vs webflux(netty)
        /*
            mvc -> RestTemplate client 사용 <- 문제가 많음 -> WebClient 빌려서 씀. -> RestClient
            webflux -> WebClient 사용
         */
        return WebClient.builder()
                .baseUrl(properties.getNc().getBaseUri())
                .defaultHeader(HttpHeaders.AUTHORIZATION, "Bearer " + properties.getNc().getApiKey())
                .codecs((codec) -> {
                    codec.defaultCodecs().jackson2JsonEncoder(new Jackson2JsonEncoder(objectMapper));
                    codec.defaultCodecs().jackson2JsonDecoder(new Jackson2JsonDecoder(objectMapper));
                })
                .build();
    }
}
