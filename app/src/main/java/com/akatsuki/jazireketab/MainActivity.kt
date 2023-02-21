package com.akatsuki.jazireketab

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract.Profile
import android.view.Gravity
import android.view.MenuItem
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.ActionBar
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
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
    lateinit var toolbar: Toolbar

    lateinit var navController: NavController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        toolbar = findViewById<Toolbar>(R.id.toolbar)
        //init action bar
        setSupportActionBar(toolbar)
        supportActionBar?.displayOptions = ActionBar.DISPLAY_SHOW_CUSTOM;
        //supportActionBar?.setCustomView(R.layout.layout_custom_toolbar)
        showActionbar()


        val navHostFragment = supportFragmentManager.findFragmentById(R.id.my_nav_host_fragment) as NavHostFragment
        navController = navHostFragment.navController


        //init bottom navigation
//        loadFragment(HomeFragment())
        bottomNav = findViewById<BottomNavigationView>(R.id.bottomNav)
        bottomNav.setupWithNavController(navController)
//        bottomNav.setOnItemSelectedListener {
//            when (it.itemId) {
//                R.id.home -> {
//                    loadFragment(HomeFragment())
//                    true
//                }
//                R.id.cats -> {
//                    loadFragment(CategoryFragment())
//                    true
//                }
//                R.id.search -> {
//                    loadFragment(SearchFragment())
//                    true
//                }
//                R.id.mybooks -> {
//                    loadFragment(MyBooksFragment())
//                    true
//                }
//                R.id.profile -> {
//                    loadFragment(ProfileMainFragment())
//                    true
//                }
//                else -> {
//                    loadFragment(HomeFragment())
//                    true
//                }
//
//
//            }
//        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.getItemId() == android.R.id.home) {
            navController.popBackStack()

            // close this activity and return to preview activity (if there is any)
        }
        return super.onOptionsItemSelected(item)
    }

    fun updatetitle(name: String){
        val title = toolbar.findViewById<TextView>(R.id.toolbar_title)
        title?.visibility = View.VISIBLE
        title?.gravity = Gravity.CENTER_HORIZONTAL
        title?.text = name
        
    }

    fun hideActionbar(){
        val share = toolbar.findViewById<ImageView>(R.id.share)
        share?.visibility = View.GONE

        val help = toolbar.findViewById<ImageView>(R.id.help)
        help?.visibility = View.GONE

        val lgo = toolbar.findViewById<ImageView>(R.id.logo_tool)
        lgo?.visibility = View.GONE

        supportActionBar?.setDisplayHomeAsUpEnabled(false);
        supportActionBar?.setDisplayShowHomeEnabled(false);
    }

    fun hideActionbarFr(){
        val share = toolbar.findViewById<ImageView>(R.id.share)
        share?.visibility = View.GONE

        val help = toolbar.findViewById<ImageView>(R.id.help)
        help?.visibility = View.GONE

        val lgo = toolbar.findViewById<ImageView>(R.id.logo_tool)
        lgo?.visibility = View.GONE


        supportActionBar?.setDisplayHomeAsUpEnabled(true);
        supportActionBar?.setDisplayShowHomeEnabled(true);
    }


    fun showActionbar(){
        val title = toolbar.findViewById<TextView>(R.id.toolbar_title)
        title?.visibility = View.GONE

        val share = toolbar.findViewById<ImageView>(R.id.share)
        share?.visibility = View.VISIBLE

        val help = toolbar.findViewById<ImageView>(R.id.help)
        help?.visibility = View.VISIBLE

        val lgo = toolbar.findViewById<ImageView>(R.id.logo_tool)
        lgo?.visibility = View.VISIBLE
    }


}