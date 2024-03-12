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

    private NcClientProperties nc = new NcClientProperties();

    @Getter
    @Setter
    public static class AuthClientProperties {
        // client-test.clients.auth.base-uri
        private String baseUri = "http://localhost:8080";
    }

    // ?? baseUri 앞에 auth/file/nc 는 어디서 붙여주는거지??

    @Getter
    @Setter
    public static class FileClientProperties {
        // client-test.clients.file.base-uri
        private String baseUri = "http://localhost:8081";
    }

    @Getter
    @Setter
    public static class NcClientProperties {
        // client-test.clients.nc.base-uri
        private String baseUri = "http://localhost:8082";
        private String apiKey = "123";
    }

}
