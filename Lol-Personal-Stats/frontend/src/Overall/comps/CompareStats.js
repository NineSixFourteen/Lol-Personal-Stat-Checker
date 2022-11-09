import React from "react";
import Card from 'react-bootstrap/Card';
import Row from 'react-bootstrap/Row';
import Col from 'react-bootstrap/Col';
import Collapse from "react-bootstrap/Collapse";
import Nav from "react-bootstrap/Nav";
import Form from "react-bootstrap/Form"
import Container from "react-bootstrap/esm/Container";
import Compare from "./Compare";

class CompareStats extends React.Component{

    constructor (props){
        super(props);
        this.state = {
            body: "asda",
            show: true,
            name: "",
            champ: "",
            pos: "",
          };
    }
    
    flip(bool){
        let x = !bool
        this.setState({show:x})
    }

    render(){
        return <Card style={{background:'rgba(50,50,50,0.5)'}}>
                <Card.Header onClick={()=>this.flip(this.state.show)} style={{background:"rgba(71, 17, 166,0.3)", marginLeft:'auto',marginRight:'auto',fontSize:'200%',fontWeight:'600',color:'tan',textShadow:'1px 0 black'}}>
                    Compare
                </Card.Header>
                <Card.Body className="px-4">
                <Collapse in={this.state.show}>
                    <div id="example-collapse-text">
                        <Container>
                            <Row className="mx-2">
                                <Col>
                                    <Compare/>
                                </Col>
                                <Col>
                                    <Compare/>
                                </Col>
                            </Row>
                        </Container>
                    </div>
                </Collapse>
                </Card.Body>
            </Card>
    }

} export default CompareStats