import React from "react";
import Container from "react-bootstrap/Container";
import Navbar from "react-bootstrap/Navbar";
import Nav from "react-bootstrap/Nav";
import logo from "../photos/logo.png";
import Row from "react-bootstrap/Row";
import Col from "react-bootstrap/Col";
import Card from "react-bootstrap/Card";
import Collapse from "react-bootstrap/Collapse";
import Button from "react-bootstrap/Button";

class OtherPanel extends React.Component{

    constructor (props){
        super(props);
        this.state = {
            show: true,
            server: false, 
            key : false
          };
    }

    async componentDidMount() {
        this.doStuff();
    }

    async doStuff(){
        let server = await fetch("/ping");
        console.log("ping")
        let x = await server.text().valueOf();
        let bool = x == "pong";
        this.setState({server: bool});
        let key = await fetch("add/test");
        let y = await key.text().valueOf();
        let bool2 = y == "Key is working";
        this.setState({key: bool2});
    }

    flip(bool){
        let x = !bool
        this.setState({show:x})
        this.doStuff();
    }

    render(){
        return <>
                <Card style={{background:'rgba(50,50,50,0.5)'}}>
                    <Card.Header onClick={()=>this.flip(this.state.show)} style={{background:"rgba(71, 17, 166,0.3)", marginLeft:'auto',marginRight:'auto',fontSize:'200%',fontWeight:'600',color:'tan',textShadow:'1px 0 black'}}>
                        Status Panel
                    </Card.Header>
                    <Card.Body className="px-4">
                    <Collapse in={this.state.show}>
                        <div id="example-collapse-text">
                            <Row>
                                <Col style={{color: this.state.server ? "Green" : "red"}}>
                                    <h1 style={{marginLeft:"40%"}}> SERVER </h1>
                                </Col>
                                <Col style={{color: this.state.key ? "Green" : "red"}}>
                                    <h1 style={{marginLeft:"40%"}}> Key </h1>
                                </Col>
                            </Row>
                            <Button onClick={() => this.doStuff()}> Update </Button>
                        </div>
                    </Collapse>
                    </Card.Body>
                </Card>
            </>
    }

} export default OtherPanel;
   
   
