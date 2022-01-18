package com.harryseong.templatemicroservice.domain;

import com.harryseong.templatemicroservice.utils.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class StringCompressThread extends Thread {

    private static final Logger LOGGER = LoggerFactory.getLogger(StringCompressThread.class);

    private final String s;
    private final List<String> compressedStrings;

    public StringCompressThread(final String s, final List<String> compressedStrings) {
        this.s = s;
        this.compressedStrings = compressedStrings;
    }

    public void run() {
        String compressed = StringUtils.compressString(this.s);
        this.compressedStrings.add(compressed);
    }
}
