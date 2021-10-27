package com.home.jester.controller.v1;

import com.home.jester.dto.NoteDto;
import com.home.jester.service.NoteService;
import com.home.jester.util.NoteMapper;
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
    private final NoteMapper noteMapper;
    private final NoteService noteService;

    @Autowired
    public NoteController(NoteMapper noteMapper, NoteService noteService) {
        this.noteMapper = noteMapper;
        this.noteService = noteService;
    }

    @PostMapping
    public UUID create(@RequestBody NoteDto noteDto) {
        return noteService.create(noteMapper.fromDto(noteDto));
    }

    @PutMapping("{id}")
    public NoteDto update(@PathVariable("id") UUID id, @RequestBody NoteDto noteDto) {
        return noteMapper.toDto(noteService.update(id, noteMapper.fromDto(noteDto)));
    }

    @GetMapping("{id}")
    public NoteDto get(@PathVariable("id") UUID id) {
        return noteMapper.toDto(noteService.get(id));
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable("id") UUID id) {
        noteService.delete(id);
    }
}
