import './Home.css';
import './Header.tsx'
import Header from "./Header.tsx";
import {Route, Routes} from "react-router-dom";
import GreatestHits from "./GreatestHits.tsx";
import About from "./About.tsx";
import Footer from "./Footer";
import Attributions from "./Attributions.tsx";

export default function Home() {
    return (
        <div className="root">
            <div className="parent">
                <Header/>
                <div className="main-body">
                    <Routes>
                        <Route path="/greatest-hits" element={<GreatestHits/>} />
                        <Route path="/about" element={<About/>} />
                        <Route path="/attributions" element={<Attributions/>} />
                    </Routes>
                </div>
                <Footer/>
            </div>
        </div>
    )
}