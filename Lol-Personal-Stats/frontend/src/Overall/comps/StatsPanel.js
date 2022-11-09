import React from "react";
import Card from 'react-bootstrap/Card';
import Row from 'react-bootstrap/Row';
import Col from 'react-bootstrap/Col';
import Collapse from "react-bootstrap/Collapse";
import Nav from "react-bootstrap/Nav";

class StatsPanel extends React.Component{

    constructor (props){
        super(props);
        this.state = {
            items: props.items,
            cur: props.cur,
            heading: props.heading,
            units: props.units,
            unit: props.unit,
            body: <h1>re</h1>,
            show: true,
            places: props.places    
          };
    }

    componentDidMount() {
        this.display(this.state.items, this.state.cur)
    }

    setCur(cur){
        this.setState({cur:cur})
        this.display(this.state.items,cur)
    }

    display(items ,cur){
        let x = items[cur];
        let places = this.state.places;
        let z = "";
        switch(cur){
            case 0:z =  "Overall";break;
            case 1:z =  "SR";break;
            case 2:z =  "ARAM";break;
            case 3:z =  "Top";break;
            case 4:z =  "Jungle";break;
            case 5:z =  "Mid";break;
            case 6:z =  "Adc";break;
            case 7:z =  "Support";break; 
            }
        let y =  
        <Row className = "baba" style={{color:'white',background:"rgba(40,80,40,0.4)",border:"ridge"}}>
            <Nav bg = "dark" style={{fontSize:"115%",background:"rgba(0,10,10,0.8)"}}>
                <Nav.Link style={{width:"12.5%", background:"rgba(20,20,20,0.5)", fontSize:"90%"}} onClick={()=>this.setCur(0)}>
                    <span style={{marginLeft:"30%", marginRight:"auto"}}> Overall</span></Nav.Link>
                <Nav.Link style={{width:"12.5%",background:"rgba(20,20,20,0.5)", fontSize:"90%"}} onClick={()=>this.setCur(1)}>
                    <span style={{marginLeft:"30%", marginRight:"auto"}}> SR</span></Nav.Link>
                <Nav.Link style={{width:"12.5%",background:"rgba(20,20,20,0.5)", fontSize:"90%"}} onClick={()=>this.setCur(2)}>
                    <span style={{marginLeft:"30%", marginRight:"auto"}}> ARAM</span></Nav.Link>
                <Nav.Link style={{width:"12.5%",marginLeft:"1%",background:"rgba(20,20,20,0.5)", fontSize:"90%"}} onClick={()=>this.setCur(3)}>
                    <span style={{marginLeft:"30%", marginRight:"auto"}}> Top</span></Nav.Link>
                <Nav.Link style={{width:"12.5%",background:"rgba(20,20,20,0.5)", fontSize:"90%"}} onClick={()=>this.setCur(4)}>
                    <span style={{marginLeft:"30%", marginRight:"auto"}}> Jungle</span></Nav.Link>
                <Nav.Link style={{width:"12.5%",background:"rgba(20,20,20,0.5)", fontSize:"90%"}} onClick={()=>this.setCur(5)}>
                    <span style={{marginLeft:"30%", marginRight:"auto"}}> Mid</span></Nav.Link>
                <Nav.Link style={{width:"12.5%",background:"rgba(20,20,20,0.5)", fontSize:"90%"}} onClick={()=>this.setCur(6)}>
                    <span style={{marginLeft:"30%", marginRight:"auto"}}> Adc</span></Nav.Link>
                <Nav.Link style={{width:"11.5%",background:"rgba(20,20,20,0.5)", fontSize:"90%"}} onClick={()=>this.setCur(7)}>
                    <span style={{marginLeft:"30%", marginRight:"auto"}}> Support</span></Nav.Link>
            </Nav>
            <h1 style={{marginLeft:"35%",marginRight:"auto"}}>{z + " - " + x.total + " " + (x.total != 1 ? this.state.units : this.state.unit)}</h1>
            <Col className="px-2 py-2">
                <strong> Kills : </strong>{(x.kills).toFixed(places)} <br></br>
                <strong> Deaths : </strong>{(x.deaths).toFixed(places)} <br></br>
                <strong> Assists :</strong> {(x.assists).toFixed(places)} <br></br>
                <strong> CS : </strong>{(x.cs).toFixed(places)} <br></br>
                <strong> Gold : </strong>{(x.gold).toFixed(places)} <br></br>
                <strong> Damage Dealt : </strong>{(x.damageDealt).toFixed(places)}<br></br>
                <strong> Damage Taken :</strong> {(x.damageTaken).toFixed(places)} <br></br>
                <strong> Barons Taken : </strong> {(x.baronsTaken).toFixed(places)} <br></br>
                <strong> Dragons Taken : </strong>{(x.dragonsTaken).toFixed(places)} <br></br>
                <strong> Objective Steals :</strong> {(x.objectiveSteals).toFixed(places)} <br></br>
            </Col>
            <Col className="px-2 py-2">
                <strong> Turret Damage :</strong> {(x.turretDamage).toFixed(places)} <br></br>
                <strong> Turrets Taken :</strong> {(x.turretsTaken).toFixed(places)} <br></br>
                <strong> Wards Placed : </strong> {(x.wardsPlaced).toFixed(places)} <br></br>
                <strong> Wards Destroyed :</strong> {(x.wardsDestroyed).toFixed(places)} <br></br>
                <strong> Vision Score  : </strong> {(x.visionScore).toFixed(places)} <br></br>
                <strong>Solo Kills : </strong>{(x.soloKills).toFixed(places)} <br></br>
                <strong>Stealth Wards Placed :</strong> {(x.stealthWardsPlaced).toFixed(places)} <br></br>
                <strong>Stolen Buffs : </strong>{(x.stolenBuffs).toFixed(places)} <br></br>
                <strong>Time CC others : </strong>{(x.timeCCother).toFixed(places)} <br></br>
                <strong>Turret Plates :</strong> {(x.turretPlates).toFixed(places)} <br></br>                   
            </Col>
            <Col className="px-2 py-2">
                <strong>Ability Uses : </strong>{(x.abiltyUses).toFixed(places)} <br></br>
                <strong>CC And Kills W Alley : </strong>{(x.cCandKillwAlley).toFixed(places)} <br></br>
                <strong>Control Wards Bought : </strong>{(x.controlWardsBought).toFixed(places)} <br></br>
                <strong>Control Wards Placed :</strong> {(x.controlWardsPlaced).toFixed(places)} <br></br>
                <strong>Enemy's CCd : </strong>{(x.enemyCCd).toFixed(places)} <br></br>
                <strong>Dodged Skill Shots : </strong>{(x.dodgedSkillShots).toFixed(places)} <br></br>
                <strong>Enemy Jungle Killed : </strong>{(x.enemyJungleKilled).toFixed(places)} <br></br>
                <strong>First Blood Kill: </strong>{(x.firstBloodKills).toFixed(places)} <br></br>
                <strong>First Blood Assist : </strong>{(x.firstBloodAssists).toFixed(places)} <br></br>
                <strong>First Blood Tower : </strong> {(x.firstTowerKill).toFixed(places)} <br></br>
            </Col>
            <Col className="px-2 py-2">
                <strong>Heal On Teamates : </strong>{(x.heal).toFixed(places)} <br></br>
                <strong>Hit Skill Shots :</strong> {(x.hitSkillShots).toFixed(places)} <br></br>
                <strong>Jungle Monsters Killed : </strong>{(x.jungleMonstersKilled).toFixed(places)} <br></br>
                <strong>lane Minions At 10 :</strong> {(x.landMinionsAt10).toFixed(places)} <br></br>
                <strong>Average Peak CS Lead : </strong>{(x.peakCsLead).toFixed(places)} <br></br>
                <strong>Average Peak Kill Lead : </strong>{(x.peakKillDiff).toFixed(places)} <br></br>
                <strong>Picks With Alley :</strong> {(x.picksWAlley).toFixed(places)} <br></br>
                <strong>Pings :</strong> {(x.pings).toFixed(places)} <br></br>
                <strong>Shield On Teamates : </strong>{(x.shield).toFixed(places)} <br></br>
                <strong>Skill Shots Early: </strong>{(x.skillShotsEarly).toFixed(places)} <br></br>
            </Col>
        </Row>
        this.setState({body:y})
    }

    flip(bool){
        let x = !bool
        this.setState({show:x})
    }

    render(){
        return             <>
        <Card style={{background:'rgba(50,50,50,0.5)'}}>
            <Card.Header onClick={()=>this.flip(this.state.show)} style={{background:"rgba(71, 17, 166,0.3)", marginLeft:'auto',marginRight:'auto',fontSize:'200%',fontWeight:'600',color:'tan',textShadow:'1px 0 black'}}>
               {this.state.heading}
            </Card.Header>
            <Card.Body className="px-4">
            <Collapse in={this.state.show}>
                <div id="example-collapse-text">
                    {this.state.body}
                </div>
            </Collapse>
            </Card.Body>
        </Card>
        </>
    }

} export default StatsPanel