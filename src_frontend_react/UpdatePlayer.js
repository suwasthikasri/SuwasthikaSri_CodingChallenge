import { useState, useEffect } from "react";
import axios from "axios";
import { useNavigate, useParams } from "react-router-dom";

export default function UpdatePlayer() {

  const { id } = useParams();
  const navigate = useNavigate();

  const [player, setPlayer] = useState({
    playerName: "",
    jerseyNumber: "",
    role: ""
  });

  const roles = ["Batsman", "Bowler", "Keeper", "All Rounder"];

  useEffect(() => {
    axios.get(`http://localhost:8080/api/players/${id}`)
      .then(res => setPlayer(res.data))
      .catch(err => console.log(err));
  }, [id]);

  const handleChange = (e) => {
    setPlayer({ ...player, [e.target.name]: e.target.value });
  };

  const handleSubmit = (e) => {
    e.preventDefault();

    axios.put(`http://localhost:8080/api/players/${id}`, player)
      .then(() => {
        alert("Updated Successfully");
        navigate("/");
      })
      .catch(() => alert("Error"));
  };

  return (
    <div>
      <h2>Update Player</h2>

      <form onSubmit={handleSubmit}>
        <input name="playerName" value={player.playerName} onChange={handleChange} />
        <input name="jerseyNumber" value={player.jerseyNumber} onChange={handleChange} />

        <select name="role" value={player.role} onChange={handleChange}>
          {roles.map(r => <option key={r}>{r}</option>)}
        </select>

        <button type="submit">Update</button>
      </form>
    </div>
  );
}