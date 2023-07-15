package ru.hometech.core_common

interface UiMapper<UI, Domain>{
    fun toDo(uiModel: UI): Domain
    fun toUi(domainModel: Domain): UI
}

interface DataMapper<Domain, Data>{
fun toDo(dataModel: Data): Domain
    fun toDto(domainModel: Domain): Data
}

