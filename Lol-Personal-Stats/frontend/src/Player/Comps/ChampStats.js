import React from "react";
import Card from 'react-bootstrap/Card';
import Row from 'react-bootstrap/Row';
import Col from 'react-bootstrap/Col';
import Collapse from "react-bootstrap/Collapse";

class ChampStats extends React.Component{

    constructor (props){
        super(props);
        this.state = {
            topChamps: props.topChamps,
            player: props.player,
            body: <h1>re</h1>,
            show: true,
            msg: "Hide"
          };
    }

    componentDidMount() {
        this.display(this.state.topChamps[0],this.state.player)
    }

    async display(champ,name){
        console.log(champ.name)
        const average = await fetch('/average/ChampGames?name=' + name + "&champ=" + champ.name);
        const x = await average.json();
        console.log(x)
        let y = (
            <>
                <Row>

                </Row>
                <Row style={{color:"white"}}>
                <h1 style={{marginLeft:"16%",marginRight:"auto"}}>{champ.name + " - " + champ.value + " Games"}</h1>
                <Col>
                        <strong> Kills : </strong>{(x.kills).toFixed(2)} <br></br>
                        <strong> Deaths : </strong>{(x.deaths).toFixed(2)} <br></br>
                        <strong> Assists :</strong> {(x.assists).toFixed(2)} <br></br>
                        <strong> CS : </strong>{(x.cs).toFixed(2)} <br></br>
                        <strong> Gold : </strong>{(x.gold/x.total).toFixed(2)} <br></br>
                        <strong> Damage Dealt : </strong>{(x.damageDealt).toFixed(2)}<br></br>
                        <strong> Damage Taken :</strong> {(x.damageTaken).toFixed(2)} <br></br>
                        <strong> Barons Taken : </strong> {(x.baronsTaken).toFixed(2)} <br></br>
                        <strong> Dragons Taken : </strong>{(x.dragonsTaken).toFixed(2)} <br></br>
                        <strong> Objective Steals :</strong> {(x.objectiveSteals).toFixed(2)} <br></br>
                        <strong> Turret Damage :</strong> {(x.turretDamage).toFixed(2)} <br></br>
                        <strong> Turrets Taken :</strong> {(x.turretsTaken).toFixed(2)} <br></br>
                        <strong> Wards Placed : </strong> {(x.wardsPlaced).toFixed(2)} <br></br>
                        <strong> Wards Destroyed :</strong> {(x.wardsDestroyed).toFixed(2)} <br></br>
                        <strong> Vision Score  : </strong> {(x.visionScore).toFixed(2)} <br></br>
                        <strong>Solo Kills : </strong>{(x.soloKills).toFixed(2)} <br></br>
                        <strong>Stealth Wards Placed :</strong> {(x.stealthWardsPlaced).toFixed(2)} <br></br>
                        <strong>Stolen Buffs : </strong>{(x.stolenBuffs).toFixed(2)} <br></br>
                        <strong>Time CC others : </strong>{(x.timeCCother).toFixed(2)} <br></br>
                        <strong>Turret Plates :</strong> {(x.turretPlates).toFixed(2)} <br></br>                   
                    </Col>
                    <Col>
                        <strong>Ability Uses : </strong>{(x.abiltyUses).toFixed(2)} <br></br>
                        <strong>CC And Kills W Alley : </strong>{(x.cCandKillwAlley).toFixed(2)} <br></br>
                        <strong>Control Wards Bought : </strong>{(x.controlWardsBought).toFixed(2)} <br></br>
                        <strong>Control Wards Placed :</strong> {(x.controlWardsPlaced).toFixed(2)} <br></br>
                        <strong>Enemy's CCd : </strong>{(x.enemyCCd).toFixed(2)} <br></br>
                        <strong>Dodged Skill Shots : </strong>{(x.dodgedSkillShots).toFixed(2)} <br></br>
                        <strong>Enemy Jungle Killed : </strong>{(x.enemyJungleKilled).toFixed(2)} <br></br>
                        <strong>First Blood Kill: </strong>{(x.firstBloodKills).toFixed(2)} <br></br>
                        <strong>First Blood Assist : </strong>{(x.firstBloodAssists).toFixed(2)} <br></br>
                        <strong>First Blood Tower : </strong> {(x.firstTowerKill).toFixed(2)} <br></br>
                        <strong>Heal On Teamates : </strong>{(x.heal).toFixed(2)} <br></br>
                        <strong>Hit Skill Shots :</strong> {(x.hitSkillShots).toFixed(2)} <br></br>
                        <strong>Jungle Monsters Killed : </strong>{(x.jungleMonstersKilled).toFixed(2)} <br></br>
                        <strong>lane Minions At 10 Minutes :</strong> {(x.landMinionsAt10).toFixed(2)} <br></br>
                        <strong>Peak CS Lead : </strong>{(x.peakCsLead).toFixed(2)} <br></br>
                        <strong>Peak Kill Lead : </strong>{(x.peakKillDiff).toFixed(2)} <br></br>
                        <strong>Picks With Alley :</strong> {(x.picksWAlley).toFixed(2)} <br></br>
                        <strong>Pings :</strong> {(x.pings).toFixed(2)} <br></br>
                        <strong>Shield On Teamates : </strong>{(x.shield/x.total).toFixed(2)} <br></br>
                        <strong>Skill Shots Early: </strong>{(x.skillShotsEarly).toFixed(2)} <br></br>
                    </Col>
                </Row>
            </>
        )
        this.setState({body:y})
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
        return (
            <Card style={{background:'rgba(50,50,50,0.5)'}}>
                <Card.Header onClick={()=>this.flip(this.state.show)} style={{background:"rgba(71, 17, 166,0.3)", marginLeft:'auto',marginRight:'auto',fontSize:'200%',fontWeight:'600',color:'tan',textShadow:'1px 0 black'}}>
                    Champ Stats
                </Card.Header>
                <Card.Body className="px-4">
                    <Collapse in={this.state.show}>
                        <div>
                            {this.state.body}
                        </div>
                    </Collapse>
                </Card.Body>
            </Card>
        )
    }

} export default ChampStats 