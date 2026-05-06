import {Outlet, createRootRoute} from '@tanstack/react-router'
import Header from "../Header.tsx";
import Footer from "../Footer.tsx";
import '../css/root.css';
import {QueryClient, QueryClientProvider} from "@tanstack/react-query";

function RootComponent() {
    const queryClient = new QueryClient()
    return (
        <QueryClientProvider client={queryClient}>
        <div className="root">
            <div className="parent">
                <Header/>
                <div className="main-body">
                    <Outlet/>
                </div>
                <Footer/>
            </div>
        </div>
        </QueryClientProvider>
    )
}

export const Route = createRootRoute({
    component: RootComponent,
})