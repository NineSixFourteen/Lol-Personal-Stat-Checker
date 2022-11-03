import React from 'react';
import Card from 'react-bootstrap/Card';
import Row from 'react-bootstrap/Row';
import Form from 'react-bootstrap/Form';
import Button from 'react-bootstrap/Button';
import Col from 'react-bootstrap/Col';
import Widges from './Widges';
import "bootstrap/dist/css/bootstrap.min.css"
import ButtonGroup from 'react-bootstrap/esm/ButtonGroup';

class Match extends React.Component {

    constructor (props){
        super(props);
        this.state = {
            players: props.players,
            stats: "",
            boards: [true],
            board: ""
          };
      }

    componentDidMount() {
        this.makeStats(this.state.players,this.state.boards)
    }

    makeStats(players,bools){
        console.log(bools)
        let x = []
        bools.forEach(
            bool => {
                if(bool){x.push(<Row><Col><Widges players={players}></Widges></Col></Row>)} 
                else {x.push(<Row><Col><Widges players={players}></Widges></Col> <Col><Widges players={players}></Widges></Col></Row>)}
            }
        )
        this.setState({stats : x})
    }

    setRows(num){
        console.log(num)
        let x = []
        num = parseInt(num)
        let y = Array.apply(0, Array(num));
        y.map((z, i) =>
            x[i] = false,
        )
        this.setState({boards:x})
        this.setButtons(num)
        this.makeStats(this.state.players,x)
    } 

    setButtons(num){
        let x = []
        let y = Array.apply(0, Array(num));
        y.map((z, i) =>
            x.push(<><ButtonGroup>
                <Button onClick={() => this.flipSwitch(i, true)}>
                    One 
                </Button>
                <Button onClick={() => this.flipSwitch(i, false)}>
                    two 
                </Button>
            </ButtonGroup><br></br></>)
        )
        this.setState({buttons:x})
    }

    flipSwitch(ind, to){
        let x = []
        let i = 0;
        this.state.boards.map(
            bool => {
                if(i == ind){
                    x[i++] = to
                } else{
                    x[i++] = bool
                }
            }
        )
        this.setState({boards:x})
        this.makeStats(this.state.players,x)
    }
      
    render(){
        return (
            <Card style={{backgroundColor:"rgba(200,200,200,0.5)"}}>
            <Card.Header>
                <Form>
                <Form.Select style={{width:"22%"}}
                onChange={(e) => {this.setRows(e.target.value == "How Many Rows would you like" ? 0 : e.target.value)}}
                >
                    <option>How Many Rows would you like</option>
                    <option value="1">1</option>
                    <option value="2">2</option>
                    <option value="3">3</option>
                </Form.Select>
                {this.state.buttons}
                </Form>
                
            </Card.Header>
            <Card.Body>
                {this.state.stats}
            </Card.Body>   
        </Card>   
        )
    }
    

} export default Match 