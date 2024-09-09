package by.clevertec;

import by.clevertec.model.Animal;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class MyClassTask9Test {

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
    void givenNormalAnimals_whenTask9_thenReturnBreedLength() {
        MyClass myClass = new MyClass();

        Integer resultLength = myClass.task9(normalAnimals);

        assertEquals(3, resultLength);
    }

    @Test
    void givenEmptyList_whenTask9_thenThrowNoSuchElementException() {
        MyClass myClass = new MyClass();


        assertThrows(NoSuchElementException.class, () -> myClass.task9(Collections.emptyList()));
    }






}