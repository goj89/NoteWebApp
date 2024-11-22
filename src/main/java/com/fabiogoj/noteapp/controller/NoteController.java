package com.fabiogoj.noteapp.controller;

import com.fabiogoj.noteapp.model.Nota;
import com.fabiogoj.noteapp.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/note")
public class NoteController {

    private final NoteService noteService;

    @Autowired
    public NoteController(NoteService noteService) {
        this.noteService = noteService;
    }

    @GetMapping
    public List<Nota> getAllNotes() {
        return noteService.getAllNotes();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Nota> getNoteById(@PathVariable Long id) {
        Optional<Nota> note = noteService.getNotaById(id);
        return note.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Nota creaNota(@RequestBody Nota nota) {
        return noteService.saveNote(nota);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Nota> modificaNota(@PathVariable Long id, @RequestBody Nota nota) {
        Optional<Nota> notaVecchia = noteService.getNotaById(id);
        if (notaVecchia.isPresent()) {
            nota.setId(id);
            noteService.saveNote(nota);
            return ResponseEntity.ok(nota);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> cancellaNota(@PathVariable Long id){
        Optional<Nota> notaDaEliminare = noteService.getNotaById(id);
        if( notaDaEliminare.isPresent()){
            noteService.deleteNote(id);
            return ResponseEntity.noContent().build();
        }else{
            return ResponseEntity.notFound().build();
        }
    }




}
