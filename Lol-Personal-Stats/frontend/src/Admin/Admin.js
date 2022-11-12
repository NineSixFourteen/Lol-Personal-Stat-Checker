import React from "react";
import Container from "react-bootstrap/Container";
import Navbar from "react-bootstrap/Navbar";
import Nav from "react-bootstrap/Nav";
import logo from "../photos/logo.png";
import Row from "react-bootstrap/Row";
import Col from "react-bootstrap/Col";
import AddPanel from "./AddPanel";
import DeletePanel from "./DeletePanel";
import GetPanel from "./GetPanel";
import OtherPanel from "./OtherPanel";


class Admin extends React.Component{

    render(){
        return <>
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
                <Nav.Link style={{color:'#cf663c', fontWeight:'300'}} href="admin"> <h2> Admin</h2></Nav.Link>
                </Container>
            </Navbar>
            <Container>
            <Row className = "my-5 px-4"> 
                    <OtherPanel/>
                </Row>
                <Row className = "my-5 px-4"> 
                    <AddPanel/>
                </Row>
                <Row className = "my-5 px-4"> 
                    <DeletePanel/>
                </Row>
                <Row className = "my-5 px-4"> 
                    <GetPanel />
                </Row>
            </Container>
        </>
    }

} export default Admin;