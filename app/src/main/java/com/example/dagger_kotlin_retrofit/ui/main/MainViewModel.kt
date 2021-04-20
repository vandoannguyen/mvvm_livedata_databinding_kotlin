package com.example.dagger_kotlin_retrofit.ui.main

import android.os.Handler
import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.dagger_kotlin_retrofit.base.BaseViewModel
import com.example.dagger_kotlin_retrofit.data.IRepository
import com.example.dagger_kotlin_retrofit.data.mode.local.UserLocal
import com.example.dagger_kotlin_retrofit.data.mode.network.User
import com.example.dagger_kotlin_retrofit.ui.main2.MainActivity2
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.*
import io.reactivex.rxjava3.disposables.Disposable
import io.reactivex.rxjava3.schedulers.Schedulers
import java.util.Calendar;
import javax.inject.Inject
import kotlin.random.Random

class MainViewModel : BaseViewModel {
    private val TAG: String = "MainViewModel";
    var repositoryImpl: IRepository;

    @Inject
    constructor(repositoryImpl: IRepository) : super() {
        this.repositoryImpl = repositoryImpl;
    };
    lateinit var listUser: MutableLiveData<List<User>>
    lateinit var dem: MutableLiveData<String>;
    fun getData() {
        repositoryImpl.getUsers()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .flatMap { inData ->
                listUser.value = inData;
                listUser.postValue(inData);
                Observable.fromIterable(inData)
            }
            .flatMap { inData -> repositoryImpl.getData(inData.login) }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : Observer<User> {
                override fun onSubscribe(d: Disposable?) {
                    if (d != null) {
                        addDisposable(d)
                    }
                }

                override fun onNext(t: User?) {
                    var list: ArrayList<User> = listUser.value as ArrayList<User>;

                    var index: Int = list?.indexOf(t) ?: -1;
                    if (index != -1) {
                        list.set(index, t as User);
                        listUser.value = list
                        listUser.postValue(list)
                    }
                }

                override fun onError(e: Throwable?) {
                    Log.e("askjdkljasdjask", "onError: ")
                }

                override fun onComplete() {
                    Log.e(TAG, "onComplete: ")
                }

            });
    }

    fun clickList() {
//        getData();
        Log.e(TAG, "clickList: ")
        changeScreen.postValue(MainActivity2::class.java)
    }

    private fun getRamdomtext(): Int? {
        return Random(1).nextInt(100);
    }

    override fun initData() {
        super.initData()
        dem = MutableLiveData();
        listUser = MutableLiveData()
        dem.postValue("1");
    }

    fun postSubmit(data: String) {
        Log.e(TAG, "postSubmit: " + "")
        dem.postValue(data);
    }
}