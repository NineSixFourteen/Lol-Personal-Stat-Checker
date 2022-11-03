import React from "react";
import Card from 'react-bootstrap/Card';
import Row from 'react-bootstrap/Row';
import Col from 'react-bootstrap/Col';
import Collapse from "react-bootstrap/Collapse";
import Nav from "react-bootstrap/Nav";
import PlayerStats from "./PlayersStats";
import Top from "../../photos/Top.png"
import Jungle from "../../photos/Jungle.png"
import Mid from "../../photos/Mid.png"
import Bot from "../../photos/Bot.png"
import Support from "../../photos/Support.png"

class PlayerStatsHolder extends React.Component{

    constructor (props){
        super(props);
        this.state = {
            stats: props.stats,
            player: props.player,
            body: <h1>re</h1>,
            show: true,
            msg: "Hide"
          };
    }

    componentDidMount() {
        this.display(this.state.stats)
    }

    display(stats){
        this.setState({body:(
            <Row >
                <Col className="px-4" >
                    {<PlayerStats stats={stats} cur={5}/>}
                </Col>
                <Col>
                    {<PlayerStats stats={stats} cur={0}/>}
                </Col>
            </Row>
        )})
    }

    flip(bool){
        let x = !bool
        let m = "Show"
        if(x){
            m = "Hide"
        }
        this.setState({show:x, msg:m})
    }

    render(){
        return(
                <Card style={{background:'rgba(50,50,50,0.5)'}}>
                <Card.Header onClick={()=>this.flip(this.state.show)} style={{background:"rgba(71, 17, 166,0.3)", marginLeft:'auto',marginRight:'auto',fontSize:'200%',fontWeight:'600',color:'tan',textShadow:'1px 0 black'}}>
                Player Stats
                </Card.Header>
                <Card.Body className="px-4">
                <Collapse in={this.state.show}>
                    <div id="example-collapse-text">
                        {this.state.body}
                    </div>
                </Collapse>
                </Card.Body>
            </Card>
        )
    }

} export default PlayerStatsHolder;