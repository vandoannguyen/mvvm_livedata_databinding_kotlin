package com.example.dagger_kotlin_retrofit.ui.main

import android.os.Handler
import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.dagger_kotlin_retrofit.base.BaseViewModel
import com.example.dagger_kotlin_retrofit.data.IRepository
import com.example.dagger_kotlin_retrofit.data.mode.local.UserLocal
import com.example.dagger_kotlin_retrofit.ui.main2.MainActivity2
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.SingleObserver
import io.reactivex.rxjava3.disposables.Disposable
import io.reactivex.rxjava3.functions.Consumer
import io.reactivex.rxjava3.schedulers.Schedulers
import java.util.*
import java.util.concurrent.Flow
import kotlin.collections.ArrayList
import kotlin.random.Random

class MainViewModel : BaseViewModel {
    var repositoryImpl: IRepository;

    constructor(repositoryImpl: IRepository) : super() {
        this.repositoryImpl = repositoryImpl;
    };
    lateinit var listUser: MutableLiveData<List<UserLocal>>
    lateinit var dem: MutableLiveData<Int>;
    fun getData() {
        repositoryImpl.run {
            insertUser(UserLocal(0, "${Calendar.getInstance().timeInMillis}"))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .flatMap { it ->
                    getUser();
                }
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(object : SingleObserver<List<UserLocal>> {
                    override fun onSubscribe(d: Disposable?) {
                        if (d != null) {
                            addDisposable(d)
                        };
                    }

                    override fun onSuccess(t: List<UserLocal>?) {
                        listUser.value = t ?: ArrayList();
                    }

                    override fun onError(e: Throwable?) {
                        Log.e("TAG111111", "onError: " + e )
                    }

                })
        }
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
        listUser = MutableLiveData()
        dem.postValue(1);
    }
}