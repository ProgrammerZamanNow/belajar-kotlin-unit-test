package belajar.kotlin.unit.test.repository

import belajar.kotlin.unit.test.model.Person

interface PersonRepository {

    fun selectById(id: String): Person?

    fun insert(person: Person)

}