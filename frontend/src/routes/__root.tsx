// src/routes/__root.tsx
import {
    Outlet,
    createRootRoute,
    HeadContent,
    Scripts,
} from '@tanstack/react-router'
import type { ReactNode } from 'react'
import Header from "../Header.tsx";
import Footer from "../Footer.tsx";
import '../css/root.css';

function RootComponent() {
    return (
        <RootDocument>
            <PageLayout/>
        </RootDocument>
    )
}

function RootDocument({ children }: Readonly<{ children: ReactNode }>) {
    return (
        <html>
            <head>
                <HeadContent />
            </head>
        <body>
            {children}
            <Scripts />
        </body>
        </html>
    )
}

function PageLayout() {
    return (
        <div className="root">
            <div className="parent">
                <Header/>
                <div className="main-body">
                    <Outlet/>
                </div>
                <Footer/>
            </div>
        </div>
    )
}

export const Route = createRootRoute({
    head: () => ({
        meta: [
            {
                charSet: 'utf-8',
            },
            {
                name: 'viewport',
                content: 'width=device-width, initial-scale=1',
            },
            {
                title: 'POE Oracle',
            },
        ],
    }),
    component: RootComponent,
})