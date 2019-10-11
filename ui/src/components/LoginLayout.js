import React from 'react'
import axios from 'axios'
class LoginLayout extends React.Component {

  constructor(props){
    super(props)
    this.state = {
      username : '',
      password : ''
    }
  }

  onChangeHandler = e => {
    this.setState({[e.target.name]:e.target.value})
  }

  onSubmitHandler = e =>{
    e.preventDefault()
    console.log(this.state)
	axios.get('http://wsaams-env.k57p24vaia.ap-south-1.elasticbeanstalk.com/testdb/time')	
    //axios.post('http://localhost:9410/login/user',this.state,{headers: {"Access-Control-Allow-Origin": "*"}})
    .then(response => {
      console.log(response)
    })
    .catch(error => {
      console.log(error)
    })
  }

    render(){
      const {username,password} = this.state
      return(
        <form onSubmit={this.onSubmitHandler}>
          <div className="LoginLayout">
            <label>Username </label>
              <input type="text" name = "username" value = {username} onChange = {this.onChangeHandler}/>
            <label>Password </label>
              <input type="password" name = "password" value = {password} onChange = {this.onChangeHandler}/>
            <button type="submit">Submit</button>
          </div>
        </form>
      );
    }
}

export default LoginLayout
