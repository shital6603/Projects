package com.notesapp.NotesApplication.service;
import com.notesapp.NotesApplication.entity.Note;
import com.notesapp.NotesApplication.entity.User;
import com.notesapp.NotesApplication.repository.NoteRepository;
import com.notesapp.NotesApplication.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoteService {
    @Autowired private NoteRepository noteRepo;
    @Autowired private UserRepository userRepo;

    public List<Note> getUserNotes(String email) {
        User user = userRepo.findByEmail(email).orElseThrow();
        return noteRepo.findByUser(user);
    }

    public Note createNote(String email, Note note) {
        User user = userRepo.findByEmail(email).orElseThrow();
        note.setUser(user);
        return noteRepo.save(note);
    }
}
