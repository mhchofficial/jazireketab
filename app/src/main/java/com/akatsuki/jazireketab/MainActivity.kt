package com.akatsuki.jazireketab

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract.Profile
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.ActionBar
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import com.akatsuki.jazireketab.ui.fragments.categories.CategoryFragment
import com.akatsuki.jazireketab.ui.fragments.home.HomeFragment
import com.akatsuki.jazireketab.ui.fragments.mybooks.MyBooksFragment
import com.akatsuki.jazireketab.ui.fragments.profile.main.ProfileMainFragment
import com.akatsuki.jazireketab.ui.fragments.search.SearchFragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    lateinit var bottomNav : BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        //init action bar
        setSupportActionBar(toolbar)
        supportActionBar?.displayOptions = ActionBar.DISPLAY_SHOW_CUSTOM;
        supportActionBar?.setCustomView(R.layout.layout_custom_toolbar)
        showActionbar()
        //init bottom navigation
        loadFragment(HomeFragment())
        bottomNav = findViewById(R.id.bottomNav) as BottomNavigationView
        bottomNav.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.home -> {
                    loadFragment(HomeFragment())
                    true
                }
                R.id.cats -> {
                    loadFragment(CategoryFragment())
                    true
                }
                R.id.search -> {
                    loadFragment(SearchFragment())
                    true
                }
                R.id.mybooks -> {
                    loadFragment(MyBooksFragment())
                    true
                }
                R.id.profile -> {
                    loadFragment(ProfileMainFragment())
                    true
                }
                else -> {
                    loadFragment(HomeFragment())
                    true
                }


            }
        }
    }

    fun updatetitle(name: String){
        val title = supportActionBar?.customView?.findViewById<TextView>(R.id.toolbar_title)
        title?.visibility = View.VISIBLE
        title?.text = name
    }

    fun hideActionbar(){
        val share = supportActionBar?.customView?.findViewById<ImageView>(R.id.share)
        share?.visibility = View.GONE

        val help = supportActionBar?.customView?.findViewById<ImageView>(R.id.help)
        help?.visibility = View.GONE

        val lgo = supportActionBar?.customView?.findViewById<ImageView>(R.id.logo_tool)
        lgo?.visibility = View.GONE
    }

    fun showActionbar(){
        val title = supportActionBar?.customView?.findViewById<TextView>(R.id.toolbar_title)
        title?.visibility = View.GONE

        val share = supportActionBar?.customView?.findViewById<ImageView>(R.id.share)
        share?.visibility = View.VISIBLE

        val help = supportActionBar?.customView?.findViewById<ImageView>(R.id.help)
        help?.visibility = View.VISIBLE

        val lgo = supportActionBar?.customView?.findViewById<ImageView>(R.id.logo_tool)
        lgo?.visibility = View.VISIBLE
    }

    private  fun loadFragment(fragment: Fragment){
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.my_nav_host_fragment,fragment)
        transaction.commit()
    }
}