import { defineConfig } from 'vite'
import react from '@vitejs/plugin-react'

// https://vite.dev/config/
export default defineConfig({
  plugins: [
    react({
      babel: {
        plugins: [['babel-plugin-react-compiler']],
      },
    }),
  ],
//   This specifies that vite should build into the default location
//   where Spring Boot is expecting static resources to be located
  build: {
    outDir: '../src/main/resources/static',
    emptyOutDir: true,
  },
})
