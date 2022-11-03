import React from "react";
import Container from 'react-bootstrap/Container';
import Nav from 'react-bootstrap/Nav';
import Card from 'react-bootstrap/Card';
import Row from 'react-bootstrap/Row';
import PlayerInterval from "./playerInterval";
import Col from 'react-bootstrap/Col';

class Stats extends React.Component{

    constructor(props) {
        super(props);
        this.state = {
          players: props.players,
          tabs : [],
          player: "",
          view: true
        };
      }

    componentDidMount() {
        this.getTabs(this.state.players);
        this.setPlayer(this.state.players[0])
    }

    setCur(player){
        this.setState({player:""})
        this.setPlayer(player)
    }

    setView(val){
        this.setState({view: val});
    }

    setPlayer(player){
        if(this.state.view){
            const match1 = player.mo.match1;
            const match2 = player.mo.match2;
            this.setState({player:
                (
                <Row style={{color:'white'}}>
                    <Col style={{textSize:"300%"}}>
                        <strong>Stats</strong>  <br></br>
                        <strong> Name </strong> : {match1.name} <br></br>
                        <strong> Champion : </strong>{match1.champion} <br></br>
                        <strong> Kills : </strong>{match1.kills} <br></br>
                        <strong> Deaths : </strong>{match1.deaths} <br></br>
                        <strong> Assists :</strong> {match1.assists} <br></br>
                        <strong> CS : </strong>{match1.cs} <br></br>
                        <strong> Gold : </strong>{match1.gold} <br></br>
                        <strong> Damage Dealt : </strong>{match1.damageDealt}<br></br>
                        <strong> Damage Taken :</strong> {match1.damageTaken} <br></br>
                        <strong> Barons Taken : </strong> {match1.baronsTaken} <br></br>
                        <strong> Dragons Taken : </strong>{match1.dragonsTaken} <br></br>
                        <strong> Objective Steals :</strong> {match1.objectiveSteals} <br></br>
                        <strong> Turret Damage :</strong> {match1.turretDamage} <br></br>
                        <strong> Turrets Taken :</strong> {match1.turretsTaken} <br></br>
                        <strong> Wards Placed : </strong> {match1.wardsPlaced} <br></br>
                        <strong> Wards Destroyed :</strong> {match1.wardsDestroyed} <br></br>
                        <strong> Vision Score  : </strong> {match1.visionScore} <br></br>
                    </Col>
                    <Col>
                    <strong>Stats - Fun </strong><br></br>
                    <strong>Ability Uses : </strong>{match2.abiltyUses} <br></br>
                    <strong>Bounty Level :</strong> {match2.bountyL} <br></br>
                    <strong>CC And Kills W Alley : </strong>{match2.ccandKillwAlley} <br></br>
                    <strong>Control Wards Bought : </strong>{match2.controlWardsBought} <br></br>
                    <strong>Control Wards Placed :</strong> {match2.controlWardsPlaced} <br></br>
                    <strong>Enemy's CCd : </strong>{match2.enemyCCd} <br></br>
                    <strong>Dodged Skill Shots : </strong>{match2.dodgedSkillShots} <br></br>
                    <strong>Enemy's CCd : </strong>{match2.enemyCCd} <br></br>
                    <strong>Enemy Jungle Killed : </strong>{match2.enemyJungleKilled} <br></br>
                    <strong>First Blood Kill: </strong>{match2.firstBloodKill ? "true" : "false"} <br></br>
                    <strong>First Blood Assist : </strong>{match2.firstBloodAssists ? "true" : "false"} <br></br>
                    <strong>First Blood Tower : </strong> {match2.firstTowerKill ? "true" : "false"} <br></br>
                    <strong>Heal On Teamates : </strong>{match2.healOnTeamates} <br></br>
                    <strong>Hit Skill Shots :</strong> {match2.hitSkillShots} <br></br>
                    <strong>Jungle Monsters Killed : </strong>{match2.jungleMonstersKilled} <br></br>
                    <strong>lane Minions At 10 Minutes :</strong> {match2.landMinionsAt10} <br></br>
                    <strong>Peak CS Lead : </strong>{match2.peakCsLead} <br></br>
                    <strong>Peak Kill Lead : </strong>{match2.peakKillDiff} <br></br>
                    <strong>Picks With Alley :</strong> {match2.picksWAlley} <br></br>
                    <strong>Pings :</strong> {match2.pings} <br></br>
                    <strong>Shield On Teamates : </strong>{match2.sheildOnTeamates} <br></br>
                    <strong>Skill Shots Early: </strong>{match2.skillShotsEarly} <br></br>
                    <strong>Solo Kills : </strong>{match2.soloKills} <br></br>
                    <strong>Stealth Wards Placed :</strong> {match2.stealthWardsPlaced} <br></br>
                    <strong>Stolen Buffs : </strong>{match2.stolenBuffs} <br></br>
                    <strong>Time CC others : </strong>{match2.timeCCother} <br></br>
                    <strong>Turret Plates :</strong> {match2.turretPlates} <br></br>
                    </Col>
                </Row>
            )});
            } else {
                let x = (<PlayerInterval player={player}/>)
                this.setState({player: x})
            }
    }

    getTabs(players){
        let z = []
        let y = []
        let i = 0 ;
        players.map(player => {
            if(i < 5){
                z[i] =                     
                    <Nav.Link key={i++}style={{width:"20%"}} onClick={()=>this.setCur(player)}>
                        <img src={
                            "https://ddragon.leagueoflegends.com/cdn/img/champion/splash/" + 
                            player.mo.match1.champion + 
                            "_0.jpg"
                        } style={{width:"100%"}} 
                        />
                    </Nav.Link>
            } else {
                y[i - 5] = 
                    <Nav.Link key={i++}style={{width:"20%"}} onClick={()=>this.setCur(player)}>
                        <img src={
                            "https://ddragon.leagueoflegends.com/cdn/img/champion/splash/" + 
                            player.mo.match1.champion + 
                            "_0.jpg"
                        } style={{width:"100%"}} 
                        />
                    </Nav.Link>
            }        
        })
        this.setState({tabs : 
        (
            <Container>
            <Row>
                <Nav variant="tabs">
                    {z}
                </Nav>
            </Row>
            <Row>
            <Nav  variant="tabs">
                {y}
            </Nav>
            </Row>

            </Container>
        )})
    }


    render() {
        return (    
        <>
            <Nav variant="tabs" style={{background:"rgba(20,20,20,0.5)"}}>
                <Nav.Link className="px-5" style={{background:"rgba(20,20,20,0.5)",width:"50%"}} onClick={()=>this.setView(true)}><span style={{marginLeft:"40%",marginRight:"auto"}}>Overall</span></Nav.Link>
                <Nav.Link className="px-5" style={{background:"rgba(20,20,20,0.5)",width:"50%"}} onClick={()=>this.setView(false)}><span style={{marginLeft:"40%",marginRight:"auto"}}>Intervals</span></Nav.Link>
            </Nav>
        <Card style={{backgroundColor:"rgba(30,200,200,0.5)"}}>
            <Card.Header>
                <Nav variant="tabs">
                    {this.state.tabs}
                </Nav>
            </Card.Header>
            <Card.Body>
                <Container>
                <Row>
                    {this.state.player}
                </Row>
                </Container>           
            </Card.Body>
        </Card> 
        </>
      )
    }

}
export default Stats;