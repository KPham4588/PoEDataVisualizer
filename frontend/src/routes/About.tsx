import { createFileRoute } from '@tanstack/react-router';
import '../css/About.css';

function About() {
    return(
        <div>
            <p className="body-block">
                We know we can get the About page via File-based routing!
            </p>
            <p className="body-block">sdasadsadsa dsadsadsads adsadsadsa dsadsadsad sadsadsadsa</p>
        </div>
    )
}

export const Route = createFileRoute('/About')({
    component: About,
})