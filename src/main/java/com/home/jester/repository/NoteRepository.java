package com.home.jester.repository;

import com.home.jester.entity.Note;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface NoteRepository extends ReactiveCrudRepository<Note, UUID> {
}
