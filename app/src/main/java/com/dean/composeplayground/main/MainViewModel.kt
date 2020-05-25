package com.dean.composeplayground.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.dean.composeplayground.model.MainScreenState
import com.dean.composeplayground.repository.CategoryRepository
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers
import io.reactivex.rxjava3.subjects.PublishSubject
import java.util.concurrent.TimeUnit

class MainViewModel(
    private val repository: CategoryRepository = CategoryRepository()
) : ViewModel() {

    private val _mainScreenState = MutableLiveData<MainScreenState>(MainScreenState.EMPTY)
    val mainScreenState: LiveData<MainScreenState> = _mainScreenState

    val querySubject: PublishSubject<String> = PublishSubject.create()

    init {
        loadCategories()
        subscribeToCategoryQuery()
    }

    private fun subscribeToCategoryQuery() {
        querySubject
            .debounce(300, TimeUnit.MILLISECONDS)
            .filter { it.isNotEmpty() }
            .distinctUntilChanged()
            .map { query ->
                repository
                    .getCategories()
                    .filter { it.subtitle.contains(query, ignoreCase = true) }
            }
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribe {
                _mainScreenState.value = MainScreenState(
                    getScreenTitle(),
                    it,
                    false
                )
            }
    }

    private fun loadCategories() = Single.fromCallable { repository.getCategories() }
        .delay(2000, TimeUnit.MILLISECONDS)
        .observeOn(AndroidSchedulers.mainThread())
        .doOnSubscribe { _mainScreenState.value = _mainScreenState.value?.copy(isLoading = true) }
        .subscribe { categories ->
            _mainScreenState.value = MainScreenState(
                getScreenTitle(),
                categories,
                false
            )
        }

    private fun getScreenTitle() = "European Categories"
}