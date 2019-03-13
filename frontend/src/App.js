import React, { Component } from 'react';
import { Route } from 'react-router-dom';
import './App.css';
import newshopperpage from './components/newshopperpage';
import Axios from 'axios';

class App extends Component {
  componentDidMount(){
    Axios.request({
      url: "/oauth/token",
      method: "post",
      baseURL:"https://localhost:2019",
      auth:{
        username:"admin",
        password: "admin123"
      },
      data:{
        "grant_type": "client_credentials",
        "scope": "public"
      }.then(function(res){
        console.log(res);
      })
    })
  }
  render() {
    return (
      <div className="App-container">
      <newshopperpage/>
      </div>
    );
  }
}

export default App;
