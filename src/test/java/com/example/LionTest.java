package com.example;

import static org.assertj.core.api.Assertions.*;
import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;


@RunWith(MockitoJUnitRunner.class)
public class LionTest {

    @Mock
    private Feline feline;

    @Test
    public void LionConstructorWithWrongArgumentThrowsAnException() {
        assertThatThrownBy(() -> {
            new Lion("abracadabra", new Feline());
        }).isInstanceOf(Exception.class)
                .hasMessage("Используйте допустимые значения пола животного - самец или самка");
    }

    @Test
    public void getKittensReturnsOne() throws Exception {
        Lion lionSpy = Mockito.spy(new Lion("Самец", feline));
        lionSpy.getKittens();
        Mockito.verify(feline, Mockito.times(1)).getKittens();
    }

    @Test
    public void getFood() throws Exception {
        Feline feline = new Feline();
        Lion lionSpy = Mockito.spy(new Lion("Самец", feline));
        assertEquals(feline.getFood("Хищник"), lionSpy.getFood());
    }
}