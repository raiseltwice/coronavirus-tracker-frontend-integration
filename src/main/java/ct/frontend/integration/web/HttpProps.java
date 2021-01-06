package ct.frontend.integration.web;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
@Getter
public class HttpProps {

    private final RestTemplate restTemplate;
    private final String url;

    public HttpProps(RestTemplate restTemplate, @Value("${app.client.url}") String url) {
        this.restTemplate = restTemplate;
        this.url = url;
    }
}
