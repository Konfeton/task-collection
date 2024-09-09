package by.clevertec;

import by.clevertec.model.Animal;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class MyClassTask11Test {

    List<Animal> normalAnimals = List.of(
            new Animal(1, "Dog", 20, "Indonesian", "Female"),
            new Animal(2, "Cat", 35, "Argentina", "Male"),
            new Animal(3, "Bird", 25, "Brazil", "Female"),
            new Animal(4, "Dog", 45, "Indonesian", "Female"),
            new Animal(5, "Horse", 32, "Albania", "Male"),
            new Animal(6, "Cow", 15, "Australia", "Male"),
            new Animal(7, "Sheep", 27, "Indonesian", "Female")
    );

    List<Animal> noneFromIndonesia = List.of(
            new Animal(1, "Dog", 20, "Argentina", "Female"),
            new Animal(2, "Cat", 35, "Argentina", "Male"),
            new Animal(3, "Bird", 25, "Brazil", "Female"),
            new Animal(4, "Dog", 45, "Albania", "Female"),
            new Animal(5, "Horse", 32, "Albania", "Male"),
            new Animal(6, "Cow", 15, "Australia", "Male"),
            new Animal(7, "Sheep", 27, "Australia", "Female")
    );

    @Test
    void givenNormalAnimals_whenTask11thenReturnAverageAge() {
        MyClass myClass = new MyClass();

        Double averageAgeFromIndonesia = myClass.task11(normalAnimals);

        double floor = Math.floor(averageAgeFromIndonesia);

        assertEquals(30, floor);
    }

    @Test
    void givenNoneFromIndonesia_whenTask11_thenThrowNoSuchElementException() {
        MyClass myClass = new MyClass();

        assertThrows(NoSuchElementException.class, () ->  myClass.task11(Collections.emptyList()));
    }






}