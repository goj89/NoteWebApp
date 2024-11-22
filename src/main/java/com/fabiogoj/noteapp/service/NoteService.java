package com.fabiogoj.noteapp.service;

import com.fabiogoj.noteapp.model.Nota;
import com.fabiogoj.noteapp.repository.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NoteService  {

    private final NoteRepository noteRepository;

    @Autowired
    public NoteService(NoteRepository noteRepository) {
        this.noteRepository = noteRepository;
    }


    public List<Nota> getAllNotes(){
        return noteRepository.findAll();
    }

    public Optional<Nota> getNotaById(Long id) {
        return noteRepository.findById(id);
    }

    public Nota saveNote(Nota nota) {
        return noteRepository.save(nota);
    }

    public void deleteNote(Long id) {
        noteRepository.deleteById(id);
    }





}
