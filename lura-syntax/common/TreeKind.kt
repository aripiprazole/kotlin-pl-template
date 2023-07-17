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

enum class TreeKind {
  Error,

  File,

  ListTree,

  LitNat,
  LitInt8,
  LitUInt8,
  LitInt16,
  LitUInt16,
  LitInt32,
  LitUInt32,
  LitInt64,
  LitUInt64,
  LitInt128,
  LitUInt128,

  LitFloat32,
  LitFloat64,

  LitTrue,
  LitFalse,

  LitString,

  SymbolIdentifier,
  QualifiedPathTree,

  ExprUnit,
  ExprGroup,
  ExprBinary,
  ExprAccessor,
  ExprApp,
  ExprDsl,
  ExprArray,
  ExprLam,
  ExprLet,
  ExprLocal,
  ExprSelf,
  ExprLit,
  ExprAnn,
  ExprQual,
  ExprPi,
  ExprSigma,
  ExprHelp,
  ExprIf,
  ExprMatch,

  AccessorArg,
  AccessorExpr,

  BranchExpr,
  BranchBlock,

  IfThen,
  IfElse,

  MatchCase,

  IdSymbol,

  PatWildcard,
  PatSpread,
  PatLit,
  PatGlobal,
  PatConstructor,
  PatConstructorList,
  PatList,
  PatGroup,
  PatUnit,

  StmtAsk,
  StmtLet,
  StmtReturn,
  StmtExpr,
  StmtIf,

  LetBinding,

  BodyValue,
  BodyDo,

  DeclUse,
  DeclSignature,
  DeclAssign,
  DeclCommand,
  DeclClass,
  DeclTrait,
  DeclEnum,
  DeclInstance,

  EnumGadtType,

  WhereClause,

  ClassField,
  ClassMethod,

  InstanceImpl,

  TraitDefault,

  VariantConstructor,
  VariantType,

  Param,
  SelfParam,
  LamParam,

  TypeConstraint,

  PropertyField,
  PropertyMethod,

  TypeInfer,
  TypeExplicit, ;

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
