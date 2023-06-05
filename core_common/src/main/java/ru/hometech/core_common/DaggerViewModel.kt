package ru.hometech.core_common

import androidx.compose.runtime.Composable
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.compose.viewModel
import ru.hometech.core_common.di.BaseComponent
import kotlin.reflect.KClass

@Suppress("UNCHECKED_CAST")
@Composable
inline fun <reified T : BaseComponent, VM : ViewModel> daggerViewModel(
    vm: KClass<VM>,
    key: String? = null,
    component: T
): VM = viewModel(
    modelClass = vm.java,
    key = key,
    factory = object : ViewModelProvider.Factory {
        override fun <VM : ViewModel> create(modelClass: Class<VM>): VM {
            return (component.getViewModel() as VM)
        }
    }
)