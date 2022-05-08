package com.fizzbuzz.writer;

import static org.assertj.core.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class StreamWriterTest {
    
    private static final String TEST_SZOVEG = "TESZT SZOVEG";

    private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    private StreamWriter streamWriter;

    @BeforeEach
    void setUp() {
        setUpStreamWriter();
        setUpStream();
    }

    @AfterEach
    void setDown() {
        setDownStream();
    }

    @Test
    void testLeir_UresString_Ok() {
        streamWriter.leir("");
        assertThat(outputStream.toString().trim()).isEqualTo("");
    }

    @Test
    void testLeir_NemUresString_Ok() {
        streamWriter.leir(TEST_SZOVEG);
        assertThat(outputStream.toString().trim()).isEqualTo(TEST_SZOVEG);
    }

    private void setUpStreamWriter() {
        streamWriter = new StreamWriter();
    }

    private void setUpStream() {
        System.setOut(new PrintStream(outputStream));
    }

    private void setDownStream() {
        System.setOut(originalOut);
    }
}