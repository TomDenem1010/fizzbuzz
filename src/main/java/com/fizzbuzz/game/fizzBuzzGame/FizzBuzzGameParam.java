package com.fizzbuzz.game.fizzBuzzGame;

import com.fizzbuzz.exception.ValidatorException;
import com.fizzbuzz.game.Param;

public class FizzBuzzGameParam implements Param {

    private final int numberOne;
    private final int numberTwo;
    private final int meddig;

    private FizzBuzzGameParam(int numberOne, int numberTwo, int meddig) {
        this.numberOne = numberOne;
        this.numberTwo = numberTwo;
        this.meddig = meddig;

        validateInput();
    }

    @Override
    public void validateInput() {
        if(numberOne > meddig) {
            throw new ValidatorException("A FIZZ ertek nem lehet nagyobb, mint a meddig ertek");
        } else if(numberTwo > meddig) {
            throw new ValidatorException("A BUZZ ertek nem lehet nagyobb, mint a meddig ertek");
        }
    }

    public int getNumberOne() {
        return numberOne;
    }

    public int getNumberTwo() {
        return numberTwo;
    }

    public int getMeddig() {
        return meddig;
    }

    public static class Builder {

        private int numberOne;
        private int numberTwo;
        private int meddig;

        public static FizzBuzzGameParam.Builder newBuilder() {
            return new FizzBuzzGameParam.Builder();
        }

        public FizzBuzzGameParam.Builder withNumberOne(int numberOne) {
            this.numberOne = numberOne;
            return this;
        }

        public FizzBuzzGameParam.Builder withNumberTwo(int numberTwo) {
            this.numberTwo = numberTwo;
            return this;
        }

        public FizzBuzzGameParam.Builder withMeddig(int meddig) {
            this.meddig = meddig;
            return this;
        }

        public FizzBuzzGameParam build() {
            return new FizzBuzzGameParam(
                    numberOne,
                    numberTwo,
                    meddig);
        }
    }
}
