import React from 'react';
import '../style/info.css';

function MyInfo() {
    let html = (
        <div>
            <div id="main">
                <h1 id="name">Georgian Nechifor</h1>
                <p>I can tell about myself a lot of things but i don't have enough space</p>
                <ol title="TODO Trips">
                    <li>Wien</li>
                    <li>Rome</li>
                    <li>Bratislav</li>
                </ol>
            </div>
        </div>
    );
    return html;
};

export default MyInfo;