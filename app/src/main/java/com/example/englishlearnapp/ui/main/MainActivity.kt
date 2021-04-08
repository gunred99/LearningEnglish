package com.example.englishlearnapp.ui.main

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import com.example.englishlearnapp.R
import com.example.englishlearnapp.ui.main.botchat.ui.BotChatActivity
import com.example.englishlearnapp.ui.main.developer.DeveloperActivity
import com.example.englishlearnapp.ui.main.dictionary.DictionaryActivity
import com.example.englishlearnapp.ui.main.learn.LearnActivity
import com.example.englishlearnapp.ui.main.message.MessageActivity
import com.example.englishlearnapp.ui.main.practices.activity.PracticesActivity
import com.example.englishlearnapp.ui.main.profile.ProfileActivity
import com.example.englishlearnapp.ui.main.send.SendActivity
import com.example.englishlearnapp.ui.main.settings.SettingsActivity
import com.example.englishlearnapp.ui.main.share.ShareActivity
import com.google.android.material.navigation.NavigationView
import com.shrikanthravi.customnavigationdrawer2.widget.SNavigationDrawer
import kotlinx.android.synthetic.main.main_activity.*


class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {
    private lateinit var mDrawer: DrawerLayout
    private lateinit var dictionary: LinearLayout
    private lateinit var mDeveloper: ImageView
    private lateinit var learn: LinearLayout
    private lateinit var practice: LinearLayout
    private lateinit var botChat: LinearLayout
    private lateinit var mNavigationView: NavigationView

    var sNavigationDrawer: SNavigationDrawer? = null
    var color1 = 0
    var fragmentClass: Class<*>? = null
    var fragment: Fragment? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)

        setSupportActionBar(toolbar)

        dictionary = findViewById(R.id.mDictionary)
        learn = findViewById(R.id.mLearn)
        practice = findViewById(R.id.mPractice)
        botChat = findViewById(R.id.mBotChat)
        mDeveloper = findViewById(R.id.developer)
        mDrawer = findViewById(R.id.drawer_layout)
        mNavigationView = findViewById(R.id.nav_view)

        dictionary.setOnClickListener {
            val intent = Intent(this, DictionaryActivity::class.java)
            startActivity(intent)
        }

        mDeveloper.setOnClickListener {
            val intent = Intent(this, DeveloperActivity::class.java)
            startActivity(intent)
        }

        learn.setOnClickListener {
            val intent = Intent(this, LearnActivity::class.java)
            startActivity(intent)
        }

        practice.setOnClickListener {
            val intent = Intent(this, PracticesActivity::class.java)
            startActivity(intent)
        }

        botChat.setOnClickListener {
            val intent = Intent(this, BotChatActivity::class.java)
            startActivity(intent)
        }

        var toggle = ActionBarDrawerToggle(
            this, mDrawer, toolbar,
            R.string.navigation_drawer_open, R.string.navigation_drawer_close
        )

        mDrawer.addDrawerListener(toggle)
        toggle.syncState()


        fun onBackPressed() {

        }
        mNavigationView.setNavigationItemSelectedListener(this)

    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.profile -> {
                val i = Intent(this, ProfileActivity::class.java)
                startActivity(i)
            }
            R.id.message -> {
                val i = Intent(this, MessageActivity::class.java)
                startActivity(i)
            }
            R.id.share -> {
                val i = Intent(this, ShareActivity::class.java)
                startActivity(i)
            }
            R.id.send -> {
                val i = Intent(this, SendActivity::class.java)
                startActivity(i)
            }
            R.id.system -> {
                val i = Intent(this, SettingsActivity::class.java)
                startActivity(i)
            }
        }
        mDrawer.closeDrawer(GravityCompat.START)
        return true
    }

    override fun onBackPressed() {
        if (mDrawer.isDrawerOpen(GravityCompat.START)) {
            mDrawer.isDrawerOpen(GravityCompat.START)
        } else {
            super.onBackPressed()

            val intent = Intent(Intent.ACTION_MAIN);
            intent.addCategory(Intent.CATEGORY_HOME);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent)
        }
    }


}