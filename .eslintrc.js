/*
 *     Copyright 2022 Gabrielle Guimarães de Oliveira
 *
 *     Licensed under the Apache License, Version 2.0 (the "License");
 *     you may not use this file except in compliance with the License.
 *     You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 *     Unless required by applicable law or agreed to in writing, software
 *     distributed under the License is distributed on an "AS IS" BASIS,
 *     WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *     See the License for the specific language governing permissions and
 *     limitations under the License.
 */

module.exports = {
  env: {
    browser: false,
    es2021: true,
    mocha: true,
    node: true,
  },
  extends: ['google'],
  parser: '@typescript-eslint/parser',
  parserOptions: {
    ecmaFeatures: {
      jsx: true,
    },
    ecmaVersion: 12,
    sourceType: 'module',
  },
  plugins: ['prettier', '@typescript-eslint'],
  settings: {
    react: {
      version: 'detect',
    },
  },
  rules: {
    'require-jsdoc': ['off'],
    'react/prop-types': ['off'],
    'spaced-comment': ['off'],
    'prettier/prettier': ['error', {}, {usePrettierrc: true}],
    'react/no-children-prop': ['off'],
    'indent': ['off'],
    'quotes': ['off'],
    'max-len': ['off'],
    'no-unused-vars': ['off'],
    'operator-linebreak': ['error', 'after', {overrides: {'?': 'before', ':': 'before'}}],
  },
};
