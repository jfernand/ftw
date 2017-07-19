package org.msp.queue.simple.input;

import net.openhft.chronicle.queue.ExcerptAppender;
import net.openhft.chronicle.queue.impl.single.SingleChronicleQueue;
import net.openhft.chronicle.queue.impl.single.SingleChronicleQueueBuilder;

import java.time.Instant;

public class InputMain {
    public static void main(String[] args) {
        String path = "queue";
        SingleChronicleQueue queue = SingleChronicleQueueBuilder.binary(path).build();
        ExcerptAppender appender = queue.acquireAppender();
        int i = 100*1024*1024;
        Instant start = Instant.now();
        while (i-- > 0) {
            appender.writeText(Integer.toHexString(i));
            if (i % 1_000_000 == 0) {
                System.out.print(".");
            }
            if (i % 100_000_000 == 0) {
                System.out.println("");
            }
        }
        long end = Instant.now().toEpochMilli() - start.toEpochMilli();
        System.out.println(Long.toString(end));
    }
} 