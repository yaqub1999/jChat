package com.jchat.gpt.model.request;


import lombok.Getter;
import lombok.Setter;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;

@Getter
@Setter
public class ApiRequest {

    @Value("${openai.api-url}")
    private String apiUrl;
    @Value("${openai.api-key}")
    private String apiKey;

    private HttpHeaders headers;
    private JSONObject body;

    public ApiRequest(String prompt) {
        headers.setBearerAuth(apiKey);
        headers.setContentType(MediaType.APPLICATION_JSON);

        body.put("model", "text-davinci-003");
        body.put("prompt", prompt);
        body.put("max_tokens", 150);
        body.put("temperature", 0.7);
    }


}
