package org.spring.web.service;

import java.util.Optional;

import org.spring.web.model.Book;
import org.spring.web.model.Subject;
import org.spring.web.repository.BookDAO;
import org.spring.web.repository.SubjectDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CrudUtilService {

	@Autowired
	private SubjectDAO subjectDAOImpl;

	@Autowired
	private BookDAO bookDao;

	public long addSubject(Subject subject) {
		Subject sub=subjectDAOImpl.save(subject);
		return sub.getSubjectId();
	}

	public Optional<Subject> getSubject(long subjectId) {
		return subjectDAOImpl.findById(subjectId);
	}

	public Iterable<Subject> getAllSubjects() {
		return subjectDAOImpl.findAll();
	}

	public Subject updateSubject(Subject subject) {
		return subjectDAOImpl.save(subject);
	}

	public String deleteSubject(long subjectId) {
		subjectDAOImpl.deleteById(subjectId);
		return "The subject has been deleted";
	}

	// Book
	public void addBook(Book book) {
		bookDao.save(book);
	}

	public Optional<Book> getBook(long bookId) {
		return bookDao.findById(bookId);
	}

	public Iterable<Book> getAllBooks() {
		return bookDao.findAll();
	}

	public void updateBook(Book book) {
		bookDao.save(book);
	}

	public String deleteBook(Long bookId) {
		bookDao.deleteById(bookId);
		return "The subject has been deleted";
	}

}
