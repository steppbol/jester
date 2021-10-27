package com.home.jester.service.impl;

import com.home.jester.entity.Note;
import com.home.jester.repository.NoteRepository;
import com.home.jester.service.NoteService;
import com.home.jester.util.NoteMapper;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.UUID;

@Log4j2
@Service
public class DefaultNoteService implements NoteService {
    private final NoteMapper noteMapper;
    private final NoteRepository noteRepository;

    @Autowired
    public DefaultNoteService(NoteMapper noteMapper, NoteRepository noteRepository) {
        this.noteMapper = noteMapper;
        this.noteRepository = noteRepository;
    }

    @Override
    public UUID create(Note note) {
        log.info("Creating note");
        return noteRepository.save(note).getId();
    }

    @Override
    @Transactional
    public Note update(UUID id, Note note) {
        log.info("Updating note. ID: {}", id);
        var foundNote = noteRepository.findById(id);

        Note updatedNote;
        if (foundNote.isPresent()) {
            updatedNote = foundNote.get();
            noteMapper.updatePatchEntity(note, updatedNote);
        } else {
            throw new EntityNotFoundException();
        }

        return noteRepository.save(updatedNote);
    }

    @Override
    public Note get(UUID id) {
        log.info("Getting note. ID: {}", id);
        return noteRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public void delete(UUID id) {
        log.info("Deleting note. ID: {}", id);
        noteRepository.deleteById(id);
    }
}
