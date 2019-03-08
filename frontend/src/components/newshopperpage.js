import React, { Component } from 'react';

class newshopperpage extends Component {
    constructor(props){
        super(props);
        this.state = {
            username:'',
            password:''
        }
    }

    editHandler = e => {
        this.setState({ [e.target.name]: e.target.value});
    }

    registerNewUser(){
        user = {
            username: this.state.username,
            password: this.state.password,
            billingaddress: "123 w. Test Ln",
            paymentmethod:"Debit",
            phonenumber: "123-456-7890",
            role: "user",
            shoppingaddress:"123 w. Test Ln"
        }
        axios.post("http://localhost:2019/users")
    }

    render() {
        return (
            <div>
                <form action="">
                    <input
                        type="text"
                        name="username"
                        onChange={this.editHandler}
                        placeholder="username"
                        value={this.state.username}
                        required
                    />
                    <input
                        type="password"
                        name="passwordInput"
                        onChange={this.editRegisterHandler}
                        placeholder="password"
                        value={this.state.passwordInput}
                        required
                    />
                    <button
                    type="generate"
                    onClick={this.registerNewUser}>
                    Register
                    </button>
                </form>
            </div>
        );
    }
}

export default newshopperpage;