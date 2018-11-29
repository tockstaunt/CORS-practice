import React, { Component } from "react";
import "./App.css";
import Values from "./components/Values";

class App extends Component {
  render() {
    return (
      <div className="App">
        <header className="App-header">
          <h1 className="App-title">Welcome to React</h1>
          <Values />
        </header>
        
      </div>
    );
  }
}

export default App;
