import React from 'react';
import ReactDOM from 'react-dom';

import App from './App';

class Main extends React.Component {
  render() {
    return (
      <App />
    );
  }
}

ReactDOM.render(<Main />, document.getElementById('root'));