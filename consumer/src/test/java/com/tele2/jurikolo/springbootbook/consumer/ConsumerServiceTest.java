package com.tele2.jurikolo.springbootbook.consumer;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tele2.jurikolo.springbootbook.commons.CommentDTO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.web.client.RestClientTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.client.MockRestServiceServer;

import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.requestTo;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withSuccess;

@RunWith(SpringRunner.class)
@RestClientTest(CommentService.class)
public class ConsumerServiceTest {

    @Value("${commentstore.endpoint}")
    private String endpoint;

    @Autowired
    private CommentService commentService;

    @Autowired
    private MockRestServiceServer server;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void whenGetComments_thenReturnEmpty() {
        final String productId = "product4712";
        server.expect(
                requestTo(
                        endpoint + "/list/" + productId
                )
        ).andRespond(
                withSuccess(
                        "[]",
                        MediaType.APPLICATION_JSON
                )
        );

        CommentDTO[] comments = commentService.getComments(productId);
        assertEquals(0, comments.length);
        server.verify();
    }
}