import React from 'react';
import '../style/nav.css';

function Nav() {
    let nav = (
        <div>
            <ul id="nav">
                <li>Home</li>
                <li>About</li>
                <li>Contact</li>
            </ul>
        </div>
    );
    return nav;
};

export default Nav;