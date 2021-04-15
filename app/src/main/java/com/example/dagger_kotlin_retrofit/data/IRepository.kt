package com.example.dagger_kotlin_retrofit.data

import com.example.dagger_kotlin_retrofit.data.local.ILocalDataHelper
import com.example.dagger_kotlin_retrofit.data.network.IApiHelper

interface IRepository : IApiHelper, ILocalDataHelper {
}