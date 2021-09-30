package com.home.jester.service.impl;

import com.home.jester.entity.Note;
import com.home.jester.repository.NoteRepository;
import com.home.jester.service.NoteService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.UUID;

@Log4j2
@Service
public class DefaultNoteService implements NoteService {
    private final NoteRepository noteRepository;

    @Autowired
    public DefaultNoteService(NoteRepository noteRepository) {
        this.noteRepository = noteRepository;
    }

    @Override
    public UUID create(Note note) {
        return noteRepository.save(note).getId();
    }

    @Override
    public Note update(UUID id, Note note) {
        note.setId(id);
        return noteRepository.save(note);
    }

    @Override
    public Note get(UUID id) {
        return noteRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public void delete(UUID id) {
        noteRepository.deleteById(id);
    }
}
