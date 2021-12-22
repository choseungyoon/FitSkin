module.exports = {
  root: true,
  env: {
    node: true,
  },
  extends: 'vuetify',
  parserOptions: {
    parser: 'babel-eslint',
  },
  rules: {
    'no-console': 'off',
    'no-debugger': 'off',
    'linebreak-style': ['error', 'unix'],
    'vue/require-default-prop': 'off',
    'template-curly-spacing': 'off',
  },
}
