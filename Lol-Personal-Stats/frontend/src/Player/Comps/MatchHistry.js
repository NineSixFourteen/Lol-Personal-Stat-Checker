import React from "react";
import Card from 'react-bootstrap/Card';
import Row from 'react-bootstrap/Row';
import Col from 'react-bootstrap/Col';
import Collapse from "react-bootstrap/Collapse";
import Top from "../../photos/Top.png"
import Jungle from "../../photos/Jungle.png"
import Mid from "../../photos/Mid.png"
import Bot from "../../photos/Bot.png"
import Support from "../../photos/Support.png"
import Question from "../../photos/Question.png"
import Victory from "../../photos/Victory.png"
import Defeat from "../../photos/Defeat.png"
import ButtonGroup from "react-bootstrap/esm/ButtonGroup";
import Button from "react-bootstrap/esm/Button";
import Form from "react-bootstrap/Form"

class MatchHistory extends React.Component{

    constructor (props){
        super(props);
        this.state = {
            MatchHistory: props.MatchHistory,
            player: props.player,
            body: <h1>re</h1>,
            show: true,
            msg: "Hide",
            start: 0
          };
    }

    componentDidMount() {
        this.display(this.state.MatchHistory,this.state.player,this.state.start)
    }

    get10(list,start){
        let i = 0; 
        let z = []
        while(i < 10){
            z[i++] = list[start++];
        }
        return z;
    }

    display(elem,name,start){
        this.setState({body:[]})
        this.setState({start: start})
        let x = []
        elem =  this.get10(elem,start)
        elem.forEach( game => {
            let player = this.findPlayer(game.players,name)
            let match = player.mo.match1
            let win = match.team.toLowerCase() == game.matchHistory.winningTeam.toLowerCase() ? Victory : Defeat
            let win2 =  match.team.toLowerCase() == game.matchHistory.winningTeam.toLowerCase() 
            let position = "";
            switch(match.position){
                case "TOP" : position = Top ;break;
                case "JUNGLE" : position = Jungle ;break;
                case "MIDDLE" : position = Mid ;break;
                case "BOTTOM" : position = Bot ;break;
                case "SUPPORT" : position = Support ;break;
                default: position = Question
            }
            x.push(
                <Row className="my-1 px-1" style={{color:"white",background: win2 ? 'rgba(26, 89, 189,0.4)' : 'rgba(201, 4, 4,0.4)', border:"double"}}>
                    <Col> 
                        <Row >
                        <Col style={{fontSize:"170%"}}>
                            <Row className="py-3 my-2">
                                <img width="200%" src={win}/>
                            </Row>
                            <Row className="py-4">
                                <strong> {match.team + " Side"}</strong>
                            </Row>
                        </Col>
                        <Col className="py-3 my-1">
                            <img width= "100%" src={position}/>
                        </Col>
                    </Row>
                    </Col>
                    <Col className="py-4"> 
                        <strong>Game Played On : </strong> {game.matchHistory.date}<br></br>
                        <strong>Gamemode : </strong> {game.matchHistory.gameMode}<br></br>
                        <strong>Game Length : </strong> {game.matchHistory.gameLength}<br></br>
                    </Col>
                    <Col className="py-4"> 
                        <strong> Kills/Deaths/Assists : </strong> {match.kills+ "/" + match.deaths + "/" + match.assists} <br></br>
                        <strong> KDA : </strong> {((match.kills + match.assists) / match.deaths).toFixed(2)} <br></br> <strong> Gold : </strong> {match.gold} <strong> CS : </strong> {match.cs}<br></br>
                        <strong> Damage Dealt : </strong> {match.damageDealt} <br></br>
                        <strong> Damage Taken : </strong> {match.damageTaken} 
                    </Col>
                    <Col> 
                    <img src={
                            "https://ddragon.leagueoflegends.com/cdn/img/champion/splash/" + 
                            match.champion + 
                            "_0.jpg"
                        } style={{width:"105%"}} 
                        />
                    </Col>
                </Row>
            )
        })
        this.setState({body:x})
    }

    findPlayer(players,name){
        let x = null;
        players.forEach( player =>
            {
                if(player.mo.match1.name == name){
                    x =  player
                }
            }
        )
        return x;
    }

    flip(bool){
        let x = !bool
        let m = "Show"
        if(x){
            m = "Hide"
        }
        this.setState({show:x, msg:m})
    }


    render(){
        return (
            <>
            <Card style={{background:'rgba(50,50,50,0.5)'}}>
                <Card.Header onClick={()=>this.flip(this.state.show)} style={{background:"rgba(71, 17, 166,0.3)", marginLeft:'auto',marginRight:'auto',fontSize:'200%',fontWeight:'600',color:'tan',textShadow:'1px 0 black'}}>
                   Match History
                </Card.Header>
                <Card.Body className="px-4">
                <Collapse in={this.state.show}>
                    <div id="example-collapse-text">
                        <Row>
                            <Form>
                            <ButtonGroup >
                                <Button
                                onClick={() => this.display(this.state.MatchHistory, this.state.player, this.state.start < 5 ? 0 : this.state.start - 5)}>
                                    Prev
                                </Button>
                                <Button
                                 onClick={() => this.display(this.state.MatchHistory, this.state.player, this.state.start + 15 > this.state.MatchHistory.length ? this.state.MatchHistory.length - 10 : this.state.start + 5)}>
                                    Next
                                </Button>
                            </ButtonGroup>
                            </Form>
                        </Row>
                        {this.state.body}
                    </div>
                </Collapse>
                </Card.Body>
            </Card>
            </>
            
        )
    }



} export default MatchHistory