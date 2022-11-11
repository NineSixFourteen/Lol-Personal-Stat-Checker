import React from "react";
import Container from "react-bootstrap/Container";
import Navbar from "react-bootstrap/Navbar";
import Nav from "react-bootstrap/Nav";
import logo from "../photos/logo.png";
import Row from "react-bootstrap/Row";
import Col from "react-bootstrap/Col";
import Card from "react-bootstrap/Card";
import Collapse from "react-bootstrap/Collapse";

class OtherPanel extends React.Component{

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
                            {this.state.body}
                        </div>
                    </Collapse>
                    </Card.Body>
                </Card>
            </>
    }

} export default OtherPanel;
   
   
