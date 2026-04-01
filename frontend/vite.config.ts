import {defineConfig} from 'vite'
import viteReact from '@vitejs/plugin-react'
import tsConfigPaths from 'vite-tsconfig-paths'
import {tanstackStart} from '@tanstack/react-start/plugin/vite'

// https://vite.dev/config/
export default defineConfig({
    plugins: [
      tsConfigPaths(),
      tanstackStart(),
      viteReact({
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
    resolve: {
        alias: {
        }
    }
})
