import React from 'react';
import Container from 'react-bootstrap/Container';
import Nav from 'react-bootstrap/Nav';
import Navbar from 'react-bootstrap/Navbar';
import Card from 'react-bootstrap/Card';
import Row from 'react-bootstrap/Row';
import Form from 'react-bootstrap/Form';
import Button from 'react-bootstrap/Button';
import Col from 'react-bootstrap/Col';
import logo from '../photos/logo.png';
import "bootstrap/dist/css/bootstrap.min.css"
import MatchHistory from './Comps/MatchHistry';
import ChampStats from './Comps/ChampStats';
import StatsPanel from './Comps/StatsPanel';
import StatsRow from './Comps/StatsRow';

class Match extends React.Component {

    constructor (props){
        super(props);
        this.state = {
            id: "",
            id2: "",
            last10: "",
            champs: "",
            team: ""
          };
    }

    async getPlayer(id){
        this.setState({
            id: "",
            id2: "",
            last10: "",
            champs: "",
            team: ""
        })
        const histroy = await fetch('get/Player/matches?name=' + id);
        const histroyBody = await histroy.json();
        const topChamps = await fetch('/get/Champ/topChamps?name=' + id);
        const topChampBody = await topChamps.json();
        let x = this.fixObj(topChampBody)
        if(histroyBody.length == 0){
            //TODO Player Not Found
            this.setState({last10:
                (
                    <h1>Player Not Found </h1>
                )
            })
        } else {
        this.setState({last10:
        <Row>
            <Col><MatchHistory MatchHistory={histroyBody} player={id} /></Col>
        </Row>})
        this.setState({champs:
            <Row>
                <Col><ChampStats topChamps={x} player={id} /></Col>
            </Row>})
        this.setState({team:
            <StatsRow id={id} heading="Stats" />
        })
    }}


    fixObj(obj){
        let x = []
        for (const [key, value] of Object.entries(obj)) { 
            x.push({name: key, value: value})
        }     
        x.sort((y,z) => { if( y.value > z.value) return -1; return 1})
        return x;
    }
    
    render() {
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
                <Nav.Link style={{color:'#cf663c', fontWeight:'300'}} href="overall"><h2>Overall</h2></Nav.Link>
                <Nav.Link style={{color:'#cf663c', fontWeight:'300'}} href="match"><h2>Match</h2></Nav.Link>
                <Nav.Link style={{color:'#cf663c', fontWeight:'300'}} href="player"><h2>Player</h2></Nav.Link>
            </Nav>
        </Container>
        </Navbar>
        <Container>
            <Row className = "px-4 my-5"> 
                    <Card border='warning'>
                        <Card.Header style={{marginLeft:'auto',marginRight:'auto',fontSize:'200%',fontWeight:'600',color:'tan',textShadow:'1px 0 black'}}>
                            Search For Player
                        </Card.Header>
                        <Card.Body >
                        <Form>
                            <Form.Group className="mb-3" >
                                <Form.Control type="PlayerName" placeholder="Enter Player Name" 
                                 onChange={e => this.setState({ id: e.target.value })}
                                />
                            </Form.Group>
                        </Form>
                        <Button variant="primary"
                        onClick={ () => {
                            this.getPlayer(this.state.id);
                        }}>
                            Search
                        </Button>
                        </Card.Body>
                        </Card>
                        </Row>
                        <Row className = "px-4 my-5">
                                {this.state.last10}
                        </Row>
                        <Row className = "px-4 my-5">
                                {this.state.champs}
                        </Row> 
                        <Row className = "px-4 my-5">
                                {this.state.stats}
                        </Row> 
                        <Row className = "px-4 my-5">
                                {this.state.team}
                        </Row> 
                </Container>
        </header>
        </div>
        )
    }
} export default Match;