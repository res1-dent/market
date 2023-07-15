package ru.hometech.core_common

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.compositionLocalOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import ru.hometech.core_common.di.FeatureComponent

@Composable
inline fun <reified T : FeatureComponent, reified VM : ViewModel, reified A : Action, reified S : State> createScreenWithDaggerMviViewModel(
    component: T,
    crossinline content: @Composable (viewModel: VM) -> Unit
) {
    val viewModel = viewModel(key = T::class.java.name) {
        component.getViewModelFactory().create(VM::class.java)
    } as BaseViewModel<S, A>

    content(viewModel as VM)
}