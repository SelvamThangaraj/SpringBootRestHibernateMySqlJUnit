package org.spring.web.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertNull;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.stream.StreamSupport;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.spring.web.Application;
import org.spring.web.model.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {Application.class})
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CrudUtilServiceTest {

	@Autowired
	CrudUtilService crudUtilService;
	
	@Test
	public void test1AddSubject() {
		Subject sub=getSampleSubject();
		
		long id=crudUtilService.addSubject(getSampleSubject());
		//Optional<Subject> sub=crudUtilService.getSubject(2);
		assertEquals(id,555);
	}

	private Subject getSampleSubject()  {
		//String jsonSubject=null;
		Subject sub=new Subject();
		sub.setSubjectId(555);
		sub.setSubtitle("Social Science");
		sub.setDurationInHours(5);
		sub.setReferences(345);
		
		/*ObjectMapper objectMapper=new ObjectMapper();
		try {
			jsonSubject= objectMapper.writeValueAsString(sub);
		} catch (JsonProcessingException e) {
			
			e.printStackTrace();
		}*/
		
		return sub;
	}

	@Test
	public void test2GetSubject() {
		Optional<Subject> sub=crudUtilService.getSubject(555);
		assertEquals("Social Science",sub.get().getSubtitle());
	}

	@Test
	public void test3GetAllSubjects() {
		Iterable<Subject> subjectIterable=crudUtilService.getAllSubjects();
		long subCount=StreamSupport.stream(subjectIterable.spliterator(),false).count();
		assertNotSame(0, subCount);
		
	}

	@Test
	public void test4UpdateSubject() {
		Subject inputSubject=getSampleSubject();
		inputSubject.setSubjectId(Long.valueOf(555));
		String title="Science"+LocalDateTime.now();
		inputSubject.setSubtitle(title);
		Subject sub=crudUtilService.updateSubject(inputSubject);
		assertEquals(sub.getSubtitle(),title);		
	}

	@Test
	public void test5DeleteSubject() {
		String deleteMsg=crudUtilService.deleteSubject(Long.valueOf(555));
		assertNotNull(deleteMsg);
	}

	/*@Test
	void testAddBook() {
		fail("Not yet implemented");
	}

	@Test
	void testGetBook() {
		fail("Not yet implemented");
	}

	@Test
	void testGetAllBooks() {
		fail("Not yet implemented");
	}

	@Test
	void testUpdateBook() {
		fail("Not yet implemented");
	}

	@Test
	void testDeleteBook() {
		fail("Not yet implemented");
	}
*/
}
