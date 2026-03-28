import { useEffect, useState } from "react";
import axios from "axios";
import { Link } from "react-router-dom";

export default function PlayerList() {

  const [players, setPlayers] = useState([]);

  useEffect(() => {
    loadPlayers();
  }, []);

  const loadPlayers = () => {
    axios.get("http://localhost:8080/api/players")
      .then(res => setPlayers(res.data))
      .catch(err => console.log(err));
  };

  const deletePlayer = (id) => {
    axios.delete(`http://localhost:8080/api/players/${id}`)
      .then(() => loadPlayers())
      .catch(err => console.log(err));
  };

  return (
    <div>
      <h2>Player List</h2>

      <table border="1">
        <thead>
          <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Jersey</th>
            <th>Role</th>
            <th>Action</th>
          </tr>
        </thead>

        <tbody>
          {players.map(p => (
            <tr key={p.playerId}>
              <td>{p.playerId}</td>
              <td>{p.playerName}</td>
              <td>{p.jerseyNumber}</td>
              <td>{p.role}</td>
              <td>
                <Link to={`/update/${p.playerId}`}>Edit</Link>
                <button onClick={() => deletePlayer(p.playerId)}>Delete</button>
              </td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
}