import React from "react";
import Row from "react-bootstrap/Row"
import Col from "react-bootstrap/Col"
import Card from "react-bootstrap/Card"
import Top from "./Top.png"
import Jungle from "./Jungle.png"
import Mid from "./Mid.png"
import Bot from "./Bot.png"
import Support from "./Support.png"
import Question from "./Question.png"
import Container from "react-bootstrap/esm/Container";
class PlayerTop extends React.Component {
    constructor(props) {
      super(props);
      this.state = {
        player: props.player,
      };
      console.log(props.player  )
    }

    getBg(team ){
        if(team == "Blue"){
            return "rgba(2,100,255,0.7)";
        } else {
            return "rgba(255,0,0,0.6)";
        }
    }

    getFont(team ){
        if(team == "Blue"){
            return "gold"
        } else {
            return "white";
        }
    }
    getPosition(pos){
      console.log(pos)
      if(pos == "TOP"){
          return Top;
      } else if(pos == "JUNGLE"){
        return Jungle;
      } else if(pos == "MIDDLE"){
        return Mid;
      } else if(pos == "BOTTOM"){
        return Bot;
      }else if(pos == "SUPPORT"){
        return Support;
      } else {
        return Question;
      }
    }

    getChamp(champion){
      return "https://ddragon.leagueoflegends.com/cdn/img/champion/splash/" + champion + "_0.jpg"
    }
  
    render() {
      const match1 = this.state.player.mo.match1;
      const match2 = this.state.player.mo.match2;
      return (
        <Card style={{background:this.getBg(match1.team), color:this.getFont(match1.team), fontWeight:"500"}}>
            <Card.Body>
              <Row>
                <Col style={{fontSize:"120%"}} >
                 <span style={{fontWeight:"700"}}>{match1.name}<br></br></span>
                 Kills : {match1.kills}<br></br>
                 Deaths : {match1.deaths}<br></br>
                 Assists : {match1.assists}<br></br>
              </Col>
              <Col style={{fontSize:"120%"}}>
              <img width="30%" 
                src={this.getPosition(match1.position)}/><br></br>
                 KDA : {((match1.kills + match1.assists) / match1.deaths).toFixed(2)}<br></br>
                 Vision Score : {match1.visionScore}
              </Col>
              <Col>
              <img width="100%" height="105%"
                src={this.getChamp(match1.champion)}/>
              </Col>
              </Row>
            </Card.Body>
        </Card>
      );
    }
  }
export default PlayerTop;