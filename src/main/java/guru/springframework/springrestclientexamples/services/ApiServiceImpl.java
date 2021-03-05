package guru.springframework.springrestclientexamples.services;

import guru.springframework.api.domain.User;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@Service
public class ApiServiceImpl implements ApiService {
    private RestTemplate restTemplate;
    private String api_url;

    public ApiServiceImpl(RestTemplate restTemplate, String api_url) {
        this.restTemplate = restTemplate;
        this.api_url = api_url;
    }

    @Override
    public List<User> getUsers(Integer limit) {
        UriComponentsBuilder uriBuilder = UriComponentsBuilder
                .fromUriString(api_url)
                .queryParam("limit", limit);
        List<User> userData = restTemplate.getForObject(uriBuilder.toUriString(), List.class);
        return userData;
    }
}
