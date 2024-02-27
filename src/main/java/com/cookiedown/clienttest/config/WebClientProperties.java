package com.cookiedown.clienttest.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Setter
@Getter
@ConfigurationProperties(prefix = "client-test.clients")
public class WebClientProperties {

    private AuthClientProperties auth = new AuthClientProperties();

    private FileClientProperties file = new FileClientProperties();

    @Getter
    @Setter
    public static class AuthClientProperties {
        // client-test.clients.auth.base-uri
        private String baseUri = "http://localhost:8080";
    }

    @Getter
    @Setter
    public static class FileClientProperties {
        // client-test.clients.file.base-uri
        private String baseUri = "http://localhost:8081";
    }

}
