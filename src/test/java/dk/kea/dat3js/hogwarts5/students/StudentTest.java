package dk.kea.dat3js.hogwarts5.students;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StudentTest {

    @Test
    void getFullNameWithMiddleName() {
        //arrange
        Student student = new Student("Harry", "James", "Potter", null, 5);


        //act
        var fullName = student.getFullName();


        //assert
        assertEquals("Harry James Potter", fullName);
    }

    @Test
    void getFullNameWithoutMiddleName() {
        //arrange
        Student student = new Student("Cho", "Chang", null, 5);

        //act
        var fullName = student.getFullName();

        //assert
        assertEquals("Cho Chang", fullName);
    }
    @Test
    void setFullNameWIthMiddleName() {
        //arrange
        Student student = new Student("first", "middle", "last", null, 5);

        //act
        student.setFullName("Hermione Jean Granger");

        //assert
        assertEquals("Hermione", student.getFirstName());
        assertEquals("Jean", student.getMiddleName());
        assertEquals("Granger", student.getLastName());
    }

    @Test
    void setFullNameWithoutLastName(){
        //arrange
        Student student = new Student("first", "middle", "last", null, 5);

        //act
        student.setFullName("Ronald Bilius");

        //assert
        assertEquals("Ronald", student.getFirstName());
        assertEquals("Bilius", student.getMiddleName());
        assertEquals("last", student.getLastName());
    }

    @Test
    void setFullNameWithMultipleMiddleNames(){
        //arrange
        Student student = new Student("first", "middle", "last", null, 5);

        //act
        student.setFullName("Albus Percival Wulfric Brian Dumbledore");

        //assert
        assertEquals("Albus", student.getFirstName());
        assertEquals("Percival Wulfric Brian", student.getMiddleName());
        assertEquals("Dumbledore", student.getLastName());
    }

    @Test
    void setFullNameWithEmptyString(){
        //arrange
        Student student = new Student("first", "middle", "last", null, 5);

        //act
        student.setFullName("");

        //assert
        assertEquals("", student.getFirstName());
        assertEquals("", student.getMiddleName());
        assertEquals("", student.getLastName());
    }

    @Test
    void setFullNameWithNull(){
        //arrange
        Student student = new Student("first", "middle", "last", null, 5);

        //act
        student.setFullName(null);

        //assert
        assertEquals("first", student.getFirstName());
        assertEquals("middle", student.getMiddleName());
        assertEquals("last", student.getLastName());
    }

    @Test
    void capitalizeIndividualNames(){
        //arrange
        Student student = new Student("first", "middle", "last", null, 5);

        //act
        student.setFullName("ronald bilius weasley");

        //assert
        assertEquals("Ronald", student.getFirstName());
        assertEquals("Bilius", student.getMiddleName());
        assertEquals("Weasley", student.getLastName());
    }

    @Test
    void capitalizeIndividualNamesWithCrazyCapitalization(){
        //arrange
        Student student = new Student("first", "middle", "last", null, 5);

        //act
        student.setFullName("RoNaLd BiLiUs WeAsLeY");

        //assert
        assertEquals("Ronald", student.getFirstName());
        assertEquals("Bilius", student.getMiddleName());
        assertEquals("Weasley", student.getLastName());
    }
}