package bonch.dev.school.ui.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import bonch.dev.school.R
import bonch.dev.school.ui.fragments.ChatFragment
import bonch.dev.school.ui.fragments.PasswordFragment
import bonch.dev.school.ui.fragments.ProfileFragment
import com.google.android.material.navigation.NavigationView
import androidx.drawerlayout.widget.DrawerLayout
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.app.ComponentActivity.ExtraData
import android.icu.lang.UCharacter.GraphemeClusterBreak.T
import android.view.MenuItem
import android.widget.Toast
import androidx.annotation.NonNull
import androidx.core.content.ContextCompat.getSystemService
import androidx.appcompat.app.ActionBar
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat


class MainAppActivity : AppCompatActivity() {
    val fm=supportFragmentManager
    private lateinit var mDrawerLayout: DrawerLayout

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_app)

        val chatFragment=ChatFragment()
        val profileFragment=ProfileFragment()
        drawer(chatFragment,profileFragment)
        fm.beginTransaction().replace(R.id.fg,chatFragment).commit()
    }

    fun drawer( chatFragment: ChatFragment, profileFragment: ProfileFragment){
        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
        val actionbar: ActionBar? = supportActionBar
        actionbar?.apply {
            setDisplayHomeAsUpEnabled(true)
            setHomeAsUpIndicator(R.drawable.ic_menu)
        }

        mDrawerLayout = findViewById(R.id.drawer_layout)

        val navigationView: NavigationView = findViewById(R.id.nav_view)
        navigationView.setNavigationItemSelectedListener { menuItem ->
            // set item as selected to persist highlight
            menuItem.isChecked = true
            // close drawer when item is tapped
            mDrawerLayout.closeDrawers()

            // Handle navigation view item clicks here.
            when (menuItem.itemId) {

                R.id.nav_profile -> {

                    fm.beginTransaction().replace(R.id.fg,profileFragment).commit()
                }
                R.id.nav_chat -> {
                    fm.beginTransaction().replace(R.id.fg,chatFragment).commit()
                }

            }
            true

        }
        navigationView.menu.getItem(0).isChecked = true

    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            android.R.id.home -> {
                mDrawerLayout.openDrawer(GravityCompat.START)
                true
            }

            else -> super.onOptionsItemSelected(item)
        }
    }

    fun replace(){
        val profileFragment=ProfileFragment()
        fm.beginTransaction().replace(R.id.fg,profileFragment).addToBackStack("fragment_chat").commit()
    }
    fun passFrag(){
        val dialog=PasswordFragment()
        dialog.show(fm.beginTransaction(),"dialog")
    }

}
