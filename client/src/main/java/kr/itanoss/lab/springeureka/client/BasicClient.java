package kr.itanoss.lab.springeureka.client;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient("BasicService")
public interface BasicClient {
    @RequestMapping(value = "/random-integers", method = RequestMethod.GET)
    List<Integer> randomIntegers();
}
