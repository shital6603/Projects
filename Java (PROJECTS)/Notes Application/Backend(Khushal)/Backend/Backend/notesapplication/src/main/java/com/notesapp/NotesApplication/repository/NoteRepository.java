package com.notesapp.NotesApplication.repository;

import com.notesapp.NotesApplication.entity.Note;
import com.notesapp.NotesApplication.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NoteRepository extends JpaRepository<Note, Long> {
    List<Note> findByUser(User user);
    List<Note> findByUserAndTagsContainingIgnoreCase(User user, String tag);
    List<Note> findByUserAndContentContainingIgnoreCase(User user, String keyword);
}
