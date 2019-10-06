import React from 'react'
import AppName from './AppName'

class Welcome extends React.Component {
    render(){
      return(
        <div className="Welcome">
          <h1>Welcome </h1>
          <appName/>
        </div>
      );
    }
}

export default Welcome
  