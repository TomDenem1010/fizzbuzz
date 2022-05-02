package com.fizzbuzz.game.fizzBuzzGame;

import com.fizzbuzz.game.Game;
import com.fizzbuzz.writer.Writer;

public class FizzBuzzGame implements Game<FizzBuzzGameParam>{

    private final Writer writer;

    private String[] gameSegedTomb;
    
    public FizzBuzzGame(Writer writer) {
        this.writer = writer;
    }

    @Override
    public void play(FizzBuzzGameParam param) {
        gameLogika(param);
        gameOutput(param.getMeddig());
    }

    private void gameLogika(FizzBuzzGameParam param) {
        createGameSegedTomb(param.getMeddig());
        changeGameSegedTomb(param);
    }
    
    private void gameOutput(int meddig) {
        writer.leir(createSzovegToOutput(meddig));
    }

    private void createGameSegedTomb(int meddig) {
        gameSegedTomb = new String[meddig];
    }

    private void changeGameSegedTomb(FizzBuzzGameParam param) {
        for (int i = 0; i < param.getMeddig(); i++) {
            if(isFizzBuzzOszto(i+1, param.getNumberOne(), param.getNumberTwo())) {
                gameSegedTomb[i] = "FIZZBUZZ";
            } else if(isFizzOszto(i+1, param.getNumberOne())) {
                gameSegedTomb[i] = "FIZZ";
            } else if(isBuzzOszto(i+1, param.getNumberTwo())) {
                gameSegedTomb[i] = "BUZZ";
            } else {
                gameSegedTomb[i] = String.valueOf(i + 1);
            }
        }
    }

    private boolean isFizzBuzzOszto(int osztando, int numberOne, int numberTwo) {
        return isFizzOszto(osztando, numberOne) && isBuzzOszto(osztando, numberTwo);
    }

    private boolean isFizzOszto(int osztando, int numberOne) {
        return numberOne != 0 && osztando % numberOne == 0;
    }

    private boolean isBuzzOszto(int osztando, int numberTwo) {
        return numberTwo != 0 && osztando % numberTwo == 0;
    }

    private String createSzovegToOutput(int meddig) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < meddig; i++) {
            stringBuilder.append(gameSegedTomb[i]);
        }
        return stringBuilder.toString();
    }

}
