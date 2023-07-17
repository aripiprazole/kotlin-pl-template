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

package lura.lsp

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.asCoroutineDispatcher
import kotlinx.coroutines.future.future
import org.eclipse.lsp4j.CompletionItemOptions
import org.eclipse.lsp4j.CompletionOptions
import org.eclipse.lsp4j.DidChangeConfigurationParams
import org.eclipse.lsp4j.DidChangeTextDocumentParams
import org.eclipse.lsp4j.DidChangeWatchedFilesParams
import org.eclipse.lsp4j.DidCloseTextDocumentParams
import org.eclipse.lsp4j.DidOpenTextDocumentParams
import org.eclipse.lsp4j.DidSaveTextDocumentParams
import org.eclipse.lsp4j.ExecuteCommandOptions
import org.eclipse.lsp4j.InitializeParams
import org.eclipse.lsp4j.InitializeResult
import org.eclipse.lsp4j.ServerCapabilities
import org.eclipse.lsp4j.TextDocumentSyncKind
import org.eclipse.lsp4j.WorkspaceFoldersOptions
import org.eclipse.lsp4j.WorkspaceServerCapabilities
import org.eclipse.lsp4j.jsonrpc.messages.Either
import org.eclipse.lsp4j.launch.LSPLauncher
import org.eclipse.lsp4j.services.LanguageServer
import org.eclipse.lsp4j.services.TextDocumentService
import org.eclipse.lsp4j.services.WorkspaceService
import java.util.concurrent.CompletableFuture
import java.util.concurrent.Executors
import kotlin.coroutines.CoroutineContext

class CoroutineLanguageServer : CoroutineScope, LanguageServer {
  override val coroutineContext: CoroutineContext = Executors.newFixedThreadPool(12).asCoroutineDispatcher()

  override fun initialize(params: InitializeParams): CompletableFuture<InitializeResult> = future {
    InitializeResult().apply {
      capabilities = ServerCapabilities().apply {
        inlayHintProvider = Either.forLeft(false)
        textDocumentSync = Either.forLeft(TextDocumentSyncKind.Full)
        completionProvider = CompletionOptions().apply {
          resolveProvider = false
          triggerCharacters = listOf(".")
          workDoneProgress = false
          allCommitCharacters = listOf()
          completionItem = CompletionItemOptions()
        }
        executeCommandProvider = ExecuteCommandOptions().apply {
          commands = listOf()
          workDoneProgress = false
        }
        workspace = WorkspaceServerCapabilities().apply {
          workspaceFolders = WorkspaceFoldersOptions().apply {
            supported = true
            changeNotifications = Either.forRight(true)
          }
        }
        definitionProvider = Either.forLeft(true)
        referencesProvider = Either.forLeft(true)
        renameProvider = Either.forLeft(true)
      }
    }
  }

  override fun shutdown(): CompletableFuture<Any?> = future {
    null
  }

  override fun exit() {
  }

  override fun getTextDocumentService(): TextDocumentService = object : TextDocumentService {
    override fun didOpen(params: DidOpenTextDocumentParams) {
    }

    override fun didChange(params: DidChangeTextDocumentParams) {
    }

    override fun didClose(params: DidCloseTextDocumentParams) {
    }

    override fun didSave(params: DidSaveTextDocumentParams) {
    }
  }

  override fun getWorkspaceService(): WorkspaceService = object : WorkspaceService {
    override fun didChangeConfiguration(params: DidChangeConfigurationParams) {
    }

    override fun didChangeWatchedFiles(params: DidChangeWatchedFilesParams) {
    }
  }
}

fun main() {
  val launcher = LSPLauncher.createServerLauncher(CoroutineLanguageServer(), System.`in`, System.`out`)
  launcher.startListening().get()
}
