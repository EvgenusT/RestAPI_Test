package EvgenusT.Request_Response.controller;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

@RestController
@RequestMapping("request")

public class MessageController {
    private final static Logger logger = Logger.getLogger(EvgenusT.Request_Response.controller.MessageController.class);

    Map<String, String> user = new HashMap<>();

    @PostMapping("1")
    public Map<String, String> create(@RequestBody Map<String, Integer> mass) throws IOException {

        Properties props = new Properties();
        props.load(getClass().getResourceAsStream("/log4j.properties"));
        PropertyConfigurator.configure(props);
        logger.info("Запрос отправлен: " + mass);

        if (mass.containsKey("id") && mass.containsValue(1)) {
            user.put("fio", "Test Testov");

            logger.info("Ответ получен: " + user);
            return user;

        } else
            return null;
    }

}
