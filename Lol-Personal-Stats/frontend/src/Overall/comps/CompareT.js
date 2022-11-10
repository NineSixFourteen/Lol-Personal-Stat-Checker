import React from "react";
import Card from 'react-bootstrap/Card';
import Row from 'react-bootstrap/Row';
import Col from 'react-bootstrap/Col';
import Collapse from "react-bootstrap/Collapse";
import Nav from "react-bootstrap/Nav";
import Form from "react-bootstrap/Form"
import Container from "react-bootstrap/esm/Container";
import Button from "react-bootstrap/Button";

class CompareT extends React.Component{

    constructor (props){
        super(props);
        this.state = {
            side: props.side,
            oname: props.player,
            ochamp: props.champ, 
            opos: props.pos,
            ogm: props.gm, 
            body: "",
            name: "",
            champ: "",
            pos: [true,true,true,true,true,true],
            gm:  [true,true,true,true,true,true]
          };
    }

    async display(){
        let name  = this.state.oname  != "" ? this.state.oname  : "all"
        let champ = this.state.ochamp != "" ? this.state.ochamp : "all"
        let pos   = this.getPos(this.state.opos);
        let gms   = this.getGms(this.state.ogm); 
        let oname  = this.state.name  != "" ? this.state.name  : "all"
        let ochamp = this.state.champ != "" ? this.state.champ : "all"
        let opos   = this.getPos(this.state.pos);
        let ogms   = this.getGms(this.state.gm);
        let fatch = "/average/Team?";
        fatch += "name=" + name + "&champ=" + champ + "&pos=" + pos + "&gms=" + gms + "&team=" + this.state.side;
        fatch += "&Oname=" + oname + "&Ochamp=" + ochamp + "&Opos=" + opos + "&Ogms=" + ogms;
        let player = await fetch(fatch);
        let x      = await player.json();
        let places = 2;
        console.log(x)
        let y = (
        <Container style={{background:"rgba(0,0,0,0.5)"}}>
            <Row style={{color:"white"}}>
                <Col className="px-2 py-2">
                    <strong> Kills :                 </strong>{(x.kills).toFixed(places)} <br></br>
                    <strong> Deaths :                </strong>{(x.deaths).toFixed(places)} <br></br>
                    <strong> Assists :               </strong> {(x.assists).toFixed(places)} <br></br>
                    <strong> CS :                    </strong>{(x.cs).toFixed(places)} <br></br>
                    <strong> Gold :                  </strong>{(x.gold).toFixed(places)} <br></br>
                    <strong> Damage Dealt :          </strong>{(x.damageDealt).toFixed(places)}<br></br>
                    <strong> Damage Taken :          </strong> {(x.damageTaken).toFixed(places)} <br></br>
                    <strong> Barons Taken :          </strong> {(x.baronsTaken).toFixed(places)} <br></br>
                    <strong> Dragons Taken :         </strong>{(x.dragonsTaken).toFixed(places)} <br></br>
                    <strong> Objective Steals :      </strong> {(x.objectiveSteals).toFixed(places)} <br></br>
                    <strong> Turret Damage :         </strong> {(x.turretDamage).toFixed(places)} <br></br>
                    <strong> Turrets Taken :         </strong> {(x.turretsTaken).toFixed(places)} <br></br>
                    <strong> Wards Placed :          </strong> {(x.wardsPlaced).toFixed(places)} <br></br>
                    <strong> Wards Destroyed :       </strong> {(x.wardsDestroyed).toFixed(places)} <br></br>
                    <strong> Vision Score  :         </strong> {(x.visionScore).toFixed(places)} <br></br>
                    <strong>Solo Kills :             </strong>{(x.soloKills).toFixed(places)} <br></br>
                    <strong>Stealth Wards Placed :   </strong> {(x.stealthWardsPlaced).toFixed(places)} <br></br>
                    <strong>Stolen Buffs :           </strong>{(x.stolenBuffs).toFixed(places)} <br></br>
                    <strong>Time CC others :         </strong>{(x.timeCCother).toFixed(places)} <br></br>
                    <strong>Turret Plates :          </strong> {(x.turretPlates).toFixed(places)} <br></br>                   
                </Col>
                <Col className="px-2 py-2">
                    <strong>Ability Uses :           </strong>{(x.abiltyUses).toFixed(places)} <br></br>
                    <strong>CC And Kills W Alley :   </strong>{(x.cCandKillwAlley).toFixed(places)} <br></br>
                    <strong>Control Wards Bought :   </strong>{(x.controlWardsBought).toFixed(places)} <br></br>
                    <strong>Control Wards Placed :   </strong> {(x.controlWardsPlaced).toFixed(places)} <br></br>
                    <strong>Enemy's CCd :            </strong>{(x.enemyCCd).toFixed(places)} <br></br>
                    <strong>Dodged Skill Shots :     </strong>{(x.dodgedSkillShots).toFixed(places)} <br></br>
                    <strong>Enemy Jungle Killed :    </strong>{(x.enemyJungleKilled).toFixed(places)} <br></br>
                    <strong>First Blood Kill:        </strong>{(x.firstBloodKills).toFixed(places)} <br></br>
                    <strong>First Blood Assist :     </strong>{(x.firstBloodAssists).toFixed(places)} <br></br>
                    <strong>First Blood Tower :      </strong> {(x.firstTowerKill).toFixed(places)} <br></br>
                    <strong>Heal On Teamates :       </strong>{(x.heal).toFixed(places)} <br></br>
                    <strong>Hit Skill Shots :        </strong> {(x.hitSkillShots).toFixed(places)} <br></br>
                    <strong>Jungle Monsters Killed : </strong>{(x.jungleMonstersKilled).toFixed(places)} <br></br>
                    <strong>lane Minions At 10 :     </strong> {(x.landMinionsAt10).toFixed(places)} <br></br>
                    <strong>Average Peak CS Lead :   </strong>{(x.peakCsLead).toFixed(places)} <br></br>
                    <strong>Average Peak Kill Lead : </strong>{(x.peakKillDiff).toFixed(places)} <br></br>
                    <strong>Picks With Alley :       </strong> {(x.picksWAlley).toFixed(places)} <br></br>
                    <strong>Pings :                  </strong> {(x.pings).toFixed(places)} <br></br>
                    <strong>Shield On Teamates :     </strong>{(x.shield).toFixed(places)} <br></br>
                    <strong>Skill Shots Early:       </strong>{(x.skillShotsEarly).toFixed(places)} <br></br>
                </Col>
            </Row>
        </Container>
        )
        this.setState({body: y})
    }

    getPos(x){
        let message = "";
        let pos = x;
        if(pos[0]){
            return "all"
        } else {
            if(pos[1]){
                message += "TOP, "
            }
            if(pos[2]){
                message += "Solo/Duo, "
            }
            if(pos[3]){
                message += "MIDDLE, "
            }
            if(pos[4]){
                message += "BOTTOM, "
            }
            if(pos[5]){
                message += "SUPPORT, "
            }
            return message.substring(0 , message.length -2);
        }
    }

    getGms(x){
        let message = "";
        let gm = x;
        if(gm[0]){
            return "all"
        } else {
            if(gm[1]){
                message += "Flex, "
            }
            if(gm[2]){
                message += "Solo/Duo, "
            }
            if(gm[3]){
                message += "Blind, "
            }
            if(gm[4]){
                message += "Draft, "
            }
            if(gm[5]){
                message += "ARAM, "
            }
            return message.substring(0 , message.length -2);
        }
    }

    flop(){
        let x = this.state.side;
        x = !x;
        this.setState({side:x})
    }

    flip(num){
        let x = [];
        let pos = this.state.pos
        if(num == 0){
            if(this.state.pos[0]){
                x = [false,false,false,false,false,false]
            } else {
                x = [true,true,true,true,true,true]
            }
        }else {
            let i = 1;
            x = [false]
            while(i < 6 ){
                if(i == num){
                    x.push(!pos[i])
                }else{
                    x.push(pos[i])
                }
                i++;
            }
        }
        this.setState({pos:x})
    }
    
    flip2(num){
        let x = [];
        let gm = this.state.gm
        if(num == 0){
            if(this.state.gm[0]){
                x = [false,false,false,false,false,false]
            } else {
                x = [true,true,true,true,true,true]
            }
        }else {
            let i = 1;
            x = [false]
            while(i < 6){
                if(i == num){
                    x.push(!gm[i])
                }else{
                    x.push(gm[i])
                }
                i++;
            }
        }
        this.setState({gm:x})
    }

    render(){
        return <Container className="px-3 py-3" style={{background:"rgba(40,40,40,0.7)"}}>
        <Row>
            <Col>        <span style={{color:"white", fontSize:"180%", fontWeight:"800" }}>{this.state.side ? "Team " : "Enemy"}</span></Col>
            <Col></Col>
            <Col></Col>
            <Col></Col>
            <Col> <Button onClick={() => {this.flop()}}> Toggle</Button> </Col>
        </Row>
        <Form>
            <Form.Group as={Row} className="mb-3" controlId="PlayerName">
                <Form.Label column sm={4}>
                    <span style={{color:"white", fontSize:"150%"}}> Player : </span>
                </Form.Label>
                <Form.Control column style={{width:"60%", marginTop:"2%", height:"80%"}} placeholder="Enter player name"
                    onChange={(e) => this.setState({name: e.target.value})} />
            </Form.Group>
            <Form.Group as={Row} className="mb-3" controlId="ChampionName">
                <Form.Label column sm={4}>
                    <span style={{color:"white", fontSize:"150%"}}> Champion : </span>
                </Form.Label>
                <Form.Control column style={{width:"60%", marginTop:"2%", height:"80%"}} placeholder="Enter champion name"
                    onChange={(e) => this.setState({champ: e.target.value})} />
            </Form.Group>
            <Form.Group as={Row} style={{color:"white"}}>
                <Form.Label column sm={4}>
                    <span style={{color:"white", fontSize:"150%"}}> Position : </span>
                </Form.Label>
                <Col sm={2}>
                    <Form.Check inline type={'checkbox'} label={'Top'} checked={this.state.pos[1]} onChange={() => {this.flip(1)} }/>
                    <Form.Check inline type={'checkbox'} label={'Adc'} checked={this.state.pos[4]} onChange={() => {this.flip(4)} }/>
                </Col>
                <Col sm={2}>
                    <Form.Check inline type={'checkbox'} label={'Jungle'} checked={this.state.pos[2]} onChange={() => {this.flip(2)} }/>
                    <Form.Check inline type={'checkbox'} label={'Supp'}   checked={this.state.pos[5]} onChange={() => {this.flip(5)} }/>
                </Col>
                <Col sm={2}>
                    <Form.Check inline type={'checkbox'} label={'Mid'} checked={this.state.pos[3]} onChange={() => {this.flip(3)} }/>
                    <Form.Check inline type={'checkbox'} label={'All'} checked={this.state.pos[0]} onChange={() => {this.flip(0)} }/>
                </Col>
            </Form.Group>
            <Form.Group as={Row} style={{ color:"white"}}>
                <Form.Label column sm={4}>
                    <span style={{color:"white", fontSize:"150%"}}> Gamemode : </span>
                </Form.Label>
                <Col sm={2}>
                    <Form.Check inline type={'checkbox'} label={'FLEX'}  checked={this.state.gm[1]} onChange={() => {this.flip2(1)} } />
                    <Form.Check inline type={'checkbox'} label={'SOLO'}  checked={this.state.gm[2]} onChange={() => {this.flip2(2)} } />
                </Col>
                <Col sm={2}>
                    <Form.Check inline type={'checkbox'} label={'BLIND'} checked={this.state.gm[3]} onChange={() => {this.flip2(3)} } />
                    <Form.Check inline type={'checkbox'} label={'DRAFT'} checked={this.state.gm[4]} onChange={() => {this.flip2(4)} } />
                </Col>
                <Col sm={2}>
                    <Form.Check inline type={'checkbox'} label={'ARAM'} checked={this.state.gm[5]} onChange={() => {this.flip2(5)} } />
                    <Form.Check inline type={'checkbox'} label={'All'}  checked={this.state.gm[0]} onChange={() => {this.flip2(0)} } />
                </Col>
            </Form.Group>
            <Button className="my-3" style={{width:"100%"}} onClick={() => {this.display()}}>
                Go
            </Button>
        </Form>
        {this.state.body}
    </Container>
    }
} export default CompareT