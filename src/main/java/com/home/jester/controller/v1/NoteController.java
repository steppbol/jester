package com.home.jester.controller.v1;

import com.home.jester.entity.Note;
import com.home.jester.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

import static com.home.jester.controller.ApiPath.API_PATH;
import static com.home.jester.controller.ApiPath.JESTER_PATH;
import static com.home.jester.controller.ApiPath.NOTES_PATH;
import static com.home.jester.controller.ApiPath.V1_PATH;

@RestController
@RequestMapping(API_PATH + V1_PATH + JESTER_PATH + NOTES_PATH)
public class NoteController {
    private final NoteService noteService;

    @Autowired
    public NoteController(NoteService noteService) {
        this.noteService = noteService;
    }

    @PostMapping
    public UUID create(@RequestBody Note note) {
        return noteService.create(note);
    }

    @PutMapping("{id}")
    public Note update(@PathVariable("id") UUID id, @RequestBody Note note) {
        return noteService.update(id, note);
    }

    @GetMapping("{id}")
    public Note get(@PathVariable("id") UUID id) {
        return noteService.get(id);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable("id") UUID id) {
        noteService.delete(id);
    }
}
