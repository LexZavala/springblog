package com.codeup.springblog.models;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface AdRepository extends JpaRepository<Ad, Long> {
    Ad findAdById(long id);

    @Query("from Ad a WHERE a.title LIKE %:term%")
    Ad findFirstByTitle(String term);
}
