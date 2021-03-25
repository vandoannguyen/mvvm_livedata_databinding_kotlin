package com.example.dagger_kotlin_retrofit.ui.main

import android.os.Handler
import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.dagger_kotlin_retrofit.base.BaseViewModel
import com.example.dagger_kotlin_retrofit.network.IRepository
import com.example.dagger_kotlin_retrofit.ui.main2.MainActivity2
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.SingleObserver
import io.reactivex.rxjava3.disposables.Disposable
import io.reactivex.rxjava3.schedulers.Schedulers
import kotlin.random.Random

class MainViewModel : BaseViewModel {
    var repositoryImpl: IRepository;

    constructor(repositoryImpl: IRepository) : super() {
        this.repositoryImpl = repositoryImpl;
    };
    lateinit var dem: MutableLiveData<Int>;
    fun getData() {
        repositoryImpl.getData()
            .map {
                "${it}  object"
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
            changeScreen.postValue(MainActivity2::class.java);
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
}