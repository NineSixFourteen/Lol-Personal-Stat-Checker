import React from "react";
import Card from "react-bootstrap/Card"
class PlayerTop extends React.Component {
    constructor(props) {
      super(props);
      this.state = {
        player: props.player,
      };
    }

    getBg(team ){
        if(team == "Blue"){
            return "info";
        } else {
            return "danger";
        }
    }

    getFont(team ){
        if(team == "Blue"){
            return "black"
        } else {
            return "white";
        }
    }
  
    render() {
      const match1 = this.state.player.mo.match1;
      const match2 = this.state.player.mo.match2;
      return (
        <Card bg={this.getBg(match1.team)} style={{color:this.getFont(match1.team)}}>
            <Card.Body>
                Name  : {this.state.player.mo.match1.name}<br></br>
                Kills : {this.state.player.mo.match1.kills}<br></br>
                Deaths : {this.state.player.mo.match1.deaths}<br></br>
                Assists : {this.state.player.mo.match1.assists}<br></br>
            </Card.Body>
        </Card>
      );
    }
  }
export default PlayerTop;