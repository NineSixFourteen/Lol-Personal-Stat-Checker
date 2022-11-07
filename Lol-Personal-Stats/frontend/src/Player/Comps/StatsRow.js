import React from "react";
import Card from "react-bootstrap/Card";
import Form from "react-bootstrap/Form";
import Collapse from "react-bootstrap/Collapse";
import Col from "react-bootstrap/Col";
import Row from "react-bootstrap/Row";
import StatsPanel from "./StatsPanel";

class StatsRow extends React.Component{

    constructor (props){
        super(props);
        this.state = {
            heading: props.heading,
            name: props.id,
            widget1 : 0,
            widget2 : 0,
            player: "21", 
            avgPlayer: "22", 
            avgTeamate: "23", 
            body: "",
            show: false,
        };
    }
    
    async componentDidMount() {
        const average = await fetch('/average/PlayerPosition?name=' + this.state.name);
        const averBody = await average.json();
        let x = <StatsPanel items={averBody} cur={2} heading={"Player Stats"} unit={"Game"} units={"Games"} />
        const avgTeam = await fetch('/average/Player/Team?name=' + this.state.name);
        const avgTeamBody = await avgTeam.json();
        let y = <StatsPanel items={avgTeamBody} cur={2} heading={"Average Team"} unit={"Game"} units={"Games"} />
        const averagePlay = await fetch("/pre/averagePos");
        const averPBody = await averagePlay.json();
        let z = <StatsPanel items={averPBody} cur={2} heading={"Average Player"} unit={"Game"} units={"Games"} />
        this.setState(
            {
                player:x,
                avgPlayer:z,
                avgTeamate:y,
            }
        )
    }

    async display(w1){
        this.setState({widget1:""})
        await setTimeout(500);
        if(w1 == 0){
            this.setState({widget1:this.state.player})
        } else if(w1 == 1) {
            this.setState({widget1:this.state.avgTeamate})
        } else{
            this.setState({widget1:this.state.avgPlayer})
        }
    }

    async display2(w1){
        this.setState({widget2:""})
        await setTimeout(500);
        if(w1 == 0){
            this.setState({widget2:this.state.player})
        } else if(w1 == 1) {
            this.setState({widget2:this.state.avgTeamate})
        } else{
            this.setState({widget2:this.state.avgPlayer})
        }
    }

    flip(bool){
        let x = !bool
        this.setState({show:x})
    }

    render(){
        return <>
            <Card style={{background:'rgba(20,0,0,0.5)'}}>
                <Card.Header onClick={()=>this.flip(this.state.show)} style={{background:"rgba(71, 17, 166,0.3)", marginLeft:'auto',marginRight:'auto',fontSize:'200%',fontWeight:'600',color:'tan',textShadow:'1px 0 black'}}>
                    {this.state.heading}
                </Card.Header>
                <Card.Body className="px-4">
                <Collapse in={this.state.show}>
                    <div id="example-collapse-text">
                        <Form >
                            <Row>
                                <Col>
                                    <span style={{fontSize:"160%",fontWeight:"600",color:"white" }}>Widget 1</span>
                                    <Form.Select 
                                    onChange={(e) => {this.display(e.target.value == "Select Widget" ? 0 : e.target.value)}}
                                    className="mx-2" style={{width:"30%", display:"inline"}}>
                                        <option>Select Widget</option>
                                        <option value="0">Player</option>
                                        <option value="1">Average Teamate</option>
                                        <option value="2">Average Player</option>
                                    </Form.Select>
                                </Col>
                                <Col>
                                 <span style={{fontSize:"160%",fontWeight:"600",color:"white" }}>Widget 2</span>
                                    <Form.Select
                                    onChange={(e) => {this.display2(e.target.value == "Select Widget" ? 0 : e.target.value)}}
                                    className="mx-2"  style={{width:"30%", display:"inline"}}>
                                        <option>Select Widget</option>
                                        <option value="0">Player</option>
                                        <option value="1">Average Teamate</option>
                                        <option value="2">Average Player</option>
                                    </Form.Select>
                                </Col>
                            </Row>
                        </Form>
                        <Row>
                            <Col>
                                {this.state.widget1}
                            </Col>
                            <Col>
                                {this.state.widget2}
                            </Col>
                        </Row>
                    </div>
                </Collapse>
                </Card.Body>
            </Card>
            </>
    }


} export default StatsRow