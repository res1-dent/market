import org.gradle.kotlin.dsl.DependencyHandlerScope

fun DependencyHandlerScope.implement(dependency: String) {
    add("implementation", dependency)
}

fun DependencyHandlerScope.implement(deps: List<String>) {
    deps.forEach {
        implement(it)
    }
}
