package com.maherbson.ui.loading

import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import androidx.appcompat.app.AppCompatDialogFragment
import androidx.constraintlayout.widget.ConstraintLayout
import com.maherbson.ui.R
import com.maherbson.ui.databinding.DialogLoadingBinding

class DialogLoading : AppCompatDialogFragment() {

    private val dialogLoadingBinding: DialogLoadingBinding by lazy {
        DialogLoadingBinding.inflate(
            layoutInflater
        )
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        context?.let {
            val dialog = Dialog(it)
            dialog.window?.requestFeature(Window.FEATURE_NO_TITLE)
            return dialog
        }
        return super.onCreateDialog(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return dialogLoadingBinding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        val message = arguments?.getString(MESSAGE_EXTRA).orEmpty()
        if (message.isNotEmpty()) dialogLoadingBinding.messageLoading.text = message
    }

    override fun onStart() {
        super.onStart()
        dialog?.window?.setLayout(
            ConstraintLayout.LayoutParams.MATCH_PARENT,
            ConstraintLayout.LayoutParams.WRAP_CONTENT
        )
    }

    override fun onResume() {
        super.onResume()
        this.isCancelable = false
    }

    companion object {
        private const val MESSAGE_EXTRA = "MESSAGE_EXTRA"

        fun newInstance(message: String): DialogLoading {
            val loading = DialogLoading()

            val args = Bundle()
            args.putString(MESSAGE_EXTRA, message)
            loading.arguments = args

            return loading
        }
    }
}