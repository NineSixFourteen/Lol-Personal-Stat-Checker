import React from 'react';
import ReactDOM from 'react-dom/client';
import './index.css';
import Match from './Match/Match';
import Home from './Home/Home';
import Overall from './Overall/Overall';
import Player from './Player/Player';
import 'bootstrap/dist/css/bootstrap.min.css';
import {
  BrowserRouter,
  Routes,
  Route,
} from "react-router-dom";

const root = ReactDOM.createRoot(document.getElementById('root'));
root.render(
    <BrowserRouter>
    <Routes>
      <Route path="/" element={<Home />}> </Route>
      <Route exact path="/home" element={<Home />}> </Route>
      <Route exact path="/match" element={<Match />}></Route>
      <Route exact path="/overall" element={<Overall />}></Route>
      <Route exact path="/player" element={<Player />}></Route>
    </Routes>
  </BrowserRouter>
);

