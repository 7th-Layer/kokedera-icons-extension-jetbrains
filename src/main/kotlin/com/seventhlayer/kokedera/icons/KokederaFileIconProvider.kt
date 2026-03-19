package com.seventhlayer.kokedera.icons

import com.intellij.ide.FileIconProvider
import com.intellij.openapi.project.Project
import com.intellij.openapi.util.IconLoader
import com.intellij.openapi.vfs.VirtualFile
import javax.swing.Icon

class KokederaFileIconProvider : FileIconProvider {

    override fun getIcon(file: VirtualFile, flags: Int, project: Project?): Icon? {
        if (file.isDirectory) return null
        return getFileIcon(file.name, file.extension)
    }

    private fun getFileIcon(fileName: String, extension: String?): Icon? {
        // Check exact filename first
        FILE_NAMES[fileName]?.let { return loadIcon(it) }

        // Check compound extensions (e.g., d.ts, test.js)
        val lowerName = fileName.lowercase()
        for ((suffix, iconName) in COMPOUND_EXTENSIONS) {
            if (lowerName.endsWith(suffix)) return loadIcon(iconName)
        }

        // Check file extension
        extension?.lowercase()?.let { ext ->
            FILE_EXTENSIONS[ext]?.let { return loadIcon(it) }
        }

        return null
    }

    private fun loadIcon(name: String): Icon {
        return IconLoader.getIcon("/icons/$name.svg", KokederaFileIconProvider::class.java)
    }

    companion object {
        private val COMPOUND_EXTENSIONS = listOf(
            ".d.ts" to "ts-def",
            ".d.mts" to "ts-def",
            ".d.cts" to "ts-def",
            ".test.js" to "test",
            ".test.ts" to "test",
            ".test.jsx" to "test",
            ".test.tsx" to "test",
            ".spec.js" to "test",
            ".spec.ts" to "test",
            ".spec.jsx" to "test",
            ".spec.tsx" to "test",
            ".stories.js" to "test",
            ".stories.ts" to "test",
            ".stories.jsx" to "test",
            ".stories.tsx" to "test",
            ".env.local" to "env-local",
            ".env.development" to "env-local",
            ".env.production" to "env-local",
            ".env.staging" to "env-local",
            ".env.test" to "env-local",
        )

        private val FILE_NAMES = mapOf(
            // Package managers
            "package.json" to "package",
            "package-lock.json" to "lockfile",
            "yarn.lock" to "lockfile",
            "pnpm-lock.yaml" to "lockfile",
            "Gemfile.lock" to "lockfile",
            "Cargo.lock" to "lockfile",
            "poetry.lock" to "lockfile",
            "composer.lock" to "lockfile",
            "Pipfile.lock" to "lockfile",
            "bun.lockb" to "lockfile",
            "go.sum" to "lockfile",
            "flake.lock" to "lockfile",
            "deno.lock" to "lockfile",
            "Cargo.toml" to "package",
            "Gemfile" to "package",
            "Pipfile" to "package",
            "pyproject.toml" to "package",
            "setup.py" to "package",
            "setup.cfg" to "package",
            "composer.json" to "package",
            "go.mod" to "package",
            ".npmrc" to "package",
            ".yarnrc" to "package",
            ".pnpmfile.cjs" to "package",
            "pnpm-workspace.yaml" to "package",
            "bun.toml" to "package",
            "bunfig.toml" to "package",
            "Brewfile" to "package",

            // Git
            ".gitignore" to "gitignore",
            ".gitattributes" to "gitignore",
            ".gitmodules" to "gitignore",

            // Env
            ".env" to "env",
            ".env.example" to "env",
            ".env.sample" to "env",

            // Build tools
            "Makefile" to "make",
            "makefile" to "make",
            "GNUmakefile" to "make",
            "CMakeLists.txt" to "make",
            "Justfile" to "make",
            "justfile" to "make",

            // Docker
            "Dockerfile" to "docker",
            "dockerfile" to "docker",
            "Containerfile" to "docker",
            "Earthfile" to "docker",
            ".dockerignore" to "docker",
            ".containerignore" to "docker",
            "docker-compose.yml" to "docker-compose",
            "docker-compose.yaml" to "docker-compose",
            "compose.yml" to "docker-compose",
            "compose.yaml" to "docker-compose",

            // CI/CD
            "Jenkinsfile" to "jenkinsfile",
            ".gitlab-ci.yml" to "gitlab-ci",
            "nginx.conf" to "nginx",

            // Docs
            "LICENSE" to "license",
            "LICENSE.md" to "license",
            "LICENSE.txt" to "license",
            "LICENCE" to "license",
            "LICENCE.md" to "license",
            "LICENCE.txt" to "license",
            "COPYING" to "license",
            "README" to "readme",
            "README.md" to "readme",
            "README.txt" to "readme",
            "README.rst" to "readme",
            "CHANGELOG" to "changelog",
            "CHANGELOG.md" to "changelog",
            "CHANGELOG.txt" to "changelog",
            "CHANGES" to "changelog",
            "CHANGES.md" to "changelog",
            "HISTORY" to "changelog",
            "HISTORY.md" to "changelog",
            "RELEASE_NOTES.md" to "changelog",

            // Linters
            ".eslintrc" to "eslint",
            ".eslintrc.js" to "eslint",
            ".eslintrc.cjs" to "eslint",
            ".eslintrc.json" to "eslint",
            ".eslintrc.yml" to "eslint",
            ".eslintrc.yaml" to "eslint",
            "eslint.config.js" to "eslint",
            "eslint.config.mjs" to "eslint",
            "eslint.config.cjs" to "eslint",
            "eslint.config.ts" to "eslint",
            "biome.json" to "eslint",
            "biome.jsonc" to "eslint",
            ".oxlintrc.json" to "eslint",
            ".prettierrc" to "prettier",
            ".prettierrc.js" to "prettier",
            ".prettierrc.cjs" to "prettier",
            ".prettierrc.json" to "prettier",
            ".prettierrc.yml" to "prettier",
            ".prettierrc.yaml" to "prettier",
            ".prettierrc.toml" to "prettier",
            "prettier.config.js" to "prettier",
            "prettier.config.cjs" to "prettier",
            "prettier.config.mjs" to "prettier",
            ".prettierignore" to "prettier",
            ".editorconfig" to "editorconfig",

            // Bundlers & frameworks
            "webpack.config.js" to "webpack",
            "webpack.config.ts" to "webpack",
            "webpack.config.cjs" to "webpack",
            "webpack.config.mjs" to "webpack",
            "vite.config.js" to "vite",
            "vite.config.ts" to "vite",
            "vite.config.mjs" to "vite",
            "vite.config.mts" to "vite",
            "babel.config.js" to "babel",
            "babel.config.cjs" to "babel",
            "babel.config.mjs" to "babel",
            "babel.config.json" to "babel",
            ".babelrc" to "babel",
            ".babelrc.json" to "babel",
            "next.config.js" to "nextjs",
            "next.config.mjs" to "nextjs",
            "next.config.ts" to "nextjs",
            "tailwind.config.js" to "tailwind",
            "tailwind.config.ts" to "tailwind",
            "tailwind.config.cjs" to "tailwind",
            "tailwind.config.mjs" to "tailwind",
            ".npmignore" to "npmignore",

            // TypeScript configs
            "tsconfig.json" to "typescript",
            "tsconfig.build.json" to "typescript",
            "tsconfig.app.json" to "typescript",
            "tsconfig.node.json" to "typescript",

            // Framework configs
            "angular.json" to "angular",
            ".angular-cli.json" to "angular",
            "svelte.config.js" to "svelte",
            "svelte.config.ts" to "svelte",
            "astro.config.mjs" to "astro",
            "astro.config.ts" to "astro",
            "nuxt.config.js" to "vue",
            "nuxt.config.ts" to "vue",
            "vue.config.js" to "vue",

            // Gradle / Maven
            "gradlew" to "shell",
            "gradlew.bat" to "shell",
            "build.gradle" to "java",
            "settings.gradle" to "java",
            "build.gradle.kts" to "kotlin",
            "settings.gradle.kts" to "kotlin",
            "gradle.properties" to "toml",
            "gradle-wrapper.properties" to "toml",
            "pom.xml" to "xml",
            "mvnw" to "shell",
            "mvnw.cmd" to "shell",

            // Spring Boot
            "application.yml" to "yaml",
            "application.yaml" to "yaml",
            "application.properties" to "toml",
            "application-dev.yml" to "yaml",
            "application-dev.yaml" to "yaml",
            "application-prod.yml" to "yaml",
            "application-prod.yaml" to "yaml",
            "bootstrap.yml" to "yaml",
            "bootstrap.yaml" to "yaml",

            // Misc
            "Procfile" to "shell",
            "flake.nix" to "nix",
            "schema.prisma" to "prisma",
            "Rakefile" to "ruby",
            "Vagrantfile" to "ruby",

            // CSS tools
            "postcss.config.js" to "css",
            "postcss.config.cjs" to "css",
            "postcss.config.mjs" to "css",
            "postcss.config.ts" to "css",

            // Test configs
            "jest.config.js" to "test",
            "jest.config.ts" to "test",
            "jest.config.mjs" to "test",
            "jest.config.cjs" to "test",
            "vitest.config.js" to "test",
            "vitest.config.ts" to "test",
            "vitest.config.mts" to "test",
            "cypress.config.js" to "test",
            "cypress.config.ts" to "test",
            "playwright.config.js" to "test",
            "playwright.config.ts" to "test",

            // DB
            "drizzle.config.ts" to "sql",
            "drizzle.config.js" to "sql",
            "knexfile.js" to "sql",
            "knexfile.ts" to "sql",

            // Deploy
            "vercel.json" to "json",
            "netlify.toml" to "toml",
            "wrangler.toml" to "toml",
            "fly.toml" to "toml",
        )

        private val FILE_EXTENSIONS = mapOf(
            // JavaScript / TypeScript
            "js" to "javascript",
            "mjs" to "javascript",
            "cjs" to "javascript",
            "coffee" to "javascript",
            "ts" to "typescript",
            "mts" to "typescript",
            "cts" to "typescript",
            "jsx" to "jsx",
            "tsx" to "jsx",

            // Web
            "html" to "html",
            "htm" to "html",
            "xhtml" to "html",
            "pug" to "html",
            "jade" to "html",
            "njk" to "html",
            "twig" to "html",
            "liquid" to "html",
            "jinja" to "html",
            "jinja2" to "html",
            "j2" to "html",
            "css" to "css",
            "pcss" to "css",
            "postcss" to "css",
            "scss" to "scss",
            "sass" to "scss",
            "less" to "less",
            "vue" to "vue",
            "svelte" to "svelte",
            "astro" to "astro",
            "hbs" to "handlebars",
            "handlebars" to "handlebars",
            "mustache" to "handlebars",
            "ejs" to "ejs",
            "svg" to "svg",

            // Data & Config
            "json" to "json",
            "jsonc" to "json",
            "json5" to "json",
            "jsonl" to "json",
            "geojson" to "json",
            "webmanifest" to "json",
            "yml" to "yaml",
            "yaml" to "yaml",
            "ini" to "yaml",
            "conf" to "yaml",
            "cfg" to "yaml",
            "properties" to "yaml",
            "toml" to "toml",
            "xml" to "xml",
            "xsl" to "xml",
            "xslt" to "xml",
            "xsd" to "xml",
            "plist" to "xml",
            "csproj" to "xml",
            "fsproj" to "xml",
            "vbproj" to "xml",
            "vcxproj" to "xml",
            "csv" to "csv",
            "tsv" to "csv",
            "iml" to "xml",
            "graphql" to "graphql",
            "gql" to "graphql",
            "proto" to "protobuf",
            "env" to "env",

            // Languages
            "py" to "python",
            "pyi" to "python",
            "pyw" to "python",
            "pyx" to "python",
            "rs" to "rust",
            "ron" to "rust",
            "go" to "go",
            "c" to "c",
            "h" to "c",
            "cpp" to "cpp",
            "cc" to "cpp",
            "cxx" to "cpp",
            "hpp" to "cpp",
            "hxx" to "cpp",
            "hh" to "cpp",
            "ino" to "cpp",
            "cs" to "csharp",
            "fs" to "csharp",
            "fsx" to "csharp",
            "java" to "java",
            "jar" to "java",
            "class" to "java",
            "jsp" to "java",
            "gradle" to "java",
            "groovy" to "java",
            "kt" to "kotlin",
            "kts" to "kotlin",
            "rb" to "ruby",
            "erb" to "ruby",
            "gemspec" to "ruby",
            "cr" to "ruby",
            "php" to "php",
            "phtml" to "php",
            "swift" to "swift",
            "dart" to "dart",
            "zig" to "zig",
            "ex" to "elixir",
            "exs" to "elixir",
            "eex" to "elixir",
            "heex" to "elixir",
            "erl" to "elixir",
            "hrl" to "elixir",
            "hs" to "haskell",
            "lhs" to "haskell",
            "elm" to "haskell",
            "ml" to "haskell",
            "mli" to "haskell",
            "scala" to "scala",
            "sc" to "scala",
            "sbt" to "scala",
            "lua" to "lua",
            "luau" to "lua",
            "r" to "r",
            "R" to "r",
            "rmd" to "r",
            "jl" to "r",
            "pl" to "perl",
            "pm" to "perl",
            "clj" to "clojure",
            "cljs" to "clojure",
            "cljc" to "clojure",
            "edn" to "clojure",
            "gleam" to "gleam",
            "nix" to "nix",
            "prisma" to "prisma",
            "wasm" to "wasm",
            "wat" to "wasm",
            "glsl" to "wasm",
            "hlsl" to "wasm",
            "wgsl" to "wasm",

            // Shell
            "sh" to "shell",
            "bash" to "shell",
            "zsh" to "shell",
            "fish" to "shell",
            "bat" to "shell",
            "cmd" to "shell",
            "ps1" to "shell",
            "psm1" to "shell",

            // SQL
            "sql" to "sql",
            "sqlite" to "sql",
            "sqlite3" to "sql",
            "pgsql" to "sql",
            "mysql" to "sql",

            // DevOps
            "tf" to "terraform",
            "tfvars" to "terraform",
            "hcl" to "terraform",
            "tfstate" to "terraform",
            "dockerfile" to "docker",
            "dockerignore" to "docker",

            // Documents
            "md" to "markdown",
            "markdown" to "markdown",
            "mdx" to "mdx",
            "txt" to "txt",
            "log" to "txt",
            "doc" to "txt",
            "docx" to "txt",
            "rtf" to "txt",
            "pdf" to "pdf",
            "epub" to "pdf",
            "rst" to "rst",
            "adoc" to "rst",
            "tex" to "latex",
            "latex" to "latex",
            "bib" to "latex",
            "typ" to "latex",
            "ipynb" to "jupyter",

            // Build
            "mk" to "make",
            "cmake" to "make",
            "sln" to "build",
            "lock" to "lockfile",
            "map" to "sourcemap",

            // Media
            "png" to "image",
            "jpg" to "image",
            "jpeg" to "image",
            "gif" to "image",
            "bmp" to "image",
            "ico" to "image",
            "webp" to "image",
            "avif" to "image",
            "tiff" to "image",
            "psd" to "image",
            "ttf" to "font",
            "otf" to "font",
            "woff" to "font",
            "woff2" to "font",
            "eot" to "font",
            "mp3" to "audio",
            "wav" to "audio",
            "ogg" to "audio",
            "flac" to "audio",
            "aac" to "audio",
            "m4a" to "audio",
            "mp4" to "video",
            "avi" to "video",
            "mov" to "video",
            "mkv" to "video",
            "webm" to "video",
            "obj" to "3d",
            "fbx" to "3d",
            "gltf" to "3d",
            "glb" to "3d",
            "stl" to "3d",
            "blend" to "3d",

            // Archives
            "zip" to "archive",
            "tar" to "archive",
            "gz" to "archive",
            "7z" to "archive",
            "rar" to "archive",
            "tgz" to "archive",
            "bz2" to "archive",
            "xz" to "archive",
            "deb" to "archive",
            "rpm" to "archive",
            "dmg" to "archive",
            "iso" to "archive",

            // Security
            "pem" to "key",
            "cer" to "key",
            "cert" to "key",
            "crt" to "key",
            "pub" to "key",
            "gpg" to "key",
            "p12" to "key",
            "pfx" to "key",
            "keystore" to "key",
            "jks" to "key",

            // Git
            "gitignore" to "gitignore",
            "gitattributes" to "gitignore",
            "patch" to "gitignore",
            "diff" to "gitignore",

            // Test
            "feature" to "test",
            "snap" to "test",
        )

    }
}
