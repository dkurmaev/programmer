import React from 'react';

class ClassCounter extends React.Component {

    constructor(props) {
        super(props);
        this.state = {
            count: 0
        };
        this.decrement = this.decrement.bind(this);
        this.increment = this.increment.bind(this);
    }

    decrement() {
        this.setState({count: this.state.count - 1});
    }

    increment() {
        this.setState({count: this.state.count + 1});
    }
    render() {
        return (
        <div>
            <h1>Counter</h1>
            <p>Current Count: {this.state.count}</p>
            <button onClick={this.increment}>Increment</button>
            <button onClick={this.decrement}>Decrement</button>
            <button onClick={() => this.setState({count: 0})}>Reset</button>
        </div>
        );
    }
}
export default ClassCounter;
