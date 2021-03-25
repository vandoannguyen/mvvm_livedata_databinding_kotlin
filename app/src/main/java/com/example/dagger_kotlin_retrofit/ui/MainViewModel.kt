package com.example.dagger_kotlin_retrofit.ui

import android.os.Handler
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import com.example.dagger_kotlin_retrofit.base.BaseViewModel
import com.example.dagger_kotlin_retrofit.network.IRepository
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.core.SingleObserver
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.disposables.Disposable
import io.reactivex.rxjava3.schedulers.Schedulers
import kotlin.random.Random

class MainViewModel : BaseViewModel {
    private val TAG: String = "MainViewModel";
    var repositoryImpl: IRepository;
    var compositeDisposable: CompositeDisposable = CompositeDisposable();

    constructor(repositoryImpl: IRepository) : super() {
        Log.e(TAG, "contrutor");
        this.repositoryImpl = repositoryImpl;
    };
    lateinit var dem: MutableLiveData<Int>;
    fun getData() {
        repositoryImpl.getData()
            .map {
                "${it}  object"
            }
            .flatMap {
                Single.just(it);
            }
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribe(object : SingleObserver<String> {
                override fun onSubscribe(d: Disposable?) {
                    compositeDisposable.add(d);
                }

                override fun onSuccess(t: String?) {
                    showMess.postValue(t);
                    dem.postValue(1234567);
                }

                override fun onError(e: Throwable?) {

                }
            });
    }

    fun clickList() {
        showMess.postValue("Loading");
        Handler().postDelayed({
            getData();
            showMess.postValue("Loaded");
        }, 3000);
    }

    private fun getRamdomtext(): Int? {
        return Random(1).nextInt(100);
    }

    override fun initData() {
        super.initData()
        dem = MutableLiveData();
        dem.postValue(1);
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.dispose();
    }
}