import React from 'react';
import Conditional from './Conditional';
class App extends React.Component {
    constructor() {
        super();
        this.state = {
            isLogged: false
        }
    }
    
    login() {
        let user = prompt("Enter a username: ");
        this.setState(() => {
            return ({
                userName: user,
                isLogged: true
            })
        });
    }
    
    logout() {
        this.setState(() => {
            return ({
                userName: undefined,
                isLogged: false
            });
        });
    }
    
    render() {
        return (
            <div>
                {
                    this.state.userName === undefined ? 
                    <button style={{display: "block", margin: "10px auto", width: "100px", padding: "5px"}} onClick={this.login.bind(this)}>Login</button> :
                    <button style={{display: "block", margin: "10px auto", width: "100px", padding: "5px"}} onClick={this.logout.bind(this)}>Logout</button>
                }
                <Conditional userName={this.state.userName} isLogged={this.state.isLogged}/>
            </div>
        );
    }
}
export default App;