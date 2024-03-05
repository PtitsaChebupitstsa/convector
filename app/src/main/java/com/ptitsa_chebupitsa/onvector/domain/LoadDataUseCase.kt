package com.ptitsa_chebupitsa.onvector.domain

import javax.inject.Inject

class LoadDataUseCase @Inject constructor(private val repository: ConvectorRepository) {
    suspend operator fun invoke()= repository.loadData()
}