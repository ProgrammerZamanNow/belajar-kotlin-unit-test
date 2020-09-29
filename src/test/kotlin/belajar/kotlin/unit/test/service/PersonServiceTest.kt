package belajar.kotlin.unit.test.service

import belajar.kotlin.unit.test.model.Person
import belajar.kotlin.unit.test.repository.PersonRepository
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.*
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.extension.ExtendWith
import org.junit.jupiter.api.extension.Extensions
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.jupiter.MockitoExtension

@Extensions(value = [
    ExtendWith(MockitoExtension::class)
])
class PersonServiceTest {

    @Mock
    lateinit var personRepository: PersonRepository

    lateinit var personService: PersonService

    @BeforeEach
    fun beforeEach(){
        personService = PersonService(personRepository)
    }

    @Test
    fun testPersonIdIsNotValid(){
        assertThrows<IllegalArgumentException> {
            personService.get("      ")
        }
    }

    @Test
    fun testPersonNotFound(){
        assertThrows<Exception> {
            personService.get("not found")
        }
    }

    @Test
    fun testGetPersonSuccess(){
        Mockito.`when`(personRepository.selectById("eko")).thenReturn(Person("eko", "Eko Kurniawan"))

        val person = personService.get("eko");
        assertEquals("eko", person.id)
        assertEquals("Eko Kurniawan", person.name)
    }

    @Test
    fun testRegisterPersonNameIsBlank(){
        assertThrows<IllegalArgumentException> {
            personService.register("    ")
        }
    }

    @Test
    fun testRegisterSuccess(){
        val person = personService.register("Eko")

        assertEquals("Eko", person.name)
        assertNotNull(person.id)

        Mockito.verify(personRepository, Mockito.times(1)).insert(Person(person.id, "Eko"))
    }

}