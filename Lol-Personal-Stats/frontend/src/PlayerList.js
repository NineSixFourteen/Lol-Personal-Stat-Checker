import React, { Component } from 'react';
import { Button, ButtonGroup, Container, Table } from 'reactstrap';
import AppNavbar from './AppNavbar';
import { Link } from 'react-router-dom';

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