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
import Last10 from './Comps/Last10';
import PlayerStatsHolder from './Comps/PlayerStatsHolder';
class Match extends React.Component {

    constructor (props){
        super(props);
        this.state = {
            id: "",
            id2: "",
            last10: "",
            stats:""
          };
    }

    async getPlayer(id){
        this.setState({
            id: "",
            id2: "",
            last10: "",
            stats:""
        })
        const last10 = await fetch('/get/Player/last10?name=' + id);
        const lastBody = await last10.json();
        const average = await fetch('/average/PlayerPosition?name=' + id);
        const averBody = await average.json();
        if(lastBody.length == 0){
            //TODO Player Not Found
            this.setState({last10:
                (
                    <h1>Player Not Found </h1>
                )
            })
        } else {
        console.log(lastBody)
        console.log(averBody)
        this.setState({last10:
        <Row>
            <Col><Last10 Last10={lastBody} player={id} /></Col>
        </Row>})
        this.setState({stats:
            <Row>
                <Col><PlayerStatsHolder stats={averBody} player={id} /></Col>
            </Row>})
        }
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
                                {this.state.stats}
                        </Row> 
                </Container>
        </header>
        </div>
        )
    }
} export default Match;