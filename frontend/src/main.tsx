import React from 'react';
import ReactDOM from 'react-dom/client';
import {createRouter, RouterProvider} from '@tanstack/react-router';
import { Route as RootRoute } from './routes/__root';

const router = createRouter({
    routeTree: RootRoute,
    context: {}
});

ReactDOM.createRoot(document.getElementById('root')!).render(
    <React.StrictMode>
        <RouterProvider router={router} />
    </React.StrictMode>
)