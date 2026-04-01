import { StrictMode } from 'react';
import ReactDOM from 'react-dom/client';
import {createRouter, RouterProvider} from '@tanstack/react-router';
import { Route as RootRoute } from './routes/__root';

const router = createRouter({
    routeTree: RootRoute,
    context: {}
});

ReactDOM.createRoot(document.getElementById('root')!).render(
    <StrictMode>
        <RouterProvider router={router} />
    </StrictMode>
)