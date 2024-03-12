package com.cookiedown.clienttest.config;

import com.cookiedown.clienttest.client.auth.AuthApi;
import com.cookiedown.clienttest.client.auth.AuthOperations;
import com.cookiedown.clienttest.client.nc.NcApi;
import com.cookiedown.clienttest.client.nc.NcOperations;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
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
    public WebClient ncClient() {
        return WebClient.builder().baseUrl(properties.getNc().getBaseUri()).defaultHeader("Authorization", "Bearer " + properties.getNc().getApiKey()).build();
    }
}
