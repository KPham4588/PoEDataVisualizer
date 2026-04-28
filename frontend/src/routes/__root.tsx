import {Outlet, createRootRoute} from '@tanstack/react-router'
import Header from "../Header.tsx";
import Footer from "../Footer.tsx";
import '../css/root.css';

function RootComponent() {


    return (
        <div className="root">
            <div className="parent">
                <Header/>
                <div className="main-body">
                    <Outlet/>
                </div>
                <Footer/>
            </div>
        </div>
    )
}

export const Route = createRootRoute({
    component: RootComponent,
})