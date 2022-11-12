import React from "react";
import Container from "react-bootstrap/Container";
import Navbar from "react-bootstrap/Navbar";
import Nav from "react-bootstrap/Nav";
import logo from "../photos/logo.png";
import Row from "react-bootstrap/Row";
import Col from "react-bootstrap/Col";
import Card from "react-bootstrap/Card";
import Collapse from "react-bootstrap/Collapse";

class GetPanel extends React.Component{

    constructor (props){
        super(props);
        this.state = {
            body: <h1>re</h1>,
            show: true   
          };
    }

    flip(bool){
        let x = !bool
        this.setState({show:x})
    }

    render(){
        return <>
                <Card style={{background:'rgba(50,50,50,0.5)'}}>
                    <Card.Header onClick={()=>this.flip(this.state.show)} style={{background:"rgba(71, 17, 166,0.3)", marginLeft:'auto',marginRight:'auto',fontSize:'200%',fontWeight:'600',color:'tan',textShadow:'1px 0 black'}}>
                        Get Panel
                    </Card.Header>
                    <Card.Body className="px-4">
                    <Collapse in={this.state.show}>
                        <div id="example-collapse-text">
                            <Nav bg = "dark" style={{fontSize:"115%",background:"rgba(0,10,10,0.8)"}}>
                                <Nav.Link style={{width:"30%",background:"rgba(20,20,20,0.5)", fontSize:"150%"}} onClick={()=>this.setCur(0)}>Get Player Matches</Nav.Link>
                                <Nav.Link style={{width:"35%",background:"rgba(20,20,20,0.5)", fontSize:"150%"}} onClick={()=>this.setCur(1)}>Get Player Top Champs</Nav.Link>
                                <Nav.Link style={{width:"35%",background:"rgba(20,20,20,0.5)", fontSize:"150%"}} onClick={()=>this.setCur(1)}>Get Player Champs played</Nav.Link>
                                <Nav.Link style={{width:"30%",background:"rgba(20,20,20,0.5)", fontSize:"150%"}} onClick={()=>this.setCur(1)}>Get Match</Nav.Link>
                                <Nav.Link style={{width:"35%",background:"rgba(20,20,20,0.5)", fontSize:"150%"}} onClick={()=>this.setCur(1)}>Get Average Stats for Champ</Nav.Link>
                                <Nav.Link style={{width:"35%",background:"rgba(20,20,20,0.5)", fontSize:"150%"}} onClick={()=>this.setCur(1)}>Get Average Stats for Positions</Nav.Link>
                                <Nav.Link style={{width:"30%",background:"rgba(20,20,20,0.5)", fontSize:"150%"}} onClick={()=>this.setCur(1)}>Get Average Teamates</Nav.Link>
                                <Nav.Link style={{width:"35%",background:"rgba(20,20,20,0.5)", fontSize:"150%"}} onClick={()=>this.setCur(1)}>Get Average Stats w/fitlers</Nav.Link>
                                <Nav.Link style={{width:"35%",background:"rgba(20,20,20,0.5)", fontSize:"150%"}} onClick={()=>this.setCur(1)}>Get Average Team w/fitlers</Nav.Link>
                            </Nav>
                            {this.state.body}
                        </div>
                    </Collapse>
                    </Card.Body>
                </Card>
            </>
    }

} export default GetPanel;
   
   
