package by.clevertec;

import by.clevertec.model.Animal;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class MyClassTask10Test {

    List<Animal> normalAnimals = List.of(
            new Animal(1, "Dog", 20, "Hungarian", "Female"),
            new Animal(2, "Cat", 35, "Argentina", "Male"),
            new Animal(3, "Bird", 25, "Brazil", "Female"),
            new Animal(4, "Dog", 45, "Argentina", "Female"),
            new Animal(5, "Horse", 32, "Albania", "Male"),
            new Animal(6, "Cow", 15, "Australia", "Male"),
            new Animal(7, "Sheep", 27, "Canada", "Female")
    );
    
    @Test
    void givenNormalAnimals_whenTask10_thenReturnTotalAge() {
        MyClass myClass = new MyClass();

        Integer resultTotalAge = myClass.task10(normalAnimals);

        assertEquals(199, resultTotalAge);
    }

    @Test
    void givenEmptyList_whenTask10_thenReturnZero() {
        MyClass myClass = new MyClass();

        Integer resultTotalAge = myClass.task10(Collections.emptyList());

        assertEquals(0, resultTotalAge);
    }






}