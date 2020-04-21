import React from 'react';

import ToDoItem from './ToDoItem';
import ContactCard from './ContactCard';
import '../style/item.css'
function App() {

    let html = (
        <div>
            <div className="app">
                <ToDoItem />
                <ToDoItem />
                <ToDoItem />
                <ToDoItem />
            </div>
            <div className="contacts">
                <ContactCard
                    url='https://shorturl.at/CEJOR'
                    name='Mr. MojoJojo'
                    number='53141535123'
                    mail='example@gmail.com'
                />
                <ContactCard
                    url='https://shorturl.at/kxyV9'
                    name='Mr. Frac Sinatra'
                    number='112911'
                    mail='franc@gmail.com'
                />
                <ContactCard
                    url='https://shorturl.at/dtwyM'
                    name='Mr. Nowton'
                    number='8887562123'
                    mail='georgian@gmail.com'
                />
                <ContactCard
                    url='https://shorturl.at/hnDL8'
                    name='Mr. Frankeinsten'
                    number='87645643'
                    mail='yesman@gmail.com'
                />
            </div>
        </div>
    );

    return html;
};


export default App;