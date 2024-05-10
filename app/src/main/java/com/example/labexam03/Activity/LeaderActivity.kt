package com.example.labexam03.Activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.example.labexam03.Adapter.LeaderAdapter
import com.example.labexam03.Domain.UserModel
import com.example.labexam03.R
import com.example.labexam03.databinding.ActivityLeaderBinding
import com.example.labexam03.databinding.ActivityMainBinding

class leaderActivity : AppCompatActivity() {
    lateinit var binding:ActivityLeaderBinding
    private val leaderAdapter by lazy{LeaderAdapter()}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityLeaderBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val window:Window = this@leaderActivity.window
        window.statusBarColor = ContextCompat.getColor(this@leaderActivity, R.color.grey)

        binding.apply {
            scoreTop1Txt.text=loadData().get(0).score.toString()
            scoreTop2Txt.text=loadData().get(1).score.toString()
            scoreTop3Txt.text=loadData().get(2).score.toString()
            titleTop1Txt.text=loadData().get(0).name
            titleTop2Txt.text=loadData().get(1).name
            titleTop3Txt.text=loadData().get(2).name

            val drawableResourceId1:Int=binding.root.resources.getIdentifier(
                loadData().get(0).pic,"drawable",binding.root.context.packageName
            )
            Glide.with(root.context)
                .load(drawableResourceId1)
                .into(pic1)

            val drawableResourceId2:Int=binding.root.resources.getIdentifier(
                loadData().get(1).pic,"drawable",binding.root.context.packageName
            )
            Glide.with(root.context)
                .load(drawableResourceId2)
                .into(pic2)

            val drawableResourceId3:Int=binding.root.resources.getIdentifier(
                loadData().get(2).pic,"drawable",binding.root.context.packageName
            )
            Glide.with(root.context)
                .load(drawableResourceId3)
                .into(pic3)

            menu.setItemSelected(R.id.Board)
            menu.setOnItemSelectedListener {
                if(it==R.id.home){
                    startActivity(Intent(this@leaderActivity,MainActivity::class.java))
                }
            }

            var list:MutableList<UserModel> = loadData()
            list.removeAt(0)
            list.removeAt(1)
            list.removeAt(2)
            leaderAdapter.differ.submitList(list)


            leaderView.apply {
                layoutManager=LinearLayoutManager(this@leaderActivity)
                adapter=leaderAdapter
            }








        }
    }


    private fun loadData():MutableList<UserModel>{
        val users:MutableList<UserModel> = mutableListOf()
        users.add(UserModel(id =1, name = "Sophia", pic = "person1", score = 4850 ))
        users.add(UserModel(id =2, name = "Daniel", pic = "person2", score = 4568 ))
        users.add(UserModel(id =3, name = "James", pic = "person3", score = 3873 ))
        users.add(UserModel(id =4, name = "John Smith", pic = "person4", score = 3250 ))
        users.add(UserModel(id =5, name = "Emily Johnson", pic = "person5", score = 3015 ))
        users.add(UserModel(id =6, name = "David Brown", pic = "person6", score = 2970))
        users.add(UserModel(id =7, name = "Sarah Wilson", pic = "person7", score = 2870))
        users.add(UserModel(id =8, name = "Michael Davis", pic = "person8", score = 2380 ))
        users.add(UserModel(id =9, name = "Sarah Wilson", pic = "person9", score = 2000 ))
        return users
    }
}




