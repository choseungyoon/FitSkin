# Flairo

Thanks for purchasing the Flairo Theme! In order to get started, you'll need to unzip the downloaded project and extract it to a location. For instructional purposes, we will assume you extract it to your home folder `~`.

When you unzip it, you'll need to `cd` into the `~/flairo-theme` directory and ensure youre able to access node and npm/yarn binaries. The following commands should check that youre able to do so.
`node -v`
`npm -v`

Once in the directory, the following instructions will show you how to get started with `yarn` or `npm`.

This package can be auto-deployed via the [Vercel CLI](https://vercel.com/docs/cli#getting-started) by:
```bash
vercel
```
The first run will prompt some questions to properly configure your project which should auto-detect a Vue.js application and properly deploy it if you dont override it.

## Project setup
```
yarn install
npm install
```

### Compiles and hot-reloads for development
```
yarn serve
npm run serve
```

### Compiles and minifies for production
```
yarn build
npm run build
```

### Lints and fixes files
```
yarn lint
npm run lint
```

### Customize configuration
See [Configuration Reference](https://cli.vuejs.org/config/).
