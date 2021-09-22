package ru.sber.functional

import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class StudentsGroupTest {

    private val studentsGroup: StudentsGroup = StudentsGroup();

    private val student1: Student = Student(firstName ="Ivan",
        lastName = "Ivanov",
        age = 18,
        averageRate = 5.0,
        city = "Moscow"
    )
    private val student2: Student = Student(firstName = "Ivan",
        lastName = "Petrov",
        age = 25,
        averageRate = 3.0,
        city = "Moscow"
    )
    private val student3: Student = Student(firstName = "Ivan",
        lastName = "Fedorov",
        age = 17,
        averageRate = 4.25,
        city = "Saint Petersburg"
    )

    @BeforeEach
    fun init() {
        studentsGroup.students = listOf(student1, student2, student3)
    }

    @Test
    fun `studentsGroupTest filter by age test`() {
        studentsGroup.filterByPredicate { it.age >= 18 }
        assertEquals(2, studentsGroup.students.size)
    }

    @Test
    fun `studentsGroupTest filter by rate test`() {
        studentsGroup.filterByPredicate { it.averageRate == 4.25 }
        assertEquals(1, studentsGroup.students.size)
    }

    @Test
    fun `studentsGroupTest filter by rate city`() {
        studentsGroup.filterByPredicate { it.city == "Moscow" }
        assertEquals(2, studentsGroup.students.size)
    }
}