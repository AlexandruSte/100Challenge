import React from 'react';

import Nav from './Nav';
import MyInfo from './MyInfo';
import Footer from './Footer';

function App() {
    let app = (
        <div>
            <Nav/>
            <MyInfo/>
            <Footer/>
        </div>
    );
    return app;
}

export default App;