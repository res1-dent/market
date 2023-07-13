package ru.hometech.core_common

interface UiMapper<UI, Domain>{
    fun mapToDomain(uiModel: UI): Domain
    fun mapToUi(domainModel: Domain): UI
}

interface DataMapper<Domain, Data>{
    fun mapToDomain(dataModel: Data): Domain
    fun mapToData(domainModel: Domain): Data
}

