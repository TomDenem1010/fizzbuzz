package com.fizzbuzz.game;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import com.fizzbuzz.exception.ValidatorException;
import com.fizzbuzz.writer.StreamWriter;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class FizzBuzzGameTest {

    private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    private StreamWriter streamWriter;
    private FizzBuzzGame fizzBuzzGame;

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
    void testStart_CsakFizz_Ok() {
        setUpFizzBuzzGameWithStreamWriter(3,0,100);
        assertThat(outputStream.toString().trim())
            .doesNotContain("BUZZ")
            .isEqualTo(
                "12FIZZ45FIZZ78FIZZ1011FIZZ1314FIZZ1617FI" +
                "ZZ1920FIZZ2223FIZZ2526FIZZ2829FIZZ3132FIZ" + 
                "Z3435FIZZ3738FIZZ4041FIZZ4344FIZZ4647FIZZ" +
                "4950FIZZ5253FIZZ5556FIZZ5859FIZZ6162FIZZ6" +
                "465FIZZ6768FIZZ7071FIZZ7374FIZZ7677FIZZ79" +
                "80FIZZ8283FIZZ8586FIZZ8889FIZZ9192FIZZ949" +
                "5FIZZ9798FIZZ100");
    }

    @Test
    void testStart_CsakBuzz_Ok() {
        setUpFizzBuzzGameWithStreamWriter(0,5,100);
        assertThat(outputStream.toString().trim())
        .doesNotContain("FIZZ")
        .isEqualTo(
            "1234BUZZ6789BUZZ11121314BUZZ16171819BUZZ" +
            "21222324BUZZ26272829BUZZ31323334BUZZ36373" + 
            "839BUZZ41424344BUZZ46474849BUZZ51525354BU" +
            "ZZ56575859BUZZ61626364BUZZ66676869BUZZ717" +
            "27374BUZZ76777879BUZZ81828384BUZZ86878889" +
            "BUZZ91929394BUZZ96979899BUZZ");
    }

    @Test
    void testStart_FizzBuzz_Ok() {
        setUpFizzBuzzGameWithStreamWriter(3,5,100);
        assertThat(outputStream.toString().trim())
            .isEqualTo(
                "12FIZZ4BUZZFIZZ78FIZZBUZZ11FIZZ1314FIZZB" +
                "UZZ1617FIZZ19BUZZFIZZ2223FIZZBUZZ26FIZZ28" + 
                "29FIZZBUZZ3132FIZZ34BUZZFIZZ3738FIZZBUZZ4" +
                "1FIZZ4344FIZZBUZZ4647FIZZ49BUZZFIZZ5253FI" +
                "ZZBUZZ56FIZZ5859FIZZBUZZ6162FIZZ64BUZZFIZ" +
                "Z6768FIZZBUZZ71FIZZ7374FIZZBUZZ7677FIZZ79" +
                "BUZZFIZZ8283FIZZBUZZ86FIZZ8889FIZZBUZZ919" +
                "2FIZZ94BUZZFIZZ9798FIZZBUZZ");
    }

    @Test
    void testStart_NagyobbMintMeddigFizz_Error() {
        ValidatorException error = assertThrows(
            ValidatorException.class,
            () ->  setUpFizzBuzzGameWithStreamWriter(101,0,100));
        assertThat(error.getMessage()).contains("FIZZ");
    }

    @Test
    void testStart_NagyobbMintMeddigBuzz_Error() {
        ValidatorException error = assertThrows(
            ValidatorException.class,
            () ->  setUpFizzBuzzGameWithStreamWriter(0,101,100));
        assertThat(error.getMessage()).contains("BUZZ");
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

    private void setUpFizzBuzzGameWithStreamWriter(int numberOne, int numberTwo, int meddig) {
        fizzBuzzGame = new FizzBuzzGame(streamWriter, numberOne, numberTwo, meddig);
        fizzBuzzGame.start();
    }
}
