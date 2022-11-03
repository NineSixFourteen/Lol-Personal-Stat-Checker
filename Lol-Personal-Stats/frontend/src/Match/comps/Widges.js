import React from 'react';
import Nav from 'react-bootstrap/Nav';
import Col from 'react-bootstrap/Col';
import Stats from './Stats';
import LeaderBoard from './LeaderBoard';
import "bootstrap/dist/css/bootstrap.min.css"

class Widges extends React.Component{

    constructor (props){
        super(props);
        this.state = {
            players: props.players,
            body1: "",
            body2: "",
            bool: true
          };
      }

    componentDidMount() {
        this.makeBody(this.state.players,this.state.bool)
    }

    setBool(bool){
        this.setState({bool:bool})
        this.makeBody(this.state.players,bool)
    }

    makeBody(players,bool){
        let x = ""
        if(bool){
            x = <><Stats players={players}></Stats></>
        } else {
            x = <LeaderBoard players={players}></LeaderBoard>
        }
        let z = (
            <Col className='my-2'>
                <Nav variant="tabs" style={{background:"rgba(20,20,20,0.5)"}}>
                    <Nav.Link className="px-5" style={{background:"rgba(20,20,20,0.5)",width:"50%"}} onClick={()=>this.setBool(true)}><span style={{marginLeft:"40%",marginRight:"auto"}}>Stats</span></Nav.Link>
                    <Nav.Link className="px-5" style={{background:"rgba(20,20,20,0.5)",width:"50%"}} onClick={()=>this.setBool(false)}><span style={{marginLeft:"40%",marginRight:"auto"}}>LeaderBoard</span></Nav.Link>
                </Nav>
                {x}
            </Col>
            ) 
        this.setState({
            body1:z
        })
    }

    render(){
        return this.state.body1
    }

}export default Widges;