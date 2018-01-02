package kr.itanoss.lab.springeureka.client;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class FrontendController {
    private static final Logger LOG = LoggerFactory.getLogger(FrontendController.class);

    @Autowired
    BasicClient basicClient;

    @RequestMapping("/")
    public Result sumWithRandomIntegers() {
        List<Integer> values = basicClient.randomIntegers();
        LOG.debug("From Basic Service: " + values);
        Result result = new Result(values);
        LOG.trace("Result: " + result);
        return result;
    }

    public static class Result {
        private final List<Integer> values;
        private final int sum;

        private Result(List<Integer> values) {
            this.values = values;
            this.sum = values.stream()
                    .reduce((a, b) -> a + b)
                    .get();
        }

        @Override
        public String toString() {
            return "Result{" +
                    "values=" + values +
                    ", sum=" + sum +
                    '}';
        }
    }
}
