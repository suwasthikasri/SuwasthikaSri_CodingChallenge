import { useState } from "react";
import axios from "axios";
import { useNavigate } from "react-router-dom";
export default function AddPlayer() {
  const navigate = useNavigate();
  const [player, setPlayer] = useState({
    playerName: "",
    jerseyNumber: "",
    role: "",
    teamName: "",
    countryOrState: "",
    totalMatches: 0,
    description: ""
  });
  const [error, setError] = useState("");
  const roles = ["Batsman", "Bowler", "Keeper", "All Rounder"];
  const handleChange = (e) => {
    let value = e.target.value;
    if (e.target.name === "jerseyNumber" || e.target.name === "totalMatches") {
      value = Number(value);
    }
    setPlayer({ ...player, [e.target.name]: value });
    if (e.target.name === "role") {
      setError("");
    }
  };
  const handleSubmit = (e) => {
    e.preventDefault();
    if (!roles.includes(player.role)) {
      setError("Select valid role (Batsman, Bowler, Keeper, All Rounder)");
      return;
    }
    setError("");
    const data = {
      ...player,
      jerseyNumber: Number(player.jerseyNumber),
      totalMatches: Number(player.totalMatches)
    };
    axios.post("http://localhost:8080/api/players/add", data)
      .then(() => {
        alert("Player Added Successfully");
        navigate("/");
      })
      .catch((err) => {
        console.log(err.response?.data);
        alert("Error while adding player");
      });
  };
  return (
    <div style={{ display: "flex", justifyContent: "center", marginTop: "30px" }}>
      
      <form 
        onSubmit={handleSubmit} 
        noValidate
        style={{ border: "1px solid black", padding: "20px", width: "350px" }}
      >
        <h2>Add Player</h2>
        <div>
          <label>Player Name</label><br/>
          <input name="playerName" onChange={handleChange} required />
        </div>
        <br/>
        <div>
          <label>Jersey Number</label><br/>
          <input type="number" name="jerseyNumber" onChange={handleChange} required />
        </div>
        <br/>
        <div>
          <label>Role</label><br/>
          <select name="role" onChange={handleChange}>
            <option value="">Select Role</option>
            {roles.map(r => <option key={r}>{r}</option>)}
          </select>
          {error && <p style={{ color: "red" }}>{error}</p>}
        </div>
        <br/>
        <div>
          <label>Team Name</label><br/>
          <input name="teamName" onChange={handleChange} required />
        </div>
        <br/>
        <div>
          <label>Country / State</label><br/>
          <input name="countryOrState" onChange={handleChange} required />
        </div>
        <br/>
        <div>
          <label>Total Matches</label><br/>
          <input type="number" name="totalMatches" onChange={handleChange} />
        </div>
        <br/>
        <div>
          <label>Description</label><br/>
          <textarea name="description" onChange={handleChange}></textarea>
        </div>
        <br/>
        <button type="submit">Add Player</button>
      </form>
    </div>
  );
}