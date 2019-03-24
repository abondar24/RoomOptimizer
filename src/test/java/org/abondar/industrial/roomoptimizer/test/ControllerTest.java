package org.abondar.industrial.roomoptimizer.test;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.abondar.industrial.roomoptimizer.controller.AllocationController;
import org.abondar.industrial.roomoptimizer.model.Resource;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.nio.charset.Charset;

import static org.hamcrest.core.IsNull.notNullValue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@ExtendWith(SpringExtension.class)
@WebMvcTest(AllocationController.class)
public class ControllerTest {
    private static Logger logger = LoggerFactory.getLogger(ControllerTest.class);

    @Autowired
    private ObjectMapper om;

    @Autowired
    private MockMvc mockMvc;

    private MediaType contentType = new MediaType(MediaType.APPLICATION_JSON.getType(),
            MediaType.APPLICATION_JSON.getSubtype(), Charset.forName("utf8"));


    @Test
    public void testAllocation() throws Exception {
        logger.info("Allocation api test");


        String content = om.writeValueAsString(new Resource());
        mockMvc.perform(
                post("/allocate/resources")
                .contentType(contentType)
                .content(content))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", notNullValue()));
    }



}
