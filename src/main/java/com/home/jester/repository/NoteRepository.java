package com.home.jester.repository;

import com.home.jester.entity.Note;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface NoteRepository extends JpaRepository<Note, UUID> {
    @Override
    @NonNull
    @EntityGraph(value = "note.attributes")
    Optional<Note> findById(@NonNull UUID id);
}
