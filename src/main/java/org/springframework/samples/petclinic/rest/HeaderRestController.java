package org.springframework.samples.petclinic.rest;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;


@RestController
@CrossOrigin(exposedHeaders = "*")
@RequestMapping("/header")
public class HeaderRestController {
    private static final Logger log = LoggerFactory.getLogger(ExceptionRestController.class);

    @RequestMapping(value = "", method = RequestMethod.GET, produces = "text/plain")
    @ResponseBody
    public String makeExceptionLog(@RequestBody String body, @RequestHeader Map<String, String> headers) {
        headers.forEach((key, value) -> {
            log.info(String.format("Header '%s' = %s", key, value));
        });

        return "check log";
    }

}
