package com.seventhlayer.kokedera.icons

import com.intellij.ide.IconProvider
import com.intellij.openapi.project.DumbAware
import com.intellij.openapi.util.IconLoader
import com.intellij.psi.PsiDirectory
import com.intellij.psi.PsiElement
import javax.swing.Icon

class KokederaDirectoryIconProvider : IconProvider(), DumbAware {

    override fun getIcon(element: PsiElement, flags: Int): Icon? {
        if (element !is PsiDirectory) return null
        val name = element.name.lowercase()
        FOLDER_NAMES[name]?.let { return loadIcon(it) }
        return loadIcon("folder-closed")
    }

    private fun loadIcon(name: String): Icon {
        return IconLoader.getIcon("/icons/$name.svg", KokederaDirectoryIconProvider::class.java)
    }

    companion object {
        private val FOLDER_NAMES = mapOf(
            "src" to "folder-src-closed",
            "source" to "folder-src-closed",
            "lib" to "folder-lib-closed",
            "libs" to "folder-lib-closed",
            "vendor" to "folder-lib-closed",
            "packages" to "folder-lib-closed",
            "test" to "folder-tests-closed",
            "tests" to "folder-tests-closed",
            "__tests__" to "folder-tests-closed",
            "__test__" to "folder-tests-closed",
            "spec" to "folder-tests-closed",
            "specs" to "folder-tests-closed",
            "e2e" to "folder-tests-closed",
            "cypress" to "folder-tests-closed",
            "public" to "folder-public-closed",
            "static" to "folder-public-closed",
            "wwwroot" to "folder-public-closed",
            "assets" to "folder-assets-closed",
            "resources" to "folder-assets-closed",
            "res" to "folder-assets-closed",
            "media" to "folder-assets-closed",
            "images" to "folder-assets-closed",
            "img" to "folder-assets-closed",
            "config" to "folder-config-closed",
            "configs" to "folder-config-closed",
            "configuration" to "folder-config-closed",
            "settings" to "folder-config-closed",
            ".idea" to "folder-config-closed",
            ".git" to "folder-git-closed",
            ".github" to "folder-github-closed",
            "node_modules" to "folder-node-modules-closed",
            ".next" to "folder-build-closed",
            ".nuxt" to "folder-build-closed",
            ".svelte-kit" to "folder-build-closed",
            "dist" to "folder-build-closed",
            "build" to "folder-build-closed",
            "out" to "folder-build-closed",
            "output" to "folder-build-closed",
            "target" to "folder-build-closed",
            "bin" to "folder-build-closed",
            "scripts" to "folder-scripts-closed",
            "tools" to "folder-scripts-closed",
            "docs" to "folder-docs-closed",
            "doc" to "folder-docs-closed",
            "documentation" to "folder-docs-closed",
            "styles" to "folder-styles-closed",
            "style" to "folder-styles-closed",
            "css" to "folder-styles-closed",
            "scss" to "folder-styles-closed",
            "components" to "folder-components-closed",
            "component" to "folder-components-closed",
            "widgets" to "folder-components-closed",
            "ui" to "folder-components-closed",
            "hooks" to "folder-hooks-closed",
            "composables" to "folder-hooks-closed",
            "utils" to "folder-utils-closed",
            "util" to "folder-utils-closed",
            "helpers" to "folder-utils-closed",
            "common" to "folder-utils-closed",
            "shared" to "folder-utils-closed",
            "api" to "folder-api-closed",
            "apis" to "folder-api-closed",
            "routes" to "folder-api-closed",
            "endpoints" to "folder-api-closed",
            "db" to "folder-database-closed",
            "database" to "folder-database-closed",
            "migrations" to "folder-database-closed",
            "seeds" to "folder-database-closed",
            "prisma" to "folder-database-closed",
            "docker" to "folder-docker-closed",
            ".docker" to "folder-docker-closed",
            "pages" to "folder-pages-closed",
            "views" to "folder-pages-closed",
            "screens" to "folder-pages-closed",
            "layouts" to "folder-pages-closed",
            "app" to "folder-pages-closed",
            "types" to "folder-types-closed",
            "typings" to "folder-types-closed",
            "@types" to "folder-types-closed",
            "interfaces" to "folder-types-closed",
        )
    }
}
