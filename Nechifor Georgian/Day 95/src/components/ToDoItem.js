import React from 'react';
import '../style/item.css';
function ToDoItem() {
    let html = (
        <div className="item">
            <input type="checkbox"/>
            <p>ToDo Item placeholder text</p>
        </div>
    );
    return html;
};

export default ToDoItem;