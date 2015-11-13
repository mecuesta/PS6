package base;

import static org.junit.Assert.*;

import java.time.LocalDate;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import domain.PersonDomainModel;
public class Person_Test {
	
	private static PersonDomainModel person1;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
		LocalDate Date1 = LocalDate.of(1972, 7, 31);
		person1 = new PersonDomainModel();
		person1.setFirstName("Manuel");
		person1.setLastName("Cuesta");
		person1.setStreet("162 David Hollowell Drive");
		person1.setCity("Newark");
		person1.setPostalCode(19717);
		person1.setBirthday(Date1);
	}	
	
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
		PersonDomainModel per;
		PersonDAL.deletePerson(person1.getPersonID());
		per = PersonDAL.getPerson(person1.getPersonID());
		assertNull("The PersonDomainModel per instance should not have a personID",per);
	}

	@Test
	public void AddPersonTest() {
		PersonDomainModel per;
		per = PersonDAL.getPerson(person1.getPersonID());
		assertNull("The PersonDomainModel per instance should not have a personID",per);
		PersonDAL.addPerson(person1);
		
		per = PersonDAL.getPerson(person1.getPersonID());
		System.out.println(person1.getPersonID() + " found");
		assertNotNull("The PersonDomainModel per instance should have a personID",per);
	}
	
	@Test
	public void UpdatePersonTest() {
		PersonDomainModel per;
		per = PersonDAL.getPerson(person1.getPersonID());
		assertNull("The PersonDomainModel per instance should not have a personID",per);
		PersonDAL.addPerson(person1);
		
		per = PersonDAL.getPerson(person1.getPersonID());
		System.out.println(person1.getPersonID() + " found");
		assertNotNull("The PersonDomainModel per instance should have a personID",per);
		
		person1.setFirstName("Tacos");
		PersonDAL.updatePerson(person1);
		
		per = PersonDAL.getPerson(person1.getPersonID());
		assertTrue(person1.getLastName() == "Tacos");
	}
	
	@Test
	public void DeletePersonTest() {
		PersonDomainModel per;
		PersonDAL.addPerson(person1);
		per = PersonDAL.getPerson(person1.getPersonID());
		assertNotNull("The PersonDomainModel per instance should have a personID",per);
		
		PersonDAL.deletePerson(person1.getPersonID());
		per = PersonDAL.getPerson(person1.getPersonID());
		assertNull("The PersonDomainModel per instance should not have a personID",per);

	}

}
