import React from "react";
import Card from 'react-bootstrap/Card';
import Row from 'react-bootstrap/Row';
import Col from 'react-bootstrap/Col';
import Nav from 'react-bootstrap/Nav';
import Button from "react-bootstrap/esm/Button";
import Collapse from "react-bootstrap/Collapse";
import Form from "react-bootstrap/esm/Form";
import "./champ.css"

class ChampStats extends React.Component{

    constructor (props){
        super(props);
        this.state = {
            topChamps: props.topChamps,
            player: props.player,
            body: <h1>re</h1>,
            show: true,
            msg: "Hide",
            select: 0,
            select2: 0,
            sortBy: 1,
            rever: false,
            champ: props.topChamps[0].name
          };
    }

    componentDidMount() {
        this.setState({body : <h1>re</h1>})
        this.display(this.state.champ,this.state.player,0,0,0)
    }

    search(name){
        this.setState({champ: name});
        this.display(name,this.state.player,0,9,this.state.select)
    }

    setCur(val){
        this.setState({champ:this.state.topChamps[val].name})
        this.setState({search:""})
        this.display(this.state.topChamps[val].name,this.state.player,0,val,0)
        this.setState({select:val})
    }

    setCur2(val){
        this.setState({select2:val})
        this.display(this.state.champ,this.state.player,val,this.state.select)
    }

    getCur(select,val){
        if(select == val){
            return "rgba(90,90,90,0.8)"
        } else {
            return "rgba(0,0,0,0.5)"
        }
    }

    getImage(name){
        return (
            <img src={
                "https://ddragon.leagueoflegends.com/cdn/img/champion/splash/" + 
                name + 
                "_0.jpg"
            } style={{height:"100%", width:"auto", objectFit:"cover", width:"102%"}} 
            /> 
        )   
    }

    fixObj(obj){
        let x = []
        for (const [key, value] of Object.entries(obj)) { 
            x.push({name: key, value: value})
        }     
        x.sort((y,z) => { if( z.name > y.name) return -1; return 1})
        return x;
    }

    async showChampList(num){
        let flip = this.state.sortBy == num && this.state.rever != true;
        this.setState({rever:flip, sortBy:num})
        const ChampPlayed = await fetch('/get/Champs/played?name=' + this.state.player);
        let x = await ChampPlayed.json();
        let y = []
        x.forEach(
            z => {
                y.push(this.fixObj(z))
            }
        )
        console.log(y)
        let i = 0;
        let j = 0; 
        let s = []
        y[0].forEach(
            z => {
                let sr = i < y[1].length && y[1][i].name == z.name ? y[1][i].value : 0;
                if(sr != 0){
                    i++;
                }
                let aram = j < y[2].length && y[2][j].name == z.name ? y[2][j].value : 0;
                if(aram != 0){
                    j++;
                }
                s.push({name: z.name, total: z.value, sr: sr , aram: aram})
            }
        )
        switch(num){
            case 0: 
                s.sort((x,y) => {if(y.name < x.name) return -1; return 1})
                break;
            case 1: 
                s.sort((x,y) => {if(y.total < x.total) return -1; return 1})
                break;
            case 2: 
                s.sort((x,y) => {if(y.sr < x.sr) return -1; return 1})
                break;
            default:
                s.sort((x,y) => {if(y.aram < x.aram) return -1; return 1})
        }
        if(flip){
            s.reverse();
        }
        console.log(s)
        let rows = [];
        {s.forEach(
            obj => {
                rows.push(<Row className="my-2" style={{color:"white", outline:"groove"}}>
                    <Col>
                        <Col>
                            {"Name : " + obj.name}
                        </Col>
                    </Col>
                    <Col>
                        <Row>
                            <Col>
                                {"Total : " + obj.total}
                            </Col>
                            <Col>
                                {"SR : " + obj.sr}
                            </Col>
                            <Col>
                                {"ARAM : " + obj.aram}
                            </Col>
                        </Row>
                    </Col>
                </Row>)
            }
        )}
        console.log(rows)
        let body = (
            <Row >
                <Col>
                    <Row className="baba"   style={{background:"rgba(0,0,0,0.5)",border:"outset", color:"white", borderColor:"black"}}>
                        <Nav>
                            <Nav.Link style={{background:this.getCur(-1, 0),width:"20%"}} onClick={()=>this.setCur(0)}>{this.getImage(this.state.topChamps[0].name)}</Nav.Link>
                            <Nav.Link style={{background:this.getCur(-1, 1),width:"20%"}} onClick={()=>this.setCur(1)}>{this.getImage(this.state.topChamps[1].name)}</Nav.Link>
                            <Nav.Link style={{background:this.getCur(-1, 2),width:"20%"}} onClick={()=>this.setCur(2)}>{this.getImage(this.state.topChamps[2].name)}</Nav.Link>
                            <Nav.Link style={{background:this.getCur(-1, 3),width:"20%"}} onClick={()=>this.setCur(3)}>{this.getImage(this.state.topChamps[3].name)}</Nav.Link>
                            <Nav.Link style={{background:this.getCur(-1, 4),width:"20%"}} onClick={()=>this.setCur(4)}>{this.getImage(this.state.topChamps[4].name)}</Nav.Link>
                            <Nav.Link style={{background:this.getCur(-1, 5),width:"20%"}} onClick={()=>this.setCur(5)}>{this.getImage(this.state.topChamps[5].name)}</Nav.Link>
                            <Nav.Link style={{background:this.getCur(-1, 6),width:"20%"}} onClick={()=>this.setCur(6)}>{this.getImage(this.state.topChamps[6].name)}</Nav.Link>
                            <Nav.Link style={{background:this.getCur(-1, 7),width:"20%"}} onClick={()=>this.setCur(7)}>{this.getImage(this.state.topChamps[7].name)}</Nav.Link>
                            <Nav.Link style={{background:this.getCur(-1, 8),width:"20%"}} onClick={()=>this.setCur(8)}>{this.getImage(this.state.topChamps[8].name)}</Nav.Link>
                            <Nav.Link style={{background:this.getCur(-1, 9),width:"20%"}} onClick={()=>this.setCur(9)}>{this.getImage(this.state.topChamps[9].name)}</Nav.Link>
                        </Nav>
                        <div>
                        <Form>
                            <Form.Group className="mb-3" >
                                <Form.Control type="PlayerName" placeholder="Enter Champion Name" 
                                onChange={e => this.setState({ id: e.target.value })}
                                />
                            </Form.Group>
                                <Button variant="primary" style={{width:"50%"}}
                                onClick={ () => {
                                    this.search(this.state.id);
                                }}>
                                    Search
                                </Button>
   
                                <Button variant="primary"  style={{width:"50%"}}
                                onClick={ () => {
                                    this.showChampList(2);
                                }}>
                                    Show Champion List
                                </Button>
                        </Form>
                    </div>
                    </Row>
                    <Row className="baba" style={{background:"rgba(0,0,0,0.5)",border:"outset", color:"white", borderColor:"black"}}>
                        <Row  className="baba">
                            <Nav>
                                <Nav.Link style={{background:this.getCur(-1, 0),width:"47%"}} onClick={() => this.showChampList(0)}>  Name  </Nav.Link>
                                <Nav.Link style={{background:this.getCur(-1, 1),width:"18%"}} onClick={() => this.showChampList(1)}>  Total </Nav.Link>
                                <Nav.Link style={{background:this.getCur(-1, 2),width:"18%"}} onClick={() => this.showChampList(2)}> SR </Nav.Link>
                                <Nav.Link style={{background:this.getCur(-1, 2),width:"17%"}} onClick={() => this.showChampList(3)}>  ARAM </Nav.Link>
                            </Nav>
                        </Row>
                        <Row>
                            {rows}
                        </Row>
                    </Row>
                    </Col>
                </Row>
        )
        this.setState({body:body})

    }

    async display(champ,name,val,select){
        const average = await fetch('/average/ChampGames?name=' + name + "&champ=" + champ);
        let x = await average.json();
        x = x[val]
        let y = (
            <Row >
                <Col>
                    <Row className="baba"   style={{background:"rgba(0,0,0,0.5)",border:"outset", color:"white", borderColor:"black"}}>
                        <Nav>
                            <Nav.Link style={{background:this.getCur(select, 0),width:"20%"}} onClick={()=>this.setCur(0)}>{this.getImage(this.state.topChamps[0].name)}</Nav.Link>
                            <Nav.Link style={{background:this.getCur(select, 1),width:"20%"}} onClick={()=>this.setCur(1)}>{this.getImage(this.state.topChamps[1].name)}</Nav.Link>
                            <Nav.Link style={{background:this.getCur(select, 2),width:"20%"}} onClick={()=>this.setCur(2)}>{this.getImage(this.state.topChamps[2].name)}</Nav.Link>
                            <Nav.Link style={{background:this.getCur(select, 3),width:"20%"}} onClick={()=>this.setCur(3)}>{this.getImage(this.state.topChamps[3].name)}</Nav.Link>
                            <Nav.Link style={{background:this.getCur(select, 4),width:"20%"}} onClick={()=>this.setCur(4)}>{this.getImage(this.state.topChamps[4].name)}</Nav.Link>
                            <Nav.Link style={{background:this.getCur(select, 5),width:"20%"}} onClick={()=>this.setCur(5)}>{this.getImage(this.state.topChamps[5].name)}</Nav.Link>
                            <Nav.Link style={{background:this.getCur(select, 6),width:"20%"}} onClick={()=>this.setCur(6)}>{this.getImage(this.state.topChamps[6].name)}</Nav.Link>
                            <Nav.Link style={{background:this.getCur(select, 7),width:"20%"}} onClick={()=>this.setCur(7)}>{this.getImage(this.state.topChamps[7].name)}</Nav.Link>
                            <Nav.Link style={{background:this.getCur(select, 8),width:"20%"}} onClick={()=>this.setCur(8)}>{this.getImage(this.state.topChamps[8].name)}</Nav.Link>
                            <Nav.Link style={{background:this.getCur(select, 9),width:"20%"}} onClick={()=>this.setCur(9)}>{this.getImage(this.state.topChamps[9].name)}</Nav.Link>
                        </Nav>
                        <div>
                        <Form>
                            <Form.Group className="mb-3" >
                                <Form.Control type="PlayerName" placeholder="Enter Champion Name" 
                                onChange={e => this.setState({ id: e.target.value })}
                                />
                            </Form.Group>
                                <Button variant="primary" style={{width:"50%"}}
                                onClick={ () => {
                                    this.search(this.state.id);
                                }}>
                                    Search
                                </Button>
   
                                <Button variant="primary"  style={{width:"50%"}}
                                onClick={ () => {
                                    this.showChampList();
                                }}>
                                    Show Champion List
                                </Button>
                        </Form>
                    </div>
                    </Row>
                    <Row className="baba"  style={{background:"rgba(0,0,0,0.5)",border:"outset", color:"white", borderColor:"black"}}>
                        <Nav>
                            <Nav.Link style={{background:this.getCur(val, 0),width:"33%"}} onClick={()=>this.setCur2(0)}> <span style={{marginLeft:"40%", marginRight:"auto"}}> Overall </span> </Nav.Link>
                            <Nav.Link style={{background:this.getCur(val, 1),width:"33%"}} onClick={()=>this.setCur2(1)}> <span style={{marginLeft:"40%", marginRight:"auto"}}> SR</span> </Nav.Link>
                            <Nav.Link style={{background:this.getCur(val, 2),width:"34%"}} onClick={()=>this.setCur2(2)}> <span style={{marginLeft:"40%", marginRight:"auto"}}> ARAM </span> </Nav.Link>
                        </Nav>

                    </Row>
                    <Row className="baba px-1"  style={{background:"rgba(0,10,60,0.5)",border:"outset", color:"white", borderColor:"black", fontSize:"100%"}}>
                        <Row>
                            <h3 style={{justifyContent:"center", marginLeft:"auto", marginRight:"auto"}}> <stong> {champ + ": "} </stong> {x.total + " Games Played"}</h3>
                        </Row>
                        <Row>
                        <Col>
                            <br></br>
                            <strong> Kills : </strong> {(x.kills).toFixed(2)} <br></br>
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
                            <strong> Time CC others : </strong>{(x.timeCCother).toFixed(2)} <br></br>
                            <strong> Turret Plates :</strong> {(x.turretPlates).toFixed(2)} <br></br>    
                            <strong> Picks With Alley :</strong> {(x.picksWAlley).toFixed(2)} <br></br>
                            <strong> Pings :</strong> {(x.pings).toFixed(2)} <br></br>
                            <strong> Stolen Buffs : </strong>{(x.stolenBuffs).toFixed(2)} <br></br>
                        </Col>               
                        <Col>
                            <br></br>
                            <strong>Ability Uses : </strong> {(x.abiltyUses).toFixed(2)} <br></br>
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
                            <strong>lane Minions At 10 :</strong> {(x.landMinionsAt10).toFixed(2)} <br></br>
                            <strong>Peak CS Lead : </strong>{(x.peakCsLead).toFixed(2)} <br></br>
                            <strong>Peak Kill Lead : </strong>{(x.peakKillDiff).toFixed(2)} <br></br>
                            <strong>Shield On Teamates : </strong>{(x.shield/x.total).toFixed(2)} <br></br>
                            <strong>Skill Shots Early: </strong>{(x.skillShotsEarly).toFixed(2)} <br></br>
                            <strong>Solo Kills : </strong>{(x.soloKills).toFixed(2)} <br></br>
                            <strong>Stealth Wards Placed :</strong> {(x.stealthWardsPlaced).toFixed(2)} <br></br>
                            <br></br>
                        </Col>
                        </Row>
                    </Row>
                </Col>
            </Row>
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