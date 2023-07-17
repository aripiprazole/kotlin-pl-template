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

package lura.parser

enum class TokenKind {
  Error,

  Nat,

  // keywords
  LetKeyword, // let
  TrueKeyword, // true
  FalseKeyword, // false
  IfKeyword, // if
  ElseKeyword, // else
  ThenKeyword, // then
  TypeKeyword, // type
  RecordKeyword, // record
  ReturnKeyword, // return
  EnumKeyword, // enum
  TraitKeyword, // trait
  ClassKeyword, // class
  CaseKeyword, // case
  WhereKeyword, // where
  MatchKeyword, // match
  UseKeyword, // use
  InstanceKeyword, // instance
  InKeyword, // in
  FunKeyword, // fun
  DefaultKeyword, // default
  SelfKeyword, // self

  // unicode
  LambdaUnicode, // λ
  ForallUnicode, // ∀
  PiUnicode, // Π
  SigmaUnicode, // Σ

  // control symbols
  LeftBracket, // [
  RightBracket, // ]
  LeftBrace, // {
  RightBrace, // }
  LeftParen, // (
  RightParen, // )
  Comma, // ,
  Semi, // ;
  Colon, // :
  Dot, // .
  HelpSymbol, // ?
  EqualSymbol, // =
  HashSymbol, // #

  DoubleArrow, // =>
  RightArrow, // ->
  LeftArrow, // <-

  // integers
  Int8,
  UInt8,
  Int16,
  UInt16,
  Int32,
  UInt32,
  Int64,
  UInt64,
  Int128,
  UInt128,

  // floats
  Float32,
  Float64,

  // literals
  Symbol,
  Identifier,
  Str,

  // end of file
  Eof, ;

  override fun toString(): String {
    return super
      .toString()
      .map { c ->
        when {
          c.isUpperCase() -> "_$c"
          else -> c.uppercase()
        }
      }
      .joinToString("")
  }
}
