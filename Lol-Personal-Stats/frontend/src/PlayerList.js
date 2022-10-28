import React, { Component } from 'react';
import AppNavbar from './AppNavbar';
import Jumbotron from 'react-bootstrap/Jumbotron';
import Toast from 'react-bootstrap/Toast';
import Container from 'react-bootstrap/Container';
import Button from 'react-bootstrap/Button';

class PlayerList extends Component {

    constructor(props) {
        super(props);
        this.state = {players: []};
        this.remove = this.remove.bind(this);
    }

    componentDidMount() {
        fetch('/get/Match?id=EUW1_6094714316')
            .then(response => response.json())
            .then(data => this.setState({players: data.players}));
    }
}
export default ClientList;