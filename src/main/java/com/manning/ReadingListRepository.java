package com.manning;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by juho0 on 2017-07-16.
 */
public interface ReadingListRepository extends JpaRepository<Book, Long> {
    List<Book> findByReader(String reader);
}
