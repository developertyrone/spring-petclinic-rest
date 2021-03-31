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
@CrossOrigin(exposedHeaders = "errors, content-type")
@RequestMapping("/exception")
public class ExceptionRestController {
    private static final Logger log = LoggerFactory.getLogger(ExceptionRestController.class);

    @Value("${greeting.message:}")
    private String greeting;
    @Value("${logging.pattern.console:}")
    private String pattern;

    @RequestMapping(value = "", method = RequestMethod.GET, produces = "text/plain")
    @ResponseBody
    public String makeExceptionLog() throws IOException {
        //response.sendRedirect(this.servletContextPath + "/swagger-ui.html");
        String message = String.format(greeting);
        log.info("Request: {}\nResponse: {}",message);
        log.info("Log pattern: {};", new ObjectMapper().writeValueAsString(pattern));
        log.info("Init ExceptionRestController with message:\n{}",greeting);
        log.error("Log exception",new Exception("test"));
        return message;
    }

}
