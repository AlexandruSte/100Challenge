import React from 'react';
import img from '../img/image0.jpg';

import '../style/item.css';

function ComponentCard(props) {
    let html = (
        <div className="contact-card">
            <img src={props.url} alt="random"/>
            <h3 id="name">{props.name}</h3>
            <p>{props.number}</p>
            <p>{props.mail}</p>
        </div>
    );
    return html;
}

export default ComponentCard;

 