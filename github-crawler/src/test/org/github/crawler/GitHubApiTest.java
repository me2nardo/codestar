package org.github.crawler;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.github.codestar.crawler.CrawlerApplication;
import org.github.codestar.crawler.model.User;
import org.github.codestar.crawler.service.GitHubApi;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.client.MockRestServiceServer;
import org.springframework.web.client.RestTemplate;

import static org.junit.Assert.assertNotNull;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.method;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.requestTo;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withBadRequest;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withSuccess;


/**
 * Unit test for github api
 * @see org.github.codestar.crawler.service.GitHubApi
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = CrawlerApplication.class)
public class GitHubApiTest {

    @Autowired
    private GitHubApi gitHubApi;

    @Autowired
    private RestTemplate restTemplate;

    private MockRestServiceServer mockRest;

    @Autowired
    private ObjectMapper objectMapper;

    @Before
    public void init(){
        mockRest = MockRestServiceServer.createServer(restTemplate);
    }

    @Test
    public void testApi() throws Exception {
        String request = objectMapper.writeValueAsString(new User(1L,"me2nardo","simple"));
        mockRest.expect(requestTo("https://api.github.com/users/me2nardo")).andExpect(method(HttpMethod.GET))
                .andRespond(withSuccess(request, MediaType.APPLICATION_JSON));
        User user = gitHubApi.extractUser("me2nardo");
        assertNotNull(user);
    }

    @Test
    public void testNotFound() throws Exception{
       /*
        mockRest.expect(requestTo("https://api.github.com/users/someuser")).andExpect(method(HttpMethod.GET))
                .andRespond();
*/
    }
}
