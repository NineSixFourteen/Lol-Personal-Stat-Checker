import React from "react";
import Card from 'react-bootstrap/Card';
import Row from 'react-bootstrap/Row';
import Col from 'react-bootstrap/Col';
import Collapse from "react-bootstrap/Collapse";
import Nav from "react-bootstrap/Nav";
import Form from "react-bootstrap/Form"
import Button from "react-bootstrap/Button";
import Container from "react-bootstrap/esm/Container";
import CompareT from "./CompareT";

class CompareStats extends React.Component{

    constructor (props){
        super(props);
        this.state = {
            body: "",
            name: "",
            champ: "",
            pos: [true,true,true,true,true,true],
            gm:  [true,true,true,true,true,true],
            show: true
          };
    }

    display(){
        let y = (
            <Row className="mx-2">
                <Col>
                    <CompareT side={true} player={this.state.name} champ={this.state.champ} pos={this.state.pos} gm={this.state.gm} />
                </Col>
                <Col>
                    <CompareT side={false} player={this.state.name} champ={this.state.champ} pos={this.state.pos} gm={this.state.gm} />
                </Col>
            </Row>
        )
        this.setState({body:y})
    }

    flop(bool){
        let x = !bool
        this.setState({show:x})
    }

    flip(num){
        let x = [];
        let pos = this.state.pos
        if(num == 0){
            if(this.state.pos[0]){
                x = [false,false,false,false,false,false]
            } else {
                x = [true,true,true,true,true,true]
            }
        }else {
            let i = 1;
            x = [false]
            while(i < 6 ){
                if(i == num){
                    x.push(!pos[i])
                }else{
                    x.push(pos[i])
                }
                i++;
            }
        }
        this.setState({pos:x})
    }
    
    flip2(num){
        let x = [];
        let gm = this.state.gm
        if(num == 0){
            if(this.state.gm[0]){
                x = [false,false,false,false,false,false]
            } else {
                x = [true,true,true,true,true,true]
            }
        }else {
            let i = 1;
            x = [false]
            while(i < 6){
                if(i == num){
                    x.push(!gm[i])
                }else{
                    x.push(gm[i])
                }
                i++;
            }
        }
        this.setState({gm:x})
    }

    render(){
        return <Card style={{background:'rgba(50,50,50,0.5)'}}>
        <Card.Header onClick={()=>this.flop(this.state.show)} style={{background:"rgba(71, 17, 166,0.3)", marginLeft:'auto',marginRight:'auto',fontSize:'200%',fontWeight:'600',color:'tan',textShadow:'1px 0 black'}}>
            Compare Team
        </Card.Header>
        <Card.Body className="px-4">
        <Collapse in={this.state.show}>
            <div id="example-collapse-text">
                <Container>
                <Form>
                    <Form.Group as={Row} className="mb-3" controlId="PlayerName">
                        <Form.Label column sm={2}>
                            <span style={{color:"white", fontSize:"150%"}}> Player : </span>
                        </Form.Label>
                        <Form.Control column style={{width:"60%"}} placeholder="Enter player name"
                            onChange={(e) => this.setState({name: e.target.value})} />
                    </Form.Group>
                    <Form.Group as={Row} className="mb-3" controlId="ChampionName">
                        <Form.Label column sm={2}>
                            <span style={{color:"white", fontSize:"150%"}}> Champion : </span>
                        </Form.Label>
                        <Form.Control column style={{width:"60%"}} placeholder="Enter champion name"
                            onChange={(e) => this.setState({champ: e.target.value})} />
                    </Form.Group>
                    <Form.Group as={Row} style={{color:"white"}}>
                        <Form.Label column sm={2}>
                            <span style={{color:"white", fontSize:"150%"}}> Position : </span>
                        </Form.Label>
                        <Col style={{marginTop:"1.2%"}}>
                            <Form.Check inline type={'checkbox'} label={'Top'} checked={this.state.pos[1]}  onChange={() => {this.flip(1)} }/>
                            <Form.Check inline style={{marginLeft:"0.8%"}} type={'checkbox'} label={'Jungle'} checked={this.state.pos[2]} onChange={() => {this.flip(2)} }/>
                            <Form.Check inline type={'checkbox'} label={'Mid'} checked={this.state.pos[3]} onChange={() => {this.flip(3)} }/>
                            <Form.Check inline style={{marginLeft:"1.7%"}} type={'checkbox'} label={'Adc'} checked={this.state.pos[4]} onChange={() => {this.flip(4)} }/>
                            <Form.Check inline style={{marginLeft:"2.2%"}} type={'checkbox'} label={'Supp'}   checked={this.state.pos[5]} onChange={() => {this.flip(5)} }/>
                            <Form.Check inline style={{marginLeft:"0.7%"}} type={'checkbox'} label={'All'} checked={this.state.pos[0]} onChange={() => {this.flip(0)} }/>
                        </Col>
                    </Form.Group>
                    <Form.Group as={Row} style={{ color:"white"}}>
                        <Form.Label column sm={2}>
                            <span style={{color:"white", fontSize:"150%"}}> Gamemode : </span>
                        </Form.Label>
                        <Col style={{marginTop:"1.2%"}}>
                            <Form.Check inline type={'checkbox'} label={'FLEX'}  checked={this.state.gm[1]} onChange={() => {this.flip2(1)} } />
                            <Form.Check inline type={'checkbox'} label={'SOLO'}  checked={this.state.gm[2]} onChange={() => {this.flip2(2)} } />
                            <Form.Check inline style={{marginLeft:"0.7%"}} type={'checkbox'} label={'BLIND'} checked={this.state.gm[3]} onChange={() => {this.flip2(3)} } />
                            <Form.Check inline type={'checkbox'} label={'DRAFT'} checked={this.state.gm[4]} onChange={() => {this.flip2(4)} } />
                            <Form.Check inline type={'checkbox'} label={'ARAM'} checked={this.state.gm[5]} onChange={() => {this.flip2(5)} } />
                            <Form.Check inline type={'checkbox'} label={'All'}  checked={this.state.gm[0]} onChange={() => {this.flip2(0)} } />
                        </Col>
                    </Form.Group>
                    <Button className="my-3" style={{width:"100%"}} onClick={() => {this.display()}}>
                        Go
                    </Button>
                </Form>
                    {this.state.body}
                </Container>
            </div>
        </Collapse>
        </Card.Body>
    </Card>
    }

} export default CompareStats