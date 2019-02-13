package com.example.hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.logging.Logger;

/**
 * @author haojingyu
 * @version $Id: HelloController.java, v 0.1 2019-02-13 9:56 jyhao Exp $$
 */
@RestController
public class HelloController {
    private final Logger logger = Logger.getLogger(HelloController.class.getName());
    @Autowired
    private DiscoveryClient client;

    @RequestMapping(value="/hello",method = RequestMethod.GET)
    public String index(){
         List<ServiceInstance> instanceInfoList  = client.getInstances("hello-service");
         ServiceInstance serviceInstance = instanceInfoList.get(0);
        logger.info("hello,Host:"+serviceInstance.getHost()+",ServiceId:"+serviceInstance.getServiceId());
        return "Hello World";
    }

}
