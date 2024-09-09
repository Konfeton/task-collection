package by.clevertec;

import by.clevertec.model.Animal;
import by.clevertec.model.Student;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class MyClassTask16Test {


    List<Student> students = List.of(
            new Student(1, "Adams", 17, "Physics", "P-1"),
            new Student(14, "Carter", 18, "Mathematics", "M-1"),
            new Student(11, "Jonson", 18, "Physics", "P-1"),
            new Student(2, "Carter", 19, "ComputerScience", "C-2"),
            new Student(3, "Jonson", 20, "Mathematics", "M-3"),
            new Student(4, "Smith", 21, "Chemistry", "C-4"),
            new Student(5, "Williams", 20, "Mathematics", "M-1"),
            new Student(6, "Adams", 19, "ComputerScience", "C-2"),
            new Student(7, "Smith", 20, "Chemistry", "C-3"),
            new Student(8, "Carter", 19, "Physics", "P-1"),
            new Student(9, "Adams", 19, "Mathematics", "M-2"),
            new Student(10, "Williams", 20, "ComputerScience", "C-3"),
            new Student(12, "Smith", 19, "Chemistry", "C-2"),
            new Student(13, "Adams", 20, "Physics", "P-3"),
            new Student(15, "Williams", 19, "ComputerScience", "C-2")
    );

    List<Student> allAbove18 = List.of(
            new Student(1, "Adams", 22, "Physics", "P-1"),
            new Student(14, "Carter", 23, "Mathematics", "M-1"),
            new Student(11, "Jonson", 24, "Physics", "P-1"),
            new Student(2, "Carter", 19, "ComputerScience", "C-2"),
            new Student(3, "Jonson", 20, "Mathematics", "M-3"),
            new Student(4, "Smith", 21, "Chemistry", "C-4"),
            new Student(5, "Williams", 20, "Mathematics", "M-1"),
            new Student(6, "Adams", 19, "ComputerScience", "C-2"),
            new Student(7, "Smith", 20, "Chemistry", "C-3"),
            new Student(8, "Carter", 19, "Physics", "P-1"),
            new Student(9, "Adams", 19, "Mathematics", "M-2"),
            new Student(10, "Williams", 20, "ComputerScience", "C-3"),
            new Student(12, "Smith", 19, "Chemistry", "C-2"),
            new Student(13, "Adams", 20, "Physics", "P-3"),
            new Student(15, "Williams", 19, "ComputerScience", "C-2")
    );

    @Test
    void givenStudents_whenTask16_thenReturnWithAgeLessOrEqualThan18Alphabeticly() {
        MyClass myClass = new MyClass();

        List<Student> result = myClass.task16(students);

        List<Student> expected = List.of(
                new Student(1, "Adams", 17, "Physics", "P-1"),
                new Student(14, "Carter", 18, "Mathematics", "M-1"),
                new Student(11, "Jonson", 18, "Physics", "P-1")
        );

        assertEquals(result, expected);
    }

    @Test
    void givenAllAbove18_whenTask16_thenReturnZero() {
        MyClass myClass = new MyClass();

        List<Student> result = myClass.task16(allAbove18);

        List<Student> expected = Collections.emptyList();

        assertEquals(result, expected);
    }


}