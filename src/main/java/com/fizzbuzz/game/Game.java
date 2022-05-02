package com.fizzbuzz.game;

public interface Game<T extends Param> {
    public void play(T param);
}
