import React from 'react';
import './App.css';
import Home from './Home';
import { BrowserRouter as Router, Route, Routes } from 'react-router-dom';
import ExpenseList from './ExpenseList';
import ExpenseEdit from './ExpenseEdit';

const App = () => {
    return (
        <Router>
            <Routes>
                <Route exact path="/" element={<Home/>}/>
                <Route path='/expenses' exact={true} element={<ExpenseList/>}/>
                <Route path='/expenses/:id' element={<ExpenseEdit/>}/>
            </Routes>
        </Router>
    )
}

export default App;