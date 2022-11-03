import React from "react";
import Card from 'react-bootstrap/Card';
import Row from 'react-bootstrap/Row';
import Button from 'react-bootstrap/Button';
import Col from 'react-bootstrap/Col';

class PlayerInterval extends React.Component{

    constructor(props) {
        super(props);
        this.state = {
          player: props.player,
          intervals: [],
          cards: [true,true,true,true,true]
        };
      }

    componentDidMount() {
        this.setState({intervals: []})
        this.getIntervals(this.state.player.intervals,this.state.cards);
    }

    setVisible(cards,val){
        val = (val/5) - 2;
        let cardss = []
        let i = 0 ;
        cards.forEach(card => {
            if(i == val){
                cardss[i] = !card;
            } else {
                cardss[i] = card;
            }
            i++;
        })
        this.setState({cards:cardss})
        this.setState({intervals: []})
        this.getIntervals(this.state.player.intervals,cardss)
    }

    showCards(cards){
        let str = "";
        cards.forEach(card =>{
            if(card){
                str+= "Yes "
            }else {
                str+= "No "
            }
        }
        )
        return str
    }

    getIntervals(intervalss,cards){
        
        let x = [];
        let i = 0;
        intervalss.forEach(interval => {
            if(cards[i] && interval.gold != 0){
                x[i] = (
                    <Card key={i} style={{background:"rgba(0,0,0,0.5)",color:'white'}}>
                        <Card.Header > <h5>{interval.name + " : " + interval.time + " Minutes"}</h5></Card.Header> 
                        <Card.Body >  
                            <Row >
                                <Col>
                                    <strong>Kills :</strong> {interval.kills} <br></br>
                                    <strong>Deaths :</strong> {interval.deaths} <br></br>
                                    <strong>Assists :</strong> {interval.assists} <br></br>
                                    <strong>KDA : </strong> {((interval.kills + interval.assists) / interval.deaths).toFixed(2)} <br></br>
                                </Col>
                                <Col>
                                    <strong>Gold :</strong> {interval.gold}  <br></br>
                                    <strong>Jungle :</strong> {interval.jungle} <br></br>
                                    <strong>Minions</strong> {interval.minions} <br></br><br></br>
                                </Col>
                                <Col>
                                    <strong>Level :</strong> {interval.level} <br></br>
                                    <strong>Xp :</strong> {interval.xp} <br></br>
                                    <strong>Damage : </strong> {interval.damageDone}<br></br><br></br>
                                </Col>
                            </Row>
                        </Card.Body>
                    </Card>
                )
            }
            i++
        });
        this.setState({intervals:x})
    }

    render(){
        return <>
                <Button style={{width:"25%"}} onClick={() => this.setVisible(this.state.cards,10)}> Toggle 10</Button>
                <Button style={{width:"25%"}} onClick={() => this.setVisible(this.state.cards,15)}> Toggle 15</Button>
                <Button style={{width:"25%"}} onClick={() => this.setVisible(this.state.cards,20)}> Toggle 20</Button>
                <Button style={{width:"25%"}} onClick={() => this.setVisible(this.state.cards,30)}> Toggle 30</Button>
            {this.state.intervals}
        </>
    }


} export default PlayerInterval;