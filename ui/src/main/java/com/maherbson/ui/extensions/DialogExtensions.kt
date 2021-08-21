package com.maherbson.ui.extensions

import android.content.DialogInterface
import androidx.fragment.app.FragmentActivity
import com.google.android.material.dialog.MaterialAlertDialogBuilder

inline fun FragmentActivity.alertDialog(
    alertDialog: MaterialAlertDialogBuilder.() -> Unit
) {
    MaterialAlertDialogBuilder(this).apply {
        setCancelable(false)
        alertDialog()
        create()
        show()
    }
}

inline fun MaterialAlertDialogBuilder.positiveButton(
    text: String,
    crossinline clickListener: (dialogInterface: DialogInterface) -> Unit = { it.dismiss() }
) {
    setPositiveButton(
        text
    ) { dialogInterface, _ ->
        clickListener(dialogInterface)
    }
}

inline fun MaterialAlertDialogBuilder.negativeButton(
    text: String,
    crossinline clickListener: (dialogInterface: DialogInterface) -> Unit = { it.dismiss() }
) {
    setNegativeButton(
        text
    ) { dialogInterface, _ ->
        clickListener(dialogInterface)
    }
}