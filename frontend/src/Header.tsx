import './Header.css';
import {Link} from "react-router-dom";

export default function Header() {
    return (
        <header className="header">
            <Link to="/">
                <img src="/assets/Oracle-Orb-Logo.png" className="header-menu-icon"/>
            </Link>
            <Link to="/greatest-hits" className="header-menu-button">Greatest Hits</Link>
            <Link to="/divine-orbs" className="header-menu-button">Divine Orbs</Link>
            <Link to="/about" className="header-menu-button">About</Link>
        </header>
    )
}