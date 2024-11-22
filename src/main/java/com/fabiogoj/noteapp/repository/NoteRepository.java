package com.fabiogoj.noteapp.repository;

import com.fabiogoj.noteapp.model.Nota;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NoteRepository extends JpaRepository<Nota, Long> {
}
