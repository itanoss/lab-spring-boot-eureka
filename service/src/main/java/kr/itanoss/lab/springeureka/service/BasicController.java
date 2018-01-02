package kr.itanoss.lab.springeureka.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@RestController
public class BasicController {

    private static final Logger LOG = LoggerFactory.getLogger(BasicController.class);
    private static final long DEFAULT_LIST_SIZE = 10;

    private final Random random = new Random(System.currentTimeMillis());

    @RequestMapping("/random-integers")
    public List<Integer> randomIntegers() {
        List<Integer> integers = random.ints(DEFAULT_LIST_SIZE)
                .boxed()
                .collect(Collectors.toList());
        LOG.debug("Random integers generated: " + integers);
        return integers;
    }
}
