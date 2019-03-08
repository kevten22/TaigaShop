import React, { Component } from 'react';
import { Route } from 'react-router-dom';
import './App.css';
import newshopperpage from './components/newshopperpage';

class App extends Component {
  render() {
    return (
      <div className="App-container">
      <newshopperpage/>
      </div>
    );
  }
}

export default App;
