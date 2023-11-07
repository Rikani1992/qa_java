package com.example;

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
    public void LionConstructorWithWrongArgument() {
        try {
            new Lion("abracadabra", new Feline());
            fail();
        } catch (Exception e) {
            assertEquals("Используйте допустимые значения пола животного - самей или самка",
                    e.getMessage());
        }
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