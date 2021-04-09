package org.springframework.samples.petclinic.rest;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@RestController
@CrossOrigin(exposedHeaders = "*")
@RequestMapping("/header")
public class HeaderRestController {
    private static final Logger log = LoggerFactory.getLogger(ExceptionRestController.class);

  

    @RequestMapping(value = "", method = RequestMethod.GET, produces = "text/plain")
    @ResponseBody
    public String makeExceptionLog(@RequestHeader Map<String, String> headers) {
        headers.forEach((key, value) -> {
            LOG.info(String.format("Header '%s' = %s", key, value));
        });

        return new ResponseEntity<String>(String.format("Listed %d headers", headers.size()), HttpStatus.OK);
    }

}
