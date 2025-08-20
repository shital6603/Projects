import React, { useEffect, useState } from 'react';
import axios from '../services/axiosConfig';
import '../styles/Dashboard.css';

const Dashboard = () => {
  const [notes, setNotes] = useState([]);

  const fetchNotes = async () => {
    try {
      const res = await axios.get('/notes');
      setNotes(res.data);
    } catch (err) {
      console.error("Failed to fetch notes", err);
    }
  };

  useEffect(() => {
    fetchNotes();
  }, []);

  return (
    <div className="dashboard-container">
      <h1>📝 My Notes</h1>
      <div className="notes-grid">
        {notes.map(note => (
          <div className="note-card" key={note.id}>
            <h3>{note.title}</h3>
            <p>{note.content}</p>
            <div className="tags">{note.tags?.map(tag => <span key={tag}>#{tag} </span>)}</div>
          </div>
        ))}
      </div>
    </div>
  );
};

export default Dashboard;