import './Header.css';
import {Link} from "react-router-dom";

export default function Header() {
    return (
        <header className="header">
            <h1 className="header-menu-button">
                <Link to="/greatest-hits">Greatest Hits</Link>
                {/*<a href="/greatest-hits">Greatest Hits2</a>*/}
            </h1>
            <h1 className="header-menu-button">
                <Link to="/divine-orbs">Divine Orbs</Link>
            </h1>
            <h1 className="header-menu-button">
                <Link to="/about">About</Link>
            </h1>
        </header>
    )
}