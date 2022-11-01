import React from 'react';
import Container from 'react-bootstrap/Container';
import Nav from 'react-bootstrap/Nav';
import Navbar from 'react-bootstrap/Navbar';
import Card from 'react-bootstrap/Card';
import Row from 'react-bootstrap/Row';
import Form from 'react-bootstrap/Form';
import Button from 'react-bootstrap/Button';
import Col from 'react-bootstrap/Col';
import logo from '../logo.png';
import Stats from './Stats';
import LeaderBoard from './LeaderBoard';
import './match.css'
import "bootstrap/dist/css/bootstrap.min.css"
import PlayerTop from './PlayerTop';

class Match extends React.Component {
    constructor (props){
        super(props);
        this.state = {
            id: "",
            id2: "",
            matchHistroy: null,
            players: ["","","","",""],
            row: [],
            tabs: null,
            current: 0,
            stats: null
          };
      }

    async getMatch(id) {
        this.setState({id:"",id2:"",mathHistory:null,players:[],row:[]})
        const response = await fetch('/get/Match?id=' + id);
        const body = await response.json();
        this.setState({id2:this.state.id ,matchHistroy: body.matchHistroy, players: body.players})
        this.makeBody(body.players)
        this.makeStats(body.players,1)
    }

    makeBody(players){
        let foo = [0,1,2,3,4] 
        let x = []
        foo.map(e => {
            x[e] = 
                    (
                        <Row className = "my-1" >
                            <Col className = "">
                                <PlayerTop player={players[e]}></PlayerTop>
                            </Col>
                            <Col>
                                <PlayerTop player={players[e+5]}></PlayerTop>
                            </Col>
                        </Row>
                    )
                })
        this.setState({row : x})
    }

    makeStats(players){
        this.setState({stats : (
            <Row>
                <Col>
                <Stats players={players}></Stats>
                </Col>
                <Col>
                <LeaderBoard players={players}/>
                </Col>
            </Row>
        )})
    }

    render() {
        const players = this.state.players;
        console.log(players)
        return (
            <div className="App">
                <header >
            <Navbar bg="dark" variant="dark" >
            <Nav.Link  href="home">
            <img
              style={{cursor:'pointer'}}
              alt=""
              src={logo}
              width="300"
              height="60"
            />
            </Nav.Link>
            <Container>
                <Navbar.Toggle aria-controls="basic-navbar-nav" />
                <Nav style={{marginLeft:'25%'}}>
                    <Nav.Link style={{color:'#cf663c', fontWeight:'300'}} href="#home"><h2>Overall</h2></Nav.Link>
                    <Nav.Link style={{color:'#cf663c', fontWeight:'300'}} href="#features"><h2>Match</h2></Nav.Link>
                    <Nav.Link style={{color:'#cf663c', fontWeight:'300'}} href="#pricing"><h2>Player</h2></Nav.Link>
                </Nav>
            </Container>
            </Navbar>
            <Container >
                <Row className = "px-4 my-5"> 
                    <Card border='warning'>
                        <Card.Header style={{marginLeft:'auto',marginRight:'auto',fontSize:'200%',fontWeight:'600',color:'tan',textShadow:'1px 0 black'}}>
                            Search For Match
                        </Card.Header>
                        <Card.Body >
                        <Form>
                            <Form.Group className="mb-3" controlId="formBasicEmail">
                                <Form.Control type="matchID" placeholder="Enter Match ID" 
                                 onChange={e => this.setState({ id: e.target.value })}
                                />
                                <Form.Text className="text-muted">
                                    Example : EUW1_6115488981 + {this.state.cur}
                                </Form.Text>
                            </Form.Group>
                        </Form>
                        <Button variant="primary" type="submit" 
                        onClick={ () => {
                            this.getMatch(this.state.id);
                        }}>
                            Search
                        </Button>
                        </Card.Body>
                    </Card>
                </Row>
                <Row>
                    <Card style={{backgroundColor:"rgba(200,200,200,0.5)"}}>
                        <Card.Body>
                            {this.state.row}  
                        </Card.Body>   
                    </Card>   
                </Row>
                <Row className = "my-5"> 
                    <Card style={{backgroundColor:"rgba(200,200,200,0.5)"}}>
                        <Card.Body>
                        {this.state.stats}
                        </Card.Body>   
                    </Card>   
                </Row>
            </Container>
            </header></div>
        );
    }
} export default Match;