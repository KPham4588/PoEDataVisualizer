// src/routes/index.tsx
import { createFileRoute } from '@tanstack/react-router'

function Index() {
    return (
        <div className="main-body">
            <h1>Welcome to the Home Page!</h1>
            <p>This content is inside main-body.</p>
        </div>
    )
}

export const Route = createFileRoute('/')({
    component: Index,
})