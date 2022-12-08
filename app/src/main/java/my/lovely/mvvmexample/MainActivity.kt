package my.lovely.mvvmexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import my.lovely.mvvmexample.domain.models.SaveUserNameParam
import my.lovely.mvvmexample.domain.models.UserName
import my.lovely.mvvmexample.domain.usecase.GetUserNameUseCase
import my.lovely.mvvmexample.domain.usecase.SaveUserNameUseCase
import org.w3c.dom.Text
import java.lang.Error

class MainActivity : AppCompatActivity() {

    private val getUserNameUseCase = GetUserNameUseCase()
    private val saveUserNameUseCase = SaveUserNameUseCase()

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

        sendButton.setOnClickListener{
            val text = dataEditText.text.toString()
            val params = SaveUserNameParam(name = text)
            val result: Boolean = saveUserNameUseCase.execute(param = params)
            dataTextView.text = "Save result = $result"
        }

        receiveButton.setOnClickListener {
            val userName: UserName = getUserNameUseCase.execute()
            dataTextView.text = "${userName.firstName} ${userName.lastName}"
        }
    }

}