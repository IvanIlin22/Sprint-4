package ru.sber.functional

data class Student(
    val firstName: String,
    val lastName: String,
    val middleName: String = "Имя отсутствует",
    val age: Int,
    val averageRate: Double,
    val city: String,
    val specialization: String = "Специализация отсутствует",
    val prevEducation: String? = "Образование отсутствует",
)
