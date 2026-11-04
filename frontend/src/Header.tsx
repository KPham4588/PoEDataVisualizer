import './css/Header.css';
import { Link } from '@tanstack/react-router';

export default function Header() {
    return (
        <header className="header">
            <Link to="/">
                <img alt="POEDataVisualizer Logo" src="/assets/Oracle-Orb-Logo.png" className="header-menu-icon"/>
            </Link>
            <Link to="/GreatestHits" className="header-menu-button" activeProps={{ id: 'active' }} activeOptions={{ exact: true, includeSearch: false }}>
                Greatest Hits
            </Link>

            <Link to="/ExchangeRates" className="header-menu-button" activeProps={{ id: 'active' }} activeOptions={{ exact: true, includeSearch: false }}>
                Exchange Rates
            </Link>

            <Link to="/About" className="header-menu-button" activeProps={{ id: 'active' }} activeOptions={{ exact: true, includeSearch: false }}>
                About
            </Link>
        </header>
    )
}