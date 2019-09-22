package com.eha.usersimple002.ui

/**
 * Created by eherrera on 2019-09-21.
 */

import android.os.Bundle
import android.widget.Button
import android.widget.PopupWindow
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.eha.usersimple002.R
import com.eha.usersimple002.adapter.UserRecycler
import com.google.android.material.floatingactionbutton.FloatingActionButton
import kotlinx.android.synthetic.main.activity_main.*
import com.eha.usersimple002.api.User as UserApi
import com.eha.usersimple002.api.model.User as UserModel

class MainActivity : AppCompatActivity() {
//    class MainActivity : DaggerAppCompatActivity(),
//        AddNoteDialogFragment.AddNoteDialogFragmentActions

    private lateinit var userAdapter : UserRecycler
    private var page : Int = 1
    private var per_page : Int = 6

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var addButton = findViewById<FloatingActionButton>(R.id.addButton)
        /*if (addButton != null) {
            addButton.setOnClickListener(
                Toast.makeText(this, "text", Toast.LENGTH_LONG).show()
            )
        }*/

        addButton.apply {
            setOnClickListener {
                /*val dialog =
                    AddNoteDialogFragment.getInstance(this@MainActivity)
                dialog.show(
                    supportFragmentManager,
                    ADD_NOTE_DIALOG_TAG
                )*/
//                Toast.makeText(this, "text", Toast.LENGTH_LONG).show()
//                loadUi()

                // this@MainActivity

                val dialog =
                AddUserDialogFragment.getInstance(this@MainActivity)
                dialog.show(
                    supportFragmentManager,
                    "com.eha.usersimple002.ui.AddUserDialogFragment"
                )
            }
        }

        initRecyclerView()
        addDataSet()

        //
        /*addButton.setOnClickListener{
//            Toast.makeText(this, "test", Toast.LENGTH_LONG).show()
            loadUi()
        }*/
    }

    private fun addDataSet(){
        var userApi : UserApi = UserApi()
        val data : UserModel? = userApi.get(this.page, this.per_page)

        if (data != null) {
            userAdapter.submitList(data.data)
        } /*else {
//           TODO when NO_DATA_FOUND
        }*/
    }

    private fun initRecyclerView(){

        recycler_view.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            val topSpacingDecorator = TopSpacingItemDecoration(30)
            addItemDecoration(topSpacingDecorator)
            userAdapter = UserRecycler()
            adapter = userAdapter
        }
    }

     private fun loadUi() {
         val window = PopupWindow(this)
         val view = layoutInflater.inflate(R.layout.add_user_dialog_fragment, null)
         window.contentView = view
         window.showAtLocation(view, 1, 1, 1)


//         mainListAdapter = MainRecyclerAdapter(MainListClickListener { todoItem ->
//             Toast.makeText(this, todoItem.title, Toast.LENGTH_LONG).show()
//         })

         /*main_todoRecycler.apply {
             addItemDecoration(
                 MainListItemDecoration(LIST_SPACING)
             )
             adapter = mainListAdapter
         }

         main_activityMainAddNoteFab.apply {
             setOnClickListener {
                 val dialog =
                     AddNoteDialogFragment.getInstance(this@MainActivity)
                 dialog.show(
                     supportFragmentManager,
                     ADD_NOTE_DIALOG_TAG
                 )
             }
         }*/
     }

}
