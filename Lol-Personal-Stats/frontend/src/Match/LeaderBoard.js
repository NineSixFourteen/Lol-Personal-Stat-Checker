import React from "react";
import Container from 'react-bootstrap/Container';
import Nav from 'react-bootstrap/Nav';
import Navbar from 'react-bootstrap/Navbar';
import Card from 'react-bootstrap/Card';
import Row from 'react-bootstrap/Row';
import Form from 'react-bootstrap/Form';
import Button from 'react-bootstrap/Button';
import ButtonGroup from 'react-bootstrap/ButtonGroup';
import DropdownButton from 'react-bootstrap/DropdownButton';
import Dropdown from 'react-bootstrap/Dropdown';
import PlayerInterval from "./playerInterval";
import NavDropdown from 'react-bootstrap/NavDropdown';
import Col from 'react-bootstrap/Col';

class LeaderBoard extends React.Component{

    constructor(props) {
        super(props);
        this.state = {
          players: props.players,
          board: "", 
          cur: "Kills",
          inOrder:true,
          ord:"Asc"
      }
    }

    componentDidMount() {
        this.setBoard(this.state.players,"Kills");
    }

    sort(players,field){
        let x = [] 
        let i = 0;
        players.forEach(player => {
            const match1 = player.mo.match1;
            const match2 = player.mo.match2;
            switch(field){
                case "Kills": x.push({id:match1.name,val:match1.kills});break;
                case "Deaths": x.push({id:match1.name,val:match1.deaths});break;
                case "Assists": x.push({id:match1.name,val:match1.assists});break;
                case "Damage Dealt": x.push({id:match1.name,val:match1.damageDealt});break;
                case "Damage Taken": x.push({id:match1.name,val:match1.damageTaken});break;
                case "Objective Steals": x.push({id:match1.name,val:match1.objectiveSteals});break;
                case "Wards Placed": x.push({id:match1.name,val:match1.wardsPlaced});break;
                case "Wards Destoryed": x.push({id:match1.name,val:match1.wardsDestroyed});break;
                case "Vision Score": x.push({id:match1.name,val:match1.visionScore});break;
                case "CS": x.push({id:match1.name,val:match1.cs});break;
                case "Gold": x.push({id:match1.name,val:match1.gold});break;
                case "Ability Uses": x.push({id:match1.name,val:match2.abiltyUses});break;
                case "Contorl Wards Bought": x.push({id:match1.name,val:match2.controlWardsBought});break;
                case "Dodged Skill Shots": x.push({id:match1.name,val:match2.dodgedSkillShots});break;
                case "Enemy CC": x.push({id:match1.name,val:match2.enemyCCd});break;
                case "Lane Minions at 10": x.push({id:match1.name,val:match2.landMinionsAt10});break;
                case "Peak CS": x.push({id:match1.name,val:match2.peakCsLead});break;
                case "Peak Kill Lead": x.push({id:match1.name,val:match2.peakKillDiff});break;
                case "Pings": x.push({id:match1.name,val:match2.pings});break;
                case "Shield on Teamates": x.push({id:match1.name,val:match2.sheildOnTeamates});break;
                case "Heal on Teamates": x.push({id:match1.name,val:match2.healOnTeamates});break;
                case "Solo Kills": x.push({id:match1.name,val:match2.soloKills});break;
                case "Turret Plates": x.push({id:match1.name,val:match2.turretPlates});break;
                case "Hit Skill Shots": x.push({id:match1.name,val:match2.hitSkillShots});break;
                case "Jungle Monsters Killed": x.push({id:match1.name,val:match2.jungleMonstersKilled});break;
                default:
                    x.push({id:"Error",val:"Error"})
            }
        });
        x.sort(function(b, a){return a.val - b.val});
        if(!this.state.inOrder){
           x.reverse(); 
        }
        return x;
    }



    setBoard(players,field) {
        let order = this.sort(players,field);
        let y = []
        this.setState({cur:field})
        {order.forEach(elem => {y.push(
        <Row className="my-3" style={{outlineStyle:'double ',outlineColor:'black'}}>
            <Col>
                <strong>Name </strong>  <br></br> {elem.id}    
            </Col>
            <Col>
                <strong>{field} </strong> <br></br> {elem.val}   
            </Col>
        </Row>
        )})}
        let x = <>
                <Nav style={{background:"rgba(20,20,20,0.5)"}}>
                <NavDropdown
                        className='m-auto'
                        title={<span style={{marginLeft:"40%",marginRight:"auto"}}>{this.state.cur} </span>}
                        style={{
                            background:"rgba(20,20,20,0.5)",width:"50%",height:"110%"
                        }}
                        menuVariant="dark"
                        >
                        <NavDropdown.Item onClick={()=>this.setBoard(this.state.players,"Kills")}>Kills </NavDropdown.Item>
                        <NavDropdown.Item onClick={()=>this.setBoard(this.state.players,"Deaths")}>Deaths </NavDropdown.Item>
                        <NavDropdown.Item onClick={()=>this.setBoard(this.state.players,"Assists")}>Assists </NavDropdown.Item>
                        <NavDropdown.Item onClick={()=>this.setBoard(this.state.players,"Damage Dealt")}>Damage Dealt </NavDropdown.Item>
                        <NavDropdown.Item onClick={()=>this.setBoard(this.state.players,"Damage Taken")}>Damage Taken </NavDropdown.Item>
                        <NavDropdown.Item onClick={()=>this.setBoard(this.state.players,"Objective Steals")}>Objective Steals </NavDropdown.Item>
                        <NavDropdown.Item onClick={()=>this.setBoard(this.state.players,"Wards Placed")}>Wards Placed </NavDropdown.Item>
                        <NavDropdown.Item onClick={()=>this.setBoard(this.state.players,"Wards Destoryed")}>Wards Destoryed </NavDropdown.Item>
                        <NavDropdown.Item onClick={()=>this.setBoard(this.state.players,"Vision Score")}>Vision Score </NavDropdown.Item>
                        <NavDropdown.Item onClick={()=>this.setBoard(this.state.players,"CS")}>CS </NavDropdown.Item>
                        <NavDropdown.Item onClick={()=>this.setBoard(this.state.players,"Gold")}>Gold </NavDropdown.Item>
                        <NavDropdown.Item onClick={()=>this.setBoard(this.state.players,"Ability Uses")}>Ability Uses </NavDropdown.Item>
                        <NavDropdown.Item onClick={()=>this.setBoard(this.state.players,"Contorl Wards Bought")}>Contorl Wards Bought</NavDropdown.Item>
                        <NavDropdown.Item onClick={()=>this.setBoard(this.state.players,"Dodged Skill Shots")}>Dodged Skill Shots</NavDropdown.Item>
                        <NavDropdown.Item onClick={()=>this.setBoard(this.state.players,"Enemy CC")}>Enemy CC</NavDropdown.Item>
                        <NavDropdown.Item onClick={()=>this.setBoard(this.state.players,"Lane Minions at 10")}>Lane Minions at 10</NavDropdown.Item>
                        <NavDropdown.Item onClick={()=>this.setBoard(this.state.players,"Peak CS")}>Peak CS</NavDropdown.Item>
                        <NavDropdown.Item onClick={()=>this.setBoard(this.state.players,"Peak Kill Lead")}>Peak Kill Lead</NavDropdown.Item>
                        <NavDropdown.Item onClick={()=>this.setBoard(this.state.players,"Pings")}>Pings</NavDropdown.Item>
                        <NavDropdown.Item onClick={()=>this.setBoard(this.state.players,"Shield on Teamates")}>Shield on Teamates</NavDropdown.Item>
                        <NavDropdown.Item onClick={()=>this.setBoard(this.state.players,"Heal on Teamates")}>Heal on Teamates</NavDropdown.Item>
                        <NavDropdown.Item onClick={()=>this.setBoard(this.state.players,"Solo Kills")}>Solo Kills</NavDropdown.Item>
                        <NavDropdown.Item onClick={()=>this.setBoard(this.state.players,"Turret Plates")}>Turret Plates</NavDropdown.Item>
                        <NavDropdown.Item onClick={()=>this.setBoard(this.state.players,"Hit Skill Shots")}>Hit Skill Shots</NavDropdown.Item>
                        <NavDropdown.Item onClick={()=>this.setBoard(this.state.players,"Jungle Monsters Killed")}>Jungle Monsters Killed</NavDropdown.Item>
                    </NavDropdown>
                    <Nav.Link className="px-5" style={{background:"rgba(20,20,20,0.5)",width:"50%"}} onClick={()=>this.toggleOrder()}><span style={{marginLeft:"40%",marginRight:"auto"}}>{this.state.ord}</span></Nav.Link>
                </Nav>
                    <Card style={{background:"rgba(30,200,200,0.5)",color:'white'}}>
                        <Card.Body style={{fontSize:"129%"}} > 
                            {y}
                        </Card.Body>
                    </Card>
        </>

        this.setState({board:x})
    }

    toggleOrder(){
        let order = !this.state.inOrder;
        let ords = order ? "Asc" :  "Desc"
        this.setState({inOrder:order, ord:ords})
        this.setBoard(this.state.players,this.state.cur)
    }
        

    render(){
        return <>{this.state.board}</>
    }
    
      
} export default LeaderBoard 