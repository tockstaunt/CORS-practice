import React from "react";
import * as api from "../utils/api";

class Values extends React.Component {
  constructor(props){
    super(props);
      this.state = {
        values: [],
        delete: "localhost:8080/api/delete/"
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

  handleSubmit = event => {
    event.preventDefault();
    this.delete();
  }

render(){
  let repos = this.state.values.map((repo) =><li key={repo.id}>{repo.postableValue}
  
  <a href={"localhost:8080/api/delete/" + repo.id}> <button >delete</button></a>
  
  </li>)
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
