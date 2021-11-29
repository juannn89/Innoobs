package com.example.myapplication

import android.content.Context
import android.content.res.AssetManager
import android.content.res.Resources

fun AssetManager.readFile(fileName: String) = open(fileName)
    .bufferedReader()
    .use { it.readText() }

fun Context.resIdByName(name:String, resType:String): Int {
    name.let { return resources.getIdentifier(it, resType, packageName) }
    throw Resources.NotFoundException()
}



