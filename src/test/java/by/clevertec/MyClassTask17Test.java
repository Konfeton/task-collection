package by.clevertec;

import by.clevertec.model.Student;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MyClassTask17Test {


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


    @Test
    void givenStudents_whenTask17_thenReturnGroupListWithoutRepetitions() {
        MyClass myClass = new MyClass();

        List<String> result = myClass.task17(students);

        List<String > expected = List.of(
                "P-1",
                "M-1",
                "C-2",
                "M-3",
                "C-4",
                "C-3",
                "M-2",
                "P-3"
        );

        assertEquals(result, expected);
    }

}