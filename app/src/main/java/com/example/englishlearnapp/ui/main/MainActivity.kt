package com.example.englishlearnapp.ui.main

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.example.englishlearnapp.R
import com.example.englishlearnapp.ui.main.botchat.BotChatActivity
import com.example.englishlearnapp.ui.main.dictionary.DictionaryActivity
import com.example.englishlearnapp.ui.main.fragment.FeedFragment
import com.example.englishlearnapp.ui.main.fragment.MessagesFragment
import com.example.englishlearnapp.ui.main.fragment.MusicFragment
import com.example.englishlearnapp.ui.main.fragment.NewsFragment
import com.example.englishlearnapp.ui.main.learn.LearnActivity
import com.example.englishlearnapp.ui.main.practice.PracticeActivity
import com.example.englishlearnapp.ui.main.profile.ProfileActivity
import com.shrikanthravi.customnavigationdrawer2.data.MenuItem
import com.shrikanthravi.customnavigationdrawer2.widget.SNavigationDrawer


class MainActivity : AppCompatActivity() {
    private lateinit var dictionary: LinearLayout
    private lateinit var mProfile: ImageView
    private lateinit var learn: LinearLayout
    private lateinit var practice: LinearLayout
    private lateinit var botChat: LinearLayout

    var sNavigationDrawer: SNavigationDrawer? = null
    var color1 = 0
    var fragmentClass: Class<*>? = null
    var fragment: Fragment? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)

        dictionary = findViewById(R.id.mDictionary)
        learn = findViewById(R.id.mLearn)
        practice = findViewById(R.id.mPractice)
        botChat = findViewById(R.id.mBotChat)
        mProfile = findViewById(R.id.profile)

        dictionary.setOnClickListener {
            val intent = Intent(this, DictionaryActivity::class.java)
            startActivity(intent)
        }

        mProfile.setOnClickListener {
            val intent = Intent(this, ProfileActivity::class.java)
            startActivity(intent)
        }

        learn.setOnClickListener {
            val intent = Intent(this, LearnActivity::class.java)
            startActivity(intent)
        }

        practice.setOnClickListener {
            val intent = Intent(this, PracticeActivity::class.java)
            startActivity(intent)
        }

        botChat.setOnClickListener {
            val intent = Intent(this, BotChatActivity::class.java)
            startActivity(intent)
        }

//        if (getSupportActionBar() != null) {
//            getSupportActionBar()?.hide()
//        }
//
//        sNavigationDrawer = findViewById(R.id.navigationDrawer)
//        val menuItems: MutableList<MenuItem> = ArrayList()
//        menuItems.add(MenuItem("News", R.drawable.news_bg))
//        menuItems.add(MenuItem("Feed", R.drawable.feed_bg))
//        menuItems.add(MenuItem("Messages", R.drawable.message_bg))
//        menuItems.add(MenuItem("Music", R.drawable.music_bg))

//        sNavigationDrawer.setMenuItemList(menuItems)
//        fragmentClass = NewsFragment::class.java
//
//        try {
//            fragment = fragmentClass!!.newInstance() as Fragment
//        } catch (e: Exception) {
//            e.printStackTrace()
//        }
//        if (fragment != null) {
//            val fragmentManager: FragmentManager = supportFragmentManager
//            fragmentManager.beginTransaction()
//                .setCustomAnimations(android.R.animator.fade_in, android.R.animator.fade_out)
//                .replace(R.id.frameLayout, fragment!!).commit()
//        }
//        sNavigationDrawer.setOnMenuItemClickListener(SNavigationDrawer.OnMenuItemClickListener { position ->
//            println("Position $position")
//            when (position) {
//                0 -> {
//                    color1 = R.color.red
//                    fragmentClass = NewsFragment::class.java
//                }
//                1 -> {
//                    color1 = R.color.orange
//                    fragmentClass = FeedFragment::class.java
//                }
//                2 -> {
//                    color1 = R.color.green
//                    fragmentClass = MessagesFragment::class.java
//                }
//                3 -> {
//                    color1 = R.color.blue
//                    fragmentClass = MusicFragment::class.java
//                }
//            }
//            sNavigationDrawer.setDrawerListener(object : SNavigationDrawer.DrawerListener {
//                override fun onDrawerOpened() {}
//                override fun onDrawerOpening() {}
//                override fun onDrawerClosing() {
//                    println("Drawer closed")
//                    try {
//                        fragment = fragmentClass!!.newInstance() as Fragment
//                    } catch (e: java.lang.Exception) {
//                        e.printStackTrace()
//                    }
//                    if (fragment != null) {
//                        val fragmentManager =
//                            supportFragmentManager
//                        fragmentManager.beginTransaction().setCustomAnimations(
//                            android.R.animator.fade_in,
//                            android.R.animator.fade_out
//                        ).replace(
//                            R.id.frameLayout,
//                            fragment!!
//                        ).commit()
//                    }
//                }
//
//                override fun onDrawerClosed() {}
//                override fun onDrawerStateChanged(newState: Int) {
//                    println("State $newState")
//                }
//            })
//        })
    }
}