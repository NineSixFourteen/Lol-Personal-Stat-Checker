import logo from './logo.svg';
import './App.css';
import React from 'react';

class App extends React.Component {
  state = {
    players: []
  };

  async componentDidMount() {
    const response = await fetch('/get/Match?id=EUW1_6094714316');
    const body = await response.json();
    console.log(body);
    this.setState({players: body.players});
  }

  render() {
    const {players} = this.state;
    return (
        <div className="App">
          <header className="App-header">
            <img src={logo} className="App-logo" alt="logo" />
            <div className="App-intro">
              <h2>Players</h2>
              {players.map(player =>
                  <div key={player.mo.match1.name}>
                    {player.mo.match1.name} {player.mo.match1.kills} ({player.mo.match1.team})
                  </div>
              )}
            </div>
          </header>
        </div>
    );
  }
}
export default App;