package com.sulake.test;

import org.springframework.jmx.export.annotation.ManagedAttribute;
import org.springframework.jmx.export.annotation.ManagedResource;
import org.springframework.stereotype.Component;

import java.util.concurrent.atomic.LongAdder;

/**
 * @author Johno Crawford (johno@sulake.com)
 */
@Component
@ManagedResource("com.sulake:type=TestStatistics")
public class TestStatisticsService {

    private LongAdder testCount = new LongAdder();

    public void incrementTestCount() {
        testCount.increment();
    }

    @ManagedAttribute
    public long getTestCount() {
        return testCount.longValue();
    }
}
