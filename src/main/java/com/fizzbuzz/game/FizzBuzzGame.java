package com.fizzbuzz.game;

import com.fizzbuzz.exception.ValidatorException;
import com.fizzbuzz.writer.Writer;

public class FizzBuzzGame implements Game{

    private final Writer writer;
    private final int numberOne;
    private final int numberTwo;
    private final int meddig;

    private String[] gameSegedTomb;
    
    public FizzBuzzGame(Writer writer, int numberOne, int numberTwo, int meddig) {
        validateInput(numberOne, numberTwo, meddig);

        this.writer = writer;
        this.numberOne = numberOne;
        this.numberTwo = numberTwo;
        this.meddig = meddig;
    }

    @Override
    public void start() {
        gameLogika();
        gameOutput();
    }

    private void validateInput(int numberOne, int numberTwo, int meddig) {
        if(numberOne > meddig) {
            throw new ValidatorException("A FIZZ ertek nem lehet nagyobb, mint a meddig ertek");
        } else if(numberTwo > meddig) {
            throw new ValidatorException("A BUZZ ertek nem lehet nagyobb, mint a meddig ertek");
        }
    }

    private void gameLogika() {
        createGameSegedTomb();
        changeGameSegedTomb();
    }
    
    private void gameOutput() {
        writer.leir(createSzovegToOutput());
    }

    private void createGameSegedTomb() {
        gameSegedTomb = new String[meddig];
    }

    private void changeGameSegedTomb() {
        for (int i = 0; i < meddig; i++) {
            if(isFizzBuzzOszto(i+1)) {
                gameSegedTomb[i] = "FIZZBUZZ";
            } else if(isFizzOszto(i+1)) {
                gameSegedTomb[i] = "FIZZ";
            } else if(isBuzzOszto(i+1)) {
                gameSegedTomb[i] = "BUZZ";
            } else {
                gameSegedTomb[i] = String.valueOf(i + 1);
            }
        }
    }

    private boolean isFizzBuzzOszto(int osztando) {
        return isFizzOszto(osztando) && isBuzzOszto(osztando);
    }

    private boolean isFizzOszto(int osztando) {
        return numberOne != 0 && osztando % numberOne == 0;
    }

    private boolean isBuzzOszto(int osztando) {
        return numberTwo != 0 && osztando % numberTwo == 0;
    }

    private String createSzovegToOutput() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < meddig; i++) {
            stringBuilder.append(gameSegedTomb[i]);
        }
        return stringBuilder.toString();
    }
}
