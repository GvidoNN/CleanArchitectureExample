package my.lovely.mvvmexample.presentation

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.ViewModelFactoryDsl
import my.lovely.mvvmexample.R
import my.lovely.mvvmexample.data.respository.UserRepositoryImpl
import my.lovely.mvvmexample.domain.models.SaveUserNameParam
import my.lovely.mvvmexample.domain.models.UserName
import my.lovely.mvvmexample.domain.repository.UserRepository
import my.lovely.mvvmexample.domain.usecase.GetUserNameUseCase
import my.lovely.mvvmexample.domain.usecase.SaveUserNameUseCase

class MainActivity : AppCompatActivity() {

    private val userRepository by lazy {UserRepositoryImpl(context = applicationContext)}
    private val getUserNameUseCase by lazy {GetUserNameUseCase(userRepository = userRepository)}
    private val saveUserNameUseCase by lazy {SaveUserNameUseCase(userRepository = userRepository)}

    private lateinit var vm: MainViewModel

    lateinit var dataTextView : TextView
    lateinit var dataEditText : EditText
    lateinit var sendButton : Button
    lateinit var receiveButton : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        dataEditText = findViewById(R.id.dataEditText)
        dataTextView = findViewById(R.id.dataTextView)
        sendButton = findViewById(R.id.sendButton)
        receiveButton = findViewById(R.id.receiveButton)

        vm = ViewModelProvider(this,MainViewModelFactory(this)).get(MainViewModel::class.java)

        sendButton.setOnClickListener {
            val text = dataEditText.text.toString()
            dataTextView.text = vm.save(text)
        }

        receiveButton.setOnClickListener {
            dataTextView.text = vm.load()
        }

    }


}