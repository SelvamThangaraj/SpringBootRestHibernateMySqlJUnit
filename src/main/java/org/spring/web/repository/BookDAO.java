package org.spring.web.repository;

import org.spring.web.model.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookDAO extends CrudRepository<Book,Long>{


}
