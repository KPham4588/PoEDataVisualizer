import './Footer.css';
import {Link} from "react-router-dom";

export default function Footer() {
    return (
        <footer className="footer">
            <Link to="/attributions">Attributions</Link>
        </footer>
    )
}