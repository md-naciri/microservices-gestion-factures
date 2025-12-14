package ma.enset.customerservice.controller;


import ma.enset.customerservice.dto.CustomerConfigParams;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
// Ce contrôleur sera réinstancié à chaque fois qu’une requête est envoyée vers /refresh.
@RefreshScope
public class ConfigTestController {

    @Value("${global.params.p1}")
    private String p1;
    @Value("${global.params.p2}")
    private String p2;

    @Autowired
    private CustomerConfigParams customerConfigParams;

    @GetMapping("/test-config1")
    public Map<String, String> config1() {
        return Map.of("p1", p1, "p2", p2);
    }


    @GetMapping("customer-config")
    public CustomerConfigParams getCustomerConfigParams() {
        return customerConfigParams;
    }
}
