package ru.job4j.chess;

public class OccupiedCellException extends Exception {
    OccupiedCellException(String message) {
        super(message);
    }
}
