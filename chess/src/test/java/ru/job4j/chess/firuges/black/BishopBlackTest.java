package ru.job4j.chess.firuges.black;

import org.junit.jupiter.api.Test;
import ru.job4j.chess.ImpossibleMoveException;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class BishopBlackTest {

    @Test
    void whenPosition() {
        Figure bishopBlack = new BishopBlack(Cell.C8);
        assertThat(bishopBlack.position()).isEqualTo(Cell.C8);
    }

    @Test
    void whenCopy() {
        Figure bishopBlack = new BishopBlack(Cell.C8);
        bishopBlack = bishopBlack.copy(Cell.A6);
        assertThat(bishopBlack.position()).isEqualTo(Cell.A6);
    }

    @Test
    void whenWay() {
        Figure bishopBlack = new BishopBlack(Cell.C1);
        Cell[] cells = bishopBlack.way(Cell.G5);
        Cell[] expected = {Cell.D2, Cell.E3, Cell.F4, Cell.G5};
        assertThat(cells).isEqualTo(expected);
    }

    @Test
    public void whenWayThenException() {
        ImpossibleMoveException exception = assertThrows(
                ImpossibleMoveException.class,
                () -> {
                    Figure bishopBlack = new BishopBlack(Cell.C1);
                    bishopBlack.way(Cell.G6);
                });
        assertThat(exception.getMessage()).isEqualTo("Could not move by diagonal from C1 to G6");
    }
}