import React from 'react';
import LoginLayout from './components/LoginLayout'
import 'jquery/dist/jquery.min.js';
import 'popper.js/dist/popper.min.js';
import 'bootstrap/dist/js/bootstrap.min.js';
import './App.css';
import 'bootstrap/dist/css/bootstrap.min.css';


class App extends React.Component {
  render(){
    return (
      <div className="App">
        <LoginLayout/>
      </div>
    );
  }
}

export default App;
