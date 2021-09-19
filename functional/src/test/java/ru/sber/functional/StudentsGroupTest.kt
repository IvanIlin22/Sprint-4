package ru.sber.functional

import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class StudentsGroupTest {

    private val studentsGroup: StudentsGroup = StudentsGroup();

    private val student1: Student = Student("Ivan",
        "Ivanov",
        "Имя отсутствует",
        18,
        5.0,
        "Moscow",
        "Специализация отсутствует",
        "Образование отсутствует"
    )
    private val student2: Student = Student("Ivan",
        "Petrov",
        "Имя отсутствует",
        25,
        3.0,
        "Moscow",
        "Специализация отсутствует",
        "Образование отсутствует"
    )
    private val student3: Student = Student("Ivan",
        "Fedorov",
        "Имя отсутствует",
        17,
        4.25,
        "Saint Petersburg",
        "Специализация отсутствует",
        "Образование отсутствует"
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