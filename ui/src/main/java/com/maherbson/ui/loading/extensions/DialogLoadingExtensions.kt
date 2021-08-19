package com.maherbson.ui.loading.extensions

import androidx.fragment.app.FragmentActivity
import com.maherbson.ui.loading.DialogLoading

fun FragmentActivity.showLoading(message: String = String()) {
    if (isShowingProgressDialog().not()) {
        val loading = DialogLoading.newInstance(message)

        supportFragmentManager.beginTransaction()
            .add(loading, DialogLoading::class.java.name)
            .commitAllowingStateLoss()
    }
}

fun FragmentActivity.hideLoading() {
    val dialog = supportFragmentManager.findFragmentByTag(DialogLoading::class.java.name)
    if (dialog is DialogLoading) {
        dialog.dismissAllowingStateLoss()
    }
}

private fun FragmentActivity.isShowingProgressDialog(): Boolean {
    val dialog = supportFragmentManager.findFragmentByTag(DialogLoading::class.java.name)
    return dialog is DialogLoading && dialog.isVisible
}