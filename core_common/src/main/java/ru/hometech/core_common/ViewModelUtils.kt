package ru.hometech.core_common

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.compositionLocalOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import ru.hometech.core_common.di.FeatureComponent

val LocalViewModel = compositionLocalOf<ViewModel?> { null }

@Composable
inline fun <reified T : FeatureComponent, reified VM : ViewModel> createScreenWithDaggerViewModel(
    component: T,
    crossinline content: @Composable () -> Unit
) {
    val viewModel = viewModel(key = T::class.java.name) { component.getViewModelFactory().create(VM::class.java) }
    CompositionLocalProvider(LocalViewModel provides viewModel) {
        content()
    }
}
@Composable
inline fun <reified VM : ViewModel> obtainViewModel(): VM =
    checkNotNull(LocalViewModel.current as? VM){
        "Cant cast ${VM::class.java} to ${LocalViewModel.current?.javaClass}"
    }