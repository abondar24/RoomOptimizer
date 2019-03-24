package org.abondar.industrial.roomoptimizer.test;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.abondar.industrial.roomoptimizer.Main;
import org.abondar.industrial.roomoptimizer.model.Resource;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureWebMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

import java.nio.charset.Charset;
import java.util.Arrays;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;


@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = Main.class)
@AutoConfigureWebMvc
public class ControllerTest {
    private static Logger logger = LoggerFactory.getLogger(ControllerTest.class);

    @Autowired
    private ObjectMapper om;

    @Autowired
    private WebApplicationContext context;


    private MockMvc mockMvc;

    private MediaType contentType = new MediaType(MediaType.APPLICATION_JSON.getType(),
            MediaType.APPLICATION_JSON.getSubtype(), Charset.forName("utf8"));


    @BeforeEach
    public void setUp() {
        this.mockMvc = webAppContextSetup(context).build();
    }

    @Test
    public void testAllocation() throws Exception {
        logger.info("Allocation api test");

        String content = om.writeValueAsString(new Resource(Arrays.asList(10,5,6),5,1));
        mockMvc.perform(
                post("/allocate/resources")
                .contentType(contentType)
                .content(content))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(3)))
                .andExpect(jsonPath("$[0].senior", is(2)))
                .andExpect(jsonPath("$[0].junior", is(0)))
                .andExpect(jsonPath("$[1].senior", is(1)))
                .andExpect(jsonPath("$[1].junior", is(0)))
                .andExpect(jsonPath("$[2].senior", is(1)))
                .andExpect(jsonPath("$[2].junior", is(1)));

    }



    @Test
    public void testAllocationError() throws Exception {
        logger.info("Allocation api test");

        String content = om.writeValueAsString(new Resource(Arrays.asList(new Integer[150]),5,1));
        mockMvc.perform(
                post("/allocate/resources")
                        .contentType(contentType)
                        .content(content))
                .andExpect(status().isNotFound())
                .andExpect(jsonPath("$", notNullValue()));
    }


}
