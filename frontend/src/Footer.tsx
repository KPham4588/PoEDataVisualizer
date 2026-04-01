import './css/Footer.css';
import {Link} from '@tanstack/react-router';

export default function Footer() {
    return (
        <footer className="footer">
            <Link to="/Attributions">Attributions</Link>
        </footer>
    )
}