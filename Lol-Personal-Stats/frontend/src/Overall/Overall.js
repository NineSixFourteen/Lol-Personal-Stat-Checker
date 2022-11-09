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
import CompareStats from './comps/CompareStats';
import StatsPanel from './comps/StatsPanel';

class Overall extends React.Component {

    constructor (props){
        super(props);
        this.state = {
            overall: "",
            average: "",
            compare: ""
          };
    }

    componentDidMount() {
        this.getOverall();
    }

    async getOverall(){
        const overall = await fetch("/pre/Pos");
        const overBody = await overall.json();
        const average = await fetch("/pre/averagePos");
        const averPBody = await average.json();
        this.setState({
            overall : <StatsPanel items={overBody}  places={0} cur={2} unit={"Game"} units="Games" heading="Overall Stats" /> ,
            average : <StatsPanel items={averPBody} places={2} cur={2} unit={"Game"} units="Games" heading="Average Stats" />
        })
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
                            {this.state.overall}
                        </Row>
                        <Row className = "px-4 my-5">
                            {this.state.average}
                        </Row>
                        <Row className = "px-4 my-5">
                           <CompareStats/>
                        </Row>
                    </Container>
            </header>
          </div>
        )
    }
} export default Overall;