import './css/Header.css';
import { Link } from '@tanstack/react-router';

export default function Header() {
    return (
        <header className="header">
            <Link to="/">
                <img src="/assets/Oracle-Orb-Logo.png" className="header-menu-icon"/>
            </Link>
            <Link to="/GreatestHits" className="header-menu-button">Greatest Hits</Link>
            <div className="header-menu-button">Divine Orbs</div>
            <Link to="/About" className="header-menu-button">About</Link>
        </header>
    )
}