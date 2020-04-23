import React from 'react';

class Conditional extends React.Component {
    
    render() {
        return (
            <div>
                 {this.props.isLogged &&
                 <h2>Username: {this.props.userName} </h2>}
            </div>
        );
    }
}

export default Conditional;