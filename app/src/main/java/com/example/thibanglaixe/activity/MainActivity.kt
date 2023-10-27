package com.example.thibanglaixe.activity

import android.app.Dialog
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.transition.Slide
import android.transition.TransitionManager
import android.util.Log
import android.view.Gravity
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.thibanglaixe.R
import com.example.thibanglaixe.adapter.AdapterTopics
import com.example.thibanglaixe.databinding.ActivityMainBinding
import com.example.thibanglaixe.fragment.FragmentChangeLicense
import com.example.thibanglaixe.fragment.FragmentLogin
import com.example.thibanglaixe.fragment.FragmentUserManual
import com.example.thibanglaixe.model.QuestionModel
import com.example.thibanglaixe.model.TopicModel
import com.example.thibanglaixe.view_model.QuestionViewModel
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    private lateinit var binding: ActivityMainBinding
    private lateinit var fragmentManager: FragmentManager
    private val DRAWER_OPTIONS = arrayOf(R.id.change, R.id.user_manual,  R.id.login)
    private val FRAGMENT_OPTIONS = arrayOf(FragmentChangeLicense(), FragmentUserManual(), FragmentLogin())
    private val FRAGMENT_OPTIONS_NAME = arrayOf("Change", "UserManual", "Login")

    private var doubleBackToExitPressedOnce = false
    private val slide = Slide()
    private lateinit var questionViewModel: QuestionViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        fragmentManager = supportFragmentManager
        questionViewModel = ViewModelProvider(this)[QuestionViewModel::class.java]

        actionToolBar()
        loadDataApi()
    }

    private fun loadDataApi() {
        questionViewModel.getDataApiQuestion().observe(this) { response ->
            val questions = response as MutableList<QuestionModel>
            var n = 0
            var list: MutableList<QuestionModel> = mutableListOf()
            val topics: MutableList<TopicModel> = mutableListOf()
            questions.forEach { item ->
                if(n % 25 == 0 && n != 0){
                    topics.add(TopicModel("${list.size} câu/19 phút", list))
                    list = mutableListOf()
                }
                list.add(item)
                ++n
            }
            if(topics.isNotEmpty()) {
                val adapterTopics = AdapterTopics(this, topics)
                binding.rcvTopics.adapter = adapterTopics
                binding.rcvTopics.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
                binding.rcvTopics.setHasFixedSize(true)
                binding.container.visibility = View.VISIBLE
                binding.progressbar.visibility = View.GONE
                Log.e("length", list.size.toString())
            }
            else {
                binding.container.visibility = View.GONE
                binding.progressbar.visibility = View.VISIBLE
            }

        }

    }

    private fun actionToolBar(){
        setSupportActionBar(binding.menuDrawer)
        val toggle = ActionBarDrawerToggle(this, binding.drawerLayout, binding.menuDrawer, R.string.open_nav, R.string.close_nav)
        binding.drawerLayout.addDrawerListener(toggle)
        toggle.syncState()
        binding.navView.menu.findItem(R.id.home).isChecked = true
        binding.navView.setNavigationItemSelectedListener(this)

        binding.buttonHelp.setOnClickListener {
            actionDialogHelp()
        }
    }

    private fun actionDialogHelp(){
        val dialogHelp = Dialog(binding.root.context)
        val viewHelp = LayoutInflater.from(binding.root.context).inflate(R.layout.dialog_help, null)
        dialogHelp.setContentView(viewHelp)
        dialogHelp.show()
        val buttonBack = viewHelp.findViewById<Button>(R.id.buttonClose)
        buttonBack.setOnClickListener {
            dialogHelp.hide()
        }
    }

    private lateinit var fragment: Fragment

    fun addFragment(fragment: Fragment, name: String){
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.setCustomAnimations(R.anim.slide_in_right, R.anim.slide_out_left)
            .add(R.id.container, fragment)
            .addToBackStack(name)
            .commit()
        this.fragment = fragment
        binding.drawerLayout.closeDrawer(GravityCompat.START)
    }

    override fun onBackPressed() {
        if(fragmentManager.backStackEntryCount > 0){
            slide.slideEdge = Gravity.END
            TransitionManager.beginDelayedTransition(binding.container, slide)
            fragmentManager.popBackStack()
            checkIndexSelected(R.id.home)
            binding.navView.menu.findItem(R.id.home).isChecked = true
        } else {
            if(binding.drawerLayout.isDrawerOpen(GravityCompat.START)){
                binding.drawerLayout.closeDrawer(GravityCompat.START)
            } else {
                if (doubleBackToExitPressedOnce) {
                    super.onBackPressed()
                    return
                }
                this.doubleBackToExitPressedOnce = true
                Toast.makeText(this, "Please click BACK again to exit", Toast.LENGTH_SHORT).show()
                Handler(Looper.getMainLooper()).postDelayed({
                    doubleBackToExitPressedOnce = false
                }, 2000)
            }
        }
    }

    private fun checkIndexSelected(idFragmentSelect: Int){
        if(fragmentManager.backStackEntryCount > 0){
            fragmentManager.popBackStack()
        }
        for(i in DRAWER_OPTIONS.indices){
            if(DRAWER_OPTIONS[i] == idFragmentSelect){
                binding.navView.menu.findItem(DRAWER_OPTIONS[i]).isChecked = true
                addFragment(FRAGMENT_OPTIONS[i], FRAGMENT_OPTIONS_NAME[i])
            } else {
                binding.navView.menu.findItem(R.id.home).isChecked = false
                binding.navView.menu.findItem(DRAWER_OPTIONS[i]).isChecked = false
            }
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        checkIndexSelected(item.itemId)
        when(item.itemId){
            R.id.home->{
                binding.navView.menu.findItem(R.id.home).isChecked = true
            }
            R.id.email->{
                shareLink("Hỗ trợ qua Email...", "Bạn giải thích giúp mình câu số: ")
                binding.navView.menu.findItem(R.id.home).isChecked = true
            }
            R.id.app_another->{
                openPlayStoreApp("https://play.google.com/store/search?q=pub%3AVietDevPro&c=apps&hl=vi&gl=US")
                binding.navView.menu.findItem(R.id.home).isChecked = true
            }
            R.id.share->{
                shareLink("Chia sẻ ứng dụng", "Học lý thuyết, thi thử lý thuyết dễ dàng với ứng dụng \"Học bằng lái xe\"\nhttps://play.google.com/store/apps/details?id=com.vietdevpro.onthigiaypheplaixe.oto&hl=vi&gl=US".trimIndent())
                binding.navView.menu.findItem(R.id.home).isChecked = true
            }
            R.id.like->{
                openPlayStoreApp("https://play.google.com/store/apps/details?id=com.vietdevpro.onthigiaypheplaixe.oto&hl=vi&gl=US")
                binding.navView.menu.findItem(R.id.home).isChecked = true
            }
            R.id.terms->{
                openPlayStoreApp("https://m.facebook.com/story.php?story_fbid=pfbid0sgkAsBdPuz1gryv5pWp6ZRj3G9UzBfCmx2xTMPkGpUksg6D3xy9oxXxhukj7dqUYl&id=1763303467298701")
                binding.navView.menu.findItem(R.id.home).isChecked = true
            }
        }
        binding.drawerLayout.closeDrawer(GravityCompat.START)
        return true
    }

    private fun shareLink(title: String, message: String){//intent filter
        try {
            val shareIntent = Intent(Intent.ACTION_SEND)
            shareIntent.type = "text/plain"
            shareIntent.putExtra(Intent.EXTRA_SUBJECT, "App Dak Nong")
            shareIntent.putExtra(Intent.EXTRA_TEXT, message)
            startActivity(Intent.createChooser(shareIntent, title))
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    private fun openPlayStoreApp(link: String){
        startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(link)))
    }
}