import React, { useEffect, useState } from 'react';
import { Link, useNavigate, useParams } from 'react-router-dom';
import { Button, Container, Form, FormGroup, Input, Label } from 'reactstrap';
import AppNavbar from './AppNavbar';

const ExpenseEdit = () => {
    const initialFormState = {
        date: '',
        description: '',
        amount: '',
    };
    const [expense, setExpense] = useState(initialFormState);
    const navigate = useNavigate();
    const { id } = useParams();

    useEffect(() => {
        if (id !== 'new') {
            fetch(`/api/expense/${id}`)
                .then(response => response.json())
                .then(data => setExpense(data));
        }
    }, [id, setExpense]);

    const handleChange = (event) => {
        const { name, value } = event.target

        setExpense({ ...expense, [name]: value })
    }

    const handleSubmit = async (event) => {
        event.preventDefault();

        await fetch(`/api/expense${expense.id ? `/${expense.id}` : ''}`, {
            method: (expense.id) ? 'PUT' : 'POST',
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(expense)
        });
        setExpense(initialFormState);
        navigate('/expenses');
    }

    const title = <h2>{expense.id ? 'Edit Expense' : 'Add Expense'}</h2>;

    return (<div>
            <AppNavbar/>
            <Container>
                {title}
                <Form onSubmit={handleSubmit}>
                    <FormGroup>
                        <Label for="date">Date</Label>
                        <Input type="text" name="date" id="date" value={expense.date || ''}
                               onChange={handleChange} autoComplete="date"/>
                    </FormGroup>
                    <FormGroup>
                        <Label for="name">Name</Label>
                        <Input type="text" name="name" id="name" value={expense.name || ''}
                               onChange={handleChange} autoComplete="name"/>
                    </FormGroup>
                    <FormGroup>
                        <Label for="description">Description</Label>
                        <Input type="text" name="description" id="description" value={expense.description || ''}
                               onChange={handleChange} autoComplete="address-level1"/>
                    </FormGroup>
                    <FormGroup>
                        <Label for="amount">Amount</Label>
                        <Input type="text" name="amount" id="amount" value={expense.amount || ''}
                               onChange={handleChange} autoComplete="address-level1"/>
                    </FormGroup>
                    <FormGroup>
                        <Button color="primary" type="submit">Save</Button>{' '}
                        <Button color="secondary" tag={Link} to="/expenses">Cancel</Button>
                    </FormGroup>
                </Form>
            </Container>
        </div>
    )
};

export default ExpenseEdit;