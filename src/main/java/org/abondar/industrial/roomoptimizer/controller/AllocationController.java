package org.abondar.industrial.roomoptimizer.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.abondar.industrial.roomoptimizer.model.Allocation;
import org.abondar.industrial.roomoptimizer.model.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/allocate")
public class AllocationController {

    private static Logger logger = LoggerFactory.getLogger(AllocationController.class);

    private ObjectMapper mapper = new ObjectMapper();

    public AllocationController(){
        logger.info("Service is up and running");
    }

    @RequestMapping(value = "/resources",method = RequestMethod.POST,consumes = "application/json")
    @ResponseBody
    private String allocateResources(@RequestBody Resource resource)throws Exception{

        return mapper.writeValueAsString(new Allocation());
    }

}
