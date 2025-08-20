import { defineConfig } from 'vite'
import react from '@vitejs/plugin-react'
import tailwindcss from '@tailwindcss/vite'

// https://vite.dev/config/
export default defineConfig({
  plugins: [react(), tailwindcss()],
  base: '/Shital-Projects/',   // 👈 add this (must match your repo name exactly!)
  server: {
    port: 3000,
  },
})
