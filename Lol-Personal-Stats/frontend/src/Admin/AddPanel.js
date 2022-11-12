import React from "react";
import Container from "react-bootstrap/Container";
import Navbar from "react-bootstrap/Navbar";
import Nav from "react-bootstrap/Nav";
import logo from "../photos/logo.png";
import Row from "react-bootstrap/Row";
import Col from "react-bootstrap/Col";
import Form from "react-bootstrap/Form"
import Card from "react-bootstrap/Card";
import Collapse from "react-bootstrap/Collapse";
import Button from "react-bootstrap/Button"
class AddPanel extends React.Component{

    constructor (props){
        super(props);
        this.state = {
            body: "",
            show: true,
            name: "",
            amount: "",
            match: ""
          };
    }

    flip(bool){
        let x = !bool
        this.setState({show:x})
    }

    setCur(num){
        switch (num){
            case 0 :
                this.setState({body: this.getMatch()})
                break;
            case 1 : 
                this.setState({body: this.getPlayer()})
                break;
        }
    }

    getPlayer(){
        return <Form>
                <Form.Group as={Row} className="my-3 mb-3" controlId="PlayerName">
                    <Form.Label column sm={2}>
                        <span style={{color:"white", fontSize:"150%"}}> Player : </span>
                    </Form.Label>
                    <Form.Control column style={{width:"60%", marginTop:"0.8%", height:"80%"}} placeholder="Enter player name"
                        onChange={(e) => this.setState({name: e.target.value})} />
                </Form.Group>
                <Form.Group as={Row} className="my-3 mb-3" controlId="amount">
                    <Form.Label column sm={2}>
                        <span style={{color:"white", fontSize:"150%"}}> Amount : </span>
                    </Form.Label>
                    <Form.Control column style={{width:"60%", marginTop:"0.8%", height:"80%"}} placeholder="Enter Amount of games"
                        onChange={(e) => this.setState({amount: e.target.value})} />   
                </Form.Group>
                <Button size="lg" onClick={()=>this.send(1)}> GO </Button>
                </Form>
    }

    getMatch(){
        return <Form>
                <Form.Group as={Row} className="my-3 mb-3" controlId="matchName">
                    <Form.Label column sm={2}>
                        <span style={{color:"white", fontSize:"150%"}}> Match ID : </span>
                    </Form.Label>
                    <Form.Control column style={{width:"60%", marginTop:"0.8%", height:"80%"}} placeholder="Enter Match name"
                        onChange={(e) => this.setState({match: e.target.value})} />
                </Form.Group>
                <Button size="lg" onClick={()=>this.send(0)}> GO </Button>
                </Form>
    }

    send(num){
        switch(num){
            case 0: 
                fetch("/add/Match?id=" + this.state.match);
                break;
            case 1: 
                fetch("add/Player?name=" + this.state.name + "&amount=" + this.state.amount);
        }
    }


    render(){
        return <>
                <Card style={{background:'rgba(50,50,50,0.5)'}}>
                    <Card.Header onClick={()=>this.flip(this.state.show)} style={{background:"rgba(71, 17, 166,0.3)", marginLeft:'auto',marginRight:'auto',fontSize:'200%',fontWeight:'600',color:'tan',textShadow:'1px 0 black'}}>
                        Add Panel
                    </Card.Header>
                    <Card.Body className="px-4">
                    <Collapse in={this.state.show}>
                        <div id="example-collapse-text">
                        <Nav bg = "dark" style={{fontSize:"115%",background:"rgba(0,10,10,0.8)"}}>
                            <Nav.Link style={{background:"rgba(20,20,20,0.5)", fontSize:"150%"}} onClick={()=>this.setCur(0)}>Add Match</Nav.Link>
                            <Nav.Link style={{background:"rgba(20,20,20,0.5)", fontSize:"150%"}} onClick={()=>this.setCur(1)}>Add Player</Nav.Link>
                        </Nav>
                            {this.state.body}
                        </div>
                    </Collapse>
                    </Card.Body>
                </Card>
            </>
    }

} export default AddPanel;
   
   
