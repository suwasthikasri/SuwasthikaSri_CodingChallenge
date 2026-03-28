import { BrowserRouter, Routes, Route, Link } from "react-router-dom";
import PlayerList from "./PlayerList";
import AddPlayer from "./AddPlayer";
import UpdatePlayer from "./UpdatePlayer";

function App() {
  return (
    <BrowserRouter>
      <h1>Cricket Team Management</h1>

      <nav>
        <Link to="/">Home</Link> |{" "}
        <Link to="/add">Add Player</Link>
      </nav>

      <Routes>
        <Route path="/" element={<PlayerList />} />
        <Route path="/add" element={<AddPlayer />} />
        <Route path="/update/:id" element={<UpdatePlayer />} />
      </Routes>
    </BrowserRouter>
  );
}

export default App;