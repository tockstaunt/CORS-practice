import React from "react";
import * as api from "../utils/api";

class Values extends React.Component {
  constructor(props){
    super(props);
      this.state = {
        values: []
    };
  }
     
  callValues = () => {
    api.fetchValues().then(response => {
      console.log("callValues: ", response);
      this.setState(() => {
        return {
          values: response
        };
      });
      console.log("after SetState: ", this.state.values);
    });
  };

  componentDidMount() {
    this.callValues();
    console.log("componentDidMount: ", this.state.values);
  }

  
render(){
  let repos = this.state.values.map((repo) => <li key={repo.id} >< a href={repo.delete} target="_blank">{repo.postableValue}</a><button>delete</button></li>)
  return(   
    
    <div className="container">
    
    
      
      <ul>
        {repos}
      </ul>
    </div>
    
  )
}
}


export default Values;
