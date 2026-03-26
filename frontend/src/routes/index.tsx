// src/routes/index.tsx
import { createFileRoute } from '@tanstack/react-router'
import Header from "../Header.tsx";
import Footer from "../Footer.tsx";
import '../css/Home.css';
import '../css/index.css';

function Home() {
    return (
        <div className="root">
            <div className="parent">
                <Header/>
                <div className="main-body">
                </div>
                <Footer/>
            </div>
        </div>
    )
}

export const Route = createFileRoute('/')({
    component: Home,
})