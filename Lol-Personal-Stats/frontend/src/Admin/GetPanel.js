import React from "react";
import Container from "react-bootstrap/Container";
import Navbar from "react-bootstrap/Navbar";
import Nav from "react-bootstrap/Nav";
import logo from "../photos/logo.png";
import Row from "react-bootstrap/Row";
import Col from "react-bootstrap/Col";
import Button from "react-bootstrap/Button"
import Form from "react-bootstrap/Form"
import Card from "react-bootstrap/Card";
import Collapse from "react-bootstrap/Collapse";
import ReactJson from "react-json-view";

class GetPanel extends React.Component{

    constructor (props){
        super(props);
        this.state = {
            body: <h1>re</h1>,
            show: true,
            player: "",
            champion: "",
            position: "",
            gameMode: "",
            team: "true",
            Oplayer : "",
            Ochampion: "",
            Oposition: "",
            OgameMpdes: "",
            match: "",
            amount: "0",
            filterType:"",
            filter: "",
            json: {}
          };
    }

    flip(bool){
        let x = !bool
        this.setState({show:x})
    }

    setCur(num){
        switch(num){
            case 0: this.getPlayerMatch(); break;
            case 1: this.getTopChamps();break;
            case 2: this.getPlayerChamps();break;
            case 3: this.getMatch();break;
            case 4: this.getAverageStatsChamp();break;
            case 5: this.getAverageStatsPos();break;
            case 6: this.getAverageTeamate();break;
            case 7: this.getAverageStastWfilter();break;
            case 8: this.getAverageTeamWfilter();break;
        }
    }

    getPlayerMatch(){
        let y = <Form>
                    <Form.Group as={Row} className="my-3 mb-3">
                        <Form.Label column sm={3}>
                            <span style={{color:"white", fontSize:"150%"}}> Player Name : </span>
                        </Form.Label>
                        <Form.Control column style={{width:"60%", marginTop:"0.8%", height:"80%"}} placeholder="Enter Player Name"
                            onChange={(e) => this.setState({player: e.target.value})} />
                    </Form.Group>
                    <Form.Group as={Row} className="my-3 mb-3" >
                        <Form.Label column sm={3}>
                            <span style={{color:"white", fontSize:"150%"}}> Filter Type : </span>
                        </Form.Label>
                        <Form.Select column style={{width:"60%", marginTop:"0.8%", height:"80%"}}
                            onChange={(e) => this.setState({filterType: e.target.value})}>
                                <option>Select Filter</option>
                                <option value="0">Champion Filter</option>
                                <option value="1">Position Filter</option>
                                <option value="2">Champion And Position Filter</option> 
                        </Form.Select>
                    </Form.Group>
                    <Form.Group as={Row} className="my-3 mb-3">
                        <Form.Label column sm={3}>
                            <span style={{color:"white", fontSize:"150%"}}> Filter : </span>
                        </Form.Label>
                        <Form.Control column style={{width:"60%", marginTop:"0.8%", height:"80%"}} placeholder="Enter Filter Info"
                            onChange={(e) => this.setState({filter: e.target.value})} />
                    </Form.Group>
                    <Button size="lg" onClick={()=>this.send(0)}> Search </Button>
                </Form>
        this.setState({body:y})
    }

    getTopChamps(){
        let y = <Form>
                    <Form.Group as={Row} className="my-3 mb-3">
                        <Form.Label column sm={3}>
                            <span style={{color:"white", fontSize:"150%"}}> Player Name : </span>
                        </Form.Label>
                        <Form.Control column style={{width:"60%", marginTop:"0.8%", height:"80%"}} placeholder="Enter Player Name"
                            onChange={(e) => this.setState({player: e.target.value})} />
                    </Form.Group>
                    <Button size="lg" onClick={()=>this.send(1)}> Search </Button>
                </Form>
        this.setState({body:y})
    }

    getPlayerChamps(){
        let y = <Form>
                    <Form.Group as={Row} className="my-3 mb-3">
                        <Form.Label column sm={3}>
                            <span style={{color:"white", fontSize:"150%"}}> Player Name : </span>
                        </Form.Label>
                        <Form.Control column style={{width:"60%", marginTop:"0.8%", height:"80%"}} placeholder="Enter Player Name"
                            onChange={(e) => this.setState({player: e.target.value})} />
                    </Form.Group>
                    <Button size="lg" onClick={()=>this.send(2)}> Search </Button>
                </Form>;
        this.setState({body:y})
    }

    getMatch(){
        let y = <Form>
                    <Form.Group as={Row} className="my-3 mb-3">
                        <Form.Label column sm={3}>
                            <span style={{color:"white", fontSize:"150%"}}> Match ID : </span>
                        </Form.Label>
                        <Form.Control column style={{width:"60%", marginTop:"0.8%", height:"80%"}} placeholder="Enter Match ID"
                            onChange={(e) => this.setState({match: e.target.value})} />
                    </Form.Group>
                    <Button size="lg" onClick={()=>this.send(3)}> Search </Button>
                </Form>;
        this.setState({body:y})
    }

    getAverageStatsChamp(){
        let y = <Form>
                    <Form.Group as={Row} className="my-3 mb-3">
                        <Form.Label column sm={3}>
                            <span style={{color:"white", fontSize:"150%"}}> Player Name : </span>
                        </Form.Label>
                        <Form.Control column style={{width:"60%", marginTop:"0.8%", height:"80%"}} placeholder="Enter Player Name"
                            onChange={(e) => this.setState({player: e.target.value})} />
                    </Form.Group>
                    <Form.Group as={Row} className="my-3 mb-3">
                        <Form.Label column sm={3}>
                            <span style={{color:"white", fontSize:"150%"}}> Champion Name : </span>
                        </Form.Label>
                        <Form.Control column style={{width:"60%", marginTop:"0.8%", height:"80%"}} placeholder="Enter Champion Name"
                            onChange={(e) => this.setState({champion: e.target.value})} />
                    </Form.Group>
                    <Button size="lg" onClick={()=>this.send(4)}> Search </Button>
                </Form>;
        this.setState({body:y})
    }

    getAverageStatsPos(){
        let y = <Form>
                    <Form.Group as={Row} className="my-3 mb-3">
                        <Form.Label column sm={3}>
                            <span style={{color:"white", fontSize:"150%"}}> Player Name : </span>
                        </Form.Label>
                        <Form.Control column style={{width:"60%", marginTop:"0.8%", height:"80%"}} placeholder="Enter Player Name"
                            onChange={(e) => this.setState({player: e.target.value})} />
                    </Form.Group>
                    <Button size="lg" onClick={()=>this.send(5)}> Search </Button>
                </Form>;
        this.setState({body:y})
    }

    getAverageTeamate(){
        let y = <Form>
                    <Form.Group as={Row} className="my-3 mb-3">
                        <Form.Label column sm={3}>
                            <span style={{color:"white", fontSize:"150%"}}> Player Name : </span>
                        </Form.Label>
                        <Form.Control column style={{width:"60%", marginTop:"0.8%", height:"80%"}} placeholder="Enter Player Name "
                            onChange={(e) => this.setState({player: e.target.value})} />
                    </Form.Group>
                    <Button size="lg" onClick={()=>this.send(6)}> Search </Button>
                </Form>;
        this.setState({body:y})
    }

    getAverageStastWfilter(){
        let y =  <Form>
                    <Form.Group as={Row} className="my-3 mb-3">
                        <Form.Label column sm={3}>
                            <span style={{color:"white", fontSize:"150%"}}>Player Name : </span>
                        </Form.Label>
                        <Form.Control column style={{width:"60%", marginTop:"0.8%", height:"80%"}} placeholder="Enter Player Name "
                            onChange={(e) => this.setState({player: e.target.value})} />
                    </Form.Group>
                    <Form.Group as={Row} className="my-3 mb-3">
                        <Form.Label column sm={3}>
                            <span style={{color:"white", fontSize:"150%"}}>Champion Name : </span>
                        </Form.Label>
                        <Form.Control column style={{width:"60%", marginTop:"0.8%", height:"80%"}} placeholder="Enter Champion Name "
                            onChange={(e) => this.setState({champion: e.target.value})} />
                    </Form.Group>
                    <Form.Group as={Row} className="my-3 mb-3">
                        <Form.Label column sm={3}>
                            <span style={{color:"white", fontSize:"150%"}}>Position : </span>
                        </Form.Label>
                        <Form.Control column style={{width:"60%", marginTop:"0.8%", height:"80%"}} placeholder="Enter Positions "
                            onChange={(e) => this.setState({position: e.target.value})} />
                    </Form.Group>
                    <Form.Group as={Row} className="my-3 mb-3">
                        <Form.Label column sm={3}>
                            <span style={{color:"white", fontSize:"150%"}}>Game Modes: </span>
                        </Form.Label>
                        <Form.Control column style={{width:"60%", marginTop:"0.8%", height:"80%"}} placeholder="Enter GameModes "
                            onChange={(e) => this.setState({gameMode: e.target.value})} />
                    </Form.Group>
                    <Button size="lg" onClick={()=>this.send(7)}> Search </Button>
                </Form>;
        this.setState({body:y})
    }

    getAverageTeamWfilter(){
        let y = <Form>
                    <Form.Group as={Row} className="my-3 mb-3">
                        <Form.Label column sm={3}>
                            <span style={{color:"white", fontSize:"150%"}}>Player Name : </span>
                        </Form.Label>
                        <Form.Control column style={{width:"60%", marginTop:"0.8%", height:"80%"}} placeholder="Enter Player Name "
                            onChange={(e) => this.setState({player: e.target.value})} />
                    </Form.Group>
                    <Form.Group as={Row} className="my-3 mb-3">
                        <Form.Label column sm={3}>
                            <span style={{color:"white", fontSize:"150%"}}>Champion Name : </span>
                        </Form.Label>
                        <Form.Control column style={{width:"60%", marginTop:"0.8%", height:"80%"}} placeholder="Enter Champion Name "
                            onChange={(e) => this.setState({champion: e.target.value})} />
                    </Form.Group>
                    <Form.Group as={Row} className="my-3 mb-3">
                        <Form.Label column sm={3}>
                            <span style={{color:"white", fontSize:"150%"}}>Position : </span>
                        </Form.Label>
                        <Form.Control column style={{width:"60%", marginTop:"0.8%", height:"80%"}} placeholder="Enter Positions "
                            onChange={(e) => this.setState({position: e.target.value})} />
                    </Form.Group>
                    <Form.Group as={Row} className="my-3 mb-3">
                        <Form.Label column sm={3}>
                            <span style={{color:"white", fontSize:"150%"}}>Game Modes: </span>
                        </Form.Label>
                        <Form.Control column style={{width:"60%", marginTop:"0.8%", height:"80%"}} placeholder="Enter GameModes "
                            onChange={(e) => this.setState({gameMode: e.target.value})} />
                    </Form.Group>
                    <Form.Group as={Row} className="my-3 mb-3">
                        <Form.Label column sm={3}>
                            <span style={{color:"white", fontSize:"150%"}}>Teamate Or Enemy </span>
                        </Form.Label>
                        <Form.Select column style={{width:"60%", marginTop:"0.8%", height:"80%"}}
                            onChange={(e) => this.setState({team: e.target.value})}>
                                <option value="true">Teamate</option>
                                <option value="false">Enemy</option>
                        </Form.Select>
                    </Form.Group>
                    <Form.Group as={Row} className="my-3 mb-3">
                        <Form.Label column sm={3}>
                            <span style={{color:"white", fontSize:"150%"}}>Other Player Name : </span>
                        </Form.Label>
                        <Form.Control column style={{width:"60%", marginTop:"0.8%", height:"80%"}} placeholder="Enter Player Name "
                            onChange={(e) => this.setState({Oplayer: e.target.value})} />
                    </Form.Group>
                    <Form.Group as={Row} className="my-3 mb-3">
                        <Form.Label column sm={3}>
                            <span style={{color:"white", fontSize:"150%"}}>Other Champion Name : </span>
                        </Form.Label>
                        <Form.Control column style={{width:"60%", marginTop:"0.8%", height:"80%"}} placeholder="Enter Champion Name "
                            onChange={(e) => this.setState({Ochampion: e.target.value})} />
                    </Form.Group>
                    <Form.Group as={Row} className="my-3 mb-3">
                        <Form.Label column sm={3}>
                            <span style={{color:"white", fontSize:"150%"}}>Other Position : </span>
                        </Form.Label>
                        <Form.Control column style={{width:"60%", marginTop:"0.8%", height:"80%"}} placeholder="Enter Positions "
                            onChange={(e) => this.setState({Oposition: e.target.value})} />
                    </Form.Group>
                    <Form.Group as={Row} className="my-3 mb-3">
                        <Form.Label column sm={3}>
                            <span style={{color:"white", fontSize:"150%"}}>Other Game Modes: </span>
                        </Form.Label>
                        <Form.Control column style={{width:"60%", marginTop:"0.8%", height:"80%"}} placeholder="Enter GameModes "
                            onChange={(e) => this.setState({OgameMpdes: e.target.value})} />
                    </Form.Group>
                    <Button size="lg" onClick={()=>this.send(8)}> Search </Button>
                </Form>;
        this.setState({body:y})
    }

    async send(num){
        let body = "";
        let json = "";
        switch(num){
            case 0: 
                body = await fetch("/get/Player/matches?name=" + this.state.player + "&filterType=" + this.state.filterType + "&filter=" + this.state.filter);
                json = await body.json();
                break;
            case 1: 
                body = await fetch("/get/Champ/topChamps?name=" + this.state.player );
                json = await body.json();
                break;
            case 2: 
                body = await fetch("/get/Champs/played?name=" + this.state.player );
                json = await body.json();
                break;
            case 3: 
                body = await fetch("/get/Match?id=" + this.state.match);
                json = await body.json();
                break;
            case 4: 
                body = await fetch("/average/ChampGames?name=" + this.state.player + "&champ=" + this.state.champion);
                json = await body.json();
                break;
            case 5: 
                body = await fetch("/average/PlayerPosition?name=" + this.state.player );
                json = await body.json();
                break;
            case 6: 
                body = await fetch("/average/Player/Team?name=" + this.state.player);
                json = await body.json();
                break;
            case 7: 
                body = await fetch("/average/Stats?name=" + this.state.player + "&champ=" + this.state.champion 
                                   + "&pos=" + this.state.position + "&gms=" + this.state.gameMode);
                                   json = await body.json();
                break;
            case 8: 
                body = await fetch("/average/Team?name=" + this.state.player + "&champ=" + this.state.champion 
                                   + "&pos=" + this.state.position + "&gms=" + this.state.gameMode + "&team=" + this.state.team
                                   + "&Oname=" + this.state.Oplayer + "&Ochamp=" + this.state.Ochampion 
                                   + "&Opos=" + this.state.Oposition + "&Ogms=" + this.state.OgameMpdes);
                json = await body.json();
                break;
        }
        this.setState({json:json});
    }

    onEdit = e => {
        this.setState({ src: e.updated_src });
    };

    onDelete = e => {
        this.setState({ src: e.updated_src });
    };
    
    render(){
        return <>
                <Card style={{background:'rgba(50,50,50,0.5)'}}>
                    <Card.Header onClick={()=>this.flip(this.state.show)} style={{background:"rgba(71, 17, 166,0.3)", marginLeft:'auto',marginRight:'auto',fontSize:'200%',fontWeight:'600',color:'tan',textShadow:'1px 0 black'}}>
                        Get Panel
                    </Card.Header>
                    <Card.Body className="px-4">
                    <Collapse in={this.state.show}>
                        <div id="example-collapse-text">
                            <Nav bg = "dark" style={{fontSize:"115%",background:"rgba(0,10,10,0.8)"}}>
                                <Nav.Link style={{width:"30%",background:"rgba(20,20,20,0.5)", fontSize:"150%"}} onClick={()=>this.setCur(0)}>Get Player Matches</Nav.Link>
                                <Nav.Link style={{width:"35%",background:"rgba(20,20,20,0.5)", fontSize:"150%"}} onClick={()=>this.setCur(1)}>Get Player Top Champs</Nav.Link>
                                <Nav.Link style={{width:"35%",background:"rgba(20,20,20,0.5)", fontSize:"150%"}} onClick={()=>this.setCur(2)}>Get Player Champs played</Nav.Link>
                                <Nav.Link style={{width:"30%",background:"rgba(20,20,20,0.5)", fontSize:"150%"}} onClick={()=>this.setCur(3)}>Get Match</Nav.Link>
                                <Nav.Link style={{width:"35%",background:"rgba(20,20,20,0.5)", fontSize:"150%"}} onClick={()=>this.setCur(4)}>Get Average Stats for Champ</Nav.Link>
                                <Nav.Link style={{width:"35%",background:"rgba(20,20,20,0.5)", fontSize:"150%"}} onClick={()=>this.setCur(5)}>Get Average Stats for Positions</Nav.Link>
                                <Nav.Link style={{width:"30%",background:"rgba(20,20,20,0.5)", fontSize:"150%"}} onClick={()=>this.setCur(6)}>Get Average Teamates</Nav.Link>
                                <Nav.Link style={{width:"35%",background:"rgba(20,20,20,0.5)", fontSize:"150%"}} onClick={()=>this.setCur(7)}>Get Average Stats w/fitlers</Nav.Link>
                                <Nav.Link style={{width:"35%",background:"rgba(20,20,20,0.5)", fontSize:"150%"}} onClick={()=>this.setCur(8)}>Get Average Team w/fitlers</Nav.Link>
                            </Nav>
                            {this.state.body}
                            <Card style={{background:"rgba(0,0,0,0)"}}>
                                <Card.Header style={{color:"white", fontSize:"200%", fontWeight:"600"}}>
                                    Result
                                </Card.Header>
                                <Card.Body >
                                    <ReactJson
                                        src={this.state.json}
                                        onEdit={this.onEdit}
                                        onDelete={this.onDelete}
                                        theme="monokai" 
                                        shouldCollapse={() => true}
                                        />
                                </Card.Body>
                            </Card>
                        </div>
                    </Collapse>
                    </Card.Body>
                </Card>
            </>
    }

} export default GetPanel;
   
   
