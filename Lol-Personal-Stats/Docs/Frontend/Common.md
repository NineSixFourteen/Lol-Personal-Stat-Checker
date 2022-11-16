# Common

This is document common things across the website such NavBar and the collapse able cards that are used multiple times across the website;

## NavBar

The navbar has an image on the left for home. Three links in the middle to go the the differn't pages to view information in a formateed way and one link on the right that takes you to the admin page.

## Collapsable card 

The collapsable card that looks like 

```
<Card style={{background:'rgba(50,50,50,0.5)'}}>
    <Card.Header onClick={()=>this.flip(this.state.show)} style={{background:"rgba(71, 17, 166,0.3)", marginLeft:'auto',marginRight:'auto',fontSize:'200%',fontWeight:'600',color:'tan',textShadow:'1px 0 black'}}>
        Heading
    </Card.Header>
    <Card.Body className="px-4">
    <Collapse in={this.state.show}>
        <div id="example-collapse-text">
        <Nav bg = "dark" style={{fontSize:"115%",background:"rgba(0,10,10,0.8)"}}>
            <Nav.Link style={{background:"rgba(20,20,20,0.5)", fontSize:"150%"}} onClick={()=>this.setCur(0)}>Add Match</Nav.Link>
            <Nav.Link style={{background:"rgba(20,20,20,0.5)", fontSize:"150%"}} onClick={()=>this.setCur(1)}>Add Player</Nav.Link>
        </Nav>
            Body
        </div>
    </Collapse>
    </Card.Body>
</Card>
```

Is the format that I show the stats because when there is alot of information on a page it helps to be able to temporally shrink the space it takes up to navigate it this format is used across many pages.