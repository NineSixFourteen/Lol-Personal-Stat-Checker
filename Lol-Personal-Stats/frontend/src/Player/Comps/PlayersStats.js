import React from "react";
import Card from 'react-bootstrap/Card';
import Row from 'react-bootstrap/Row';
import Col from 'react-bootstrap/Col';
import Collapse from "react-bootstrap/Collapse";
import Nav from "react-bootstrap/Nav";

class PlayerStats extends React.Component{

    constructor (props){
        super(props);
        this.state = {
            stats: props.stats,
            cur: props.cur,
            body: <h1>re</h1>,
            show: true,
            msg: "Hide"
          };
    }

    componentDidMount() {
        this.display(this.state.stats, this.state.cur)
    }

    setCur(cur){
        this.setState({cur:cur})
        this.display(this.state.stats,cur)
    }

    flip(bool){
        let x = !bool
        let m = "Show"
        if(x){
            m = "Hide"
        }
        this.setState({show:x, msg:m})
    }

    
    display(stats, cur){
        let x = stats[cur];
        let z = "";
        switch(cur){
            case 5:z =  "Overall";break;
            case 6:z =  "SR";break;
            case 7:z =  "ARAM";break;
            case 0:z =  "Top";break;
            case 1:z =  "Jungle";break;
            case 2:z =  "Mid";break;
            case 3:z =  "Adc";break;
            case 4:z =  "Support";break; 
            }
        let y = (
            <Row className = "baba" style={{color:'white',background:"rgba(40,80,40,0.4)",border:"ridge"}}>
                <Nav bg = "dark" style={{fontSize:"115%",background:"rgba(0,10,10,0.8)"}}>
                    <Nav.Link style={{background:"rgba(20,20,20,0.5)"}} onClick={()=>this.setCur(5)}>Overall</Nav.Link>
                    <Nav.Link style={{background:"rgba(20,20,20,0.5)"}} onClick={()=>this.setCur(6)}>SR</Nav.Link>
                    <Nav.Link style={{background:"rgba(20,20,20,0.5)"}} onClick={()=>this.setCur(7)}>ARAM</Nav.Link>
                    <Nav.Link style={{marginLeft:"1%",background:"rgba(20,20,20,0.5)"}} onClick={()=>this.setCur(0)}>Top</Nav.Link>
                    <Nav.Link style={{background:"rgba(20,20,20,0.5)"}} onClick={()=>this.setCur(1)}>Jun</Nav.Link>
                    <Nav.Link style={{background:"rgba(20,20,20,0.5)"}} onClick={()=>this.setCur(2)}>Mid</Nav.Link>
                    <Nav.Link style={{background:"rgba(20,20,20,0.5)"}} onClick={()=>this.setCur(3)}>Adc</Nav.Link>
                    <Nav.Link style={{width:"11.6%",background:"rgba(20,20,20,0.5)"}} onClick={()=>this.setCur(4)}>Sup</Nav.Link>
                </Nav>
                <h1 style={{marginLeft:"16%",marginRight:"auto"}}>{z + " - " + x.total + (x.total != 1 ? " Games" : " Game")}</h1>
                <Col className="px-2 py-2">
                        <strong> Kills : </strong>{(x.kills/x.total).toFixed(2)} <br></br>
                        <strong> Deaths : </strong>{(x.deaths/x.total).toFixed(2)} <br></br>
                        <strong> Assists :</strong> {(x.assists/x.total).toFixed(2)} <br></br>
                        <strong> CS : </strong>{(x.cs/x.total).toFixed(2)} <br></br>
                        <strong> Gold : </strong>{(x.gold/x.total).toFixed(2)} <br></br>
                        <strong> Damage Dealt : </strong>{(x.damageDealt/x.total).toFixed(2)}<br></br>
                        <strong> Damage Taken :</strong> {(x.damageTaken/x.total).toFixed(2)} <br></br>
                        <strong> Barons Taken : </strong> {(x.baronsTaken/x.total).toFixed(2)} <br></br>
                        <strong> Dragons Taken : </strong>{(x.dragonsTaken/x.total).toFixed(2)} <br></br>
                        <strong> Objective Steals :</strong> {(x.objectiveSteals/x.total).toFixed(2)} <br></br>
                        <strong> Turret Damage :</strong> {(x.turretDamage/x.total).toFixed(2)} <br></br>
                        <strong> Turrets Taken :</strong> {(x.turretsTaken/x.total).toFixed(2)} <br></br>
                        <strong> Wards Placed : </strong> {(x.wardsPlaced/x.total).toFixed(2)} <br></br>
                        <strong> Wards Destroyed :</strong> {(x.wardsDestroyed/x.total).toFixed(2)} <br></br>
                        <strong> Vision Score  : </strong> {(x.visionScore/x.total).toFixed(2)} <br></br>
                        <strong>Solo Kills : </strong>{(x.soloKills/x.total).toFixed(2)} <br></br>
                        <strong>Stealth Wards Placed :</strong> {(x.stealthWardsPlaced/x.total).toFixed(2)} <br></br>
                        <strong>Stolen Buffs : </strong>{(x.stolenBuffs/x.total).toFixed(2)} <br></br>
                        <strong>Time CC others : </strong>{(x.timeCCother/x.total).toFixed(2)} <br></br>
                        <strong>Turret Plates :</strong> {(x.turretPlates/x.total).toFixed(2)} <br></br>                   
                    </Col>
                    <Col className="px-2 py-2">
                    <strong>Ability Uses : </strong>{(x.abiltyUses/x.total).toFixed(2)} <br></br>
                    <strong>CC And Kills W Alley : </strong>{(x.cCandKillwAlley/x.total).toFixed(2)} <br></br>
                    <strong>Control Wards Bought : </strong>{(x.controlWardsBought/x.total).toFixed(2)} <br></br>
                    <strong>Control Wards Placed :</strong> {(x.controlWardsPlaced/x.total).toFixed(2)} <br></br>
                    <strong>Enemy's CCd : </strong>{(x.enemyCCd/x.total).toFixed(2)} <br></br>
                    <strong>Dodged Skill Shots : </strong>{(x.dodgedSkillShots/x.total).toFixed(2)} <br></br>
                    <strong>Enemy Jungle Killed : </strong>{(x.enemyJungleKilled/x.total).toFixed(2)} <br></br>
                    <strong>First Blood Kill: </strong>{(x.firstBloodKills/x.total).toFixed(2)} <br></br>
                    <strong>First Blood Assist : </strong>{(x.firstBloodAssists/x.total).toFixed(2)} <br></br>
                    <strong>First Blood Tower : </strong> {(x.firstTowerKill/x.total).toFixed(2)} <br></br>
                    <strong>Heal On Teamates : </strong>{(x.heal/x.total).toFixed(2)} <br></br>
                    <strong>Hit Skill Shots :</strong> {(x.hitSkillShots/x.total).toFixed(2)} <br></br>
                    <strong>Jungle Monsters Killed : </strong>{(x.jungleMonstersKilled/x.total).toFixed(2)} <br></br>
                    <strong>lane Minions At 10 :</strong> {(x.landMinionsAt10/x.total).toFixed(2)} <br></br>
                    <strong>Average Peak CS Lead : </strong>{(x.peakCsLead/x.total).toFixed(2)} <br></br>
                    <strong>Average Peak Kill Lead : </strong>{(x.peakKillDiff/x.total).toFixed(2)} <br></br>
                    <strong>Picks With Alley :</strong> {(x.picksWAlley/x.total).toFixed(2)} <br></br>
                    <strong>Pings :</strong> {(x.pings/x.total).toFixed(2)} <br></br>
                    <strong>Shield On Teamates : </strong>{(x.shield/x.total).toFixed(2)} <br></br>
                    <strong>Skill Shots Early: </strong>{(x.skillShotsEarly/x.total).toFixed(2)} <br></br>
                    </Col>
                </Row>
        )
        this.setState({body:y})
    }

    render(){
        return(
            <Card style={{background:'rgba(50,50,50,0.5)'}}>
            <Card.Header onClick={()=>this.flip(this.state.show)} style={{background:"rgba(71, 17, 166,0.3)", marginLeft:'auto',marginRight:'auto',fontSize:'200%',fontWeight:'600',color:'tan',textShadow:'1px 0 black'}}>
            Player Stats
            </Card.Header>
            <Card.Body className="px-4">
            <Collapse in={this.state.show}>
                <div id="example-collapse-text">
                    {this.state.body}
                </div>
            </Collapse>
            </Card.Body>
        </Card>
        )
    }


} export default PlayerStats;