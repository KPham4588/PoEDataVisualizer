import {StrictMode} from 'react'
import {createRoot} from 'react-dom/client'
import './index.css'
import {BrowserRouter} from "react-router-dom";
import Home from "./Home.tsx"

createRoot(document.getElementById('root')!).render(
    <StrictMode>
        <BrowserRouter>
            <Home/>
        </BrowserRouter>
    </StrictMode>,
)
