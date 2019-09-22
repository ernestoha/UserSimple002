package com.eha.usersimple002.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioButton
import androidx.fragment.app.DialogFragment
import com.eha.usersimple002.R
import com.eha.usersimple002.entity.User as UserEntity
import kotlinx.android.synthetic.main.add_user_dialog_fragment.view.*

class AddUserDialogFragment(private val clicksListener: AddUserDialogFragmentActions) :
    DialogFragment() {

    private lateinit var dialogView: View

    companion object {
        fun getInstance(clicksListener: AddUserDialogFragmentActions): AddUserDialogFragment {
            return AddUserDialogFragment(clicksListener)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.add_user_dialog_fragment, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        dialogView = view
        dialogView.main_AddUserDialogFragmentOkBtn.apply {
            setOnClickListener {
                clicksListener.userClickedOk(getUserItem())
                this@AddUserDialogFragment.dismiss()
            }
        }

        dialogView.main_AddUserDialogFragmentCancelBtn.apply {
            setOnClickListener {
                this@AddUserDialogFragment.dismiss()
            }
        }

    }

    private fun getUserItem(): UserEntity {
        // No validation
        /*val rb = dialogView.findViewById<RadioButton>(
            dialogView.main_AddUserDialogFragmentTodoImportanceRg.checkedRadioButtonId
        )*/

//        val title = dialogView.main_AddUserDialogFragmentTodoTitleEt.text.toString()
//        val description = dialogView.main_AddUserDialogFragmentTodoDescriptionEt.text.toString()


//        return Todo(title = title, description = description, importance = importance!!)
        return UserEntity(1,"test","test2","123","--url--")
    }

    interface AddUserDialogFragmentActions {
        fun userClickedOk(todo: UserEntity)
    }

}