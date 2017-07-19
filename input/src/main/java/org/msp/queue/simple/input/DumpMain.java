package org.msp.queue.simple.input;

import net.openhft.chronicle.queue.ExcerptAppender;
import net.openhft.chronicle.queue.impl.single.SingleChronicleQueue;
import net.openhft.chronicle.queue.impl.single.SingleChronicleQueueBuilder;

import java.io.FileNotFoundException;
import java.util.Scanner;
import net.openhft.chronicle.queue.DumpQueueMain;

public class DumpMain {
    public static void main(String[] args) throws FileNotFoundException {
        DumpQueueMain.dump(args[0]);
    }
}