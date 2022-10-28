import Container from 'react-bootstrap/Container';
import Nav from 'react-bootstrap/Nav';
import Navbar from 'react-bootstrap/Navbar';
import Button from 'react-bootstrap/Button';
import Card from 'react-bootstrap/Card';
import Row from 'react-bootstrap/Row';
import Col from 'react-bootstrap/Col';
import React from 'react';
import stinger from './stinger.jpg'
import team from './team.jpg'
import overall from './overall.jpg'
import logo from './logo.png'
import "bootstrap/dist/css/bootstrap.min.css"
class App extends React.Component {

state = {
    text: (
        <span style={{fontSize:'130%'}}>
        This site was made to add a front end to the api I built using Java Spring and MySql. <br></br>
        The MYSQL database I am using have information stored about my League Of Legends games 
        I split the information for each game into 4 Tables to see what each table stores see &nbsp; 
        <a href = "https://github.com/NineSixFourteen/Lol-Personal-Stat-Checker/tree/main/Lol-Personal-Stats/src/main/java/Stats/FetchSystem/Storage/Entitys">
        the classes</a> that corresponds to each table<br></br>
        If you wish to look at the source code of the project &nbsp; 
        <a href="https://github.com/NineSixFourteen/Lol-Personal-Stat-Checker/">Click Here</a> <br></br>
        </span>
    ),
    size : '100%',
    }
    
changeText = (text,size, colour) => {
    this.setState({ text,size}); 
} 

render() {
    const nothing = (<><br></br> <br></br><br></br> <br></br> </>);
    const something =  (
    <span style={{fontSize:'130%'}}>
        This site was made to add a front end to the api I built using Java Spring and MySql. <br></br>
        The MYSQL database I am using have information stored about my League Of Legends games 
        I split the information for each game into 4 Tables to see what each table stores see &nbsp; 
        <a href = "https://github.com/NineSixFourteen/Lol-Personal-Stat-Checker/tree/main/Lol-Personal-Stats/src/main/java/Stats/FetchSystem/Storage/Entitys">
        the classes</a> that corresponds to each table<br></br>
        If you wish to look at the source code of the project &nbsp; 
        <a href="https://github.com/NineSixFourteen/Lol-Personal-Stat-Checker/">Click Here</a> <br></br>
        </span>
    );
    return (
        <div className="App">
          <header >
            <Navbar bg="dark" variant="dark" >
            <img
              alt=""
              src={logo}
              width="300"
              height="60"
            />
            <Container>
                <Navbar.Toggle aria-controls="basic-navbar-nav" />
                <Nav style={{marginLeft:'25%'}}>
                    <Nav.Link style={{color:'Violet', fontWeight:'300'}} href="#home"><h2>Overall</h2></Nav.Link>
                    <Nav.Link style={{color:'Violet', fontWeight:'300'}} href="#features"><h2>Match</h2></Nav.Link>
                    <Nav.Link style={{color:'Violet', fontWeight:'300'}} href="#pricing"><h2>Player</h2></Nav.Link>
                </Nav>
                </Container>
            </Navbar>
            <Container fluid>
            <Row className = "px-4 my-5"> 
                <Card style={{width:this.state.size}}border='warning'>
                    <Card.Header border='dark'><span style={{fontSize:'150%',fontWeight:'700'}}> About This Site </span>
                    <Nav variant="tabs" defaultActiveKey="#first">
                        <Nav.Item>
                            <Nav.Link onClick={()=>this.changeText(something,'100%')}>Show</Nav.Link>
                        </Nav.Item>
                        <Nav.Item>
                            <Nav.Link onClick={()=>this.changeText(nothing,'15%')}>Hide</Nav.Link>
                        </Nav.Item>
                        </Nav>
                    </Card.Header>
                    <Card.Body> 
                        {this.state.text}
                    </Card.Body>
                </Card>
            </Row>
            <Row className = "px-4 my-5">       
                <Col  >
                <Card border='warning' style={{ width: "80%", cursor:'pointer'}} onClick={() => alert("Hello from 1")}>
                    <Card.Img variant="top" src={overall} />
                    <Card.Body>
                    <Card.Title><h2>Overall Stats</h2></Card.Title>
                        <Card.Text>
                        <span style={{ fontWeight: '500', fontSize: '130%' }}>
                            The Overall Stats Page allows you to <br></br>
                            - Shows The Overall Stats For Every Record <br></br>
                            - Shows The Overall Stats For Every Position  <br></br>
                            - Shows The Overall Stats For Every Gamemode <br></br>
                            - Shows The Average Stats For Every Position <br></br>
                            - Shows The Average Stats For Every Gamemode<br></br>
                            </span>
                        </Card.Text>
                    </Card.Body>
                </Card>
            </Col>
            <Col  >
                <Card border='warning' style={{ width: "80%",cursor:'pointer'}}  onClick={() => alert("Hello from 2")}>
                    <Card.Img fluid variant="top" src={team} />
                    <Card.Body>
                    <Card.Title><h2>Match Stats</h2></Card.Title>
                    <Card.Text >
                        <span style={{ fontWeight: '500', fontSize: '130%' }}>
                        The Match Stats Page allows you to <br></br>
                        - Search for a match<br></br>
                        - View each players overall stats for that game <br></br>
                        - View each players stats at the intervals of<br></br>
                            - 10 Minutes , 15 Minutes<br></br>
                            - 20 Minutes , 25 Minutes<br></br>
                            - 30 Minutes<br></br>
                        </span>
                    </Card.Text>
                    </Card.Body>
                </Card>
            </Col>
            <Col >
                <Card border='warning' style={{ width: "80%",cursor:'pointer'}}   onClick={() => alert("Hello from here")}>
                    <Card.Img variant="top" src={stinger} />
                    <Card.Body>
                    <Card.Title><h2>Player Stats</h2></Card.Title>
                    <Card.Text>
                        <span style={{ fontWeight: '500', fontSize: '130%' }}>
                        The Players Stats Page allows you to <br></br>
                        - Search For A Player <br></br>
                        - View Players Match History <br></br>
                        - View Players Overall Stats <br></br>
                        - View Players Average Stats<br></br>
                        - View Players Average Stats For Each Position<br></br>
                        - View Players Team Mates Average Stats<br></br>
                        </span>
                    </Card.Text>
                    </Card.Body>
                </Card>
            </Col>
            </Row>
            <Row>
              <Card>
                <Card.Body>
                <span style={{ fontWeight: '500' }}>Assests Used </span> <br></br>
                <span style={{ fontWeight: '300' }}>Background : </span>
                    <a href = "https://www.uhdpaper.com/2022/04/star-guardian-valoran-city-lol-4k-8531h.html">
                        https://www.uhdpaper.com/2022/04/star-guardian-valoran-city-lol-4k-8531h.html
                    </a> <br></br>
                    <span style={{ fontWeight: '300' }}>Logo Generated : </span>
                    <a href = "https://www.adobe.com/express/create/logo">
                            https://www.adobe.com/express/create/logo
                    </a> <br></br>
                    <span style={{ fontWeight: '300' }}>Overall Image : </span> 
                    <a href = "https://www.uhdpaper.com/2022/04/glorious-crimson-fiora-skin-4k-8k-7741h.html">
                            https://www.uhdpaper.com/2022/04/glorious-crimson-fiora-skin-4k-8k-7741h.html
                    </a> <br></br>
                    <span style={{ fontWeight: '300' }}>Team Image : </span>
                    <a href = "https://www.uhdpaper.com/2022/05/lol-wild-rift-warwick-jinx-vex-4k-8631i.html">
                        https://www.uhdpaper.com/2022/05/lol-wild-rift-warwick-jinx-vex-4k-8631i.html
                    </a> <br></br>
                    <span style={{ fontWeight: '300' }}>Player Image : </span>
                    <a href = "https://www.uhdpaper.com/2021/11/ziggs-heimerdinger-bee-skin-4k-8k-5241f.html">
                            https://www.uhdpaper.com/2021/11/ziggs-heimerdinger-bee-skin-4k-8k-5241f.html
                    </a>
                </Card.Body>
            </Card>
            </Row>
          </Container>
          </header>
        </div>
    );
  }
}
export default App;